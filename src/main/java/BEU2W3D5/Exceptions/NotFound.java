package BEU2W3D5.Exceptions;

import lombok.Getter;

@Getter
public class NotFound extends  RuntimeException{
    public  NotFound(String message) {
        super(message);
    }
}