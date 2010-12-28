/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.GregorianCalendar;

/**
 * Esta classe é responsável pelos pedidos e tratamento de dados estatísticos
 * do sistema.
 * @author Daniela
 */
public class GestorEstatisticas
{
	/*
	private GestorClientes gc;
	private GestorEmpregados ge;
	private GestorFilmes gf;
	private GestorMaquinas gm;
	
	public GestorEstatisticas(GestorClientes gc,GestorEmpregados ge, GestorFilmes gf, GestorMaquinas gm){
	    this.gc=gc;
	    this.ge=ge;
	    this.gf=gf;
	    this.gm=gm;
	}
	*/

    
	/**
	 * @param parameters contém os elementos a partir dos quais vai ser
	 *        adquirida informação
	 * @param begin data de inicio da contagem das estatísticas, null-> tempo
	 *        total
	 * @param end data de fim da contagem das estatísticas, null-> tempo total
	 * @return
	 */
	public String getEstatisticas(GregorianCalendar begin, GregorianCalendar end) {

		return null;
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos clientes
	 */
	// TODO: do it
	// TODO: GregorianCalendars? e Strings, nao? :p
	public String estatisticasClientes(GregorianCalendar begin, GregorianCalendar end) {
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
		} else {

		}
		return "Estatisticas Clientes:\n------------------------\n";
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos empregados
	 */
	// TODO: do it
	public String estatisticasEmpregados(GregorianCalendar begin, GregorianCalendar end) {
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
		} else {

		}
		return "Estatisticas Empregados:\n------------------------\n";
	}

    /**
     * gera uma string com as estatisticas mais relevantes relativas aos clientes
     * @param begin
     * @param end
     * @return
     */
	// TODO: do it
    public String estatisticasFilmes(GregorianCalendar begin,GregorianCalendar end){
        if(begin!=null&&end!=null){
            //estatisticas num intrevalo de tempo
        }else{

        }
        return "Estatisticas Filmes:\n------------------------\n";
    }
	
	/**
	 * gera estatisticas relacionadas com máquinas
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
