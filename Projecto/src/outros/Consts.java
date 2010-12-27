package outros;

public class Consts
{
	public final static String ORACLE_USER = "bd01";
	public final static String ORACLE_PASS = "bd01";
	public final static String ORACLE_URL  = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	/** A constante que define o valor inteiro devolvido em caso de erro na função de conversão String -> int. */
	public final static int ERRO_INT = Integer.MIN_VALUE;
	/** A constante que define o valor inteiro devolvido em caso de erro na função de conversão String -> double. */
	public final static double ERRO_DOUBLE = Double.MIN_VALUE;
}
