package com.javapera.biscuit.entities;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

import java.util.Arrays;


@Entity
@Table(name = "img_profile")
public class ImgProfilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_img")
    private int id;

    @Column(name="img_id_user")
    private int idUtente;

    @Column(name="img_name")
    private String nomeFile;

    @Column(name="img_type")
    private String tipoFile;

    @Lob
    @Column(name = "img_data", length = 1000)
    private byte[] imagData;

    public ImgProfilo(int idUtente, String nomeFile, String tipoFile, byte[] imagData) {
        this.idUtente = idUtente;
        this.nomeFile = nomeFile;
        this.tipoFile = tipoFile;
        this.imagData = imagData;
    }

    public ImgProfilo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String getTipoFile() {
        return tipoFile;
    }

    public void setTipoFile(String tipoFile) {
        this.tipoFile = tipoFile;
    }

    public byte[] getImagData() {
        return imagData;
    }

    public void setImagData(byte[] imagData) {
        this.imagData = imagData;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public String toString() {
        return "ImgProfilo{" +
                "id=" + id +
                ", nomeFile='" + nomeFile + '\'' +
                ", tipoFile='" + tipoFile + '\'' +
                ", imagData=" + Arrays.toString(imagData) +
                '}';
    }
}
