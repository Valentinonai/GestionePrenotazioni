package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {
//    @Query("select p from Postazione p where p.tipo=:tipo and p.edificio.city=:city")
//   List<Postazione>  findPostazione(Tipo tipo, String city);
    List<Postazione> findByTipoAndEdificioCity(Tipo tipo, String city);
}
