package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import outros.Consts;
import outros.Utils;

/**
 * A Class DatabaseHandler.
 */
public class DatabaseHandler
{
	Connection conn;

	public static void main(String args[]) {
		DatabaseHandler dbh = new DatabaseHandler();
		if (dbh.conn != null) {
			dbh.getGeneros();
			dbh.addGenero("Cenazes");
		} else
			System.out.println("deu bode");
	}

	/**
	 * Instancia um novo objecto de manuseamento da base de dados, criando uma
	 * ligação a esta.
	 */
	public DatabaseHandler() {
		open();
	}

	/**
	 * Cria uma ligação à BD.
	 */
	public void open() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			this.conn = DriverManager.getConnection(Consts.ORACLE_URL, Consts.ORACLE_USER, Consts.ORACLE_PASS);
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

	/**
	 * Obtém os géneros de filme existentes.
	 * @return Vector com [id, nome] do género.
	 */
	public Vector<String[]> getGeneros() {
		Vector<String[]> generos = new Vector<String[]>();
		String[] genero;
		try {
			Statement sttmt = this.conn.createStatement();
			ResultSet rset = sttmt.executeQuery("SELECT * FROM generos");

			while (rset.next()) {
				genero = new String[2];
				genero[0] = "" + rset.getInt("id_gen");
				genero[1] = rset.getString("nome_genero");
				generos.add(genero);
				System.out.println(genero[0] + " : " + genero[1]);
			}
			sttmt.close();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return generos;
	}
	
	/**
	 * Adiciona um género à BD.
	 * @param nome o nome do género
	 */
	public void addGenero(String nome) {
		try {
			Statement st = this.conn.createStatement();
			st.executeUpdate("INSERT INTO generos VALUES(seq_genero_id.NEXTVAL, '" + nome + "')");
			this.conn.commit();
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
