package BEU2W3D5.controller;


import BEU2W3D5.Exceptions.BadRequest;
import BEU2W3D5.Payload.UserPayload;
import BEU2W3D5.entities.Evento;
import BEU2W3D5.entities.User;
import BEU2W3D5.service.EventoService;
import BEU2W3D5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EventoService eventoService;
    @GetMapping()
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size, @RequestParam(defaultValue = "id") String order){

        return userService.getAllUsers(page,size>20?5:size,order);
    }
    @GetMapping("/{id}")
    public User getSingleUser(@PathVariable int id){
        return userService.getSingleUser(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Validated UserPayload userPayload, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequest(validation.getAllErrors());
        }
        return userService.createUser(userPayload);
    }
    @PutMapping("/{id}")
    public User modifyUser(@RequestBody @Validated UserPayload userPayload,BindingResult validation,@PathVariable int id){
        if(validation.hasErrors()){
            throw new BadRequest(validation.getAllErrors());
        }
        return userService.modifyUser(userPayload,id);
    }



    @GetMapping("/{id}/eventi")
    public List<Evento> getEventoById(@PathVariable int id){
        return userService.getEventoById(id);
    }
}
