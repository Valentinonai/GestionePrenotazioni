package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Prenotazione;
import Esercizio3112023.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class PrenotazioneSerrvice {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void save(Prenotazione p) {

        prenotazioneRepository.save(p);
        log.info( " salvato correttamente!");
    }

    public void findByIdAndDelete(long id) throws Exception {
     Prenotazione found = this.findById(id);
        prenotazioneRepository.delete(found);
        log.info( " eliminato con successo!");
    }


    public Prenotazione findById(long id) throws Exception{
        return prenotazioneRepository.findById(id).orElseThrow(() -> new Exception("Elemento non trovato"));
    }

public Optional<Postazione> getPostazioneById(LocalDate date, long id){
        return prenotazioneRepository.busyPostazione(date,id);
}



}
