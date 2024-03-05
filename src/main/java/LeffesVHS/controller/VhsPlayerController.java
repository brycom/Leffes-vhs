package LeffesVHS.controller;

import java.util.List;

import LeffesVHS.model.VhsMovie;
import LeffesVHS.model.VhsPlayer;
import LeffesVHS.service.VhsPlayerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
    public Response getUniquePlayer() {
        return null;

    }

    // Används för att köpa en spelare. vhsPlayer --
    @PATCH
    @Path("/buyplayer/{id}")
    public Response buyPlayer() {
        return null;
    }

    // För Leffe när han inventerar
    @PATCH
    @Path("/changeplayerinventory/{id}")
    public Response changePlayerInventory() {
        return null;
    }

    @PATCH
    @Path("/updateprice/{id}")
    public Response updatePlayerPrice() {
        return null;
    }

    @POST
    @Path("/addnewplayer")
    public Response addNewPlayer() {
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response deletePlayer() {
        return null;
    }

}
