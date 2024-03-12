package LeffesVHS.service;

import java.util.List;

import LeffesVHS.model.VhsMovie;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

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
    public Response buyMovie(int id) {

        try {
            
            VhsMovie vhsMovieToBuy = entityManager.find(VhsMovie.class, id);

            if (vhsMovieToBuy.getInventoryAmount() <= 0) {
                return Response.status(Response.Status.BAD_REQUEST).entity("We are currently out of stock for this movie").build();
            }

            vhsMovieToBuy.setInventoryAmount(vhsMovieToBuy.getInventoryAmount() - 1);
            entityManager.merge(vhsMovieToBuy);

            return Response.ok(vhsMovieToBuy).build();

        } catch (Exception e) {
            System.out.println(">>>>" + e);
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find movie with ID " + id).build();
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Response changeMovieInventory(int id, int newInventoryAmount) {

        try {

            VhsMovie vhsMovieToChangeInventory = entityManager.find(VhsMovie.class, id);

            if(newInventoryAmount < 0) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Inventory cant be a negative number").build();
            }

            vhsMovieToChangeInventory.setInventoryAmount(newInventoryAmount);
            entityManager.merge(vhsMovieToChangeInventory);

            return Response.ok(vhsMovieToChangeInventory).build();
            
        } catch (Exception e) {
            System.out.println(">>>>" + e);
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find movie with ID " + id).build();
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

    public List<VhsMovie> getMoviesBySearch(String name) {
        @SuppressWarnings("unchecked")
        List<VhsMovie> movies = entityManager.createQuery("SELECT v FROM VhsMovie v WHERE v.name LIKE :name AND v.deleted = false ")
        .setParameter("name", "%" + name + "%")
        .getResultList();

        return movies;
    }
}
