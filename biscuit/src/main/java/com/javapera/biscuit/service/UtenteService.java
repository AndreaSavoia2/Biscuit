package com.javapera.biscuit.service;


import com.javapera.biscuit.entities.Utente;

import java.util.List;

public interface UtenteService {

    List<Utente> getUtente();

    Utente addUtente(Utente utente);

    Utente findUtenteEmail(String email);

    void cambiaPassword(String email);

}
