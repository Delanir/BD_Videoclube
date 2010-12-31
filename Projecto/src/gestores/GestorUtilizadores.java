package gestores;

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
	 * @return "1" se é admin autenticado; "0" se é empregado, "FAIL" se falhou
	 */
	public String loginEmpregado(String username, String password) {
		Utils.dbg("1");
		if (DBHandler.loginEmpregadoCorrectoBI(username, password)) {
			Utils.dbg("2");
			this.username = username;
			if(DBHandler.empregadoEAdminBI(username)) {
				Utils.dbg("3");
				return "1";
			} else {
				Utils.dbg("4");
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
