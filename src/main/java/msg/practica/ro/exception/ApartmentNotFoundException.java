package msg.practica.ro.exception;

public class ApartmentNotFoundException extends RuntimeException {

    public ApartmentNotFoundException(Long id) {
        super("Apartment not found with id: " + id);
    }
}
