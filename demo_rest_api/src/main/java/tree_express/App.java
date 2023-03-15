package tree_express;

import com.google.gson.Gson;

import java.util.*;

import static spark.Spark.*;
import static spark.Spark.get;

public class App {
    static Map<Integer, User> userz = new HashMap<>();
    static List<Order> orderz = new ArrayList<>();

    //static Map<Integer,Order> orderz=new TreeMap<>();

    //public static Map<Integer, Order> getOrderz(){
        //return orderz;
    //}

    public static void main(String[] args) {

//        User u1= new User(1,"n1","c1","v1");
//        User u2= new User(2,"n2","c2","v2");
//        User u3= new User(3,"n3","c3","v3");
//
//        userz.put(u1.getId(),u1);
//        userz.put(u2.getId(),u2);
//        userz.put(u3.getId(),u3);
//
//        //creo un ordine per un test
//        Order o1= new Order();
//
//        orderz.put(50, o1);


        port(8082);

        path("/api/TreeExpress", () ->{

            get("/allusers", (req,res)->{
                res.status(201);
                res.type("application/json");
                return new Gson().toJsonTree(userz.values());
            });

            post("/adduser", (req, res)->{

                //TODO: implementare controllo su ID
                User newUser= new Gson().fromJson(req.body(), User.class);
                userz.put(newUser.getId(),newUser);
                res.status(201); //201-> creato
                res.type("application/json");
                return new Gson().toJson(newUser);

            });

            //elimina prodotto: rimuove un prodotto dalla lista dei prodotti disponibili
            get("/allorder", (req,res)->{
                res.type("application/json");
                return new Gson().toJsonTree(orderz);
            });
//            delete("/deleteOrder", (req,res)->{
//                int id= Integer.valueOf(req.queryParams("id"));
//                if(!orderz.containsKey(id)|| orderz.get(id).getState()==State.Received)
//                    return new Gson().toJson("Order Unavailable");
//                Order orderRemove=orderz.remove(id);
//                res.type("application/json");
//                return new Gson().toJson(orderRemove);
//            });

            post("/addOrder",(req,res)->{

                String senderId = req.queryParams("senderID");
                String receiverId = req.queryParams("receiverID");

                if(senderId == null || receiverId == null || senderId.equals("") || receiverId.equals("")) {
                    res.status(404);
                    return "Sender or Receiver id not valid";
                }

                //Sto recuperando gli utenti dalla HashMap, che ha int come chiave, devo convertire
                User userSender = userz.get(Integer.valueOf(senderId));
                User userReceiver = userz.get(Integer.valueOf(receiverId));

                String weightString = req.queryParams("weight");
                if(weightString == null || weightString.equals("")){
                    res.status(400);
                    return "weightString not present";
                }
                double weight = Double.parseDouble(weightString);

                //TODO: generare ID intero randomico
                Order new_order = new Order(1, userSender, userReceiver, weight, State.Sending);
                orderz.add(new_order);
                res.status(201);
                return "ok";
            });

//            put("/setState",(req,res)->{
//                int id=Integer.valueOf(req.queryParams("id"));
//                if(!orderz.containsKey(id)||orderz.get(id).getState()==State.Received)
//                    return new Gson().toJson("Order Unavailable");
//                //Order upOrder= new Gson().fromJson(req.body(),Order.class);
//                orderz.get(id).setState(State.Received);
//                return new Gson().toJson("Order: "+id+" Received: "+(orderz.get(id).getState()==State.Received));
//            });
//
//            get("/ordertrans",(req,res)->{
//                List<Order> transfer=new ArrayList<>();
//                for(Order o:orderz.values())
//                    if(o.getState()==State.Sending)
//                        transfer.add(o);
//                res.type("application/json");
//                return new Gson().toJson(transfer);
//            });
//
//            get("/receiverorder",(req,res)->{
//                int id=Integer.valueOf(req.queryParams("id"));
//                if(!userz.containsKey(id))
//                    return new Gson().toJson("Users not Found");
//
//                List<Order> transfer=new ArrayList<>();
//                for(Order o:orderz.values())
//                    if(o.getId_receiver()==id)
//                        transfer.add(o);
//                if(transfer.size()==0)
//                    return new Gson().toJson("User: "+userz.get(id).getName()+" Do not have any Order");
//                res.type("application/json");
//                return new Gson().toJson("User: "+userz.get(id).getName()+" \\n Is Receiver of: "+transfer);
//            });
        });

    }
}
