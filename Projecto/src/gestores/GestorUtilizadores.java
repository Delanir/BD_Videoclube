package gestores;

import outros.Consts;
import outros.Utils;
import bd.DBHandler;

public class GestorUtilizadores
{

	private String username;

	public String getUsername() {
		return username;
	}

	/**
	 * procura autenticar um cliente no sistema
	 */
	public String loginCliente(String username, String password) {
                if (Utils.toInt(username) == Consts.ERRO_INT)
			return null;
		if (DBHandler.loginClienteCorrectoBI(username, password)) {
			this.username = username;
			return username;
		} else
			return null;
	}

	/**
	 * procura autenticar um empregado/administrador no sistema
	 * @param username
	 * @param password
	 * @return "1" se � admin autenticado; "0" se � empregado, "FAIL" se falhou
	 */
	public String loginEmpregado(String username, String password) {
		if (Utils.toInt(username) == Consts.ERRO_INT)
			return "FAIL";
		
		if (DBHandler.loginEmpregadoCorrectoBI(username, password)) {
			this.username = username;
			if(DBHandler.empregadoEAdminBI(username)) {
				return "1";
			} else {
				return "0";
			}
		} else if(DBHandler.loginEmpregadoCorrecto(username, password)) {
			this.username = username;
			if(DBHandler.empregadoEAdmin(username))
				return "1";
			else
				return "0";
		} else
			return "FAIL";
	}
}
