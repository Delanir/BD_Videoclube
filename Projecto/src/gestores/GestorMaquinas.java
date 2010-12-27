/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;

/**
 * Classe que lida com as máquinas ATM que a loja possui
 * @author Daniela
 */
public class GestorMaquinas
{
	/**
	 * Adiciona uma nova máquina ao sistema
	 * @param custo
	 * @return resultado da operação
	 */
	public String addATM(String custo) {
		return null;
	}

	/**
	 * Vende uma máquina ATM
	 * @param id
	 * @return
	 */
	public String sellATM(String id) {
		return null;
	}

	/**
	 * devolve uma lista com todas as máquinas pertencentes ao sistema
	 * @return
	 */
	public String [] listaATMS() {
		return null;
	}


        /**
         * gera estatisticas relacionadas com máquinas
         * @param begin
         * @param end
         * @return
         */
        public String estatisticasMaquinas(GregorianCalendar begin,GregorianCalendar end){
            if(begin!=null&&end!=null){
                //estatisticas num intrevalo de tempo
            }else{

            }
            return "Estatisticas Maquinas:\n------------------------\n";
        }
}
