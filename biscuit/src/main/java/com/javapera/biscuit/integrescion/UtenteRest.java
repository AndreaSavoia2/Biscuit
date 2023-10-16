package com.javapera.biscuit.integrescion;


import com.javapera.biscuit.entities.Utente;
import com.javapera.biscuit.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtenteRest {


    private UtenteService service;

    @Autowired
    public UtenteRest(UtenteService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("${indirizzo.utente}")
    public List<Utente> getUtente(){
        return service.getUtente();
    }

    @CrossOrigin
    @PostMapping("${indirizzo.utente}")
    public Utente addUtente(@RequestBody Utente u){
        return service.addUtente(u);
    }

    @CrossOrigin
    @PutMapping("${indirizzo.utente}")
    public void cambiaPassword(@RequestParam String email, @RequestParam String password) {
        service.cambiaPassword(email, password);

        /* boolean passwordCambiata = service.cambiaPassword(email, password);
        if (passwordCambiata) {
            return ResponseEntity.status(HttpStatus.OK).body("Password cambiata con successo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
        }*/
    }

    @CrossOrigin
    @GetMapping("${indirizzo.utente}/{email}")
    public Utente UtenteByEmail(@PathVariable String email){
        return service.findUtenteEmail(email);
    }


}
