package outros;

import java.util.Scanner;
import java.util.Vector;

public class Utils
{
	public static void printError(Exception e) {
		System.out.println(e.toString() + " no método " + e.getStackTrace()[0].getMethodName() + "() da classe " + e.getStackTrace()[0].getClassName());
		//e.printStackTrace();
	}

	public static int toInt(String strnumber) {
		try {
			return Integer.parseInt(strnumber);
		} catch (NumberFormatException e) {
			return Consts.ERRO_INT;
		}
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
