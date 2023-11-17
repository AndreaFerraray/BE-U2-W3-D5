package BEU2W3D5.entities;

import jakarta.persistence.*;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private int userId;

    public void setUserId(int userId) {
    }

    public void setEvento(Evento evento) {
    }
}
