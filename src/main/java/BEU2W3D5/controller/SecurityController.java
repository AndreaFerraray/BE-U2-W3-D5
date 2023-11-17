package BEU2W3D5.controller;


import BEU2W3D5.Payload.UserLoginSuccessDTO;
import BEU2W3D5.entities.UserLoginDTO;
import BEU2W3D5.security.JWTTools;
import BEU2W3D5.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {
@Autowired
    private JWTTools jwtTools;
@Autowired
SecurityService securityService;

    @PostMapping("/login")
    private UserLoginSuccessDTO login(@RequestBody UserLoginDTO body){


        return new UserLoginSuccessDTO(securityService.authenticateUser(body) );
    }
}
