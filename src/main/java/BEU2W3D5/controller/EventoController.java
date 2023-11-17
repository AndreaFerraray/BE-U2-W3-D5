package BEU2W3D5.controller;


import BEU2W3D5.Exceptions.BadRequest;
import BEU2W3D5.Payload.EventoPayload;
import BEU2W3D5.entities.Evento;
import BEU2W3D5.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventi")
public class EventoController {
    @Autowired
    private EventoService eventoService;



    @GetMapping("/{id}")
    public Evento getSingleEvento(@PathVariable int id){
        return eventoService.getSingleEvento(id);

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Evento createEvento(@RequestBody @Validated EventoPayload evento, BindingResult validation){


        if(validation.hasErrors())
            throw new BadRequest(validation.getAllErrors());
        return EventoService.createEvento(evento);
    }

}