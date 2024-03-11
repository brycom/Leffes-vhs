package LeffesVHS.service;

import java.util.List;


import LeffesVHS.model.VhsPlayer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class VhsPlayerService {

    @Inject
    EntityManager entityManager;

     public List<VhsPlayer> findAll(){
        List<VhsPlayer> players = entityManager.createQuery("SELECT v FROM VhsPlayer v", VhsPlayer.class).getResultList();
        return players;
    }

     public List<VhsPlayer> findAllNotSoftDeleted(){
        List<VhsPlayer> players = entityManager.createQuery("SELECT v FROM VhsPlayer v WHERE v.deleted = false", VhsPlayer.class).getResultList();
        return players;
    }

    public VhsPlayer getPlayerById(int id) {
        return entityManager.find(VhsPlayer.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public VhsPlayer createNewPlayer(VhsPlayer newVhsPlayer) {
        try {

            entityManager.persist(newVhsPlayer);
            return newVhsPlayer;

        } catch (Exception e) {

            System.out.println(">>>>>" + e);
            return null;
            
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Response buyPlayer(int id) {
    
        try {
                
            VhsPlayer vhsPlayerToBuy = entityManager.find(VhsPlayer.class, id);
    
            if (vhsPlayerToBuy.getInventoryAmount() <= 0) {

                return Response.status(Response.Status.BAD_REQUEST).entity("We are currently out of stock for this player").build();

            }
    
            vhsPlayerToBuy.setInventoryAmount(vhsPlayerToBuy.getInventoryAmount() - 1);
            entityManager.merge(vhsPlayerToBuy);
    
            return Response.ok(vhsPlayerToBuy).build();
    
        } catch (Exception e) {
            System.out.println(">>>>" + e);
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find player with ID " + id).build();
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Response changePlayerInventory(int id, int newInventoryAmount) {
        try {

            VhsPlayer vhsPlayerToChangeInventory = entityManager.find(VhsPlayer.class, id);

            if(newInventoryAmount < 0) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Inventory cant be a negative number").build();
            }

            vhsPlayerToChangeInventory.setInventoryAmount(newInventoryAmount);
            entityManager.merge(vhsPlayerToChangeInventory);

            return Response.ok(vhsPlayerToChangeInventory).build();
            
        } catch (Exception e) {
            System.out.println(">>>>" + e);
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find player with ID " + id).build();
        }
    }
}
