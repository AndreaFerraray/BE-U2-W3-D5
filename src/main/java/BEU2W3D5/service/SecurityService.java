package BEU2W3D5.service;


import BEU2W3D5.Exceptions.Unauthorized;
import BEU2W3D5.entities.User;
import BEU2W3D5.entities.UserLoginDTO;
import BEU2W3D5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTools jwtTools;

    public String authenticateUser(UserLoginDTO body){
        User user = userService.findByEmail(body.email());
        if(body.password().equals(user.getPassword())){
            return jwtTools.createToken(user);
        }
        else{
            throw new Unauthorized("credenziali non valide");
        }


    }


}
