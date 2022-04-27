package msg.practica.ro.model;

import lombok.Getter;
import lombok.Setter;
import msg.practica.ro.controller.UserController;
import msg.practica.ro.repository.UserRepository;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    Apartment apartment;

//    public Wishlist() {}
//
//    public Wishlist(Long userId, Long apartmentId) {
//        UserRepository userRepository = userController.getUserRepo();
//
//        ApartmentController apartmentController = new ApartmentController();
//        ApartmentRepository apartmentRepository = apartmentController.getApartmentRepo();
//
//        this.user = userRepository.findUserById(userId);
//        this.apartment = apartmentRepository.findApartmentById(apartmentId);
//    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", user=" + user +
                ", apartment=" + apartment +
                '}';
    }
}
