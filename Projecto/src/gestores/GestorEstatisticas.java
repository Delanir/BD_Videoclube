/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import bd.DBHandler;
import java.util.Calendar;
import java.util.GregorianCalendar;
import outros.Utils;

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
                
                String estatisticas="";
                if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
                        GregorianCalendar now=new GregorianCalendar();

                        if(begin.compareTo(end)<0&&end.compareTo(now)<0){

                             estatisticas+=DBHandler.estatisticasContabilidadeData(
                                     calendarize(begin),
                                     calendarize(end));
                        }else{
                            estatisticas+="Datas mal especificadas\n";
                        }
		} else {
                        //top10clientes
                    estatisticas+=DBHandler.estatisticasContabilidade();
		}
		return estatisticas;
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos clientes
	 */
	// TODO: do it
	// TODO: GregorianCalendars? e Strings, nao? :p
	public String estatisticasClientes(GregorianCalendar begin, GregorianCalendar end) {
		String estatisticas="";
                if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
                        GregorianCalendar now=new GregorianCalendar();
                      
                        if(begin.compareTo(end)<0&&end.compareTo(now)<0){
                             Utils.dbg("here sucker");
                             estatisticas+=DBHandler.estatisticasTop10ClientesData(
                                     calendarize(begin),
                                     calendarize(end));
                        }else{
                            estatisticas+="Datas mal especificadas\n";
                        }
		} else {
                        //top10clientes
                    estatisticas+=DBHandler.estatisticasTop10Clientes();
		}
		return "Estatisticas Clientes:\n------------------------\n"+estatisticas;
	}

	/**
	 * gera uma string com as estatisticas mais relevantes relativas aos empregados
	 */
	// TODO: do it
	public String estatisticasEmpregados(GregorianCalendar begin, GregorianCalendar end) {
		 String estatisticas="";
                if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
                        // estatisticas num intrevalo de tempo
                        GregorianCalendar now=new GregorianCalendar();

                        if(begin.compareTo(end)<0&&end.compareTo(now)<0){
                             Utils.dbg("here sucker");
                             estatisticas+=DBHandler.estatisticasEmpregadosData(
                                     calendarize(begin),
                                     calendarize(end));
                        }else{
                            estatisticas+="Datas mal especificadas\n";
                        }
		} else {
                    estatisticas+=DBHandler.estatisticasEmpregados();
		}
		return "Estatisticas Empregados:\n------------------------\n"+estatisticas;
	}

        private String calendarize(GregorianCalendar d){
            String out="";
            if(d.get(Calendar.DAY_OF_MONTH)<10){
                out+="0"+d.get(Calendar.DAY_OF_MONTH);
            }else{
                out+=d.get(Calendar.DAY_OF_MONTH);
            }
            if(d.get(Calendar.MONTH)+1<10){
                out+="/" + "0"+(d.get(Calendar.MONTH)+1);
            }else{
                out+="/" + d.get(Calendar.MONTH);
            }
                
            out+="/"+ d.get(Calendar.YEAR);
            Utils.dbg(out);
            return out;
        }
    /**
     * gera uma string com as estatisticas mais relevantes relativas aos clientes
     * @param begin
     * @param end
     * @return
     */
	// TODO: do it
    public String estatisticasFilmes(GregorianCalendar begin,GregorianCalendar end){
        String estatisticas="";
        if(begin!=null&&end!=null){
            //estatisticas num intrevalo de tempo
            GregorianCalendar now=new GregorianCalendar();

            if(begin.compareTo(end)<0&&end.compareTo(now)<0){
                 Utils.dbg("here sucker");
                 estatisticas+=DBHandler.estatisticasTop10FilmesData(
                         calendarize(begin),
                         calendarize(end));
                 estatisticas+=DBHandler.estatisticasTotalGenerosData(
                         calendarize(begin),
                         calendarize(end));
            }else{
                estatisticas+="Datas mal especificadas\n";
            }
        }else{
            //top10filmes
            estatisticas+=DBHandler.estatisticasTop10Filmes();
            estatisticas+="\n"+DBHandler.estatisticasTotalGeneros();
            estatisticas+="\n"+DBHandler.estatisticasTotalFilmes();
        }
        return "Estatisticas Filmes:\n------------------------\n"+estatisticas;
    }
	
	/**
	 * gera estatisticas relacionadas com máquinas
	 * @param begin
	 * @param end
	 * @return
	 */
	// TODO
	public String estatisticasMaquinas(GregorianCalendar begin, GregorianCalendar end) {
                String estatisticas="";
		if (begin != null && end != null) {
			// estatisticas num intrevalo de tempo
                        GregorianCalendar now=new GregorianCalendar();

                        if(begin.compareTo(end)<0&&end.compareTo(now)<0){
                             Utils.dbg("here sucker");
                             estatisticas+=DBHandler.estatisticasTopMaquinasData(
                                     calendarize(begin),
                                     calendarize(end));
                        }else{
                            estatisticas+="Datas mal especificadas\n";
                        }
		} else {
                    estatisticas+=DBHandler.estatisticasTopMaquinas();
		}
                
		return "Estatisticas Maquinas:\n------------------------\n"+estatisticas;
	}
}
