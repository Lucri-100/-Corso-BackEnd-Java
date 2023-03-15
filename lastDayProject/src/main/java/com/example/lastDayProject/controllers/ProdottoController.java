package com.example.lastDayProject.controllers;

import com.example.lastDayProject.entities.Prodotto;
import com.example.lastDayProject.entities.Utente;
import com.example.lastDayProject.exceptions.ProdottoNonFoundException;
import com.example.lastDayProject.exceptions.UtenteNonFoundException;
import com.example.lastDayProject.repositories.ProdottoRepository;
import com.example.lastDayProject.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {
    @Autowired
    private ProdottoRepository prodottoRepository;

    //Questo metodo prende il body di un api contenente i dati di un utente e li salva nel db
    //@RequestBody ci sta dicende che deve guardare il body dove ci sono i dati di un utente e automaticamente spring genera un oggetto utente
    //Salviamo l'utente nel DB
    @PostMapping
    public Prodotto create(@RequestBody Prodotto p){
        return prodottoRepository.saveAndFlush(p); //saveAndFlush salva direttamente nel DB -> lo aggiorna -> è una post (sto scrivendo dentro il DB)
    }

    //Questo metodo prende in input un ID e ritorna l'utente con quell'id
    @GetMapping({"/{id}"})
    //"http://localhost:/8080/utente?{id=1}"
    public Prodotto getProdottoById(@PathVariable int id) throws ProdottoNonFoundException {
        Optional<Prodotto> p = prodottoRepository.findById(id);
        Prodotto prodotto;
        if(p.isPresent()) {
            prodotto = p.get();}
        else{
            //posso lanciare un eccezione
            throw new ProdottoNonFoundException("Il prodotto con id" + id + " non è stato trovato nel DB");
        }
        return prodotto;
    }

    //questo metodo ritorna una lista contenente tutti gli utenti
    @GetMapping("/all")
    public List<Prodotto> getAllProdotti(){
        return prodottoRepository.findAll();
    }

    @PutMapping
    public Prodotto updateProdotto(@RequestBody Prodotto p) throws ProdottoNonFoundException{
        Optional<Prodotto> optionalProdotto = prodottoRepository.findById((p.getId()));
        Prodotto prodotto;
        if(optionalProdotto.isPresent()){
            prodotto = optionalProdotto.get();
        }
        else{
            throw new ProdottoNonFoundException("Il prodotto con id" + p.getId() + " non è stato trovato nel DB");
        }
        return prodottoRepository.saveAndFlush(p);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable int id){
        prodottoRepository.deleteById(id);
    }
}
