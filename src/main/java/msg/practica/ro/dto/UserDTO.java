package msg.practica.ro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO{

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String token;

    private String fullName;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String email, String token, String fullName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.token = token;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
