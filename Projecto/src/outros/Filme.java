/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package outros;

import javax.swing.Icon;

/**
 *
 * @author Daniela
 */
public class Filme {
    private String titulo;
    private int ano;
    private String[] generos;
    private String realizador;
    private String produtora;
    private String pais;
    private Icon capa;
    private String descricao;
    private double ratingIMDB;

    public Filme(String titulo,
            int ano,
            String[] generos,
            String realizador,
            String produtora,
            String pais,
            Icon capa,
            String descricao,
            double ratingIMDB) {

        this.titulo=titulo;
        this.ano=ano;
        this.generos=generos;
        this.realizador=realizador;
        this.produtora=produtora;
        this.pais=pais;
        this.descricao=descricao;
        this.capa=capa;
        this.ratingIMDB=ratingIMDB;

    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Icon getCapa() {
        return capa;
    }

    public void setCapa(Icon capa) {
        this.capa = capa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public double getRatingIMDB() {
        return ratingIMDB;
    }

    public void setRatingIMDB(double ratingIMDB) {
        this.ratingIMDB = ratingIMDB;
    }

    public String getRealizador() {
        return realizador;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
