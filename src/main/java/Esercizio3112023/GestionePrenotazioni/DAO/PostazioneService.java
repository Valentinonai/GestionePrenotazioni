package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Prenotazione;
import Esercizio3112023.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void save(Postazione p) {

        postazioneRepository.save(p);
        log.info( " salvato correttamente!");
    }

    public void findByIdAndDelete(long id) throws Exception {
    Postazione found = this.findById(id);
        postazioneRepository.delete(found);
        log.info("eliminato con successo!");
    }


    public Postazione findById(long id) throws Exception{
        return postazioneRepository.findById(id).orElseThrow(() -> new Exception("Elemento non trovato"));
    }


}
