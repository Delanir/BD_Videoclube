/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;
import java.util.Vector;

import outros.Consts;

import bd.DBHandler;

public class GestorClientes
{
	/**
	 * Adiciona um novo cliente ao sistema
	 */
	// TODO: ordem na gui
	// "ID_PES", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"
	public String adicionaCliente(String nome, String bi, String password, String morada, String email, String telefone) {
		if (!DBHandler.biClienteExiste("", bi)) {
			DBHandler.adicionaCliente(nome, bi, password, morada, email, telefone);
			return "Novo cliente adicionado.";
		} else
			return Consts.BI_CLIENTE_EXISTE;
	}

	/**
	 * actualiza os campos n�o nulos no cliente
	 */
	// TODO: ordem na gui
	public String actualizaCliente(String id, String nome, String bi, String password, String morada, String email, String telefone) {
		//TODO verificar strings ""!
		if (!DBHandler.biClienteExiste(id, bi)) {
			DBHandler.actualizaCliente(id, nome, bi, password, morada, email, telefone);
			return "Cliente actualizado.";
		} else
			return Consts.BI_CLIENTE_EXISTE;
	}
	
	/**
	 * Devolve informa��es relativas oa cliente em questão
	 */
	public String[] procuraCliente(String id) {
		return DBHandler.getCliente(id);
	}
	
	public String[] procuraClienteBI(String bi) {
		return DBHandler.getClienteBI(bi);
	}

	/**
	 * Procura clientes que respeitem as informações não nulas dadas!
	 */
	public String procuraClientes(String nome, String bi, String password, String morada, String email, String telefone) {
		return null;
	}

	/**
	 * Lista clientes activos no sistema
	 * @return
	 */
	public String[] verListaClientes() {
		Vector<String[]> vec = DBHandler.getClientes();
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + ": (" + sa[2] + ") " + sa[1]; //id: (BI) nome
			i++;
		}
		return ret;
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
	 * apaga um cliente do sistema
	 * @param id
	 * @return
	 */
	public String removeClienteBI(String bi) {
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
