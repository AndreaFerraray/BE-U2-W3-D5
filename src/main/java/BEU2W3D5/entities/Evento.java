package BEU2W3D5.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="titolo")
    private String titolo;

    @Column(name="descrizione")
    private String descrizione ;

    @Column(name="luogo")
    private String luogo;

    @Column(name="posti")
    private int posti;
    @Column(name = "posti_disponibili")
    private int postiDisponibili;

    @Column(name = "immagine")
    private String imageUrl;



    @ManyToOne
    @JoinColumn
    private User user;}
