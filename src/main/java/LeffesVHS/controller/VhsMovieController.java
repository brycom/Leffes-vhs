package LeffesVHS.controller;

import java.util.List;

import LeffesVHS.model.VhsMovie;
import LeffesVHS.service.VhsMovieService;
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

@Path("/api/v1/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VhsMovieController {

    @Inject
    VhsMovieService vhsMovieService;

    @GET
    public Response getAllMovies() {
        List<VhsMovie> movies = vhsMovieService.findAll();

        if (movies.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(movies).build();
    }

    @GET
    @Path("/{id}")
    public Response getUniqueMovie(@PathParam("id") int id) {

        VhsMovie uniqueMovie = vhsMovieService.getMovieById(id);

        if (uniqueMovie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find a movie with ID: " + id).build();

        }
        return Response.ok(uniqueMovie).build();
    }

    @GET
    @Path("/category/{category}")
    public Response getMovieCategory(@PathParam("category") String category) {
        List<VhsMovie> movies = vhsMovieService.getMoviesByCategory(category);
         if(movies.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok(movies).build();
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
    public Response addNewMovie(VhsMovie newMovie) {

        if(newMovie.getPrice() == 0.0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You must give the movie a price").build();
        }

        if (newMovie.getName() == null || newMovie.getName().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("You must give the movie a name").build();
        }

        VhsMovie createdMovie = vhsMovieService.createNewMovie(newMovie);

        return Response.ok(createdMovie).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") int id) {

        VhsMovie movieToDelete = vhsMovieService.deleteMovie(id);

        if (movieToDelete == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Could not find a movie with ID: " + id).build();
        }

        return Response.status(Response.Status.OK).entity("The Movie: \"" + movieToDelete.getName() + "\" Was Deleted").build();

    }

}
