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
	
	public final static String GENERO_EXISTE = "Já existe um género com esse nome!";
	public final static String FORMATO_EXISTE = "Já existe um formato com esse nome!";
	public final static String FORMATO_EM_USO = "Existe pelo menos um stock de um filme neste formato. Por favor elimine primeiro todas as referências a este formato.";
	public final static String GENERO_EM_USO = "Existe pelo menos um filme pertencente a esse género. Por favor elimine primeiro todas as referências a este género.";
	public final static String BI_CLIENTE_EXISTE = "Já existe um cliente com esse BI!";
	public final static String BI_EMPREGADO_EXISTE = "Já existe um empregado com esse BI!";
	
	public static final boolean DEBUG = true;
}
