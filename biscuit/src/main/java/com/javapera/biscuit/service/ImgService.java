package com.javapera.biscuit.service;

import com.javapera.biscuit.entities.ImgProfilo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImgService {

    ImgProfilo uploadImg(MultipartFile file , int idUtente) throws IOException;

    ImgProfilo GetInfoByImgName(String name);

    /*byte[] getImage(int id);*/

    byte[] getImagebyIdUser(int idUtente);

}
