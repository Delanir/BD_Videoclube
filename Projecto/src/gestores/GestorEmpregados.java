/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;

/**
 * Gere os empregados na aplicação
 * @author Daniela
 */
public class GestorEmpregados
{
	/**
	 * procura autenticar um empregado/administrador no sistema
	 * @param username
	 * @param password
	 * @return
	 */
	public String login(String username, String password) {
		return null;
	}

	/**
	 * Adiciona um novo empregado ao sistema
	 * @param nome
	 * @param telefone
	 * @param bi
	 * @param administrador
	 * @param password
	 * @param salario
	 * @param email
	 * @param morada
	 * @return sucesso/insucesso
	 */
	public String addEmpregado(String nome, String telefone, String bi, boolean administrador, String password, String salario, String email, String morada) {
		return null;
	}

        /**
	 * Actualiza um empregado ao sistema
	 * @param nome
	 * @param telefone
	 * @param bi
	 * @param administrador
	 * @param password
	 * @param salario
	 * @param email
	 * @param morada
	 * @return sucesso/insucesso
	 */
	public String updateEmpregado(String nome, String telefone, String bi, boolean administrador, String password, String salario, String email, String morada) {
                //TODO : verificar campos null aqui
		return null;
	}

	/**
	 * Elimina um empregado do sistema
	 * @param id
	 * @return
	 */
	public String deleteEmpregado(String id) {
		return null;
	}
        
        public String [] listaEmpregados(){
            String []out={"Lobo","Fontes","Almeida"};
            return out;
        }

        /**
         * gera uma string com as estatisticas mais relevantes relativas aos clientes
         * @param begin
         * @param end
         * @return
         */
        public String estatisticasEmpregados(GregorianCalendar begin,GregorianCalendar end){
            if(begin!=null&&end!=null){
                //estatisticas num intrevalo de tempo
            }else{

            }
            return "Estatisticas Empregados:\n------------------------\n";
        }
}


