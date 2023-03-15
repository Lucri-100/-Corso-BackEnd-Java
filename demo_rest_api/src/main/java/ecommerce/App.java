package ecommerce;

import com.google.gson.Gson;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class App {

    //creiamo una mappa
    static Map<Integer,Prodotto> prodotti = new HashMap<>();
    public static Map<Integer, Prodotto> mapGet(){
        return prodotti;
    }

    public static void main(String[] args) {
        //Inizializzazione
        Prodotto maglia1 = new Prodotto(1,"maglia1","una maglia bellissima1", 33, 6.0);
        Prodotto maglia2 = new Prodotto(2,"maglia2","una maglia bellissima2", 33, 6.0);
        Prodotto maglia3 = new Prodotto(3,"maglia3","una maglia bellissima3", 33, 6.0);
        Prodotto maglia4 = new Prodotto(4,"maglia4","una maglia bellissima4", 33, 6.0);


        prodotti.put(maglia1.getId(), maglia1);
        prodotti.put(maglia2.getId(), maglia2);
        prodotti.put(maglia3.getId(), maglia3);
        prodotti.put(maglia4.getId(), maglia4);


        port(8081);
        path("/api/ecommerce", () ->{

            get("/allprodotti", (req, res)->{
                res.type("application/json");
                return new Gson().toJsonTree(prodotti.values());
            });

            post("/addprodotto", (req, res) -> {
                Prodotto nuovoProdotto = new Gson().fromJson(req.body(), Prodotto.class);
                prodotti.put(nuovoProdotto.getId(), nuovoProdotto);
                res.type("application/json");
                return new Gson().toJson(nuovoProdotto);
            });

            delete("/deleteProdotto", (req, res) -> {
                int id = Integer.valueOf(req.queryParams("id"));
                Prodotto prodottoRimosso = prodotti.remove(id);
                res.type("application/json");
                return new Gson().toJson(prodottoRimosso);
            });

            //acquista prodotto, specificando l'id del prodotto e la quantità
            get("/buy", (req, res) -> {
               int id = Integer.valueOf(req.queryParams("id"));
               int stock = Integer.valueOf(req.queryParams("stock"));

               if((prodotti.get(id).getStock() - stock) < 0){
                   int quantità_venduta = prodotti.get(id).getStock();
                   prodotti.get(id).setStock(0);
                   return new Gson().toJson("Ne hai acquistati solo: " + quantità_venduta + " su " + stock);
               }
               prodotti.get(id).setStock(prodotti.get(id).getStock() - stock);
               return new Gson().toJson("Prodotto: " + id + " acquistato, in quantita " + stock);
            });

            get("/filter", (req, res) -> {
                int id = Integer.valueOf(req.queryParams("id"));
                String name = req.queryParams("name");

                List<Prodotto> risultati = prodotti.values().stream().filter(prodotto -> (prodotto.getId() == id && prodotto.getName().equals(name))).collect(Collectors.toList());
                System.out.println(risultati);


                if(risultati.size()==0) {
                    res.status(404); //errore
                    return new Gson().toJson("Prodotto non trovato");

                }
                Prodotto prodotto_trovato = risultati.get(0);
                System.out.println(prodotto_trovato);
                res.status(200); //ok
                return new Gson().toJson(prodotto_trovato);
            });



        });
    }
}
