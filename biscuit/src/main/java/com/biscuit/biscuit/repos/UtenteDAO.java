package com.biscuit.biscuit.repos;

import com.biscuit.biscuit.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtenteDAO extends JpaRepository<Utente, Integer> {

    @Query("SELECT u FROM Utente u WHERE u.email = :email")
    List<Utente> getUtenteByEmail(@Param("email") String email);
}
