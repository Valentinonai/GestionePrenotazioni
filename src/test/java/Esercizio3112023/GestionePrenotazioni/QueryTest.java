package Esercizio3112023.GestionePrenotazioni;

import Esercizio3112023.GestionePrenotazioni.DAO.PostazioneService;
import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Tipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryTest {
    @Autowired
private PostazioneService ps;
    @Test
void testQuery1(){
        List<Postazione> lp=ps.findPostazione(Tipo.OPENSPACE,"Susanbury");
        System.out.println(lp.size());
        Assertions.assertEquals(2,lp.size());
    }
}
