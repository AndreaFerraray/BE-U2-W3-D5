package BEU2W3D5.repository;

import BEU2W3D5.entities.Evento;

import BEU2W3D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query
            (value = "select u.listaEventi from User u where u.id=:id")
    Optional<List<Evento>> findEventoById(int id);


    <User> Optional <User> findByEmail(String email);
}
