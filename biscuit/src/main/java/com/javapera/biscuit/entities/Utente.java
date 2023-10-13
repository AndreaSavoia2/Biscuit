package com.javapera.biscuit.entities;

import jakarta.persistence.*;

@Entity
@Table(name="utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utente;

    @Column(nullable = false,unique = true , length = 50)
    private String username;

    @Column(nullable = false,unique = true , length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String img_profilo;

    public int getId_untente() {
        return id_utente;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getImg_profilo() {
        return img_profilo;
    }

    public void setId_untente(int id_untente) {
        this.id_utente = id_untente;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImg_profilo(String img_profilo) {
        this.img_profilo = img_profilo;
    }

}
