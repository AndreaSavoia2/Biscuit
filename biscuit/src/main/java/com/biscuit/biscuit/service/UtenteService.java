package com.biscuit.biscuit.service;

import com.biscuit.biscuit.entities.Utente;

import java.util.List;

public interface UtenteService {

    List<Utente> getUtente();

    Utente addUtente(Utente utente);

    List<Utente> findUtenteEmail(String email);

}
