package com.biscuit.biscuit.service;

import com.biscuit.biscuit.entities.Utente;
import com.biscuit.biscuit.repos.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceIMPL implements UtenteService {

    @Autowired
    private UtenteDAO dao;

    @Override
    public List<Utente> getUtente() {
        return dao.findAll();
    }

    @Override
    public Utente addUtente(Utente utente) {
        return dao.save(utente);
    }

    @Override
    public List<Utente> findUtenteEmail(String email) {
        return dao.getUtenteByEmail(email);
    }
}
