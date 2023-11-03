package Esercizio3112023.GestionePrenotazioni.DAO;

import Esercizio3112023.GestionePrenotazioni.entities.Postazione;
import Esercizio3112023.GestionePrenotazioni.entities.Prenotazione;
import Esercizio3112023.GestionePrenotazioni.entities.User;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
@ToString
public class PrenotazioneSerrvice {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void save(Prenotazione p,long id_postazione,PrenotazioneSerrvice prenotazioneDAO) {
try{
   Optional<Postazione> pr = prenotazioneDAO.getPostazioneById(p.getData_prenotazione(),id_postazione);
    Optional<Prenotazione>prenotazione=prenotazioneDAO.findPrenotazionePerUser(p.getData_prenotazione(),p.getUser().getId());
   if(pr.isEmpty() && prenotazione.isEmpty())
   {
       prenotazioneRepository.save(p);
       System.err.println( " salvato correttamente!");
   }

   else{
        log.info("Postazione occupata o prenotazione già presente per la data selezionata");

   }

}catch (Exception e){
    log.error(e.getMessage());
}


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

   public  Optional<Prenotazione> findPrenotazionePerUser(LocalDate data,long id_user){
        return  prenotazioneRepository.findPrenotazionePerUser(data,id_user);
   }

}
