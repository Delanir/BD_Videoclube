package outros;

import java.util.Scanner;

public class Utils
{
	public static void printError(Exception e) {
		System.out.println(e.toString() + " no m�todo " + e.getStackTrace()[0].getMethodName() + "() da classe " + e.getStackTrace()[0].getClassName());
		//e.printStackTrace();
	}

	public static int toInt(String strnumber) {
		try {
			return Integer.parseInt(strnumber);
		} catch (NumberFormatException e) {
			return Consts.ERRO_INT;
		}
	}

	// Faz parsing de uma lista de string e imprime de maneira a pôr tudo num
	// array estático
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\"" + sc.nextLine() + "\",");
		}
	}
}
