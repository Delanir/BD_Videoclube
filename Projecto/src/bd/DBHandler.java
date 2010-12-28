package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import outros.Consts;
import outros.Utils;

/**
 * A classe-invólucro da Base de Dados (BD).
 * Comunica directamente com ela e executa queries e updates.
 */
public class DBHandler
{
	//TODO: ver cenas onde faltam plicas (provavelmente muito sitio >_>)
	private static Connection conn;
	
	/**
	 * O método main. Apenas para propósitos de teste.
	 * @param args os argumentos da linha de comandos.
	 */
	public static void main(String args[]) {
		open();
		if (conn != null) {
			//Icon icon = new ImageIcon("MV5BMTI5Mjc2MTE3OV5BMl5BanBnXkFtZTcwNTc2MzI2Mg@@._V1._CR341,0,1365,1365_SS80_.jpg");
			System.out.println(Utils.list(getClientesOrdNome(), ","));
			//Utils.printStringArrayVector(dbh.getFilmes());
			//System.out.println(Utils.list(getFilme("2"), ","));
			close();
		} else
			System.out.println("deu bode");
	}

	/**
	 * Instancia um novo objecto de manuseamento da base de dados, criando uma
	 * ligação a esta.
	 */
	public DBHandler() {
		open();
	}
	
	/* ----------------------------------------------------------------- */
	/* ---------------------------- LIGAÇÃO ---------------------------- */
	/* ----------------------------------------------------------------- */
	/**
	 * Cria uma ligação à BD.
	 */
	public static void open() {
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
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/* --------------------------------------------------------------------------------- */
	/* ---------------------------- GETS DE NOMES DE CAMPOS ---------------------------- */
	/* --------------------------------------------------------------------------------- */
	
	public static String[] getCamposClientes() {		return new String[]{"ID_PES", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"};}
	public static String[] getCamposEmpregados() {		return new String[]{"ID_PES", "IS_ADMIN", "SALARIO", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"};}
	public static String[] getCamposFilmes() {			return new String[]{"ID_FIL", "TITULO", "ANO", "REALIZADOR", "RANKIMDB", "PAIS", "PRODUTORA", "DESCRICAO", "CAPA", "VALIDO"};}
	public static String[] getCamposFilmeGenero() {		return new String[]{"ID_GEN", "ID_FIL"};}
	public static String[] getCamposFormatos() {		return new String[]{"ID_FOR", "NOME_FORMATO"};}
	public static String[] getCamposGeneros() {			return new String[]{"ID_GEN", "NOME_GENERO"};}
	public static String[] getCamposMaquinasATM() {		return new String[]{"ID_MAQ", "PRECO", "VALIDO", "DATA_INSTALACAO"};}
	public static String[] getCamposPagamentos() {		return new String[]{"ID_REQ", "MONTANTE"};}
	public static String[] getCamposRequisicoes() {		return new String[]{"ID_REQ", "ID_MAQ", "EMP_ID_PES", "ID_PES", "ID_FIL", "ID_FOR", "DATA", "DATA_LIMITE", "DATA_ENTREGA"};}
	public static String[] getCamposStocks() {			return new String[]{"ID_FIL", "ID_FOR", "DISPONIVEIS", "QUANT", "CUSTO_COMPRA", "CUSTO_ALUGUER"};}

	public static String[] getToSetCamposClientes() {		return new String[]{"NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE"};}
	public static String[] getToSetCamposEmpregados() {		return new String[]{"IS_ADMIN", "SALARIO", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE"};}
	public static String[] getToSetCamposFilmes() {			return new String[]{"TITULO", "ANO", "REALIZADOR", "RANKIMDB", "PAIS", "PRODUTORA", "DESCRICAO", "CAPA"};}
	public static String[] getToSetCamposFilmeGenero() {	return new String[]{};}
	public static String[] getToSetCamposFormatos() {		return new String[]{"NOME_FORMATO"};}
	public static String[] getToSetCamposGeneros() {		return new String[]{"NOME_GENERO"};}
	public static String[] getToSetCamposMaquinasATM() {	return new String[]{"PRECO"};}
	public static String[] getToSetCamposPagamentos() {		return new String[]{"MONTANTE"};}
	public static String[] getToSetCamposRequisicoes() {	return new String[]{"DATA_LIMITE", "DATA_ENTREGA"};}
	public static String[] getToSetCamposStocks() {			return new String[]{"DISPONIVEIS", "QUANT", "CUSTO_COMPRA", "CUSTO_ALUGUER"};}

	/* ------------------------------------------------------------------ */
	/* ---------------------------- CLIENTES ---------------------------- */
	/* ------------------------------------------------------------------ */
	/**
	 * Obtém os clientes existentes.
	 * @return Vector com os campos de cada cliente.
	 */
	public static Vector<String[]> getClientes() {
		return selectAll("clientes");
	}
	
	public static Vector<String[]> getClientesOrdNome() {
		return selectAll("clientes", "NOME_PESSOA");
	}
	
	/**
	 * Obtém os dados de um cliente.
	 * @param id o ID do cliente.
	 * @return os campos do cliente.
	 */
	public static String[] getCliente(String id) {
		return selectAll("clientes", "ID_PES", id).get(0);
	}
	
	public static String[] getClienteBI(String bi) {
		return selectAll("clientes", "BI", bi).get(0);
	}

	/**
	 * Adiciona um cliente à BD.
	 * @param nome o nome do cliente a adicionar.
	 * @param bi o BI do cliente a adicionar.
	 * @param password a password do cliente a adicionar.
	 * @param morada a morada do cliente a adicionar.
	 * @param email o e-mail do cliente a adicionar.
	 * @param telefone o número de telefone do cliente a adicionar.
	 */
	public static void adicionaCliente(String nome, String bi, String password, String morada, String email, String telefone) {
		adicionaObjecto("clientes",
						new String[]{"seq_pessoa_id.NEXTVAL", p(nome), bi, p(password), p(morada), p(email), telefone, "1", "SYSDATE"});
	}
	
	/**
	 * Actualiza um cliente na BD.
	 * @param id o ID do cliente a actualizar.
	 * @param nome o novo nome do cliente a actualizar.
	 * @param bi o novo BI do cliente a actualizar.
	 * @param password a nova password do cliente a actualizar.
	 * @param morada a nova morada do cliente a actualizar.
	 * @param email o novo e-mail do cliente a actualizar.
	 * @param telefone o novo número de telefone do cliente a actualizar.
	 */
	public static void actualizaCliente(String id, String nome, String bi, String password, String morada, String email, String telefone) {
		actualizaObjecto("clientes", "ID_PES", id,
						 getToSetCamposClientes(),
						 new String[]{p(nome), bi, p(password), p(morada), p(email), telefone});
	}
	
	public static void actualizaCliente(String nome, String bi, String password, String morada, String email, String telefone) {
		actualizaObjecto("clientes", "BI", bi,
						 getToSetCamposClientes(),
						 new String[]{p(nome), bi, p(password), p(morada), p(email), telefone});
	}

	/**
	 * Invalida um cliente na BD.
	 * @param id o ID do cliente a invalidar.
	 */
	public static void invalidaCliente(String id) {
		invalidaObjecto("clientes", "ID_PES", id);
	}
	
	public static void invalidaClienteBI(String bi) {
		invalidaObjecto("clientes", "BI", bi);
	}
	
	/**
	 * Re-valida um cliente na BD.
	 * @param id o ID do cliente a re-validar.
	 */
	public static void validaCliente(String id) {
		validaObjecto("clientes", "ID_PES", id);
	}
	
	public static Vector<String[]> procuraClientes(String nome, String morada, String email, String telefone) {
		String query = "SELECT ID_PES, NOME, BI" +
					   " FROM clientes" +
					   " WHERE ID_PES = ID_PES" +	// redundância para evitar o caso em que o WHERE fica sem nada
					   (nome.isEmpty()?"":" AND nome = "+p("%"+nome+"%")) +
					   (morada.isEmpty()?"":" AND morada = "+p("%"+morada+"%")) +
					   (email.isEmpty()?"":" AND email = "+p("%"+email+"%")) +
					   (telefone.isEmpty()?"":" AND telefone = "+p("%"+telefone+"%"));
		return select(query);
	}

	/* -------------------------------------------------------------------- */
	/* ---------------------------- EMPREGADOS ---------------------------- */
	/* -------------------------------------------------------------------- */
	/**
	 * Obtém os empregados existentes.
	 * @return Vector com os campos de cada empregado.
	 */
	public static Vector<String[]> getEmpregados() {
		return selectAll("empregados");
	}
	
	/**
	 * Obtém os dados de um empregado.
	 * @param id o ID do empregado.
	 * @return os campos do empregado.
	 */
	public static String[] getEmpregado(String id) {
		return selectAll("empregados", "ID_PES", id).get(0);
	}
	
	public static String[] getEmpregadoBI(String bi) {
		return selectAll("empregados", "BI", bi).get(0);
	}

	/**
	 * Adiciona um empregado à BD.
	 * @param is_admin "1" se o empregado a adicionar é administrador. "0" caso contrário.
	 * @param salario o salário do empregado a adicionar.
	 * @param nome o nome do empregado a adicionar.
	 * @param bi o BI do empregado a adicionar.
	 * @param password a password do empregado a adicionar.
	 * @param morada a morada do empregado a adicionar.
	 * @param email o e-mail do empregado a adicionar.
	 * @param telefone o número de telefone do empregado a adicionar.
	 * @param data_registo a data de registo do empregado a adicionar.
	 */
	public static void adicionaEmpregado(String is_admin, String salario, String nome, String bi, String password, String morada, String email, String telefone, String data_registo) {
		adicionaObjecto("empregados",
						new String[]{"seq_pessoa_id.NEXTVAL", is_admin, salario, p(nome), bi, p(password), p(morada), p(email), telefone, "1", p(data_registo)});
	}
	
	/**
	 * Actualiza um empregado na BD.
	 * @param id o ID do empregado a actualizar.
	 * @param is_admin "1" se o empregado a actualizar fica definido como administrador. "0" caso contrário.
	 * @param salario o novo salário do empregado a actualizar.
	 * @param nome o novo nome do empregado a actualizar.
	 * @param bi o novo BI do empregado a actualizar.
	 * @param password a nova password do empregado a actualizar.
	 * @param morada a nova morada do empregado a actualizar.
	 * @param email o novo e-mail do empregado a actualizar.
	 * @param telefone o novo número de telefone do empregado a actualizar.
	 */
	public static void actualizaEmpregado(String id, String is_admin, String salario, String nome, String bi, String password, String morada, String email, String telefone) {
		actualizaObjecto("empregados", "ID_PES", id,
						 getToSetCamposEmpregados(),
					 	 new String[]{is_admin, salario, p(nome), bi, p(password), p(morada), p(email), telefone});
	}

	/**
	 * Invalida um empregado na BD.
	 * @param id o ID do empregado a invalidar.
	 */
	public static void invalidaEmpregado(String id) {
		invalidaObjecto("empregados", "ID_PES", id);
	}
	
	public static void invalidaEmpregadoBI(String bi) {
		invalidaObjecto("empregados", "BI", bi);
	}
	
	/**
	 * Re-valida um empregado na BD.
	 * @param id o ID do empregado a re-validar.
	 */
	public static void validaEmpregado(String id) {
		invalidaObjecto("empregados", "ID_PES", id);
	}
	
	public static Vector<String[]> procuraEmpregados(String is_admin, String salarioLow, String salarioHigh, String nome, String morada, String email, String telefone) {
		String query = "SELECT ID_PES, NOME, BI" +
					   " FROM clientes" +
					   " WHERE ID_PES = ID_PES" +	// redundância para evitar o caso em que o WHERE fica sem nada
					   (is_admin.isEmpty()?"":" AND is_admin = "+is_admin) +
					   (salarioLow.isEmpty()||salarioHigh.isEmpty()?"":" AND salario BETWEEN "+salarioLow+" AND "+salarioHigh) +
					   (nome.isEmpty()?"":" AND nome = "+p("%"+nome+"%")) +
					   (morada.isEmpty()?"":" AND morada = "+p("%"+morada+"%")) +
					   (email.isEmpty()?"":" AND email = "+p("%"+email+"%")) +
					   (telefone.isEmpty()?"":" AND telefone = "+p("%"+telefone+"%"));
		return select(query);
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- FILMES ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Obtém os filmes existentes.
	 * @return Vector com os campos de cada filme.
	 */
	public static Vector<String[]> getFilmes() {
		return selectAll("filmes");
	}
	
	public static Vector<String[]> getFilmesOrdTitulo() {
		return selectAll("filmes", "TITULO");
	}
	
	public static Vector<String[]> getFilmesOrdAno() {
		return selectAll("filmes", "ANO");
	}
	
	public static Vector<String[]> getFilmesOrdRankIMDB() {
		return selectAll("filmes", "RANKIMDB");
	}
	
	/**
	 * Obtém os dados de um filme.
	 * @param id o ID do filme.
	 * @return os campos do filme.
	 */
	public static String[] getFilme(String id) {
		return selectAll("filmes", "ID_FIL", id).get(0);
	}

	/**
	 * Adiciona um filme à BD.
	 * @param titulo o título do filme a adicionar.
	 * @param ano o ano do filme a adicionar.
	 * @param realizador o realizador do filme a adicionar.
	 * @param ratingIMDB o rating da IMDB do filme a adicionar.
	 * @param pais o país de origem do filme a adicionar.
	 * @param produtora a produtora do filme a adicionar.
	 * @param descricao a descrição do filme a adicionar.
	 * @param capa a capa do filme a adicionar.
	 */
	public static void adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa) {
		adicionaObjecto("filmes",
						new String[]{"seq_filme_id.NEXTVAL", p(titulo), p(ano), p(realizador), p(ratingIMDB), p(pais), p(produtora), p(descricao), p(capa)});
	}
	
	/**
	 * Actualiza um filme na BD.
	 * @param id o ID do filme a actualizar.
	 * @param titulo o novo título do filme a actualizar.
	 * @param ano o novo ano do filme a actualizar.
	 * @param realizador o novo realizador do filme a actualizar.
	 * @param ratingIMDB o novo rating da IMDB do filme a actualizar.
	 * @param pais o novo país de origem do filme a actualizar.
	 * @param produtora a nova produtora do filme a actualizar.
	 * @param descricao a nova descrição do filme a actualizar.
	 * @param capa a nova capa do filme a actualizar.
	 */
	public static void actualizaFilme(String id, String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa) {
		actualizaObjecto("filmes", "ID_FIL", id,
						 getToSetCamposFilmes(),
					 	 new String[]{p(titulo), ano, p(realizador), ratingIMDB, p(pais), p(produtora), p(descricao), p(capa)});
	}

	/**
	 * Invalida um filme na BD.
	 * @param id o ID do filme a invalidar.
	 */
	public static void invalidaFilme(String id) {
		invalidaObjecto("filmes", "ID_FIL", id);
	}
	
	/**
	 * Re-valida um filme na BD.
	 * @param id o ID do filme a re-validar.
	 */
	public static void validaFilme(String id) {
		invalidaObjecto("filmes", "ID_FIL", id);
	}
	
	// TODO: géneros
	public static Vector<String[]> procuraFilmes(String titulo, String anoLow, String anoHigh, String realizador, String ratingIMDBLow, String ratingIMDBHigh, String pais, String produtora, String[] generos) {
		String query = "SELECT ID_FIL, ANO, TITULO" +
					   " FROM filmes f" +
					   " WHERE ID_FIL = ID_FIL" +	// redundância para evitar o caso em que o WHERE fica sem nada
					   (titulo.isEmpty()?"":" AND titulo = "+p("%"+titulo+"%")) +
					   (realizador.isEmpty()?"":" AND realizador = "+p("%"+realizador+"%")) +
					   (pais.isEmpty()?"":" AND pais = "+p("%"+pais+"%")) +
					   (produtora.isEmpty()?"":" AND produtora = "+p("%"+produtora+"%")) +
					   (anoLow.isEmpty()||anoHigh.isEmpty()?"":" AND ano BETWEEN "+anoLow+" AND "+anoHigh) +
					   (ratingIMDBLow.isEmpty()||ratingIMDBHigh.isEmpty()?"":" AND ratingIMDB BETWEEN "+ratingIMDBLow+" AND "+ratingIMDBHigh);
		/*for(String id_gen : generos) {
			query += " AND " + ) +
		}*/
		return select(query);
	}

	/* ---------------------------------------------------------------------- */
	/* ---------------------------- FILME/GÉNERO ---------------------------- */
	/* ---------------------------------------------------------------------- */
	/**
	 * Obtém as relações filme/género.
	 * @return Vector com os IDs do filme e género que formam a relação.
	 */
	public static Vector<String[]> getFilmeGenero() {
		return selectAll("filme_genero");
	}
	
	/**
	 * Obtém os géneros de um filme.
	 * @param id_fil o ID do filme.
	 * @return os géneros do filme.
	 */
	public static String[] getGenerosFilmeID(String id_fil) {
		Vector<String[]> selected = select("filme_genero", new String[]{"ID_GEN"}, "ID_FIL", id_fil);
		int size = selected.size();
		String[] generos = new String[size];
		for(int i=0; i<size; i++)
			generos[i] = selected.get(i)[0];
		return generos;
	}
	
	public static String[] getGenerosFilmeNome(String id_fil) {
		Vector<String[]> selected = select("SELECT g.NOME_GENERO" +
										   " FROM generos g, filme_genero fg" +
										   " WHERE fg.ID_FIL =" + id_fil +
											 " AND fg.ID_GEN = g.ID_GEN");
		return Utils.strArrayVectorToArray(selected);
	}
	
	public static Vector<String[]> getGenerosFilme(String id_fil) {
		return select("SELECT g.ID_GEN, g.NOME_GENERO" +
				  " FROM generos g, filme_genero fg" +
				  " WHERE fg.ID_FIL =" + id_fil +
					" AND fg.ID_GEN = g.ID_GEN");
	}

	/**
	 * Adiciona uma relação filme/género à BD.
	 * @param id_fil ID do filme na relação.
	 * @param id_gen ID do género na relação.
	 */
	public static void adicionaFilmeGenero(String id_fil, String id_gen) {
		adicionaObjecto("filme_genero",
						new String[]{id_fil, id_gen});
	}

	/**
	 * Remove uma relação filme/género da BD.
	 * @param id_fil ID do filme na relação.
	 * @param id_gen ID do género na relação.
	 */
	public static void removeFilmeGenero(String id_fil, String id_gen) {
		removeObjecto("filme_genero",
					  getCamposFilmeGenero(),
					  new String[]{id_fil, id_gen});
	}

	/* ------------------------------------------------------------------ */
	/* ---------------------------- FORMATOS ---------------------------- */
	/* ------------------------------------------------------------------ */
	/**
	 * Obtém os formatos de filme existentes.
	 * @return Vector com os campos de cada formato.
	 */
	public static Vector<String[]> getFormatos() {
		return selectAll("formatos");
	}
	
	public static Vector<String[]> getFormatosOrdNome() {
		return selectAll("formatos", "NOME_FORMATO");
	}
	
	/**
	 * Obtém os dados de um formato.
	 * @param id o ID do formato.
	 * @return os campos do formato.
	 */
	public static String[] getFormato(String id) {
		return selectAll("formatos", "ID_FOR", id).get(0);
	}
	
	public static String getFormatoNome(String id) {
		return selectAll("formatos", "ID_FOR", id).get(0)[1];
	}
	
	/**
	 * Adiciona um formato à BD.
	 * @param nome o nome do formato a adicionar.
	 */
	public static void adicionaFormato(String nome) {
		adicionaObjecto("formatos",
						new String[]{"seq_formato_id.NEXTVAL", p(nome)});
	}
	
	/**
	 * Actualiza um formato na BD.
	 * @param id o ID do formato a actualizar.
	 * @param nome o novo nome para o formato a actualizar.
	 */
	public static void actualizaFormato(String id, String nome) {
		actualizaObjecto("formatos", "ID_FOR", id,
						 getToSetCamposFormatos(),
						 new String[]{p(nome)});
	}

	/**
	 * Remove um formato da BD.
	 * @param id o ID do formato a remover.
	 */
	public static void removeFormato(String id) {
		removeObjecto("formatos", "ID_FOR", id);
	}

	/**
	 * Remove da BD os formatos com um dado nome.
	 * @param nome o nome do formato a remover.
	 */
	public static void removeFormatoNome(String nome) {
		removeObjecto("formatos", "NOME_FORMATO", p(nome));
	}

	/* ----------------------------------------------------------------- */
	/* ---------------------------- GÉNEROS ---------------------------- */
	/* ----------------------------------------------------------------- */
	/**
	 * Obtém os géneros de filme existentes.
	 * @return Vector com os campos de cada género.
	 */
	public static Vector<String[]> getGeneros() {
		return selectAll("generos");
	}
	
	public static Vector<String[]> getGenerosOrdNome() {
		return selectAll("generos", "NOME_GENERO");
	}
	
	/**
	 * Obtém os dados de um género.
	 * @param id o ID do género.
	 * @return os campos do género.
	 */
	public static String[] getGenero(String id) {
		return selectAll("generos", "ID_GEN", id).get(0);
	}
	
	public static String getGeneroNome(String id) {
		return selectAll("generos", "ID_GEN", id).get(0)[1];
	}
	
	/**
	 * Adiciona um género à BD.
	 * @param nome o nome do género a adicionar.
	 */
	public static void adicionaGenero(String nome) {
		adicionaObjecto("generos",
						new String[]{"seq_genero_id.NEXTVAL", p(nome)});
	}
	
	/**
	 * Actualiza um género na BD.
	 * @param id o ID do género a actualizar.
	 * @param nome o novo nome para o género a actualizar.
	 */
	public static void actualizaGenero(String id, String nome) {
		actualizaObjecto("generos", "ID_GEN", id,
						 getToSetCamposGeneros(),
						 new String[]{p(nome)});
	}

	/**
	 * Remove um género da BD.
	 * @param id o ID do género a remover.
	 */
	public static void removeGenero(String id) {
		removeObjecto("generos", "ID_GEN", id);
	}

	/**
	 * Remove da BD os géneros com um dado nome.
	 * @param nome o nome do género a remover.
	 */
	public static void removeGeneroNome(String nome) {
		removeObjecto("generos", "NOME_GENERO", p(nome));
	}

	/* ---------------------------------------------------------------------- */
	/* ---------------------------- MÁQUINAS ATM ---------------------------- */
	/* ---------------------------------------------------------------------- */
	/**
	 * Obtém as máquinas ATM existentes.
	 * @return Vector com os campos de cada máquina ATM.
	 */
	public static Vector<String[]> getMaquinasATM() {
		return selectAll("maquinasatm");
	}
	
	/**
	 * Obtém os dados de uma máquina ATM.
	 * @param id o ID da máquina ATM.
	 * @return os campos da máquina ATM.
	 */
	public static String[] getMaquinaATM(String id) {
		return selectAll("maquinasatm", "ID_MAQ", id).get(0);
	}

	/**
	 * Adiciona uma máquina ATM à BD.
	 * @param preco o preço da máquina a adicionar.
	 * @param data_instalacao a data de instalação da máquina a adicionar.
	 */
	public static void adicionaMaquinaATM(String preco) {
		adicionaObjecto("maquinasatm",
						new String[]{"seq_maquinaatm_id.NEXTVAL", preco, "1", "SYSDATE"});
	}
	
	/**
	 * Actualiza uma máquina ATM na BD.
	 * @param id o ID da máquina a actualizar.
	 * @param preco o novo preço da máquina a actualizar.
	 * @param data_instalacao a nova data de instalação da máquina a actualizar.
	 */
	public static void actualizaMaquinaATM(String id, String preco) {
		actualizaObjecto("maquinasatm", "ID_MAQ", id,
						 getToSetCamposMaquinasATM(),
						 new String[]{preco});
	}

	/**
	 * Invalida uma máquina ATM na BD.
	 * @param id o ID da máquina ATM a invalidar.
	 */
	public static void invalidaMaquinaATM(String id) {
		invalidaObjecto("maquinasatm", "ID_MAQ", id);
	}
	
	/**
	 * Re-valida uma máquina ATM na BD.
	 * @param id o ID da máquina ATM a re-validar.
	 */
	public static void validaMaquinaATM(String id) {
		invalidaObjecto("maquinasatm", "ID_MAQ", id);
	}

	/* -------------------------------------------------------------------- */
	/* ---------------------------- PAGAMENTOS ---------------------------- */
	/* -------------------------------------------------------------------- */
	/**
	 * Obtém os pagamentos existentes.
	 * @return Vector com os campos de cada pagamento.
	 */
	public static Vector<String[]> getPagamentos() {
		return selectAll("pagamentos");
	}
	
	/**
	 * Obtém os dados de um pagamento.
	 * @param id_req o ID da requisição do pagamento.
	 * @return os campos do pagamento.
	 */
	public static String[] getPagamento(String id_req) {
		return selectAll("pagamentos", "ID_REQ", id_req).get(0);
	}
	
	/**
	 * Adiciona um pagamento à BD.
	 * @param id_req o ID da requisição do pagamento a adicionar.
	 * @param montante o montante do pagamento a adicionar.
	 */
	public static void adicionaPagamento(String id_req, String montante) {
		adicionaObjecto("pagamentos",
						new String[]{id_req, montante});
	}
	
	/**
	 * Actualiza um pagamento na BD.
	 * @param id o ID da requisição do pagamento a actualizar.
	 * @param montante o novo montante para o pagamento a actualizar.
	 */
	public static void actualizaPagamento(String id, String montante) {
		actualizaObjecto("pagamentos", "ID_REQ", id,
						 getToSetCamposPagamentos(),
						 new String[]{montante});
	}

	/**
	 * Remove um pagamento da BD.
	 * @param id o ID da requisição do pagamento a remover.
	 */
	public static void removePagamento(String id) {
		removeObjecto("pagamentos", "ID_REQ", id);
	}

	/* --------------------------------------------------------------------- */
	/* ---------------------------- REQUISIÇÕES ---------------------------- */
	/* --------------------------------------------------------------------- */
	/**
	 * Obtém as requisições existentes.
	 * @return Vector com os campos de cada requisição.
	 */
	public static Vector<String[]> getRequisicao() {
		return selectAll("requisicoes");
	}
	
	/**
	 * Obtém os dados de uma requisição.
	 * @param id o ID da requisição.
	 * @return os campos da requisição.
	 */
	public static String[] getRequisicao(String id) {
		return selectAll("requisicoes", "ID_REQ", id).get(0);
	}

	/**
	 * Adiciona uma requisição à BD.
	 * @param data a data da requisição.
	 * @param data_limite a nova data limite de entrega do material da requisição.
	 */
	public static void adicionaRequisicao(String data, String data_limite) {
		adicionaObjecto("requisicoes",
						new String[]{p(data), p(data_limite), "null"});
	}
	
	/**
	 * Actualiza uma requisição na BD.
	 * @param id o ID da requisição a actualizar.
	 * @param data_limite a nova data limite de entrega do material da requisição.
	 * @param data_entrega a data de entrega do material da requisição.
	 */
	public static void actualizaRequisicao(String id, String data_limite, String data_entrega) {
		actualizaObjecto("requisicoes", "ID_REQ", id,
						 getToSetCamposRequisicoes(),
						 new String[]{p(data_limite), p(data_entrega)});
	}
	
	/**
	 * Actualiza uma requisição na BD com a data de entrega.
	 * @param id o ID da requisição a actualizar.
	 * @param data_entrega a data de entrega do material da requisição.
	 */
	public static void actualizaRequisicao(String id, String data_entrega) {
		actualizaObjecto("requisicoes", "ID_REQ", id, "DATA_ENTREGA", p(data_entrega));
	}

	/**
	 * Remove uma requisição da BD.
	 * @param id o ID da requisição a remover.
	 */
	public static void removeRequisicao(String id) {
		removeObjecto("requisicoes", "ID_REQ", id);
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- STOCKS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Obtém os stocks existentes.
	 * @return Vector com os campos de cada stock.
	 */
	public static Vector<String[]> getStocks() {
		return selectAll("stocks");
	}
	
	/**
	 * Obtém os dados de um stock.
	 * @param id_fil o ID do filme do stock.
	 * @param id_for o ID do formato do stock.
	 * @return os campos do stock.
	 */
	public static String[] getStock(String id_fil, String id_for) {
		return select("stocks",
					  getCamposStocks(),
					  new String[]{"ID_FIL", "ID_FOR"},
					  new String[]{id_fil, id_for}).get(0);
	}

	/**
	 * Adiciona um stock à BD.
	 * @param id_fil o ID do filme do stock a adicionar.
	 * @param id_for o ID do formato do stock a adicionar.
	 * @param disponiveis o número de filmes disponíveis no formato do stock.
	 * @param quant a quantidade total de filmes existentes no stock.
	 * @param custo_compra o custo de compra (à distribuidora) associado a um filme no stock.
	 * @param custo_aluguer o custo de aluguer associado a um filme no stock.
	 */
	public static void adicionaStock(String id_fil, String id_for, String disponiveis, String quant, String custo_compra, String custo_aluguer) {
		adicionaObjecto("stocks",
						new String[]{id_fil, id_for, disponiveis, quant, custo_compra, custo_aluguer});
	}
	
	/**
	 * Actualiza um stock na BD.
	 * @param id_fil o ID do filme do stock a actualizar.
	 * @param id_for o ID do formato do stock a actualizar.
	 * @param disponiveis o novo número de filmes disponíveis no formato do stock.
	 * @param quant a nova quantidade total de filmes existentes no stock.
	 * @param custo_compra o novo custo de compra (à distribuidora) associado a um filme no stock.
	 * @param custo_aluguer o novo custo de aluguer associado a um filme no stock.
	 */
	public static void actualizaStock(String id_fil, String id_for, String disponiveis, String quant, String custo_compra, String custo_aluguer) {
		actualizaObjecto("stocks",
						 new String[]{"ID_FIL", "ID_FOR"},
						 new String[]{id_fil, id_for},
						 getToSetCamposStocks(),
						 new String[]{disponiveis, quant, custo_compra, custo_aluguer});
	}
	
	/**
	 * Actualiza o número de filmes disponíveis num stock da BD.
	 * @param id_fil o ID do filme do stock a actualizar.
	 * @param id_for o ID do formato do stock a actualizar.
	 * @param incr o incremento (ou decremento) a aplicar ao número de filmes disponíveis em stock.
	 */
	public static void actualizaDisponiveisStock(String id_fil, String id_for, int incr) {
		String comando = "UPDATE stocks SET disponiveis = disponiveis + " + incr +
						 " WHERE ID_FIL = " + id_fil + " AND ID_FOR = " + id_for;
		execute(comando);
	}

	/**
	 * Remove um stock da BD.
	 * @param id_fil o ID do filme do stock a remover.
	 * @param id_for o ID do formato do stock a remover.
	 */
	public static void removePagamento(String id_fil, String id_for) {
		removeObjecto("stocks",
					  new String[]{"ID_FIL", "IF_FOR"},
					  new String[]{id_fil, id_for});
	}
	
	/* -------------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS DE VERIFICAÇÃO ---------------------------- */
	/* -------------------------------------------------------------------------------- */
	/**
	 * Verifica se existe um cliente com determinado BI, para além do cliente com o ID passado.
	 * @param id_cli o ID do cliente a excluir da verificação.
	 * @param bi o BI a procurar.
	 * @return true, se existe outro cliente com esse BI. false, caso contrário.
	 */
	public static boolean biClienteExiste(String id_cli, String bi) {
		return valorExiste("clientes", "BI", bi, "ID_PES", id_cli);
	}
	
	public static boolean biClienteExiste(String bi) {
		return valorExiste("clientes", "BI", bi);
	}
	
	/**
	 * Verifica se existe um empregado com determinado BI, para além do empregado com o ID passado.
	 * @param id_emp o ID do empregado a excluir da verificação.
	 * @param bi o BI a procurar.
	 * @return true, se existe outro empregado com esse BI. false, caso contrário.
	 */
	public static boolean biEmpregadoExiste(String id_emp, String bi) {
		return valorExiste("empregados", "BI", bi, "ID_PES", id_emp);
	}
	
	public static boolean biEmpregadoExiste(String bi) {
		return valorExiste("empregados", "BI", bi);
	}
	
	/**
	 * Vertifica se o empregado é administrador e é o único.
	 * @param id_emp o ID do empregado a verificar.
	 * @return true, se o empregado é o único administrador. false, caso contrário.
	 */
	public static boolean empregadoEUnicoAdmin(String id_emp) {
		return !valorExiste("empregados", "IS_ADMIN", "1", "ID_PES", id_emp);
	}
	
	public static boolean empregadoEUnicoAdminBI(String bi) {
		return !valorExiste("empregados", "IS_ADMIN", "1", "BI", bi);
	}
	
	/**
	 * Verifica se determinado nome de género existe, excluíndo o género com o ID passado
	 * (comparação não olha a diferenças de maiúsculas/minúsculas).
	 * @param id_gen o ID do género a excluir da verificação.
	 * @param nome o nome do género cuja existência tem de ser verificada.
	 * @return true, se existe outro género com esse nome.  false, caso contrário.
	 */
	public static boolean generoExiste(String id_gen, String nome) {
		return valorExiste("generos", "NOME_GENERO", p(nome), "ID_GEN", id_gen);
	}
	
	/**
	 * Verifica se determinado nome de formato existe, excluíndo o formato com o ID passado
	 * (comparação não olha a diferenças de maiúsculas/minúsculas).
	 * @param id_for o ID do formato a excluir da verificação.
	 * @param nome o nome do formato cuja existência tem de ser verificada.
	 * @return true, se existe outro formato com esse nome. false, caso contrário.
	 */
	public static boolean formatoExiste(String id_for, String nome) {
		return valorExiste("formatos", "NOME_FORMATO", p(nome), "ID_FOR", id_for);
	}

	/**
	 * Verifica se determinado stock para um certo filme e formato existe.
	 * @param id_fil o ID do filme a verificar stock.
	 * @param id_for o ID do formato a verificar stock.
	 * @return true, se existe stock para o filme e formato referidos. false, caso contrário.
	 */
	public static boolean stockExiste(String id_fil, String id_for) {
		return valorExiste("stocks",
						   new String[]{"ID_FIL", "ID_FOR"},
						   new String[]{id_fil, id_for});
	}

	/**
	 * Verifica se existe algum stock para um certo formato (para qualquer filme).
	 * Por outras palavras, verifica se o formato está a ser usado para algo.
	 * @param id_for o ID do formato a verificar.
	 * @return true, se existe pelo menos um stock para o formato. false, caso contrário.
	 */
	public static boolean formatoEmUso(String id_for) {
		return valorExiste("stocks", "ID_FOR", id_for);
	}
	
	public static boolean formatoEmUsoNome(String nome) {
		Vector<String[]> vec = select("formatos", new String[]{"ID_FOR"}, "NOME_FORMATO", p(nome));
		return valorExiste("stocks", "ID_FOR", vec.get(0)[0]);
	}
	
	/**
	 * Verifica se existe algum filme com um certo género.
	 * Por outras palavras, verifica se o género está a ser usado para algo.
	 * @param id_gen o ID do género a verificar.
	 * @return true, se existe pelo menos um filme com esse género. false, caso contrário.
	 */
	public static boolean generoEmUso(String id_gen) {
		return valorExiste("filme_genero", "ID_GEN", id_gen);
	}
	
	public static boolean generoEmUsoNome(String nome) {
		Vector<String[]> vec = select("generos", new String[]{"ID_GEN"}, "NOME_GENERO", nome);
		return valorExiste("filme_genero", "ID_GEN", vec.get(0)[0]);
	}
	
	/**
	 * Verifica se um filme tem apenas determinado género e mais nenhum.
	 * @param id_fil o ID do filme a verificar.
	 * @param id_gen o ID do género a verificar.
	 * @return true, se o filme tem apenas esse género e mais nenhum. false, caso contrário.
	 */
	public static boolean filmeSoTemGenero(String id_fil, String id_gen) {
		Vector<String[]> vec = getGenerosFilme(id_fil);
		return (vec.size() == 1 && vec.get(0).equals(id_gen));
	}

	/**
	 * Verifica se determinado valor existe em determinado campo numa dada tabela (função genérica).
	 * @param tabela a tabela a verificar.
	 * @param campo o campo cujo valor verificar.
	 * @param valor o valor a encontrar no campo.
	 * @return true, se o valor foi encontrado no campo referido de algum elemento. false, caso contrário.
	 */
	private static boolean valorExiste(String tabela, String campo, String valor) {
		Vector<String[]> vec = selectAll(tabela, campo, valor);
		return (vec.size() > 0);
	}
	
	/**
	 * Verifica se determinados valores existem (em simultâneo) em vários campos de uma dada tabela (função genérica).
	 * @param tabela a tabela a verificar.
	 * @param campos os campos cujo valor verificar.
	 * @param valores os valores a encontrar nos campos.
	 * @return true, se os valores existem em simultâneo nos campos referidos de algum elemento. false, caso contrário.
	 */
	private static boolean valorExiste(String tabela, String[] campos, String[] valores) {
		Vector<String[]> vec = selectAll(tabela, campos, valores);
		return (vec.size() > 0);
	}

	/**
	 * Verifica se determinado valor existe em determinado campo numa dada tabela,
	 * exluíndo elementos com determinado valor em determinado campo (função genérica).
	 * @param tabela a tabela a verificar.
	 * @param campo o campo cujo valor verificar.
	 * @param valor o valor a encontrar no campo.
	 * @param exceptCampo o campo a verificar para excluir elementos da procura.
	 * @param exceptValor o valor que o campo de exclusão deve ter para excluir elementos da procura.
	 * @return true, se o valor foi encontrado no campo referido de algum elemento (excluíndo os devidos). false, caso contrário.
	 */
	private static boolean valorExiste(String tabela, String campo, String valor, String exceptCampo, String exceptValor) {
		Vector<String[]> vec = select("SELECT *" +
									  " FROM " + tabela +
									  " WHERE " + campo + "=" + valor +
									  " AND " + exceptCampo + "!=" + exceptValor);
		return (vec.size() > 0);
	}
	
	/* --------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS GENÉRICOS ---------------------------- */
	/* --------------------------------------------------------------------------- */
	/**
	 * Adiciona um objecto à BD. Função genérica.
	 * @param tabela a tabela à qual adicionar o objecto.
	 * @param valores os valores do objecto a adicionar.
	 */
	private static void adicionaObjecto(String tabela, String[] valores) {
		execute("INSERT INTO " + tabela +
				" VALUES(" + Utils.list(valores, ",") + ")");
	}
	
	/**
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a actualizar.
	 * @param valor o valor que deve ter o campo no objecto a actualizar.
	 * @param campoAct o campo a actualizar no objecto.
	 * @param valorAct o valor do campo a actualizar.
	 */
	private static void actualizaObjecto(String tabela, String campo, String valor, String campoAct, String valorAct) {
		execute("UPDATE " + tabela +
				" SET " + campoAct + "=" + valorAct +
				" WHERE " + campo + "=" + valor);
	}
	
	/**
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a actualizar.
	 * @param valor o valor que deve ter o campo no objecto a actualizar.
	 * @param camposAct os campos a actualizar no objecto.
	 * @param valoresAct os valores dos campos a actualizar.
	 */
	private static void actualizaObjecto(String tabela, String campo, String valor, String[] camposAct, String[] valoresAct) {
		execute("UPDATE " + tabela +
				" SET " + Utils.list(camposAct, "=", valoresAct, ",") +
				" WHERE " + campo + "=" + valor);
	}
	
	/**
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campos os campos utilizados para encontrar o objecto a actualizar.
	 * @param valores os valores que devem ter os campos no objecto a actualizar.
	 * @param campoAct o campo a actualizar no objecto.
	 * @param valorAct o valor do campo a actualizar.
	 */
	private static void actualizaObjecto(String tabela, String[] campos, String[] valores, String campoAct, String valorAct) {
		execute("UPDATE " + tabela +
				" SET " + campoAct + "=" + valorAct +
				" WHERE " + Utils.list(campos, "=", valores, " AND "));
	}
	
	/**
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campos os campos utilizados para encontrar o objecto a actualizar.
	 * @param valores os valores que devem ter os campos no objecto a actualizar.
	 * @param camposAct os campos a actualizar no objecto.
	 * @param valoresAct os valores dos campos a actualizar.
	 */
	private static void actualizaObjecto(String tabela, String[] campos, String[] valores, String[] camposAct, String[] valoresAct) {
		execute("UPDATE " + tabela +
			   " SET " + Utils.list(camposAct, "=", valoresAct, ",") +
			   " WHERE " + Utils.list(campos, "=", valores, " AND "));
	}
	
	/**
	 * Invalida um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual invalidar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a invalidar.
	 * @param valor o valor que deve ter o campo no objecto a invalidar.
	 */
	private static void invalidaObjecto(String tabela, String campo, String valor) {
		actualizaObjecto(tabela, campo, valor, "valido", "0");
	}
	
	/**
	 * Valida um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual validar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a validar.
	 * @param valor o valor que deve ter o campo no objecto a validar.
	 */
	private static void validaObjecto(String tabela, String campo, String valor) {
		actualizaObjecto(tabela, campo, valor, "valido", "1");
	}
	
	/**
	 * Remove os objectos da BD que tenham determinado valor num determinado campo. Função genérica.
	 * @param tabela a tabela da qual remover o(s) objecto(s).
	 * @param campo o campo a verificar para encontrar o(s) objecto(s) a remover.
	 * @param valor o valor do campo no(s) objecto(s) a ser removido(s).
	 */
	private static void removeObjecto(String tabela, String campo, String valor) {
		execute("DELETE FROM " + tabela +
				" WHERE " + campo + " = " + valor);
	}
	
	/**
	 * Remove os objectos da BD que tenham determinados valores em determinados campos. Função genérica.
	 * @param tabela a tabela da qual remover o(s) objecto(s).
	 * @param campos os campos a verificar para encontrar o(s) objecto(s) a remover.
	 * @param valores os valores do campos no(s) objecto(s) a ser removido(s).
	 */
	private static void removeObjecto(String tabela, String[] campos, String[] valores) {
		execute("DELETE FROM " + tabela +
				" WHERE " + Utils.list(campos, "=", valores, " AND "));
	}
	
	/**
	 * Obtém todos campos de todos os objectos existentes numa dada tabela.
	 * @param tabela tabela de onde obter os dados.
	 * @return Vector com os campos de cada linha da tabela.
	 */
	private static Vector<String[]> selectAll(String tabela) {
		return select("SELECT *" +
					  " FROM " + tabela);
	}
	
	private static Vector<String[]> selectAll(String tabela, String campoOrder) {
		return select("SELECT *" +
					  " FROM " + tabela +
					  " ORDER BY " + campoOrder);
	}
	
	/**
	 * Obtém todos os campos do objecto existente numa dada tabela que contiver
	 * certo valor num determinado campo.
	 * @param tabela tabela de onde obter os dados.
	 * @param campo o campo que seleccionará o objecto.
	 * @param valor o valor a procurar no campo.
	 * @return Vector com todos os campos dos objectos.
	 */
	private static Vector<String[]> selectAll(String tabela, String campo, String valor) {
		return select("SELECT *" +
					  " FROM " + tabela +
					  " WHERE " + campo + "=" + valor);
	}
	
	private static Vector<String[]> selectAll(String tabela, String[] campos, String[] valores) {
		return select("SELECT *" +
					  " FROM " + tabela +
					  " WHERE " + Utils.list(campos, "=", valores, "AND"));
	}
	
	/**
	 * Obtém os campos seleccionados dos objectos existentes numa dada tabela.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campos nomes das colunas a obter da tabela.
	 * @return Vector com os valores dos campos seleccionados de cada linha da tabela.
	 */
	private static Vector<String[]> select(String tabela, String[] camposSel) {
		return select("SELECT " + Utils.list(camposSel, ",") +
					  " FROM " + tabela);
	}
	
	/**
	 * Obtém os campos seleccionados dos objectos existentes numa dada tabela que contiverem
	 * certo valor num determinado campo.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campos nomes das colunas a obter da tabela.
	 * @param campo o campo que seleccionará o objecto.
	 * @param valor o valor a procurar no campo.
	 * @return Vector com os campos seleccionados dos objectos.
	 */
	private static Vector<String[]> select(String tabela, String[] camposSel, String campo, String valor) {
		return select("SELECT " + Utils.list(camposSel, ",") +
					  " FROM " + tabela +
					  " WHERE " + campo + "=" + valor);
	}
	
	/**
	 * Obtém os campos seleccionados dos objectos existentes numa dada tabela que contiverem
	 * certos valores em determinados campos.
	 * @param tabela tabela onde fazer SELECT.
	 * @param camposSel nomes das colunas a obter da tabela.
	 * @param campos os campos que seleccionarão o objecto.
	 * @param valores os valores a procurar nos campos.
	 * @return Vector com os campos seleccionados dos objectos.
	 */
	private static Vector<String[]> select(String tabela, String[] camposSel, String[] campos, String[] valores) {
		return select("SELECT " + Utils.list(camposSel, ",") +
					  " FROM " + tabela +
					  " WHERE " + Utils.list(campos, "=", valores, "AND"));
	}
	
	private static String queryBuilder(String SELECT, String FROM, String WHERE, String ORDER) {
		return "SELECT " + SELECT +
			   " FROM " + FROM +
			   ((WHERE==null || WHERE.isEmpty()) ? "" : " WHERE " + WHERE) +
			   ((ORDER==null || ORDER.isEmpty()) ? "" : " ORDER BY " + ORDER);
	}
	
	private static Vector<String[]> select(String query) {
		Vector<String[]> objectos = new Vector<String[]>();
		String[] objecto;
		try {
			Statement st = conn.createStatement();
			ResultSet rset = st.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int n = rsmd.getColumnCount();
			
			while (rset.next()) {
				objecto = new String[n];
				for (int i = 0; i < n; i++)
					objecto[i] = rset.getString(i+1);
				objectos.add(objecto);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		return objectos;
	}

	/**
	 * Actualiza a BD com o comando passado por argumento.
	 * @param comando o comando a executar sobre a BD.
	 */
	private static void execute(String comando) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(comando);
			conn.commit();
		} catch (SQLException ex) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- OUTROS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Coloca plicas na string passada. Substitui todos os apóstrofes na palavra
	 * por apóstrofes duplos para fazer "escape".
	 * @param s a string à qual aplicar plicas.
	 * @return a string, com plicas e os apóstrofes diplicados.
	 */
	private static String p(String s) {
		return "'" + s.replace("'", "''") + "'";
	}
}
