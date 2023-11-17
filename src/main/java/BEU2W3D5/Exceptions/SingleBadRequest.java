package BEU2W3D5.Exceptions;

public class SingleBadRequest extends RuntimeException{
    public SingleBadRequest(String message) {
        super(message);
    }
}