/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;
import java.util.Vector;

import outros.Utils;
import bd.DBHandler;

/**
 * Gere os empregados na aplicação.
 */
public class GestorEmpregados
{
	/**
	 * Adiciona um novo empregado se o BI passado como argumento não existir.
	 * Actualiza os dados se já existir.
	 */
	public String actualizaCliente(String nome, String bi, String password, String morada, String email, String telefone) {
		if (DBHandler.biClienteExiste(bi)) {
			DBHandler.adicionaCliente(nome, bi, password, morada, email, telefone);
			return "Novo empregado adicionado.";
		} else {
			DBHandler.actualizaCliente(nome, bi, password, morada, email, telefone);
			return "Empregado actualizado.";
		}
	}
	
	/**
	 * Devolve informações relativas ao empregado em questÃ£o
	 */
	public String[] procuraEmpregado(String id) {
		return DBHandler.getEmpregado(id);
	}
	
	public String[] procuraEmpregadoBI(String bi) {
		return DBHandler.getEmpregadoBI(bi);
	}

	/**
	 * Procura empregados com as informações nos campos não nulos passados.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] procuraEmpregados(String is_admin, String salarioLow, String salarioHigh, String nome, String bi, String morada, String email, String telefone) {
		Vector<String[]> vec = DBHandler.procuraEmpregados(is_admin, salarioLow, salarioHigh, nome, morada, email, telefone);
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + " : [" + sa[2] + "] " + sa[1];
			i++;
		}
		return ret;
	}

	/**
	 * Lista empregados activos no sistema.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] verListaEmpregados() {
		Vector<String[]> vec = DBHandler.getEmpregados();
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + " : [" + sa[2] + "] " + sa[1];
			i++;
		}
		return ret;
	}

	public String invalidaEmpregado(String id) {
		if(!DBHandler.empregadoEUnicoAdmin(id)) {
			DBHandler.invalidaEmpregado(id);
			Utils.dbg("O empregado com o ID " + id + " foi invalidado.");
			return "O empregado foi invalidado.";
		} else
			return "O empregado é o único administrador de sistema. Não pode ser invalidado.";
			
	}

	public String invalidaEmpregadoBI(String bi) {
		if(!DBHandler.empregadoEUnicoAdminBI(bi)) {
			DBHandler.invalidaEmpregadoBI(bi);
			Utils.dbg("O empregado com o BI " + bi + " foi invalidado.");
			return "O empregado foi invalidado.";
		} else
			return "O empregado é o único administrador de sistema. Não pode ser invalidado.";
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos empregados
	 */
	// TODO: do it
	public String estatisticasEmpregados(GregorianCalendar begin, GregorianCalendar end) {
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
		} else {

		}
		return "Estatisticas Empregados:\n------------------------\n";
	}
}
