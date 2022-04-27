package msg.practica.ro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Pictures")
@Getter
@Setter
@Table(name = "Pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "picture_url", nullable = false, length = 2000)
    private String url;

    @Override
    public String toString() {
        return "Picture{" +
                "url='" + url + '\'' +
                '}';
    }
}
