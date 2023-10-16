package com.javapera.biscuit.service;


import com.javapera.biscuit.entities.Utente;
import com.javapera.biscuit.repos.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceIMPL implements UtenteService {


    @Autowired
    private UtenteDAO dao;

    @Autowired
    public UtenteServiceIMPL(UtenteDAO dao) {
        this.dao = dao;
    }
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