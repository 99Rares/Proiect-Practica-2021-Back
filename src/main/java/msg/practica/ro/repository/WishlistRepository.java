package msg.practica.ro.repository;

import msg.practica.ro.model.Apartment;
import msg.practica.ro.model.User;
import msg.practica.ro.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findAll();

    @Query("select w.apartment from Wishlist w where w.user.id = ?1")
    List<Apartment> findAllByUserId(Long userId);

    @Query("select count(w.apartment )from Wishlist w where w.apartment.id = ?1")
    Long countDistinctByApartment_Id(Long apartmentID);

    @Query("select count(w.apartment) from Wishlist w join Apartments a on w.apartment.id = a.id where a.owner.id = ?1")
    Long countApartmentsBySpecificOwnerInWishlist(Long ownerId);

    Wishlist findByUserAndApartment(User user, Apartment apartment);
}
