/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores_atm;

/**
 *
 * @author Daniela
 */
public class GestorUtilizadores {
    private String username;

    /**
     * procura autenticar um cliente no sistema
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password){
        return null;
    }

    /**
     * faz display dos dados pessoais do utiizador
     * @return
     */
    public String verDadosPessoais(){
        return null;
    }

    /**
     * faz display dos dados pessoais do utiizador
     * @return
     */
    public String verHistorico(){
        return null;
    }

    /**
     * Cada parâmetro pode ser null se não for para ser utilizado na mega query
     * @param titulo
     * @param ano
     * @param imdbBegin
     * @param imdbEnd
     * @param realizador
     * @param produtor
     * @param pais
     * @return lista com resultados
     */
    public String searchMovie(String titulo,
                            String ano,
                            String imdbBegin,
                            String imdbEnd,
                            String realizador ,
                            String produtor ,
                            String pais){
            return null;
    }

    /**
     * aluga um filme
     * @param id
     * @param formato
     * @return
     */
    public String alugar(String id, String formato){
        return null;

    }

    /**
     * entrega um filme requisitado
     * @param idRequisicao
     * @return
     */
    public String entregar(String idRequisicao ){
        return null;
    }
    /**
     * mostra a lista de requisiçoes actuais do cliente
     * @return
     */
    public String verListadeRequisicoes(){
        return null;
    }

    /**
     * calcula o preço da requisição
     * @return
     */
    public String calcularPrecoRequisicao(String idRequisicao ){
        return null;
    }
}
