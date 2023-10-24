package com.javapera.biscuit.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class Utente {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utente;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="gender")
    private String gender;

    @Column(name="birthdate")
    private String birthdate;

    public Utente() {
    }

    public Utente(String username, String email, String password, String gender, String birthdate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public int getId_utente() {
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

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id_utente=" + id_utente +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
