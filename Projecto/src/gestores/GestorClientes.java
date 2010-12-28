/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;
import java.util.Vector;

import outros.Utils;

import bd.DBHandler;

public class GestorClientes
{
	/**
	 * Adiciona um novo cliente se o BI passado como argumento não existir.
	 * Actualiza os dados se já existir.
	 */
	public String actualizaCliente(String nome, String bi, String password, String morada, String email, String telefone) {
		if (DBHandler.biClienteExiste(bi)) {
			DBHandler.adicionaCliente(nome, bi, password, morada, email, telefone);
			return "Novo cliente adicionado.";
		} else {
			DBHandler.actualizaCliente(nome, bi, password, morada, email, telefone);
			return "Cliente actualizado.";
		}
	}
	
	/**
	 * Devolve informações relativas ao cliente em questÃ£o
	 */
	public String[] procuraCliente(String id) {
		return DBHandler.getCliente(id);
	}
	
	public String[] procuraClienteBI(String bi) {
		return DBHandler.getClienteBI(bi);
	}

	/**
	 * Procura clientes com as informações nos campos não nulos passados.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] procuraClientes(String nome, String bi, String morada, String email, String telefone) {
		Vector<String[]> vec = DBHandler.procuraClientes(nome, morada, email, telefone);
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + " : [" + sa[2] + "] " + sa[1];
			i++;
		}
		return ret;
	}

	/**
	 * Lista clientes activos no sistema.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] verListaClientes() {
		Vector<String[]> vec = DBHandler.getClientes();
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + " : [" + sa[2] + "] " + sa[1];
			i++;
		}
		return ret;
	}

	public String invalidaCliente(String id) {
		DBHandler.invalidaCliente(id);
		Utils.dbg("O cliente com o ID " + id + " foi invalidado.");
		return "O cliente foi invalidado.";
	}

	public String invalidaClienteBI(String bi) {
		DBHandler.invalidaClienteBI(bi);
		Utils.dbg("O cliente com o BI " + bi + " foi invalidado.");
		return "O cliente foi invalidado.";
	}
	
	/**
	 * devolve uma lista com os clientes que tÃªm pagamentos em atraso
	 * @return
	 */
	// TODO: do it
	public String [] verificaClientesComPagamentosEmAtraso() {
		return null;
	}

	/**
	 * envia um email a um cliente
	 */
	// TODO: do it
	public void notificarCliente(String id, String mensagem) {
		if (id != null && id.isEmpty()) {
			// procura email

			// envia email
		}
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos clientes
	 */
	// TODO: do it
	// TODO: GregorianCalendars? e Strings, nao? :p
	public String estatisticasClientes(GregorianCalendar begin, GregorianCalendar end) {
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
		} else {

		}
		return "Estatisticas Clientes:\n------------------------\n";
	}
}
