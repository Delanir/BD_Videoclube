package gestores_manager;

import bd.DBHandler;

public class GestorUtilizadores
{

	private String idEmpregado;

	/**
	 * procura autenticar um empregado/administrador no sistema
	 * @param username
	 * @param password
	 * @return "1" se é admin autenticado; "0" se é empregado, "FAIL" se falhou
	 */
	public String login(String username, String password) {
		idEmpregado = username;
                String []out=null;
                out=DBHandler.getEmpregadoBI(username);
                if(out!=null&&out.length>0){
                    //verifica credenciais
                    if(password.equals(out[5])){
                        //autenticacao bem sucedida
                        if(out[1].equals("1")){
                            //administrador
                            return "1";
                        }
                        return "0";
                    }
                }else{
                    //tenta verificar se o utilizador utilizou o ID para se identificar
                    out=DBHandler.getEmpregado(username);
                    if(out!=null&&out.length>0){
                        //verifica credenciais
                        if(password.equals(out[5])){
                            //autenticacao bem sucedida
                            if(out[1].equals("1")){
                                //administrador
                                return "1";
                            }
                            return "0";
                        }
                    }
                }
                
		return "FAIL";
	}

	/**
	 * -----------------GETTERS & SETTERS-------------------------
	 */
	public String getIdEmpregado() {
		return idEmpregado;
	}
}
