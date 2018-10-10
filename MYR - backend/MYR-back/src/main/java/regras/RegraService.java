/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;


/**
 *
 * @author kamil
 */
public class RegraService {
    
    List<Regra> regras;
    
    public RegraService(){
        regras = new ArrayList<>();
    }    
    
    @GET
    public List<Regra> getRegras(){
        return regras;
    }
    
    
    
    
    
}
