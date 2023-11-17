package BEU2W3D5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "Users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "cognome",nullable = false)
    private String cognome;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "immagine")
    private String imageUrl;
    @Column(name="password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private TipoUtente tipo;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Evento> listaEventi;

}