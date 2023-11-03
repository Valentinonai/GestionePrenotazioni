package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {
// @Query(value = "select* from postazione join prenotazione on postazione_id=postazione.id where data_prenotazione=:data AND postazione.id=:id",nativeQuery = true)
 @Query("select p from Postazione p where p.id=:id and :data in(select pr.data_prenotazione from Prenotazione pr)")
   Optional<Postazione> busyPostazione(LocalDate data, Long id);
}
