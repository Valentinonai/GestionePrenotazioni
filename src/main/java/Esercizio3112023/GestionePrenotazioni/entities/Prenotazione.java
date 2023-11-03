package Esercizio3112023.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazione")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data_prenotazione;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public LocalDate getData_prenotazione() {
        return data_prenotazione;
    }

    public void setData_prenotazione(LocalDate data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", data_prenotazione=" + data_prenotazione +
                '}';
    }
}
