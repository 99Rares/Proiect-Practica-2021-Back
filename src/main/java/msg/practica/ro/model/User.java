package msg.practica.ro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Users")

//@NamedQueries({
//        @NamedQuery(name = "User.findByFirstName",
//                query = "SELECT u FROM User u WHERE u.first_name = :first_name") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    public User() {
        super();
        this.verified = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verified=" + verified +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}