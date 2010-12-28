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
 * Classe que lida com as m√°quinas ATM que a loja possui
 * @author Daniela
 */
public class GestorMaquinas
{
	public String adicionaMaquinaATM(String preco) {
		DBHandler.adicionaMaquinaATM(preco);
		return "Nova m·quina ATM adicionada.";
	}
	
	public String actualizaMaquinaATM(String id, String preco) {
		DBHandler.actualizaMaquinaATM(id, preco);
		return "M·quina ATM actualizada.";
	}
	
	/**
	 * Devolve informaÁıes relativas ‡ m·quina ATM em quest√£o
	 */
	public String[] procuraMaquinaATM(String id) {
		return DBHandler.getMaquinaATM(id);
	}

	/**
	 * Lista as m·quinas ATM activas no sistema.
	 * Strings devolvidas no formato "id : data_instalacao, preco"
	 */
	public String[] verListaMaquinasATM() {
		Vector<String[]> vec = DBHandler.getMaquinasATM();
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + " : " + sa[2] + ", " + sa[1];
			i++;
		}
		return ret;
	}

	public String invalidaMaquinaATM(String id) {
		DBHandler.invalidaMaquinaATM(id);
		Utils.dbg("A m·quina ATM com o ID " + id + " foi invalidada.");
		return "A m·quina ATM foi invalidada.";
	}
	
	/**
	 * gera estatisticas relacionadas com m√°quinas
	 * @param begin
	 * @param end
	 * @return
	 */
	// TODO
	public String estatisticasMaquinas(GregorianCalendar begin, GregorianCalendar end) {
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
		} else {

		}
		return "Estatisticas Maquinas:\n------------------------\n";
	}
}
