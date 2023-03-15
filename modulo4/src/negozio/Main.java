package negozio;

public class Main {
    public static void main(String[] args) {
        //creo dei prodotti
        Prodotto prodotto1 = new Prodotto("Mela", 0.25, 15, true);
        Prodotto prodotto2 = new Prodotto("Sapone mani", 1.50, 5, false);
        Prodotto prodotto3 = new Prodotto("Riso", 1.00, 10, true);
        Prodotto prodotto4 = new Prodotto("Vino Bianco", 4.20, 8, true);
        Prodotto prodotto5 = new Prodotto("Deodorante", 3.00, 4, false);

        //creo due clienti
        Cliente c1 = new Cliente(65);
        Cliente c2 = new Cliente(29);
        Cliente c3 = new Cliente(50);

        //aggiungo i prodotti al negozio
        Negozio.addProdotto(prodotto1, prodotto1.getQuantita());
        Negozio.addProdotto(prodotto2, prodotto2.getQuantita());
        Negozio.addProdotto(prodotto3, prodotto3.getQuantita());
        Negozio.addProdotto(prodotto4, prodotto4.getQuantita());
        Negozio.addProdotto(prodotto5, prodotto5.getQuantita());

        //riempiamo i carrelli dei clienti
        c1.aggiungiAlCarrello(prodotto1, 6);
        c1.aggiungiAlCarrello(prodotto2,1);
        c1.aggiungiAlCarrello(prodotto3, 2);

        c2.aggiungiAlCarrello(prodotto1, 6);
        c2.aggiungiAlCarrello(prodotto2, 1);
        c2.aggiungiAlCarrello(prodotto3, 2);

        c3.aggiungiAlCarrello(prodotto1, 10);

        System.out.println("---------------------------------");
        c1.getCarrello().stampaCarrello();
        System.out.println("---------------------------------");
        c2.getCarrello().stampaCarrello();
        System.out.println("---------------------------------");
        c3.getCarrello().stampaCarrello();
        System.out.println("---------------------------------");

        Negozio.stampaProdotti();
        System.out.println("---------------------------------");

        System.out.println(c1.checkOut(Giorni.MERCOLEDI, false));
        System.out.println(c2.checkOut(Giorni.MERCOLEDI, false));

        System.out.println("---------------------------------");

        Negozio.stampaProdotti();

        System.out.println("---------------------------------");

        System.out.println(c3.checkOut(Giorni.MERCOLEDI, false));
        System.out.println("---------------------------------");
        Negozio.stampaProdotti();
    }
}
