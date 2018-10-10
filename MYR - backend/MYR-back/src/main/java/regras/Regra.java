package regras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kamil
 */
public class Regra {
    
    private Integer id;
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
