package Esercizio3112023.GestionePrenotazioni;

import Esercizio3112023.GestionePrenotazioni.DAO.EdificioService;
import Esercizio3112023.GestionePrenotazioni.DAO.PostazioneService;
import Esercizio3112023.GestionePrenotazioni.DAO.PrenotazioneSerrvice;
import Esercizio3112023.GestionePrenotazioni.DAO.UserService;
import Esercizio3112023.GestionePrenotazioni.entities.*;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
@Slf4j
public class MainRunner implements CommandLineRunner {
    @Autowired
    private UserService usersDAO;
    @Autowired
    private EdificioService edificioDAO;

    @Autowired
    private PostazioneService postazioneDAO;
    @Autowired
    private PrenotazioneSerrvice prenotazioneDAO;

    @Override
    public void run(String... args) throws Exception {
        try {
            Faker fkr = new Faker();
            Random rnd = new Random();


            /*  for(int i=0;i<10;i++){
                int n = rnd.nextInt(0, 3);
              User genericUser = User.builder().nome(fkr.name().firstName()).cognome(fkr.name().lastName()).email(fkr.internet().emailAddress()).build();
                usersDAO.save(genericUser);
                Edificio genericEdificio = Edificio.builder().name(fkr.address().firstName()).address(fkr.address().fullAddress()).city(fkr.address().city()).build();
                edificioDAO.save(genericEdificio);
                Postazione genericPostazione = Postazione.builder().description(fkr.commerce().department()).numMax(rnd.nextInt(5,50)).tipo((n==0?Tipo.PRIVATO:n==1?Tipo.OPENSPACE:Tipo.SALA_RIUNIONI)).build();
                postazioneDAO.save(genericPostazione);
            }*/
         log.info("******************************Effettuare prenotazione***************************");
            Prenotazione p= Prenotazione.builder().data_prenotazione(LocalDate.of(2023,11,06)).build();
            p.setPostazione(postazioneDAO.findById(8));
            p.setUser(usersDAO.findById(3));
            prenotazioneDAO.save(p,8,prenotazioneDAO);
            log.info("***********************Ricerca postazioni per tipo postazione e città***********************");
            List<Postazione> postazioneList=postazioneDAO.findPostazione(Tipo.OPENSPACE,"Susanbury");
            if(postazioneList.size()==0) System.err.println("nessun elemento trovato");
            else
            postazioneList.forEach(elem-> log.info(String.valueOf(elem)));
            log.info("***********************Una prenotazione per data***********************");
            Prenotazione p1= Prenotazione.builder().data_prenotazione(LocalDate.of(2023,11,07)).build();
            p1.setPostazione(postazioneDAO.findById(5));
            p1.setUser(usersDAO.findById(4));
            prenotazioneDAO.save(p1,p1.getPostazione().getId(),prenotazioneDAO);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}