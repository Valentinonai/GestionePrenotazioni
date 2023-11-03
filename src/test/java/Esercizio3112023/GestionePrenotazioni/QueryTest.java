package Esercizio3112023.GestionePrenotazioni;

import Esercizio3112023.GestionePrenotazioni.DAO.PostazioneService;
import Esercizio3112023.GestionePrenotazioni.DAO.PrenotazioneSerrvice;
import Esercizio3112023.GestionePrenotazioni.DAO.UserService;
import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Prenotazione;
import Esercizio3112023.GestionePrenotazioni.entities.Tipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryTest {
    @Autowired
private PostazioneService ps;
    @Autowired
    private UserService us;
    @Autowired
    private PrenotazioneSerrvice prs;


    @Test
    void testQuery1() throws Exception {

       Optional<Prenotazione> p= prs.getPostazioneById(LocalDate.of(2023,11,05),9);
        Assertions.assertTrue(p.isEmpty());
    }
    @Test
void testQuery2(){
        List<Postazione> lp=ps.findPostazione(Tipo.OPENSPACE,"Susanbury");
        System.out.println(lp.size());
        Assertions.assertEquals(2,lp.size());
    }
}
