package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;

import outros.Consts;
import outros.Utils;

/**
 * A classe-invólucro da Base de Dados. Comunica directamente com ela e executa
 * queries e updates.
 */
public class DatabaseHandler
{
	private Connection conn;

	public static void main(String args[]) {
		DatabaseHandler dbh = new DatabaseHandler();
		if (dbh.conn != null) {
			/**/
		} else
			System.out.println("deu bode");
		dbh.close();
	}

	/**
	 * Instancia um novo objecto de manuseamento da base de dados, criando uma
	 * ligação a esta.
	 */
	public DatabaseHandler() {
		open();
	}
	

	/* ---------------------------- LIGAÇÃO ---------------------------- */
	/**
	 * Cria uma ligação à BD.
	 */
	public void open() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			this.conn = DriverManager.getConnection(Consts.ORACLE_URL, Consts.ORACLE_USER,
					Consts.ORACLE_PASS);
		} catch (SQLException e) {
			Utils.printError(e);
		} catch (InstantiationException e) {
			Utils.printError(e);
		} catch (IllegalAccessException e) {
			Utils.printError(e);
		} catch (ClassNotFoundException e) {
			Utils.printError(e);
		}
	}

	/**
	 * Fecha a ligação à BD.
	 */
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	/* ---------------------------- CLIENTES ---------------------------- */
	// "ID_PESSOA", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"
	/* ---------------------------- EMPREGADOS ---------------------------- */
	// "ID_PESSOA", "IS_ADMIN", "SALARIO", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"
	/* ---------------------------- FILME/GÉNERO ---------------------------- */
	// "ID_GEN", "ID_FIL"
	/* ---------------------------- MÁQUINAS ATM ---------------------------- */
	// "ID_MAQ", "PRECO", "VALIDO", "DATA_INSTALACAO"
	/* ---------------------------- PAGAMENTOS ---------------------------- */
	// "ID_REQ", "MONTANTE"
	/* ---------------------------- REQUISIÇÕES ---------------------------- */
	// "ID_REQ", "ID_FIL", "ID_MAQ", "EMP_ID_PESSOA", "ID_PESSOA", "DATA", "DATA_LIMITE", "DATA_ENTREGA"
	/* ---------------------------- STOCKS ---------------------------- */
	// "ID_FIL", "DISPONIVEIS", "QUANT", "CUSTO_COMPRA", "CUSTO_ALUGUER", "FORMATO"
	
	/* ---------------------------- FILMES ---------------------------- */
	/**
	 * Obtém os géneros de filme existentes.
	 * @return Vector com [id, nome] de cada género.
	 */
	public Vector<String[]> getFilmes() {
		String[] campos = { "ID_FIL", "TITULO", "ANO", "REALIZADOR", "RANKIMDB", "PAIS",
				"PRODUTORA", "DESCRICAO", "CAPA", "VALIDO" };
		return select("filmes", campos);
	}

	/**
	 * Adiciona um género à BD.
	 * @param nome o nome do género
	 */
	public void adicionaFilme(String titulo, int ano, String realizador, double ratingIMDB,
							  String pais, String produtora, String descricao, Icon capa) {
		String[] valores = { "seq_filme_id.NEXTVAL", p(titulo), p(ano), p(realizador),
							 p(ratingIMDB), p(pais), p(produtora), p(descricao), "null" };
		adicionaObjecto("generos", valores);
	}

	/**
	 * Remove um filme da BD.
	 * @param id o ID do filme
	 */
	public void removeFilme(String id) {
		removeObjecto("filmes", "id_fil", id);
	}
	
	/* ---------------------------- GÉNEROS ---------------------------- */
	/**
	 * Obtém os géneros de filme existentes.
	 * @return Vector com [id, nome] de cada género.
	 */
	public Vector<String[]> getGeneros() {
		String[] campos = { "id_gen", "nome_genero" };
		return select("generos", campos);
	}

	/**
	 * Adiciona um género à BD.
	 * @param nome o nome do género
	 */
	public void adicionaGenero(String nome) {
		String[] valores = { "seq_genero_id.NEXTVAL", "'" + nome + "'" };
		adicionaObjecto("generos", valores);
	}

	/**
	 * Remove um género da BD.
	 * @param id o ID do género
	 */
	public void removeGenero(String id) {
		removeObjecto("generos", "id_gen", id);
	}

	/**
	 * Remove da BD os géneros com um dado nome.
	 * @param nome o nome do género
	 */
	public void removeGeneroNome(String nome) {
		removeObjecto("generos", "nome_genero", nome);
	}


	/* ---------------------------- MÉTODOS GENÉRICOS ---------------------------- */
	/**
	 * Adiciona um objecto à BD. Função genérica.
	 * @param tabela a tabela à qual adicionar o objecto.
	 * @param valores os valores do objecto a adicionar.
	 */
	private void adicionaObjecto(String tabela, String[] valores) {
		String comando = "INSERT INTO " + tabela + " VALUES(" + valores[0];
		for (int i = 1; i < valores.length; i++)
			comando += "," + valores[i];
		comando += ")";
		execute(comando);
	}

	/**
	 * Remove um objecto da BD. Função genérica.
	 * @param tabela a tabela da qual remover o objecto.
	 * @param campo o campo a verificar para encontrar o(s) objecto(s) a
	 *        remover.
	 * @param valor o valor do campo no(s) objecto(s) a ser removido(s).
	 */
	private void removeObjecto(String tabela, String campo, String valor) {
		execute("DELETE FROM " + tabela + " WHERE " + campo + " = " + valor);
	}

	/**
	 * Obtém os objectos existentes numa dada tabela.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campos nomes das colunas na tabela.
	 * @return Vector com os campos de cada linha da tabela.
	 */
	private Vector<String[]> select(String tabela, String[] campos) {
		Vector<String[]> linhas = new Vector<String[]>();
		int nColunas = campos.length;

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT * FROM " + tabela);

			while (rset.next()) {
				String[] linha = new String[nColunas];
				for (int i = 0; i < nColunas; i++)
					linha[i] = rset.getString(campos[i]);
				linhas.add(linha);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return linhas;
	}

	/**
	 * Actualiza a BD com o comando passado por argumento.
	 * @param comando o comando a executar sobre a BD.
	 */
	private void execute(String comando) {
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate(comando);
			this.conn.commit();
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/* ---------------------------- OUTROS ---------------------------- */
	/**
	 * Coloca plicas na "string" passada.
	 */
	private String p(Object o) {
		return "'" + o + "'";
	}
}
