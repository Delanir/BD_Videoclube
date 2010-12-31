package outros;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * A classe de utilitários. Contém métodos úteis a toda a aplicação.
 * ex.: conversão de String para inteiro, conversão e subtracção de datas, contextualização de erros, etc.
 * Recorre à classe Consts.
 */
public class Utils
{
	public static void main(String[] args) {
		/*for(String s : extract(new String[]{"cenas", "coisas", "outras"}, 0)) {
			System.out.println(s);
		}*/
		Vector<String[]> vec = new Vector<String[]>();
		vec.add(new String[]{"id1", "nome1", "bi1", "cenas1", "mais cenas1"});
		vec.add(new String[]{"id2", "nome2", "bi2", "cenas2", "mais cenas2"});
		vec.add(new String[]{"id3", "nome3", "bi3", "cenas3", "mais cenas3"});
		printStringArrayln(formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 2, 1}));
	}
	
	/* ------------------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS DE VECTORS E ARRAYS ---------------------------- */
	/* ------------------------------------------------------------------------------------- */

	/* ---------------------------- UTILS ---------------------------- */
	/**
	 * Une o conteúdo de dois arrays de Strings num só.
	 */
	public static String[] extend(String[] a1, String[] a2) {
		String[] ret = new String[a1.length + a2.length];
		int i, j;
		for(i=0; i<a1.length; i++)
			ret[i] = a1[i];
		for(j=0; j<a2.length; i++, j++)
			ret[i] = a2[j];
		return ret;
	}
	
	/**
	 * Obtém um array de Strings com os elementos do array original a partir do índice "from". 
	 */
	public static String[] extract(String[] sa, int from) {
		String[] ret = new String[sa.length - from];
		int i=0, j=from;
		for(; j<sa.length; i++, j++)
			ret[i] = sa[j];
		return ret;
	}
	
	/* ---------------------------- CONVERSÃO ---------------------------- */
	/**
	 * Converte um Vector de arrays de Strings para um array apenas,
	 * com os antigos arrays em sequência.
	 */
	public static String[] strArrayVectorToArray(Vector<String[]> vec) {
		int i = 0, j, size=0;
		for(String[] sa : vec)
			size += sa.length;
		
		String[] ret = new String[size];
		
		for(String[] sa : vec)
			for(j=0; j<sa.length; i++, j++)
				ret[i] = sa[j];
		return ret;
	}
	
	/**
	 * Converte um Vector de arrays de Strings para um array apenas,
	 * usando somente o elemento de índice "index" de cada array.
	 */
	public static String[] strArrayVectorToArray(Vector<String[]> vec, int index) {
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[index];
			i++;
		}
		return ret;
	}
	
	/**
	 * Converte um Vector de Strings para um array de Strings.
	 */
	public static String[] strVectorToArray(Vector<String> vec) {
		String[] ret = new String[vec.size()];
		int i=0;
		for(String s : vec) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	/**
	 * Gera um array de Strings, em que cada String são os elementos de índice "indexes"
	 * em cada String[] do Vector<String[]> passado, formatadas segundo "macro".
	 */
	public static String[] formattedFromVector(Vector<String[]> vec, String macro, int[] indexes) {
		String[] ret = new String[vec.size()];
		Object[] values;
		int i=0, j;
		
		for(String[] sa : vec) {
			values = new String[indexes.length];
			j=0;
			for(int index : indexes) {
				values[j] = sa[index];
				j++;
			}
			ret[i] = String.format(macro, values);
			i++;
		}
		return ret;
	}

	/* ---------------------------- GERAÇÃO DE STRINGS ---------------------------- */
	/**
	 * Devolve uma string com os elementos "strs" separados pela string "sep".
	 * @param strs os elementos a juntar numa string apenas.
	 * @param sep o separador a usar para separar os elementos.
	 * @return uma string com os elementos "strs" separados pela string "sep".
	 */
	public static String list(String[] strs, String sep) {
		String lista = strs[0];
		for (int i = 1; i < strs.length; i++)
			lista += sep + strs[i];
		return lista;
	}

	/**
	 * Devolve uma string com os elementos separados em linhas e com
	 * as Strings em cada array separadas por "sep".
	 * @param strs os elementos a juntar numa string apenas.
	 * @param sep o separador a usar para separar os elementos.
	 * @return com os elementos separados em linhas e com as Strings em cada array separadas por "sep".
	 */
	public static String list(Vector<String[]> strs, String sep) {
		String lista = "";
		for(String[] sa : strs) {
			lista += sa[0];
			for (int i = 1; i < sa.length; i++)
				lista += sep + sa[i];
			lista += "\n";
		}
		return lista;
	}
	
	/**
	 * Devolve uma string organizada em pares (separados pela string "sep2") de
	 * "strs" e "strs2" (separados por "sep").
	 * @param strs a primeira parte dos elementos a juntar em pares numa string apenas.
	 * @param sep o separador a usar para separar cada dois elementos (par. um de cada lista).
	 * @param strs2 a segunda parte dos elementos a juntar em pares numa string apenas.
	 * @param sep2 o separador a usar para separar cada par de elementos dos outros pares.
	 * @return uma string organizada em pares (separados pela string "sep2") de
	 * "strs" e "strs2" (separados por "sep").
	 */
	public static String list(String[] strs, String sep, String[] strs2, String sep2) {
		String lista = strs[0] + sep + strs2[0];
		for (int i = 1; i < strs.length; i++)
			lista += sep2 + strs[i] + sep + strs2[i];
		return lista;
	}
	
	/* --------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS DE PRINTS ---------------------------- */
	/* --------------------------------------------------------------------------- */
	/**
	 * Imprime o erro que ocorreu, bem como o método e classe onde ocorreu.
	 * @param e a excepção (erro) lançada.
	 */
	public static void printError(Exception e) {
		System.out.println(e.toString() + " no método " + e.getStackTrace()[0].getMethodName() + "() da classe " + e.getStackTrace()[0].getClassName());
		e.printStackTrace();
	}
	
	/**
	 * Imprime um Vector de arrays de Strings, um array por linha, separados por vírgulas.
	 * @param vec Vector a imprimir.
	 */
	public static void printStringArrayVector(Vector<String[]> vec) {
		for(String[] sa : vec) {
			System.out.print(sa[0]);
			for(int i=1; i<sa.length; i++)
				System.out.print(", " + sa[i]);
			System.out.println();
		}
	}
	
	/**
	 * Imprime um array de Strings numa linha, com os elementos separados por vírgulas.
	 */
	public static void printStringArray(String[] arr) {
		System.out.print(arr[0]);
		for(int i=1; i<arr.length; i++)
			System.out.print(", " + arr[i]);
		System.out.println();
	}
	
	/**
	 * Imprime um array de Strings, uma String por linha.
	 */
	public static void printStringArrayln(String[] arr) {
		for(String s : arr)
			System.out.println(s);
	}
	
	/**
	 * Imprime a String passada com um newline a seguir, caso o programa esteja em modo de DEBUG.
	 */
	public static void dbg(String string) {
		if(Consts.DEBUG)
			System.out.println(string);
	}
	
	/**
	 * Imprime a String passada, caso o programa esteja em modo de DEBUG.
	 */
	public static void dbgsl(String string) {
		if(Consts.DEBUG)
			System.out.print(string);
	}
	
	/* --------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS NUMÉRICOS ---------------------------- */
	/* --------------------------------------------------------------------------- */
	/**
	 * Converte uma String para inteiro.
	 * @param strnumber o número (em formato String) a converter.
	 * @return a String numérica convertida ou ERROR_INT (definido em Consts) se a conversão é impossível.
	 */
	public static int toInt(String strnumber) {
		try {
			return Integer.parseInt(strnumber);
		} catch(NumberFormatException e) {
			return Consts.ERRO_INT;
		}
	}
	
	/**
	 * Converte uma String para double.
	 * @param strnumber o número (em formato String) a converter.
	 * @return a o número convertido ou ERROR_DOUBLE (definido em Consts) se a conversão é impossível.
	 */
	public static double toDouble(String strnumber) {
		try {
			return Double.parseDouble(strnumber);
		} catch(NumberFormatException e) {
			return Consts.ERRO_DOUBLE;
		}
	}
	
	/* -------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS DE DATAS ---------------------------- */
	/* -------------------------------------------------------------------------- */
	/**
	 * Converte uma data para formato legível, em String, com o formato "ano/mês/dia".
	 * @param date a data (Calendar) a converter.
	 * @return a data em formato String se a data recebida é válida, "null" caso contrário.
	 */
	public static String toSimpleDate(Calendar date) {
		if(date != null)
			return String.format("%04d/%02d/%02d", date.get(Calendar.YEAR), (date.get(Calendar.MONTH)+1), date.get(Calendar.DAY_OF_MONTH));
		else
			return "null";
	}
	
	/**
	 * Converte uma data para formato legível, em String, com o formato "ano/mês/dia (hora:minuto)".
	 * @param date a data (Calendar) a converter.
	 * @return a data em formato String se a data recebida é válida, "null" caso contrário.
	 */
	public static String toSimpleTime(Calendar date) {
		if(date != null)
			return (toSimpleDate(date) + String.format(" (%02d:%02d)", date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE)));
		else
			return "null";
	}
	
	/**
	 * Converte uma String para Calendar, segundo o formato "ano/mês/dia (hora:minuto)" ou somente "ano/mês/dia".
	 * @param date String a converter.
	 * @return o Calendar correspondente, null se não conseguiu converter.
	 */
	public static Calendar toCalendar(String date) {
		if(date.contains("("))
			return toCalendarTime(date);
		else
			return toCalendarDate(date);
	}
	
	/**
	 * Converte uma String para Calendar, segundo o formato "ano/mês/dia (hora:minuto)".
	 * @param date String a converter.
	 * @return o Calendar correspondente, null se não conseguiu converter.
	 */
	private static Calendar toCalendarTime(String date) {
		String[] dateValues = date.split(" ");
		Calendar calendar = toCalendarDate(dateValues[0]);
		if(calendar == null)
			return null;
		
		String time = dateValues[1].substring(1, dateValues[1].indexOf(')'));

		String[] timeValues = time.split(":");
		int hour=0, min=0;
		if(timeValues.length == 2) {
			try {
				hour = Integer.parseInt(timeValues[0]);
				min = Integer.parseInt(timeValues[1]);
			} catch(NumberFormatException e) {
				return null;
			}
		}
		if(hour > 23 || hour < 0 || min > 59 || min < 0) {
			return null;
		}
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		calendar.add(Calendar.MINUTE, min);
		return calendar;
	}
	
	/**
	 * Converte uma String para Calendar, segundo o formato "ano/mês/dia".
	 * @param date String a converter.
	 * @return o Calendar correspondente, null se não conseguiu converter.
	 */
	private static Calendar toCalendarDate(String date) {
		String[] dateValues = date.split("/");
		int year=0, month=0, day=0;
		if(dateValues.length == 3) {
			try {
				year = Integer.parseInt(dateValues[0]);
				month = Integer.parseInt(dateValues[1]);
				day = Integer.parseInt(dateValues[2]);
			} catch(NumberFormatException e) {
				return null;
			}
		}
		int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if((month > 12 || day > months[month] || day < 1)
			|| ((day == 29 && month == 2)
				&& (year%4!=0 || (year%100==0 && year%400!=0)))) {
            return null;
		}
		Calendar calendar = new GregorianCalendar(year, month-1, day);
		return calendar;
	}
	
	/**
	 * Calcula a diferença em dias entre duas datas.
	 * @param c1 a data 1 (à qual subtrair a segunda)
	 * @param c2 o data 2 (subtraída à primeira)
	 * @return a diferença em dias (negativo se a segunda for mais recente que a primeira).
	 */
	public static int difCalendars(Calendar c1, Calendar c2) {
		long millis = c1.getTimeInMillis() - c2.getTimeInMillis();
		return (int) (millis / 1000 / 60 / 60 / 24);
	}
	
	/**
	 * Calcula a diferença em dias entre uma data e a actual.
	 * @param cal a data a verificar (subtraída à actual).
	 * @return a diferença em dias (negativo se a data actual for mais recente que a outra).
	 */
	public static int difToCurrentDate(Calendar cal){
		return difCalendars(cal, new GregorianCalendar());
	}
}
