package Esercizio3112023.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "edificio")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}
