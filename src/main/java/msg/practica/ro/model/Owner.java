package msg.practica.ro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Owners")
@Getter
@Setter
@Table(name = "Owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "url_chart", nullable = false, length = 1000)
    private String urlStatisticsChart;

    @Override
    public String toString() {
        return "First Name: " + firstName +
                ", lastName:" + lastName +
                ", phoneNumber: " + phoneNumber +
                ",\nStatistics Chart: " + urlStatisticsChart;
    }
}
