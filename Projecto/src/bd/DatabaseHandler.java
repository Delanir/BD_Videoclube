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

public class DatabaseHandler
{
	Connection conn;

	public static void main(String args[]) {
		DatabaseHandler dbh = new DatabaseHandler();
		if(dbh.conn != null)
			dbh.getGeneros();
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
			conn = DriverManager.getConnection(Consts.ORACLE_URL, Consts.ORACLE_USER, Consts.ORACLE_PASS);
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
			conn.close();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public Vector<String[]> getGeneros() {
		Vector<String[]> generos = new Vector<String[]>();
		String[] genero;
		try {
			Statement sttmt = conn.createStatement();
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

	public void addGenero(String nome) {

	}
}
