package msg.practica.ro.exception;

public class PictureNotFoundException extends RuntimeException{
    public PictureNotFoundException(Long id) {
        super("Picture not found with id: " + id);
    }
}
