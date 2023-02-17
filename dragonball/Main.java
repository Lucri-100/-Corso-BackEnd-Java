package dragonball;

public class Main {
    public static void main(String[] args) {
        //Attacchi base (da mischia) - danno pari alla forza fisica del personaggio
        Attacco pugni_in_bocca = new Attacco("pugni in bocca");
        Attacco calci_in_faccia = new Attacco("calci in faccia");
        Attacco dita_negli_occhi = new Attacco("dita negli occhi");
        Attacco calcio_genitale = new Attacco("calcio genitale");
        Attacco morso_all_orecchio = new Attacco("morso all'orecchio");

        //Attacchi speciali
        Attacco kamehameha = new Attacco("kamehameha", 25);
        Attacco final_flash = new Attacco("final flash", 25);
        Attacco energia_sferica = new Attacco("energia sferica", 50);
        Attacco colpo_aura = new Attacco("colpo dell'aura", 5);
        Attacco cannone_speciale = new Attacco("cannone speciale", 30);
        Attacco raggio_oculare = new Attacco("raggio oculare", 10);
        Attacco cannone_garrik = new Attacco("cannone garrik", 20);
        Attacco masenko = new Attacco("masenko", 10);
        Attacco kienzan = new Attacco("kienzan", 20);
        Attacco pugno_del_drago = new Attacco("pugno del drago", 35);
        Attacco sfera_distruttiva = new Attacco("sfera distruttiva", 50);

        //Attacchi personalizzati
        Attacco[] combo_goku = {pugni_in_bocca, kamehameha, energia_sferica, colpo_aura, pugno_del_drago};
        Attacco[] combo_cell = {morso_all_orecchio, final_flash, kamehameha, cannone_speciale, cannone_garrik};
        Attacco[] combo_freezer = {dita_negli_occhi, raggio_oculare, colpo_aura, masenko, sfera_distruttiva};
        Attacco[] combo_crilin = {calcio_genitale, masenko, kienzan, colpo_aura, kamehameha};
        Attacco[] combo_vegeta = {calci_in_faccia, final_flash, cannone_speciale, cannone_garrik, colpo_aura};

        //Personaggi
        Personaggio goku = new Personaggio("Goku", 100, 10, Razza.SAIYAN, combo_goku);
        Personaggio cell = new Personaggio("Cell", 85, 8, Razza.ALIENO, combo_cell);
        Personaggio freezer = new Personaggio("Freezer", 90, 7, Razza.ALIENO, combo_freezer);
        Personaggio crilin = new Personaggio("Crilin", 50, 2, Razza.UMANO, combo_crilin);
        Personaggio vegeta = new Personaggio("Vegeta", 95, 9, Razza.SAIYAN, combo_vegeta);

        Combattimento.combatti(vegeta, cell);

    }
}
