package BEU2W3D5.security;


import BEU2W3D5.Exceptions.Unauthorized;
import BEU2W3D5.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {
    @Value("${spring.jwt.secret}")
    private String secret;
    public String createToken(User user){

        return Jwts.builder().setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7 ) )
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();

    }
    public void verifyToken(String token){
        ;
        try {

            token = token.trim();

            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build().parse(token);
        } catch (Exception ex){

            throw new Unauthorized("Il token non è valido! Per favore effettua nuovamente il login!"); //ERRORE
        }

    }


public String gextractIdFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJwt(token).getBody().getSubject();

}

}
