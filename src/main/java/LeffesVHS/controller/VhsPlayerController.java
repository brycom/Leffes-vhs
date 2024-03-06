package LeffesVHS.controller;

import java.util.List;

import LeffesVHS.model.VhsPlayer;
import LeffesVHS.service.VhsPlayerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VhsPlayerController {

    @Inject
    VhsPlayerService vhsPlayerService;

    @GET
    public Response getAllPlayers() {
        List<VhsPlayer> players = vhsPlayerService.findAll();

        if (players.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(players).build();
    }

    @GET
    @Path("/{id}")
    public Response getUniquePlayer(@PathParam("id") int id) {

        VhsPlayer uniquePlayer = vhsPlayerService.getPlayerById(id);

        if(uniquePlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find a movie with ID: " + id).build();
        }

        return Response.ok(uniquePlayer).build();

    }

    // Används för att köpa en spelare. vhsPlayer --
    @PATCH
    @Path("/buyplayer/{id}")
    public Response buyPlayer(@PathParam("id") int id) {
    
        return vhsPlayerService.buyPlayer(id);
    
    }

    // För Leffe när han inventerar
    @PATCH
    @Path("/changeplayerinventory/{id}/{newInventoryAmount}")
    public Response changePlayerInventory(@PathParam("id") int id, @PathParam("newInventoryAmount") int newInventoryAmount) {
    
        return vhsPlayerService.changePlayerInventory(id, newInventoryAmount);
            
    }

    @PATCH
    @Path("/updateprice/{id}")
    public Response updatePlayerPrice() {
        return null;
    }

    @POST
    @Path("/addnewplayer")
    public Response addNewPlayer(VhsPlayer newVhsPlayer) {

        if(newVhsPlayer.getPrice() == 0.0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You must give the player a price").build();
        }

        if (newVhsPlayer.getName() == null || newVhsPlayer.getName().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You must give the player a name").build();
        }

        VhsPlayer createdVhsPlayer = vhsPlayerService.createNewPlayer(newVhsPlayer);

        return Response.ok(createdVhsPlayer).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deletePlayer() {
        return null;
    }

}
