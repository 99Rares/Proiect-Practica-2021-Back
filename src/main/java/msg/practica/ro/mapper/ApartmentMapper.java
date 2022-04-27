package msg.practica.ro.mapper;

import msg.practica.ro.dto.ApartmentDTO;
import msg.practica.ro.model.Apartment;

public final class ApartmentMapper {

    public static ApartmentDTO convertEntitytoDTO(Apartment apartment){
        ApartmentDTO apartmentDTO = new ApartmentDTO();
        apartmentDTO.setId(apartment.getId());
        apartmentDTO.setTitleApart(apartment.getTitleApart());
        apartmentDTO.setTransactionType(apartment.getTransactionType());
        apartmentDTO.setPropertyType(apartment.getPropertyType());
        apartmentDTO.setCity(apartment.getCity());
        apartmentDTO.setNeighbourhood(apartment.getNeighbourhood());
        apartmentDTO.setPrice(apartment.getPrice());
        apartmentDTO.setNrRooms(apartment.getNrRooms());
        apartmentDTO.setSurface(apartment.getSurface());
        apartmentDTO.setYearConstruction(apartment.getYearConstruction());
        apartmentDTO.setDescription(apartment.getDescription());
        apartmentDTO.setOwner(apartment.getOwner());
        apartmentDTO.setPictures(apartment.getPictures());

        return apartmentDTO;
    }
}
