package com.javapera.biscuit;

import com.javapera.biscuit.entities.Utente;
import com.javapera.biscuit.input.MioScanner;
import com.javapera.biscuit.service.UtenteService;
import com.javapera.biscuit.service.UtenteServiceIMPL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BiscuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiscuitApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(UtenteServiceIMPL service){

		return runner -> {

			console(service);

		};


	}

	private void console(UtenteService service) {

		MioScanner in = new MioScanner();
		boolean fine = false;

		System.out.println("Server Biscuit Avviato [eseguire help per controllare i comando della console]");
		do {
			switch (in.leggiStringaLow("")) {
				case "help" -> {
					System.out.println("\n" +
							"/console get.utente -all {Restituisce lista di tutti gli utenti all'interno della tabella utenti}\n" +
							"/console add.utente {Aggiunge un utente alla tabella Utenti}\n" +
							"/console update.utente.password -check {Conntrolla se la email inserita esiste resistuendo true o false e modifica l'email in caso di true}\n" +
							"/console get.utente.email -check {Restituisce false se l'email esiste e true se non esiste}\n" +
							"/console get.utente.username -check {Restituisce false se l'email esiste e true se non esiste}\n");
				}
				case "/console get.utente -all" -> {
					List<Utente> u = service.getUtente();
					for (Utente utente:u) {
						System.out.println(utente);
					}
				}
				case "/console add.utente" -> {
					Utente u = new Utente(in.leggiStringaLow("Username:"),in.leggiStringaLow("email:"),in.leggiStringaLow("password:"),"");
					service.addUtente(u);
				}
				case "/console update.utente.password -check" -> {
					boolean check = service.changePassword(in.leggiStringaLow("email:"),in.leggiStringaLow("new password:"));
					System.out.println(check);
					if (check){
						System.out.println("password modificata");
					} else {
						System.out.println("Utente non esiste");
					}
				}
				case "/console get.utente.email -check" -> {
					boolean check = service.checkEmail(in.leggiStringaLow("email:"));
					System.out.println(check);
				}
				case "/console get.utente.username -check"  -> {
					boolean check = service.checkUser(in.leggiStringaLow("username:"));
					System.out.println(check);
				}
			}

		}while (!fine) ;
	}

}
