package com.javapera.biscuit.repos;

import com.javapera.biscuit.entities.ImgProfilo;
import com.javapera.biscuit.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ImgDAO extends JpaRepository<ImgProfilo,Integer> {

    @Query("FROM ImgProfilo WHERE idUtente = :idUtente")
    Optional<ImgProfilo> findImgByIdUser(@Param("idUtente") int idUtente);

}
