package org.example.web;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entities.Compte;
import org.example.repositories.CompteRepository;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    private CompteRepository compteRepository;
    @Path("/compte")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Transactional
    public List<Compte> compteList(){return compteRepository.findAll();}
    @Path("/compte/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value="id")Long id){return compteRepository.findById(id).get();}
    @Path("/compte")
    @POST

    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){return compteRepository.save(compte);}
    @Path("/compe/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update (Compte compte,@PathParam("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/compte/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id")Long id){compteRepository.deleteById(id);}
}

