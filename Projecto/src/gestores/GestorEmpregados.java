/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

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
	public String[] procuraEmpregados(String is_admin, String salarioLow, String salarioHigh, String nome, String morada, String email, String telefone) {
		Vector<String[]> vec = DBHandler.procuraEmpregados(is_admin, salarioLow, salarioHigh, nome, morada, email, telefone);
		return Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 4, 3});
	}

	/**
	 * Lista empregados activos no sistema.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] verListaEmpregados() {
		Vector<String[]> vec = DBHandler.getEmpregados();
		return Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 4, 3});
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
}
