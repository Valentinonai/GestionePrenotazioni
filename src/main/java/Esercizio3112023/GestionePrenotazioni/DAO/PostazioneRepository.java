package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {

}
