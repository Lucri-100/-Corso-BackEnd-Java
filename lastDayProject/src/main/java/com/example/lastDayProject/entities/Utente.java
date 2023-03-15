package com.example.lastDayProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //imposta in automatico getters e setters per la classe
@AllArgsConstructor //imposta in automatico un costruttore senza argomenti
@NoArgsConstructor //imposta in automatico un costruttore con tutti gli argomenti
@Entity //dico che è una entità del progetto
@Table //che metterò in una sua tabella
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Mi dice che l'id verrà generato in maniera incrementale
    private int id;
    @Column(nullable = false) //sarà una colonna del mio DB - e non può essere nullo
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false, unique = true)
    private String email;

}
