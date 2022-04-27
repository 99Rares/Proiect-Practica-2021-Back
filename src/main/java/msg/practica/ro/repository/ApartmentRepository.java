package msg.practica.ro.repository;

import msg.practica.ro.model.Apartment;
import msg.practica.ro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findAll();

    @Query("select a from Apartments a where a.owner.id = ?1")
    List<Apartment> findApartmentsByOwner(Long id);

}
