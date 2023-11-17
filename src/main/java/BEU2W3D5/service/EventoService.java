package BEU2W3D5.service;

import BEU2W3D5.Exceptions.NotFound;
import BEU2W3D5.Exceptions.PostiEsauritiException;
import BEU2W3D5.Exceptions.SingleBadRequest;
import BEU2W3D5.Payload.EventoPayload;
import BEU2W3D5.entities.Evento;
import BEU2W3D5.entities.Prenotazione;
import BEU2W3D5.repository.EventoRepository;
import BEU2W3D5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private static EventoRepository eventoRepository;

    @Autowired
    static UserService userService;
    private int posti;


    public Page<Evento> getAllEventi(int page, int size, String order){
        Pageable p= PageRequest.of(page,size, Sort.by(order));
        return eventoRepository.findAll(p);

    }

    public static Evento getSingleEvento(int id){
        return eventoRepository.findById(id).orElseThrow(()->new NotFound("evento non trovato"));
    }

    public static Evento createEvento(EventoPayload eventoPayload) {
        Evento evento = new Evento();
        evento.setDescrizione(eventoPayload.getDescrizione());
        evento.setLuogo(eventoPayload.getLuogo());
        evento.setTitolo(eventoPayload.getTitolo());
        evento.setPostiDisponibili(eventoPayload.getPosti());
        return eventoRepository.save(evento);
    }


    public void deleteEvento(int id){
        Evento event=this.getSingleEvento(id);
        eventoRepository.delete(event);
    }





    public void prenotaPosto(  int eventoId, int userId) {

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new SingleBadRequest("Evento non trovato"));


        if (evento.getPostiDisponibili() > 0) {

            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setEvento(evento);
            prenotazione.setUserId(userId);


            prenotazioneRepository.save(prenotazione);


            evento.setPostiDisponibili(evento.getPostiDisponibili() - 1);
            eventoRepository.save(evento);
        } else {
            throw new PostiEsauritiException("I posti per questo evento sono esauriti");
        }
    }


}
