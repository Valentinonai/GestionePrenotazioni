package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneSerrvice {
    @Autowired
    private UserRepository prenotazioneRepository;

    public void save(User user) {
        if(user.getNome().length() < 2) throw new RuntimeException("Il nome è troppo corto");
        prenotazioneRepository.save(user);
        log.info(user.getNome() + " salvato correttamente!");
    }

    public void findByIdAndDelete(long id) throws Exception {
        User found = this.findById(id);
        prenotazioneRepository.delete(found);
        log.info("User con id " + id + " eliminato con successo!");
    }


    public User findById(long id) throws Exception{
        return prenotazioneRepository.findById(id).orElseThrow(() -> new Exception("Elemento non trovato"));
    }
}
