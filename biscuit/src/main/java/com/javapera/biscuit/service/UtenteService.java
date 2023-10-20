package com.javapera.biscuit.service;


import com.javapera.biscuit.entities.Utente;

import java.util.List;

public interface UtenteService {

    List<Utente> getUtente();

    Utente addUtente(Utente utente);

    boolean changePassword(String email, String password);

    boolean checkUser(String username);

    boolean checkEmail(String email);

}
