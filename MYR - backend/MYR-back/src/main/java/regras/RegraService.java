/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author kamil
 */
@Stateless
@Path("/regras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegraService {
    
    @PersistenceContext(unitName = "RegrasPU")
    private EntityManager entityManager;
      
    public RegraService(){
    }    
    
    @GET
    public List<Regra> getRegras(){
        Query query = entityManager.createQuery("SELECT r FROM Regra r");
        query.getResultList();
        return (List<Regra>) query;
    }
    
    @POST
    public Regra adicionar(Regra regra){
        entityManager.persist(regra);
        return regra;
    }
    
    @PUT
    @Path("(id)")
    public Regra atualizar(@PathParam("id") Integer id, Regra regraAtualizada){
        Regra regraEncontrada = getRegra(id);
        regraEncontrada.setNome(regraAtualizada.getNome());
        regraEncontrada.setDescricao(regraAtualizada.getDescricao());
        regraEncontrada.setParEntrada(regraAtualizada.getParEntrada());
        regraEncontrada.setParSaida(regraAtualizada.getParSaida());
        
        entityManager.merge(regraEncontrada);
        return regraEncontrada;
    }
    
    @DELETE
    @Path("(id)")
    public Regra excluir(@PathParam("id") Integer id){
        Regra regra = getRegra(id);
        entityManager.remove(regra);
        return regra;
    }
    
    @GET
    @Path("(id)")
    public Regra getRegra(@PathParam("id") Integer id){
        return entityManager.find(Regra.class, id);
    }
    
    
    
    
    
}
