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
    public boolean cambiaPassword(@RequestParam String email, @RequestParam String password) {
        return service.changePassword(email, password);
    }

    @CrossOrigin
    @GetMapping("controlla-email")
    public @ResponseBody boolean ControllaEmail(@RequestParam String email){
        return service.checkEmail(email);
    }

    @CrossOrigin
    @GetMapping("controlla-username")
    public @ResponseBody boolean ControllaUsername(@RequestParam String username){
        return service.checkUser(username);
    }
}
