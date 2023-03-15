package com.example.lastDayProject.controllers;

import com.example.lastDayProject.entities.Utente;
import com.example.lastDayProject.exceptions.UtenteNonFoundException;
import com.example.lastDayProject.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    private UtenteRepository utenteRepository;

    //Questo metodo prende il body di un api contenente i dati di un utente e li salva nel db
    //@RequestBody ci sta dicende che deve guardare il body dove ci sono i dati di un utente e automaticamente spring genera un oggetto utente
    //Salviamo l'utente nel DB
    @PostMapping
    public Utente create(@RequestBody Utente u){
        return utenteRepository.saveAndFlush(u); //saveAndFlush salva direttamente nel DB -> lo aggiorna -> è una post (sto scrivendo dentro il DB)
    }

    //Questo metodo prende in input un ID e ritorna l'utente con quell'id
    @GetMapping({"/{id}"})
    //"http://localhost:/8080/utente?{id=1}"
    public Utente getUtenteById(@PathVariable int id) throws UtenteNonFoundException {
        Optional<Utente> u = utenteRepository.findById(id);
        Utente utente;
        if(u.isPresent()) {
            utente = u.get();}
        else{
            //posso lanciare un eccezione
            throw new UtenteNonFoundException("L'utente con id" + id + " non è stato trovato nel DB");
        }
        return utente;
    }

    //questo metodo ritorna una lista contenente tutti gli utenti
    @GetMapping("/all")
    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }

    @PutMapping
    public Utente updateUtente(@RequestBody Utente u) throws UtenteNonFoundException{
        Optional<Utente> optionalUtente = utenteRepository.findById((u.getId()));
        Utente utente;
        if(optionalUtente.isPresent()){
            utente = optionalUtente.get();
        }
        else{
            throw new UtenteNonFoundException("L'utente con id" + u.getId() + " non è stato trovato nel DB");
        }
        return utenteRepository.saveAndFlush(u);
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable int id){
        utenteRepository.deleteById(id);
    }
}
