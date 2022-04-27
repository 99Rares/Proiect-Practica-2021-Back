package msg.practica.ro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "Apartments")
@Getter
@Setter
@Table(name = "Apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 200)
    private String titleApart;

    @Column(nullable = false, length = 30)
    private String transactionType;

    @Column(nullable = false, length = 30)
    private String propertyType;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 30)
    private String neighbourhood;

    @Column(nullable = false, length = 60)
    private Integer price;

    @Column(nullable = false, length = 10)
    private Integer nrRooms;

    @Column(nullable = false, length = 20)
    private Integer surface;

    @Column(nullable = false, length = 20)
    private Integer yearConstruction;

    @Column(nullable = false, length = 1000)
    private String description;

    @JoinColumn(name = "OWNER_ID")
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Owner owner;

    @JoinColumn(name = "APARTMENT_ID")
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Picture> pictures;

    @Override
    public String toString() {
        return
                "Title: " + titleApart +
                ", Transaction Type: " + transactionType +
                ",\nProperty Type:" + propertyType +
                ", City: " + city +
                ", Neighbourhood: " + neighbourhood +
                ",\nPrice:" + price +
                ", Nr Rooms:" + nrRooms +
                ", Surface:" + surface +
                ",\nYear Construction:" + yearConstruction +
                ", Description: " + description;
    }
}