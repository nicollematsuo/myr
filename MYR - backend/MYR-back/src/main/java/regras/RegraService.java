/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 *
 * @author kamil
 */
@Path("/regras")
public class RegraService {
    
    static Integer count;
    List<Regra> regras;
    
    public RegraService(){
        regras = new ArrayList<>();
        count = 1;
    }    
    
    @GET
    public List<Regra> getRegras(){
        return regras;
    }
    
    @POST
    public void adicionar(Regra regra){
        regra.setId(count++);
        regras.add(regra);
    }
    
    @PUT
    @Path("(id)")
    public void atualizar(@PathParam("id") Integer id, Regra regra){
        for(Regra r : regras){
            if(r.getId().equals(id)){
                r.setDescricao(regra.getDescricao());
                r.setNome(regra.getNome());
                r.setParEntrada(regra.getParEntrada());
                r.setParSaida(regra.getParSaida());
                break;
            }
        }
    }
    
    @DELETE
    @Path("(id)")
    public void excluir(@PathParam("id") Integer id, Regra regra){
        for(Regra r : regras){
            if(r.getId().equals(id)){
                regras.remove(r);
                break;
            }
        }
    }
    
    @GET
    @Path("(id)")
    public Regra getRegra(@PathParam("id") Integer id, Regra regra){
        for(Regra r : regras){
            if(r.getId().equals(id)){
               return r;
            }
        }
        return null;
    }
    
    
    
    
    
}
