
package gestores_atm;

import bd.DBHandler;
import outros.Utils;

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
        //return DBHandler.;
    }

    /**
     * faz display dos dados pessoais do utiizador
     * @return
     */
    public String [] verDadosPessoais(String username){
        //pesquisar na base de dados e devolver uma string com os dados
        //nao sei se sao estas as funçoes
        DBHandler.getCliente(username);
        //String [] dados = {"pedro","daniel","daniela"};
        return DBHandler.getCliente(username);
    }

    /**
     * faz display dos dados pessoais do utiizador
     * @return
     */
    // TODO
    public String [] verHistorico(){
        //pesquisar pelo username e devolver uma listagem do historico
        String [] hist = {"pedro","daniel","daniela"};
        return hist;
    }

    /**
     * aluga um filme
     * @param id
     * @param formato
     * @return
     */
    // TODO
    public String alugar(String id, String formato){
        Utils.dbg("id: "+id);
        Utils.dbg("formato: "+formato);
        return null;

    }

    /**
     * entrega um filme requisitado
     * @param idRequisicao
     * @return
     */
    // TODO
    public String entregar(String idRequisicao ){
        Utils.dbg("id_req: "+idRequisicao);
        return null;
    }
    /**
     * mostra a lista de requisiçoes actuais do cliente
     * @return
     */
    // TODO
    public String [] verListadeRequisicoes(){
        String [] reqs = {"pedro","daniel","daniela"};
        return reqs;
    }

    /**
     * calcula o preço da requisição
     * @return
     */
    // TODO
    public String calcularPrecoRequisicao(String idRequisicao ){
        Utils.dbg("id_req: "+idRequisicao);
        return "100";
    }
}
