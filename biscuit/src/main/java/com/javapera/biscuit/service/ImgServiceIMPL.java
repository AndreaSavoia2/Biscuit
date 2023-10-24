package com.javapera.biscuit.service;

import com.fasterxml.jackson.databind.util.NativeImageUtil;
import com.javapera.biscuit.entities.ImgProfilo;
import com.javapera.biscuit.repos.ImgDAO;
import com.javapera.biscuit.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Optional;


@Service
public class ImgServiceIMPL implements ImgService {


    private ImgDAO  dao;

    @Autowired
    public ImgServiceIMPL(ImgDAO  imageDataRepository) {
        this. dao =  imageDataRepository;
    }


    @Override
    public ImgProfilo uploadImg(MultipartFile file, int idUtente) throws IOException {
        ImgProfilo img = new ImgProfilo();
        img.setIdUtente(idUtente);
        img.setNomeFile(file.getOriginalFilename());
        img.setTipoFile(file.getContentType());
        img.setImagData(file.getBytes());
        return dao.save(img);
    }

    @Override
    public ImgProfilo GetInfoByImgName(String name) {
        return null;
    }

    /*@Override
    public byte[] getImage(int id) {
        Optional<ImgProfilo> dbImg = dao.findById(id);
        if (dbImg.isPresent()) {
            byte[] image = dbImg.get().getImagData();
            return image;
        } else {
            return new byte[0];
        }
    }*/

    @Override
    public byte[] getImagebyIdUser(int idUtente) {
        Optional<ImgProfilo> dbImg = dao.findImgByIdUser(idUtente);
        if (dbImg.isPresent()) {
            byte[] image = dbImg.get().getImagData();
            return image;
        } else {
            return new byte[0];
        }
    }
}
