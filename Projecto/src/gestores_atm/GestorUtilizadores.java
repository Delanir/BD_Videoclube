/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores_atm;

import outros.Filme;

/**
 *
 * @author Daniela
 */
public class GestorUtilizadores {
    private String username;
    private String password;

    /**
     * procura autenticar um cliente no sistema
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password){
        //se login se confirmar, guardar campos de username e password
        return username;
        //return null;
    }

    /**
     * faz display dos dados pessoais do utiizador
     * @return
     */
    public String [] verDadosPessoais(){
        //pesquisar na base de dados e devolver uma string com os dados
        String [] dados = {"pedro","daniel","daniela"};
        return dados;
    }

    /**
     * faz display dos dados pessoais do utiizador
     * @return
     */
    public String [] verHistorico(){
        //pesquisar pelo username e devolver uma listagem do historico
        String [] hist = {"pedro","daniel","daniela"};
        return hist;
    }

    /**
     * Cada parâmetro pode ser null se não for para ser utilizado na mega query
     * @param titulo
     * @param ano
     * @param imdbBegin
     * @param imdbEnd
     * @param realizador
     * @param produtor
     * @param pais -> mudei para género porque parecia-me que era o que se kia By PMMA
     * @return lista com resultados
     */
    public Filme [] searchMovie(String titulo,
                            String ano,
                            String imdbBegin,
                            String imdbEnd,
                            String realizador ,
                            String produtor ,
                            String genero){
        System.out.println("tit:"+titulo);
        System.out.println("ano:"+ano);
        System.out.println("imB:"+imdbBegin);
        System.out.println("imE:"+imdbEnd);
        System.out.println("rea:"+realizador);
        System.out.println("pro:"+produtor);
        System.out.println("gen:"+genero);
        String [] gens = {"terror","drama","XXX"};
        Filme [] film = {new Filme("titulo",
            2000,
            gens,
            "realizador",
            "produtor",
            "pais",
            null,
            "descricao",
            11.2)};
        return film;
    }

    /**
     * aluga um filme
     * @param id
     * @param formato
     * @return
     */
    public String alugar(String id, String formato){
        System.out.println("id: "+id);
        System.out.println("formato: "+formato);
        return null;

    }

    /**
     * entrega um filme requisitado
     * @param idRequisicao
     * @return
     */
    public String entregar(String idRequisicao ){
        System.out.println("id_req: "+idRequisicao);
        return null;
    }
    /**
     * mostra a lista de requisiçoes actuais do cliente
     * @return
     */
    public String [] verListadeRequisicoes(){
        String [] reqs = {"pedro","daniel","daniela"};
        return reqs;
    }

    /**
     * calcula o preço da requisição
     * @return
     */
    public String calcularPrecoRequisicao(String idRequisicao ){
        System.out.println("id_req: "+idRequisicao);
        return "100";
    }

    public String [] verListadeGeneros(){
        String [] gens = {"terror","drama","XXX"};
        return gens;
    }
}
