package LeffesVHS.service;

import java.util.List;

import LeffesVHS.model.VhsMovie;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class VhsMovieService {

    @Inject
    EntityManager entityManager;

    public List<VhsMovie> findAll(){
        List<VhsMovie> books = entityManager.createQuery("SELECT v FROM VhsMovie v", VhsMovie.class).getResultList();
        return books;
    }
}
