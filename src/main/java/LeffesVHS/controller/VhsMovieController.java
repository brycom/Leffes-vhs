package LeffesVHS.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VhsMovieController {

    @GET
    public Response getAllMovies() {
        return null;
    }

    @GET
    @Path("/{id}")
    public Response getUniqueMovie() {
        return null;

    }

    @GET
    @Path("/{category}")
    public Response getMovieCategory() {
        return null;
    }

    // Används för att köpa en film. vhsMovie --
    @PATCH
    @Path("/buymovie/{id}")
    public Response buyMovie() {
        return null;
    }

    // För Leffe när han inventerar
    @PATCH
    @Path("/changemovieinventory/{id}")
    public Response changeMovieInventory() {
        return null;
    }

    @PATCH
    @Path("/updateprice/{id}")
    public Response updateMoviePrice() {
        return null;
    }

    @POST
    @Path("/addnewmovie")
    public Response addNewMovie() {
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie() {
        return null;
    }

}
