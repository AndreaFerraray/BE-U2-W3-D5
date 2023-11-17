package BEU2W3D5.Exceptions;

import lombok.Getter;

@Getter

public class Unauthorized extends RuntimeException{
    public Unauthorized(String message) {
        super(message);
    }
}

