package com.javapera.biscuit.integrescion;

import com.javapera.biscuit.entities.ImgProfilo;
import com.javapera.biscuit.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImgRest {

    private ImgService service;
    @Autowired
    public ImgRest(ImgService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/upload")
    public ImgProfilo uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("id") int idUtente) throws IOException {
        return service.uploadImg(file, idUtente);
    }

    @CrossOrigin
    @GetMapping("/img/{idUtente}")
    public byte[] getImgProfilo(@PathVariable("idUtente") int idUtente){
        byte[] image =  service.getImagebyIdUser(idUtente);
        return image;
    }

}
