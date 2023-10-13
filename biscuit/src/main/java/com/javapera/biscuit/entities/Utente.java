package com.javapera.biscuit.entities;

import jakarta.persistence.*;

@Entity
@Table(name="utente")
public class Utente {

    @Id
    @Column(name="id_utente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utente;

    @Column(name="username",nullable = false,unique = true , length = 50)
    private String username;

    @Column(name="email",nullable = false,unique = true , length = 100)
    private String email;

    @Column(name="password",nullable = false, length = 100)
    private String password;

    @Column(name="img_profilo", nullable = false, length = 100)
    private String img_profilo;

    /*public Utente(String username, String email, String password, String img_profilo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.img_profilo = img_profilo;
    }*/

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

    /*@Override
    public String toString() {
        return "Utente{" +
                "id_utente=" + id_utente +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", img_profilo='" + img_profilo + '\'' +
                '}';
    }*/
}
