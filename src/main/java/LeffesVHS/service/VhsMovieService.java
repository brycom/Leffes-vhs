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
        List<VhsMovie> movies = entityManager.createQuery("SELECT v FROM VhsMovie v", VhsMovie.class).getResultList();
        return movies;
    }

    public List<VhsMovie> findAllNotSoftDeleted(){
        List<VhsMovie> movies = entityManager.createQuery("SELECT v FROM VhsMovie v WHERE v.deleted = false", VhsMovie.class).getResultList();
        return movies;
    }

    public VhsMovie getMovieById(int id) {
        return entityManager.find(VhsMovie.class, id);
    }

    public List<VhsMovie> getMoviesByCategory(String category) {
        @SuppressWarnings("unchecked")
        List<VhsMovie> movies = entityManager.createQuery("SELECT v FROM VhsMovie v WHERE v.category LIKE :category")
        .setParameter("category", "%" + category + "%")
        .getResultList();

        return movies;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public VhsMovie createNewMovie(VhsMovie vhsMovie) {
        try {
            entityManager.persist(vhsMovie);
            return vhsMovie;
        } catch (Exception e) {
            System.out.println(">>>>>>" + e);
            return null;
        }
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public VhsMovie deleteMovie(int id) {
        VhsMovie movieToDelete = entityManager.find(VhsMovie.class, id);

        try {

            movieToDelete.setDeleted(true);
            entityManager.merge(movieToDelete);
            return movieToDelete;

        } catch (Exception e) {

            System.out.println(">>>>>>" + e);
            return null;
            
        }
    }

    @Transactional(Transactional.TxType.REQUIRED) 
    public VhsMovie buyMovie(int id) {
        VhsMovie existingMovie = entityManager.find(VhsMovie.class, id);
            
             existingMovie.setInventoryAmount(existingMovie.getInventoryAmount()- 1);
           
        return entityManager.merge(existingMovie);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public VhsMovie changeMovieInventory(int id, int newInventoryAmount) {

        try {

            VhsMovie movieInventoryToChange = entityManager.find(VhsMovie.class, id);
            movieInventoryToChange.setInventoryAmount(newInventoryAmount);
            entityManager.merge(movieInventoryToChange);
            return movieInventoryToChange;
            
        } catch (Exception e) {

            System.out.println(">>>>>" + e);
            return null;

        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public VhsMovie updateMoviePrice(int id, double newPrice) {

        try {

            VhsMovie movieWithNewPrice = entityManager.find(VhsMovie.class, id);
            movieWithNewPrice.setPrice(newPrice);
            entityManager.merge(movieWithNewPrice);
            return movieWithNewPrice;

        } catch (Exception e) {

            System.out.println(">>>>" + e);
            return null;

        }

    }
}
