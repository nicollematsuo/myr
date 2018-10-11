package regras;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author kamilla
 */
@Entity
@Table(name = "regrasDeNegocio", schema = "public")
public class Regra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "O campo nome não pode ser nulo")
    private String nome;
    private String descricao;
    private String parEntrada;
    private String parSaida;
    
    public Regra(){
    }
    
    public Regra(Integer id, String nome, String descricao, String parEntrada, String parSaida){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.parEntrada = parEntrada;
        this.parSaida = parSaida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getParEntrada() {
        return parEntrada;
    }

    public void setParEntrada(String parEntrada) {
        this.parEntrada = parEntrada;
    }

    public String getParSaida() {
        return parSaida;
    }

    public void setParSaida(String parSaida) {
        this.parSaida = parSaida;
    }
   
    
    
}
