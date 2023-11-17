package BEU2W3D5.service;


import BEU2W3D5.Exceptions.NotFound;
import BEU2W3D5.Payload.UserPayload;
import BEU2W3D5.entities.Evento;
import BEU2W3D5.entities.User;
import BEU2W3D5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;
import java.io.IOException;
import java.util.List;



@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public Page<User> getAllUsers(int page, int size, String order){
        Pageable p = PageRequest.of (page,size, Sort.by(order));
        return userRepository.findAll(p);

    }
    public User findByEmail(String email) throws NotFound {
        return (User) userRepository.findByEmail(email).orElseThrow(()-> new NotFound("utente con mail"+ email+"non trovato"));

    }

    public User getSingleUser( int id)
    {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("utente non trovato"));
        return user;
    }
    public User findById(int id) throws NotFound{
        return userRepository.findById(id).orElseThrow( ()  -> new NotFound("id"));
    }

    public User createUser (UserPayload userPayload){
        User user= User.builder().nome(userPayload.nome()).cognome(userPayload.cognome()).email(userPayload.email()).username(userPayload.nome()+"_"+userPayload.cognome()).imageUrl("https://picsum.photos/200/300").password((userPayload.password())).build();
        userRepository.save(user);
        return user;



    }
    public User modifyUser(UserPayload userPayload,int id){
        User user=this.getSingleUser(id);
        user.setNome(userPayload.nome());
        user.setCognome(userPayload.cognome());
        user.setEmail(userPayload.email());
        user.setUsername(userPayload.nome()+"_"+userPayload.cognome());
        userRepository.save(user);
        return user;
    }









    public List<Evento> getEventoById(int id){
        List<Evento> eventoList=userRepository.findEventoById(id).orElseThrow(()->new NotFound("Nessun evento associato all'utente selezionato"));
        if(eventoList.isEmpty()) throw new NotFound ("Nessun evento associato all'utente selezionato");
        return eventoList;
    }
}
