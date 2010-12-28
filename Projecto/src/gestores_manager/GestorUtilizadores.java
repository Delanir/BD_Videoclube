package gestores_manager;

public class GestorUtilizadores
{

	private String idEmpregado;

	/**
	 * procura autenticar um empregado/administrador no sistema
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username, String password) {
		idEmpregado = username;
		return username;
	}

	/**
	 * -----------------GETTERS & SETTERS-------------------------
	 */
	public String getIdEmpregado() {
		return idEmpregado;
	}
}
