package msg.practica.ro.exception;

public class WishlistNotFoundException extends RuntimeException{
    public WishlistNotFoundException(Long id) {
        super("Wishlist not found with id: " + id);
    }
}
