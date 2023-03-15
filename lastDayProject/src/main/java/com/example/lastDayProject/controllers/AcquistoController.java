package com.example.lastDayProject.controllers;

import com.example.lastDayProject.entities.Acquisto;
import com.example.lastDayProject.entities.Prodotto;
import com.example.lastDayProject.exceptions.AcquistoNonFoundException;
import com.example.lastDayProject.exceptions.ProdottoNonFoundException;
import com.example.lastDayProject.repositories.AcquistoRepository;
import com.example.lastDayProject.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acquisto")
public class AcquistoController {

        @Autowired
        private AcquistoRepository acquistoRepository;

        @PostMapping
        public Acquisto create(@RequestBody Acquisto a){
            return acquistoRepository.saveAndFlush(a); //saveAndFlush salva direttamente nel DB -> lo aggiorna -> è una post (sto scrivendo dentro il DB)
        }

        //Questo metodo prende in input un ID e ritorna l'utente con quell'id
        @GetMapping({"/{id}"})
        //"http://localhost:/8080/utente?{id=1}"
        public Acquisto getAcquistoById(@PathVariable int id) throws AcquistoNonFoundException {
            Optional<Acquisto> a = acquistoRepository.findById(id);
            Acquisto acquisto;
            if(a.isPresent()) {
                acquisto = a.get();}
            else{
                //posso lanciare un eccezione
                throw new AcquistoNonFoundException("L'acquisto con id" + id + " non è stato trovato nel DB");
            }
            return acquisto;
        }

        //questo metodo ritorna una lista contenente tutti gli utenti
        @GetMapping("/all")
        public List<Acquisto> getAllAcquisto(){
            return acquistoRepository.findAll();
        }

        @PutMapping
        public Acquisto updateAcquisto(@RequestBody Acquisto a) throws AcquistoNonFoundException{
            Optional<Acquisto> optionalAcquisto = acquistoRepository.findById((a.getId()));
            Acquisto acquisto;
            if(optionalAcquisto.isPresent()){
                acquisto = optionalAcquisto.get();
            }
            else{
                throw new AcquistoNonFoundException("L'acquisto con id" + a.getId() + " non è stato trovato nel DB");
            }
            return acquistoRepository.saveAndFlush(a);
        }

        @DeleteMapping({"/{id}"})
        public void deleteById(@PathVariable int id){
            acquistoRepository.deleteById(id);
        }

}
