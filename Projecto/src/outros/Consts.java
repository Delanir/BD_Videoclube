package outros;

public class Consts
{
	public final static String ORACLE_USER = "bd01";
	public final static String ORACLE_PASS = "bd01";
	public final static String ORACLE_URL  = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	/** A constante que define o valor inteiro devolvido em caso de erro na fun��o de convers�o String -> int. */
	public final static int ERRO_INT = Integer.MIN_VALUE;
	/** A constante que define o valor inteiro devolvido em caso de erro na fun��o de convers�o String -> double. */
	public final static double ERRO_DOUBLE = Double.MIN_VALUE;
	
	public final static String GENERO_EXISTE = "J� existe um g�nero com esse nome!";
	public final static String FORMATO_EXISTE = "J� existe um formato com esse nome!";
	public final static String FORMATO_EM_USO = "Existe pelo menos um stock de um filme neste formato. Por favor elimine primeiro todas as refer�ncias a este formato.";
	public final static String GENERO_EM_USO = "Existe pelo menos um filme pertencente a esse g�nero. Por favor elimine primeiro todas as refer�ncias a este g�nero.";
	public final static String BI_CLIENTE_EXISTE = "J� existe um cliente com esse BI!";
	public final static String BI_EMPREGADO_EXISTE = "J� existe um empregado com esse BI!";
	
	public static final boolean DEBUG = true;
}
