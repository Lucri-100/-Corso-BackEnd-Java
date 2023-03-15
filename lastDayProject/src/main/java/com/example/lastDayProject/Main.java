package com.example.lastDayProject;

import com.example.lastDayProject.entities.Utente;

public class Main {
    public static void main(String[] args) {
        Utente u = new Utente();
        // facendo u. vedremo che avrà tutti quanti i getters e i setters
        System.out.println(u.getId());
        System.out.println(u.getEmail());

        Utente u2 = new Utente(1, "Lucrezia", "Arestia", "lucri@gmail.com");
        System.out.println(u2.getEmail());
    }
}
