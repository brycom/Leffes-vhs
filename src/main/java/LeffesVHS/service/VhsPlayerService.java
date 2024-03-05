package LeffesVHS.service;

import java.util.List;

import LeffesVHS.model.VhsPlayer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional(Transactional.TxType.SUPPORTS) 
@ApplicationScoped
public class VhsPlayerService {

    @Inject
    EntityManager entityManager;

     public List<VhsPlayer> findAll(){
        List<VhsPlayer> players = entityManager.createQuery("SELECT v FROM VhsPlayer v", VhsPlayer.class).getResultList();
        return players;
    }
}
