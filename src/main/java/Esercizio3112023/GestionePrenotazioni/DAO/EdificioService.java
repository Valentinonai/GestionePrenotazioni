package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Edificio;
import Esercizio3112023.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void save(Edificio ed) {

        edificioRepository.save(ed);
        log.info( " salvato correttamente!");
    }

    public void findByIdAndDelete(long id) throws Exception {
        Edificio found = this.findById(id);
        edificioRepository.delete(found);
        log.info(" eliminato con successo!");
    }


    public Edificio findById(long id) throws Exception{
        return edificioRepository.findById(id).orElseThrow(() -> new Exception("Elemento non trovato"));
    }


}
