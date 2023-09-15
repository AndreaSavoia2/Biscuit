package com.biscuit.biscuit.integrascion;

import com.biscuit.biscuit.entities.Utente;
import com.biscuit.biscuit.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UtenteRest {

    @Autowired
    private UtenteService service;

    @GetMapping("utenti")
    public List<Utente> getUtente(){
        return service.getUtente();
    }

    @CrossOrigin
    @PostMapping("utenti")
    public Utente addUtente(@RequestBody Utente u){
        return service.addUtente(u);
    }

    @CrossOrigin
    @GetMapping("utenti/{email}")
    public List<Utente> UtenteByEmail(@PathVariable String email){
        return service.findUtenteEmail(email);
    }
}
