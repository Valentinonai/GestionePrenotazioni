package Esercizio3112023.GestionePrenotazioni.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Random;

@Entity
@Table(name = "postazione")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Postazione {
 @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int numMax;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List< Prenotazione> prenotazione;



 public void setEdificio(Edificio edificio) {
  this.edificio = edificio;
 }

// public void setPrenotazione(Prenotazione prenotazione) {
//  this.prenotazione.add(prenotazione) ;
// }
}
