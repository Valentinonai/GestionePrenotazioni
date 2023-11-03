package Esercizio3112023.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazione")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Postazione {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String description;
    private Tipo tipo;
    private int numMax;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToOne(mappedBy = "postazione")
    private Prenotazione prenotazione;

}
