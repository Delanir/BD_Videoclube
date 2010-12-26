package outros;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Vector;

/**
 * A classe de utilitários. Contém métodos úteis a toda a aplicação.
 * ex.: conversão de String para inteiro, conversão e subtracção de datas, contextualização de erros, etc.
 * Recorre à classe Consts.
 */
public class Utils
{
	/**
	 * Imprime o erro que ocorreu, bem como o método e classe onde ocorreu.
	 * @param e a excepção (erro) lançada.
	 */
	public static void printError(Exception e) {
		System.out.println(e.toString() + " no método " + e.getStackTrace()[0].getMethodName() + "() da classe " + e.getStackTrace()[0].getClassName());
		//e.printStackTrace();
	}

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

	// Faz parsing de uma lista de string e imprime de maneira a pÃ´r tudo num
	// array estÃ¡tico
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\"" + sc.nextLine() + "\",");
		}
	}
}
