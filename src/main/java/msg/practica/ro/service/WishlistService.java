package msg.practica.ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Service
public class WishlistService {
    @Autowired
    private EntityManager entityManager;

    public void insertIntoWishlist(Long userId, Long apartmentId){
        StoredProcedureQuery storedProcedure = this.entityManager.createStoredProcedureQuery("inserttowishlist")
                .registerStoredProcedureParameter(0, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);

        storedProcedure.setParameter(0, userId)
                .setParameter(1, apartmentId);

        storedProcedure.execute();
    }
}
