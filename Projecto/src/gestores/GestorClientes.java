/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

/**
 * monitoriza clientes
 * @author Daniela
 */
public class GestorClientes
{
	/**
	 * Adiciona um novo cliente ao sistema
	 * @param nome
	 * @param telefone
	 * @param bi
	 * @param password
	 * @param email
	 * @param morada
	 * @return
	 */
	public String addClient(String nome, String telefone, String bi, String password, String email, String morada) {
		return null;
	}

	/**
	 * actualza os campos não nulos no cliente
	 * @param nome
	 * @param telefone
	 * @param bi
	 * @param password
	 * @param email
	 * @param morada
	 * @return
	 */
	public String actualizaCliente(String id, String nome, String telefone, String bi, String password, String email, String morada) {
		return null;
	}

	/**
	 * Devolve informações relativas oa cliente em questão
	 * @param id
	 * @return
	 */
	public String procuraCliente(String id) {
		return null;
	}

	/**
	 * Procura clientes que respeitem as informações não nulas dadas!
	 * @param id
	 * @param nome
	 * @param telefone
	 * @param bi
	 * @param email
	 * @param morada
	 * @return
	 */
	public String procuraCliente(String id, String nome, String telefone, String bi, String email, String morada) {
		return null;
	}

	/**
	 * Lista clientes activos no sistema
	 * @return
	 */
	public String[] listaClientes() {
		return null;
	}

	/**
	 * apaga um cliente do sistema
	 * @param id
	 * @return
	 */
	public String  deleteClient(String id) {
		return null;
	}

	/**
	 * devolve uma lista com os clientes que têm pagamentos em atraso
	 * @return
	 */
	public String verificaClientesComPagamentosEmAtraso() {
		return null;
	}

	/**
	 * envia um email a um cliente
	 * @param id
	 * @param mensagem
	 * @return
	 */
	public void notificarCliente(String id, String mensagem) {
		if(id!=null&&id.isEmpty()){
                    //procura email

                    //envia email
                }
	}
}
