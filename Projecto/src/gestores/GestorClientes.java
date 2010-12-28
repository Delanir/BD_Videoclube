/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;

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
	// "ID_PES", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"
	public String adicionaCliente(String nome, String telefone, String bi, String password, String email, String morada) {
		return null;
	}

	/**
	 * actualiza os campos n�o nulos no cliente
	 * @param nome
	 * @param telefone
	 * @param bi
	 * @param password
	 * @param email
	 * @param morada
	 * @return
	 */
	public String actualizaCliente(String id, String nome, String telefone, String bi,
			String password, String email, String morada) {
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
	// TODO: do it. WTF o k � isto?
	public String procuraCliente(String id, String nome, String telefone, String bi, String email,
			String morada) {
		return null;
	}

	/**
	 * Lista clientes activos no sistema
	 * @return
	 */
	public String[] verListaClientes() {
		return null;
	}

	/**
	 * apaga um cliente do sistema
	 * @param id
	 * @return
	 */
	public String removeCliente(String id) {
		return null;
	}

	/**
	 * devolve uma lista com os clientes que têm pagamentos em atraso
	 * @return
	 */
	// TODO: do it
	public String [] verificaClientesComPagamentosEmAtraso() {
		return null;
	}

	/**
	 * envia um email a um cliente
	 * @param id
	 * @param mensagem
	 * @return
	 */
	// TODO: do it
	public void notificarCliente(String id, String mensagem) {
		if (id != null && id.isEmpty()) {
			// procura email

			// envia email
		}
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos
	 * clientes
	 * @param begin
	 * @param end
	 * @return
	 */
	public String estatisticasClientes(GregorianCalendar begin, GregorianCalendar end) {
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
		} else {

		}
		return "Estatisticas Clientes:\n------------------------\n";
	}
}
