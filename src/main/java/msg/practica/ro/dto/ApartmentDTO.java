package msg.practica.ro.dto;

import lombok.Getter;
import lombok.Setter;
import msg.practica.ro.model.Owner;
import msg.practica.ro.model.Picture;
import java.util.List;

@Getter
@Setter
public class ApartmentDTO {
    private Long id;

    private String titleApart;

    private String transactionType;

    private String propertyType;

    private String city;

    private String neighbourhood;

    private Integer price;

    private Integer nrRooms;

    private Integer surface;

    private Integer yearConstruction;

    private String description;

    private Owner owner;

    private List<Picture> pictures;

    public ApartmentDTO() {
    }

    public ApartmentDTO(Long id, String titleApart, String transactionType, String propertyType, String city, String neighbourhood, Integer price, Integer nrRooms, Integer surface, Integer yearConstruction, String description, Owner owner, List<Picture> pictures) {
        this.id = id;
        this.titleApart = titleApart;
        this.transactionType = transactionType;
        this.propertyType = propertyType;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.price = price;
        this.nrRooms = nrRooms;
        this.surface = surface;
        this.yearConstruction = yearConstruction;
        this.description = description;
        this.owner = owner;
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "ApartmentDTO{" +
                "id=" + id +
                ", titleApart='" + titleApart + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", city='" + city + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", price=" + price +
                ", nrRooms=" + nrRooms +
                ", surface=" + surface +
                ", yearConstruction=" + yearConstruction +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", pictures=" + pictures +
                '}';
    }
}
