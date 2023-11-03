package Esercizio3112023.GestionePrenotazioni;

import Esercizio3112023.GestionePrenotazioni.DAO.EdificioService;
import Esercizio3112023.GestionePrenotazioni.DAO.PostazioneService;
import Esercizio3112023.GestionePrenotazioni.DAO.UserService;
import Esercizio3112023.GestionePrenotazioni.entities.Edificio;
import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Tipo;
import Esercizio3112023.GestionePrenotazioni.entities.User;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    @Override
    public void run(String... args) throws Exception {
        try {
            Faker fkr=new Faker();
            Random rnd=new Random();
            int n= rnd.nextInt(0,3);

            for(int i=0;i<10;i++){
//                User genericUser = User.builder().nome(fkr.name().firstName()).cognome(fkr.name().lastName()).email(fkr.internet().emailAddress()).build();
//                usersDAO.save(genericUser);
//                Edificio genericEdificio = Edificio.builder().name(fkr.address().firstName()).address(fkr.address().fullAddress()).city(fkr.address().city()).build();
//                edificioDAO.save(genericEdificio);
                Postazione genericPostazione = Postazione.builder().description(fkr.commerce().department()).numMax(rnd.nextInt(5,50)).tipo((n==0?Tipo.PRIVATO:n==1?Tipo.OPENSPACE:Tipo.SALA_RIUNIONI)).build();
                postazioneDAO.save(genericPostazione);
            }

        }catch (Exception e){
            log.info(e.getMessage());
        }
    }
}