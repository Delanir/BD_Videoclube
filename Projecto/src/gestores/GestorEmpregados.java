/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.Vector;

import outros.Utils;
import bd.DBHandler;

/**
 * Gere os empregados na aplica��o.
 */
public class GestorEmpregados
{
	/**
	 * Adiciona um novo empregado se o BI passado como argumento n�o existir.
	 * Actualiza os dados se j� existir.
	 */
	public String actualizaEmpregado(String is_admin, String salario, String nome, String bi, String password, String morada, String email, String telefone) {
		if (!DBHandler.biEmpregadoExiste(bi)) {
			DBHandler.adicionaEmpregado(is_admin, salario, nome, bi, password, morada, email, telefone);
			return "Novo empregado adicionado.";
		} else {
			DBHandler.actualizaEmpregado(is_admin, salario, nome, bi, password, morada, email, telefone);
			return "Empregado actualizado.";
		}
	}
	
	/**
	 * Devolve informa��es relativas ao empregado em questão
	 */
	public String[] procuraEmpregado(String id) {
		return DBHandler.getEmpregado(id);
	}
	
	public String[] procuraEmpregadoBI(String bi) {
		return DBHandler.getEmpregadoBI(bi);
	}

	public static String getEmpregadoBIFromID(String id) {
		return DBHandler.getEmpregadoBIFromID(id);
	}
	
	/**
	 * Procura empregados com as informa��es nos campos n�o nulos passados.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] procuraEmpregados(String is_admin, String salarioLow, String salarioHigh, String nome, String morada, String email, String telefone) {
		Vector<String[]> vec = DBHandler.procuraEmpregados(is_admin, salarioLow, salarioHigh, nome, morada, email, telefone);
		String[] out = Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 2, 1});
		int i=0;
		for(String[] sa : vec) {
			if(sa[3].equals("0"))
				out[i] = out[i] + " (inv�lido)";
			i++;
		}
		return out;
	}

	/**
	 * Lista empregados activos no sistema.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] verListaEmpregados() {
		Vector<String[]> vec = DBHandler.getEmpregados();
		String[] out = Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 4, 3});
		int i=0;
		for(String[] sa : vec) {
			if(sa[9].equals("0"))
				out[i] = out[i] + " (inv�lido)";
			i++;
		}
		return out;
	}

	public String invalidaEmpregado(String id) {
		if(!DBHandler.empregadoEUnicoAdmin(id)) {
			DBHandler.invalidaEmpregado(id);
			Utils.dbg("O empregado com o ID " + id + " foi invalidado.");
			return "O empregado foi invalidado.";
		} else
			return "O empregado � o �nico administrador de sistema. N�o pode ser invalidado.";
			
	}

	public String invalidaEmpregadoBI(String bi) {
		if(!DBHandler.empregadoEUnicoAdminBI(bi)) {
			DBHandler.invalidaEmpregadoBI(bi);
			Utils.dbg("O empregado com o BI " + bi + " foi invalidado.");
			return "O empregado foi invalidado.";
		} else
			return "O empregado � o �nico administrador de sistema. N�o pode ser invalidado.";
	}
}
