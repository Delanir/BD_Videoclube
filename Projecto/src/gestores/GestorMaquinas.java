/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.Vector;

import outros.Utils;
import bd.DBHandler;

/**
 * Classe que lida com as mÃ¡quinas ATM que a loja possui
 * @author Daniela
 */
public class GestorMaquinas
{
	public String adicionaMaquinaATM(String preco) {
		DBHandler.adicionaMaquinaATM(preco);
		return "Nova máquina ATM adicionada.";
	}
	
	public String actualizaMaquinaATM(String id, String preco) {
		DBHandler.actualizaMaquinaATM(id, preco);
		return "Máquina ATM actualizada.";
	}
	
	/**
	 * Devolve informações relativas à máquina ATM em questÃ£o
	 */
	public String[] procuraMaquinaATM(String id) {
		return DBHandler.getMaquinaATM(id);
	}

	/**
	 * Lista as máquinas ATM activas no sistema.
	 * Strings devolvidas no formato "id : data_instalacao, preco"
	 */
	public String[] verListaMaquinasATM() {
		Vector<String[]> vec = DBHandler.getMaquinasATM();
		return Utils.formattedFromVector(vec, "%s : %s, %s [%s]", new int[]{0, 3, 1, 2});
	}

	public String invalidaMaquinaATM(String id) {
		DBHandler.invalidaMaquinaATM(id);
		Utils.dbg("A máquina ATM com o ID " + id + " foi invalidada.");
		return "A máquina ATM foi invalidada.";
	}
}
