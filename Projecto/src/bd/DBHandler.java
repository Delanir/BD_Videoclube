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
 * A classe-inv�lucro da Base de Dados (BD).
 * Comunica directamente com ela e executa queries e updates.
 */
public class DBHandler
{
	private Connection conn;
	
	/**
	 * O m�todo main. Apenas para prop�sitos de teste.
	 * @param args os argumentos da linha de comandos.
	 */
	public static void main(String args[]) {
		DBHandler dbh = new DBHandler();
		if (dbh.conn != null) {
			//Icon icon = new ImageIcon("MV5BMTI5Mjc2MTE3OV5BMl5BanBnXkFtZTcwNTc2MzI2Mg@@._V1._CR341,0,1365,1365_SS80_.jpg");
			
			//Utils.printStringArrayVector(dbh.getFilmes());
			System.out.println();
			dbh.close();
		} else
			System.out.println("deu bode");
	}

	/**
	 * Instancia um novo objecto de manuseamento da base de dados, criando uma
	 * liga��o a esta.
	 */
	public DBHandler() {
		open();
	}
	
	/* ----------------------------------------------------------------- */
	/* ---------------------------- LIGA��O ---------------------------- */
	/* ----------------------------------------------------------------- */
	/**
	 * Cria uma liga��o � BD.
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
	 * Fecha a liga��o � BD.
	 */
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/* --------------------------------------------------------------------------------- */
	/* ---------------------------- GETS DE NOMES DE CAMPOS ---------------------------- */
	/* --------------------------------------------------------------------------------- */
	
	public String[] getCamposClientes() {		return new String[]{"ID_PES", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"};}
	public String[] getCamposEmpregados() {		return new String[]{"ID_PES", "IS_ADMIN", "SALARIO", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE", "VALIDO", "DATA_REGISTO"};}
	public String[] getCamposFilmes() {			return new String[]{"ID_FIL", "TITULO", "ANO", "REALIZADOR", "RANKIMDB", "PAIS", "PRODUTORA", "DESCRICAO", "CAPA", "VALIDO"};}
	public String[] getCamposFilmeGenero() {	return new String[]{"ID_GEN", "ID_FIL"};}
	public String[] getCamposFormatos() {		return new String[]{"ID_FOR", "NOME_FORMATO"};}
	public String[] getCamposGeneros() {		return new String[]{"ID_GEN", "NOME_GENERO"};}
	public String[] getCamposMaquinasATM() {	return new String[]{"ID_MAQ", "PRECO", "VALIDO", "DATA_INSTALACAO"};}
	public String[] getCamposPagamentos() {		return new String[]{"ID_REQ", "MONTANTE"};}
	public String[] getCamposRequisicoes() {	return new String[]{"ID_REQ", "ID_MAQ", "EMP_ID_PES", "ID_PES", "ID_FIL", "ID_FOR", "DATA", "DATA_LIMITE", "DATA_ENTREGA"};}
	public String[] getCamposStocks() {			return new String[]{"ID_FIL", "ID_FOR", "DISPONIVEIS", "QUANT", "CUSTO_COMPRA", "CUSTO_ALUGUER"};}

	public String[] getToSetCamposClientes() {		return new String[]{"NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE"};}
	public String[] getToSetCamposEmpregados() {	return new String[]{"IS_ADMIN", "SALARIO", "NOME_PESSOA", "BI", "PASSWORD", "MORADA", "E_MAIL", "TELEFONE"};}
	public String[] getToSetCamposFilmes() {		return new String[]{"TITULO", "ANO", "REALIZADOR", "RANKIMDB", "PAIS", "PRODUTORA", "DESCRICAO", "CAPA"};}
	public String[] getToSetCamposFilmeGenero() {	return new String[]{};}
	public String[] getToSetCamposFormatos() {		return new String[]{"NOME_FORMATO"};}
	public String[] getToSetCamposGeneros() {		return new String[]{"NOME_GENERO"};}
	public String[] getToSetCamposMaquinasATM() {	return new String[]{"PRECO", "DATA_INSTALACAO"};}
	public String[] getToSetCamposPagamentos() {	return new String[]{"MONTANTE"};}
	public String[] getToSetCamposRequisicoes() {	return new String[]{"DATA_LIMITE", "DATA_ENTREGA"};}
	public String[] getToSetCamposStocks() {		return new String[]{"DISPONIVEIS", "QUANT", "CUSTO_COMPRA", "CUSTO_ALUGUER"};}

	/* ------------------------------------------------------------------ */
	/* ---------------------------- CLIENTES ---------------------------- */
	/* ------------------------------------------------------------------ */
	/**
	 * Obt�m os clientes existentes.
	 * @return Vector com os campos de cada cliente.
	 */
	public Vector<String[]> getClientes() {
		return select("clientes");
	}
	
	/**
	 * Obt�m os dados de um cliente.
	 * @param id o ID do cliente.
	 * @return os campos do cliente.
	 */
	public String[] getCliente(String id) {
		return select("clientes", "ID_CLI", id).get(0);
	}

	/**
	 * Adiciona um cliente � BD.
	 * @param nome o nome do cliente a adicionar.
	 * @param bi o BI do cliente a adicionar.
	 * @param password a password do cliente a adicionar.
	 * @param morada a morada do cliente a adicionar.
	 * @param email o e-mail do cliente a adicionar.
	 * @param telefone o n�mero de telefone do cliente a adicionar.
	 * @param data_registo a data de registo do cliente a adicionar.
	 */
	public void adicionaCliente(String nome, String bi, String password, String morada, String email, String telefone, String data_registo) {
		adicionaObjecto("clientes",
						new String[]{"seq_pessoa_id.NEXTVAL", p(nome), bi, p(password), p(morada), p(email), telefone, "1", p(data_registo)});
	}
	
	/**
	 * Actualiza um cliente na BD.
	 * @param id o ID do cliente a actualizar.
	 * @param nome o novo nome do cliente a actualizar.
	 * @param bi o novo BI do cliente a actualizar.
	 * @param password a nova password do cliente a actualizar.
	 * @param morada a nova morada do cliente a actualizar.
	 * @param email o novo e-mail do cliente a actualizar.
	 * @param telefone o novo n�mero de telefone do cliente a actualizar.
	 */
	public void actualizaCliente(String id, String nome, String bi, String password, String morada, String email, String telefone) {
		actualizaObjecto("clientes", "ID_CLI", id,
						 getToSetCamposClientes(),
						 new String[]{p(nome), bi, p(password), p(morada), p(email), telefone});
	}

	/**
	 * Invalida um cliente na BD.
	 * @param id o ID do cliente a invalidar.
	 */
	public void invalidaCliente(String id) {
		invalidaObjecto("clientes", "ID_CLI", id);
	}
	
	/**
	 * Re-valida um cliente na BD.
	 * @param id o ID do cliente a re-validar.
	 */
	public void validaCliente(String id) {
		validaObjecto("clientes", "ID_CLI", id);
	}

	/* -------------------------------------------------------------------- */
	/* ---------------------------- EMPREGADOS ---------------------------- */
	/* -------------------------------------------------------------------- */
	/**
	 * Obt�m os empregados existentes.
	 * @return Vector com os campos de cada empregado.
	 */
	public Vector<String[]> getEmpregados() {
		return select("empregados");
	}
	
	/**
	 * Obt�m os dados de um empregado.
	 * @param id o ID do empregado.
	 * @return os campos do empregado.
	 */
	public String[] getEmpregado(String id) {
		return select("empregados", "ID_EMP", id).get(0);
	}

	/**
	 * Adiciona um empregado � BD.
	 * @param is_admin "1" se o empregado a adicionar � administrador. "0" caso contr�rio.
	 * @param salario o sal�rio do empregado a adicionar.
	 * @param nome o nome do empregado a adicionar.
	 * @param bi o BI do empregado a adicionar.
	 * @param password a password do empregado a adicionar.
	 * @param morada a morada do empregado a adicionar.
	 * @param email o e-mail do empregado a adicionar.
	 * @param telefone o n�mero de telefone do empregado a adicionar.
	 * @param data_registo a data de registo do empregado a adicionar.
	 */
	public void adicionaEmpregado(String is_admin, String salario, String nome, String bi, String password, String morada, String email, String telefone, String data_registo) {
		adicionaObjecto("empregados",
						new String[]{"seq_pessoa_id.NEXTVAL", is_admin, salario, p(nome), bi, p(password), p(morada), p(email), telefone, "1", p(data_registo)});
	}
	
	/**
	 * Actualiza um empregado na BD.
	 * @param id o ID do empregado a actualizar.
	 * @param is_admin "1" se o empregado a actualizar fica definido como administrador. "0" caso contr�rio.
	 * @param salario o novo sal�rio do empregado a actualizar.
	 * @param nome o novo nome do empregado a actualizar.
	 * @param bi o novo BI do empregado a actualizar.
	 * @param password a nova password do empregado a actualizar.
	 * @param morada a nova morada do empregado a actualizar.
	 * @param email o novo e-mail do empregado a actualizar.
	 * @param telefone o novo n�mero de telefone do empregado a actualizar.
	 */
	public void actualizaEmpregado(String id, String is_admin, String salario, String nome, String bi, String password, String morada, String email, String telefone) {
		actualizaObjecto("empregados", "ID_EMP", id,
						 getToSetCamposEmpregados(),
					 	 new String[]{is_admin, salario, p(nome), bi, p(password), p(morada), p(email), telefone});
	}

	/**
	 * Invalida um empregado na BD.
	 * @param id o ID do empregado a invalidar.
	 */
	public void invalidaEmpregado(String id) {
		invalidaObjecto("empregados", "ID_EMP", id);
	}
	
	/**
	 * Re-valida um empregado na BD.
	 * @param id o ID do empregado a re-validar.
	 */
	public void validaEmpregado(String id) {
		invalidaObjecto("empregados", "ID_EMP", id);
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- FILMES ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Obt�m os filmes existentes.
	 * @return Vector com os campos de cada filme.
	 */
	public Vector<String[]> getFilmes() {
		return select("filmes");
	}
	
	/**
	 * Obt�m os dados de um filme.
	 * @param id o ID do filme.
	 * @return os campos do filme.
	 */
	public String[] getFilme(String id) {
		return select("filmes", "ID_FIL", id).get(0);
	}

	/**
	 * Adiciona um filme � BD.
	 * @param titulo o t�tulo do filme a adicionar.
	 * @param ano o ano do filme a adicionar.
	 * @param realizador o realizador do filme a adicionar.
	 * @param ratingIMDB o rating da IMDB do filme a adicionar.
	 * @param pais o pa�s de origem do filme a adicionar.
	 * @param produtora a produtora do filme a adicionar.
	 * @param descricao a descri��o do filme a adicionar.
	 * @param capa a capa do filme a adicionar.
	 */
	public void adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa) {
		adicionaObjecto("filmes",
						new String[]{"seq_filme_id.NEXTVAL", p(titulo), p(ano), p(realizador), p(ratingIMDB), p(pais), p(produtora), p(descricao), p(capa)});
	}
	
	/**
	 * Actualiza um filme na BD.
	 * @param id o ID do filme a actualizar.
	 * @param titulo o novo t�tulo do filme a actualizar.
	 * @param ano o novo ano do filme a actualizar.
	 * @param realizador o novo realizador do filme a actualizar.
	 * @param ratingIMDB o novo rating da IMDB do filme a actualizar.
	 * @param pais o novo pa�s de origem do filme a actualizar.
	 * @param produtora a nova produtora do filme a actualizar.
	 * @param descricao a nova descri��o do filme a actualizar.
	 * @param capa a nova capa do filme a actualizar.
	 */
	public void actualizaFilme(String id, String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa) {
		actualizaObjecto("filmes", "ID_FIL", id,
						 getToSetCamposFilmes(),
					 	 new String[]{p(titulo), ano, p(realizador), ratingIMDB, p(pais), p(produtora), p(descricao), p(capa)});
	}

	/**
	 * Invalida um filme na BD.
	 * @param id o ID do filme a invalidar.
	 */
	public void invalidaFilme(String id) {
		invalidaObjecto("filmes", "ID_FIL", id);
	}
	
	/**
	 * Re-valida um filme na BD.
	 * @param id o ID do filme a re-validar.
	 */
	public void validaFilme(String id) {
		invalidaObjecto("filmes", "ID_FIL", id);
	}

	/* ---------------------------------------------------------------------- */
	/* ---------------------------- FILME/G�NERO ---------------------------- */
	/* ---------------------------------------------------------------------- */
	/**
	 * Obt�m as rela��es filme/g�nero.
	 * @return Vector com os IDs do filme e g�nero que formam a rela��o.
	 */
	public Vector<String[]> getFilmeGenero() {
		return select("filme_genero");
	}
	
	/**
	 * Obt�m os g�neros de um filme.
	 * @param id_fil o ID do filme.
	 * @return os g�neros do filme.
	 */
	public String[] getGenerosFilme(String id_fil) {
		Vector<String[]> selected = select("filme_genero", new String[]{"ID_GEN"}, "ID_FIL", id_fil);
		int size = selected.size();
		String[] generos = new String[size];
		for(int i=0; i<size; i++)
			generos[i] = selected.get(i)[0];
		return generos;
	}

	/**
	 * Adiciona uma rela��o filme/g�nero � BD.
	 * @param id_fil ID do filme na rela��o.
	 * @param id_gen ID do g�nero na rela��o.
	 */
	public void adicionaFilmeGenero(String id_fil, String id_gen) {
		adicionaObjecto("filme_genero",
						new String[]{id_fil, id_gen});
	}

	/**
	 * Remove uma rela��o filme/g�nero da BD.
	 * @param id_fil ID do filme na rela��o.
	 * @param id_gen ID do g�nero na rela��o.
	 */
	public void removeFilmeGenero(String id_fil, String id_gen) {
		removeObjecto("filme_genero",
					  getCamposFilmeGenero(),
					  new String[]{id_fil, id_gen});
	}

	/* ------------------------------------------------------------------ */
	/* ---------------------------- FORMATOS ---------------------------- */
	/* ------------------------------------------------------------------ */
	/**
	 * Obt�m os formatos de filme existentes.
	 * @return Vector com os campos de cada formato.
	 */
	public Vector<String[]> getFormatos() {
		return select("formatos");
	}
	
	/**
	 * Obt�m os dados de um formato.
	 * @param id o ID do formato.
	 * @return os campos do formato.
	 */
	public String[] getFormato(String id) {
		return select("formatos", "ID_FOR", id).get(0);
	}
	
	/**
	 * Adiciona um formato � BD.
	 * @param nome o nome do formato a adicionar.
	 */
	public void adicionaFormato(String nome) {
		adicionaObjecto("formatos",
						new String[]{"seq_formato_id.NEXTVAL", p(nome)});
	}
	
	/**
	 * Actualiza um formato na BD.
	 * @param id o ID do formato a actualizar.
	 * @param nome o novo nome para o formato a actualizar.
	 */
	public void actualizaFormato(String id, String nome) {
		actualizaObjecto("formatos", "ID_FOR", id,
						 getToSetCamposFormatos(),
						 new String[]{p(nome)});
	}

	/**
	 * Remove um formato da BD.
	 * @param id o ID do formato a remover.
	 */
	public void removeFormato(String id) {
		removeObjecto("formatos", "ID_FOR", id);
	}

	/**
	 * Remove da BD os formatos com um dado nome.
	 * @param nome o nome do formato a remover.
	 */
	public void removeFormatoNome(String nome) {
		removeObjecto("formatos", "NOME_FORMATO", p(nome));
	}

	/* ----------------------------------------------------------------- */
	/* ---------------------------- G�NEROS ---------------------------- */
	/* ----------------------------------------------------------------- */
	/**
	 * Obt�m os g�neros de filme existentes.
	 * @return Vector com os campos de cada g�nero.
	 */
	public Vector<String[]> getGeneros() {
		return select("generos");
	}
	
	/**
	 * Obt�m os dados de um g�nero.
	 * @param id o ID do g�nero.
	 * @return os campos do g�nero.
	 */
	public String[] getGenero(String id) {
		return select("generos", "ID_GEN", id).get(0);
	}
	
	/**
	 * Adiciona um g�nero � BD.
	 * @param nome o nome do g�nero a adicionar.
	 */
	public void adicionaGenero(String nome) {
		adicionaObjecto("generos",
						new String[]{"seq_genero_id.NEXTVAL", p(nome)});
	}
	
	/**
	 * Actualiza um g�nero na BD.
	 * @param id o ID do g�nero a actualizar.
	 * @param nome o novo nome para o g�nero a actualizar.
	 */
	public void actualizaGenero(String id, String nome) {
		actualizaObjecto("generos", "ID_GEN", id,
						 getToSetCamposGeneros(),
						 new String[]{p(nome)});
	}

	/**
	 * Remove um g�nero da BD.
	 * @param id o ID do g�nero a remover.
	 */
	public void removeGenero(String id) {
		removeObjecto("generos", "ID_GEN", id);
	}

	/**
	 * Remove da BD os g�neros com um dado nome.
	 * @param nome o nome do g�nero a remover.
	 */
	public void removeGeneroNome(String nome) {
		removeObjecto("generos", "NOME_GENERO", p(nome));
	}

	/* ---------------------------------------------------------------------- */
	/* ---------------------------- M�QUINAS ATM ---------------------------- */
	/* ---------------------------------------------------------------------- */
	/**
	 * Obt�m as m�quinas ATM existentes.
	 * @return Vector com os campos de cada m�quina ATM.
	 */
	public Vector<String[]> getMaquinasATM() {
		return select("maquinasatm");
	}
	
	/**
	 * Obt�m os dados de uma m�quina ATM.
	 * @param id o ID da m�quina ATM.
	 * @return os campos da m�quina ATM.
	 */
	public String[] getMaquinaATM(String id) {
		return select("maquinasatm", "ID_MAQ", id).get(0);
	}

	/**
	 * Adiciona uma m�quina ATM � BD.
	 * @param preco o pre�o da m�quina a adicionar.
	 * @param data_instalacao a data de instala��o da m�quina a adicionar.
	 */
	public void adicionaMaquinaATM(String preco, String data_instalacao) {
		adicionaObjecto("maquinasatm",
						new String[]{"seq_maquinaatm_id.NEXTVAL", preco, "1", p(data_instalacao)});
	}
	
	/**
	 * Actualiza uma m�quina ATM na BD.
	 * @param id o ID da m�quina a actualizar.
	 * @param preco o novo pre�o da m�quina a actualizar.
	 * @param data_instalacao a nova data de instala��o da m�quina a actualizar.
	 */
	public void actualizaMaquinaATM(String id, String preco, String data_instalacao) {
		actualizaObjecto("maquinasatm", "ID_MAQ", id,
						 getToSetCamposMaquinasATM(),
						 new String[]{preco, p(data_instalacao)});
	}

	/**
	 * Invalida uma m�quina ATM na BD.
	 * @param id o ID da m�quina ATM a invalidar.
	 */
	public void invalidaMaquinaATM(String id) {
		invalidaObjecto("maquinasatm", "ID_MAQ", id);
	}
	
	/**
	 * Re-valida uma m�quina ATM na BD.
	 * @param id o ID da m�quina ATM a re-validar.
	 */
	public void validaMaquinaATM(String id) {
		invalidaObjecto("maquinasatm", "ID_MAQ", id);
	}

	/* -------------------------------------------------------------------- */
	/* ---------------------------- PAGAMENTOS ---------------------------- */
	/* -------------------------------------------------------------------- */
	/**
	 * Obt�m os pagamentos existentes.
	 * @return Vector com os campos de cada pagamento.
	 */
	public Vector<String[]> getPagamentos() {
		return select("pagamentos");
	}
	
	/**
	 * Obt�m os dados de um pagamento.
	 * @param id_req o ID da requisi��o do pagamento.
	 * @return os campos do pagamento.
	 */
	public String[] getPagamento(String id_req) {
		return select("pagamentos", "ID_REQ", id_req).get(0);
	}
	
	/**
	 * Adiciona um pagamento � BD.
	 * @param id_req o ID da requisi��o do pagamento a adicionar.
	 * @param montante o montante do pagamento a adicionar.
	 */
	public void adicionaPagamento(String id_req, String montante) {
		adicionaObjecto("pagamentos",
						new String[]{id_req, montante});
	}
	
	/**
	 * Actualiza um pagamento na BD.
	 * @param id o ID da requisi��o do pagamento a actualizar.
	 * @param montante o novo montante para o pagamento a actualizar.
	 */
	public void actualizaPagamento(String id, String montante) {
		actualizaObjecto("pagamentos", "ID_REQ", id,
						 getToSetCamposPagamentos(),
						 new String[]{montante});
	}

	/**
	 * Remove um pagamento da BD.
	 * @param id o ID da requisi��o do pagamento a remover.
	 */
	public void removePagamento(String id) {
		removeObjecto("pagamentos", "ID_REQ", id);
	}

	/* --------------------------------------------------------------------- */
	/* ---------------------------- REQUISI��ES ---------------------------- */
	/* --------------------------------------------------------------------- */
	/**
	 * Obt�m as requisi��es existentes.
	 * @return Vector com os campos de cada requisi��o.
	 */
	public Vector<String[]> getRequisicao() {
		return select("requisicoes");
	}
	
	/**
	 * Obt�m os dados de uma requisi��o.
	 * @param id o ID da requisi��o.
	 * @return os campos da requisi��o.
	 */
	public String[] getRequisicao(String id) {
		return select("requisicoes", "ID_REQ", id).get(0);
	}

	/**
	 * Adiciona uma requisi��o � BD.
	 * @param data a data da requisi��o.
	 * @param data_limite a nova data limite de entrega do material da requisi��o.
	 */
	public void adicionaRequisicao(String data, String data_limite) {
		adicionaObjecto("requisicoes",
						new String[]{p(data), p(data_limite), "null"});
	}
	
	/**
	 * Actualiza uma requisi��o na BD.
	 * @param id o ID da requisi��o a actualizar.
	 * @param data_limite a nova data limite de entrega do material da requisi��o.
	 * @param data_entrega a data de entrega do material da requisi��o.
	 */
	public void actualizaRequisicao(String id, String data_limite, String data_entrega) {
		actualizaObjecto("requisicoes", "ID_REQ", id,
						 getToSetCamposRequisicoes(),
						 new String[]{data_limite, p(data_entrega)});
	}
	
	/**
	 * Actualiza uma requisi��o na BD com a data de entrega.
	 * @param id o ID da requisi��o a actualizar.
	 * @param data_entrega a data de entrega do material da requisi��o.
	 */
	public void actualizaRequisicao(String id, String data_entrega) {
		actualizaObjecto("requisicoes", "ID_REQ", id, "DATA_ENTREGA", p(data_entrega));
	}

	/**
	 * Remove uma requisi��o da BD.
	 * @param id o ID da requisi��o a remover.
	 */
	public void removeRequisicao(String id) {
		removeObjecto("requisicoes", "ID_REQ", id);
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- STOCKS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Obt�m os stocks existentes.
	 * @return Vector com os campos de cada stock.
	 */
	public Vector<String[]> getStocks() {
		return select("stocks");
	}
	
	/**
	 * Obt�m os dados de um stock.
	 * @param id_fil o ID do filme do stock.
	 * @param id_for o ID do formato do stock.
	 * @return os campos do stock.
	 */
	public String[] getStock(String id_fil, String id_for) {
		return select("stocks",
					  getCamposStocks(),
					  new String[]{"ID_FIL", "ID_FOR"},
					  new String[]{id_fil, id_for}).get(0);
	}

	/**
	 * Adiciona um stock � BD.
	 * @param id_fil o ID do filme do stock a adicionar.
	 * @param id_for o ID do formato do stock a adicionar.
	 * @param disponiveis o n�mero de filmes dispon�veis no formato do stock.
	 * @param quant a quantidade total de filmes existentes no stock.
	 * @param custo_compra o custo de compra (� distribuidora) associado a um filme no stock.
	 * @param custo_aluguer o custo de aluguer associado a um filme no stock.
	 */
	public void adicionaStock(String id_fil, String id_for, String disponiveis, String quant, String custo_compra, String custo_aluguer) {
		adicionaObjecto("stocks",
						new String[]{id_fil, id_for, disponiveis, quant, custo_compra, custo_aluguer});
	}
	
	/**
	 * Actualiza um stock na BD.
	 * @param id_fil o ID do filme do stock a actualizar.
	 * @param id_for o ID do formato do stock a actualizar.
	 * @param disponiveis o novo n�mero de filmes dispon�veis no formato do stock.
	 * @param quant a nova quantidade total de filmes existentes no stock.
	 * @param custo_compra o novo custo de compra (� distribuidora) associado a um filme no stock.
	 * @param custo_aluguer o novo custo de aluguer associado a um filme no stock.
	 */
	public void actualizaStock(String id_fil, String id_for, String disponiveis, String quant, String custo_compra, String custo_aluguer) {
		actualizaObjecto("stocks",
						 new String[]{"ID_FIL", "ID_FOR"},
						 new String[]{id_fil, id_for},
						 getToSetCamposStocks(),
						 new String[]{disponiveis, quant, custo_compra, custo_aluguer});
	}
	
	/**
	 * Actualiza o n�mero de filmes dispon�veis num stock da BD.
	 * @param id_fil o ID do filme do stock a actualizar.
	 * @param id_for o ID do formato do stock a actualizar.
	 * @param incr o incremento (ou decremento) a aplicar ao n�mero de filmes dispon�veis em stock.
	 */
	public void actualizaDisponiveisStock(String id_fil, String id_for, int incr) {
		String comando = "UPDATE stocks SET disponiveis = disponiveis + " + incr +
						 " WHERE ID_FIL = " + id_fil + " AND ID_FOR = " + id_for;
		execute(comando);
	}

	/**
	 * Remove um stock da BD.
	 * @param id_fil o ID do filme do stock a remover.
	 * @param id_for o ID do formato do stock a remover.
	 */
	public void removePagamento(String id_fil, String id_for) {
		removeObjecto("stocks",
					  new String[]{"ID_FIL", "IF_FOR"},
					  new String[]{id_fil, id_for});
	}
	
	/* -------------------------------------------------------------------------------- */
	/* ---------------------------- M�TODOS DE VERIFICA��O ---------------------------- */
	/* -------------------------------------------------------------------------------- */
	/**
	 * Verifica se existe um cliente com determinado BI, para al�m do cliente com o ID passado.
	 * @param id_cli o ID do cliente a excluir da verifica��o.
	 * @param bi o BI a procurar.
	 * @return true, se existe outro cliente com esse BI. false, caso contr�rio.
	 */
	public boolean biClienteExiste(String id_cli, String bi) {
		return valorExiste("clientes", "BI", bi, "ID_CLI", id_cli);
	}
	
	/**
	 * Verifica se existe um empregado com determinado BI, para al�m do empregado com o ID passado.
	 * @param id_emp o ID do empregado a excluir da verifica��o.
	 * @param bi o BI a procurar.
	 * @return true, se existe outro empregado com esse BI. false, caso contr�rio.
	 */
	public boolean biEmpregadoExiste(String id_emp, String bi) {
		return valorExiste("empregados", "BI", bi, "ID_EMP", id_emp);
	}
	
	/**
	 * Vertifica se o empregado � administrador e � o �nico.
	 * @param id_emp o ID do empregado a verificar.
	 * @return true, se o empregado � o �nico administrador. false, caso contr�rio.
	 */
	public boolean empregadoEUnicoAdmin(String id_emp) {
		return !valorExiste("empregados", "IS_ADMIN", "1", "ID_EMP", id_emp);
	}
	
	/**
	 * Verifica se determinado nome de g�nero existe, exclu�ndo o g�nero com o ID passado
	 * (compara��o n�o olha a diferen�as de mai�sculas/min�sculas).
	 * @param id_gen o ID do g�nero a excluir da verifica��o.
	 * @param nome o nome do g�nero cuja exist�ncia tem de ser verificada.
	 * @return true, se existe outro g�nero com esse nome.  false, caso contr�rio.
	 */
	public boolean generoExiste(String id_gen, String nome) {
		return valorExiste("generos", "NOME_GENERO", nome, "ID_GEN", id_gen);
	}
	
	/**
	 * Verifica se determinado nome de formato existe, exclu�ndo o formato com o ID passado
	 * (compara��o n�o olha a diferen�as de mai�sculas/min�sculas).
	 * @param id_for o ID do formato a excluir da verifica��o.
	 * @param nome o nome do formato cuja exist�ncia tem de ser verificada.
	 * @return true, se existe outro formato com esse nome. false, caso contr�rio.
	 */
	public boolean formatoExiste(String id_for, String nome) {
		return valorExiste("formatos", "NOME_FORMATO", nome, "ID_FOR", id_for);
	}

	/**
	 * Verifica se determinado stock para um certo filme e formato existe.
	 * @param id_fil o ID do filme a verificar stock.
	 * @param id_for o ID do formato a verificar stock.
	 * @return true, se existe stock para o filme e formato referidos. false, caso contr�rio.
	 */
	public boolean stockExiste(String id_fil, String id_for) {
		return valorExiste("stocks",
						   new String[]{"ID_FIL", "ID_FOR"},
						   new String[]{id_fil, id_for});
	}

	/**
	 * Verifica se existe algum stock para um certo formato (para qualquer filme).
	 * Por outras palavras, verifica se o formato est� a ser usado para algo.
	 * @param id_for o ID do formato a verificar.
	 * @return true, se existe pelo menos um stock para o formato. false, caso contr�rio.
	 */
	public boolean stockParaFormatoExiste(String id_for) {
		return valorExiste("stocks", "ID_FOR", id_for);
	}
	
	/**
	 * Verifica se existe algum filme com um certo g�nero.
	 * Por outras palavras, verifica se o g�nero est� a ser usado para algo.
	 * @param id_gen o ID do g�nero a verificar.
	 * @return true, se existe pelo menos um filme com esse g�nero. false, caso contr�rio.
	 */
	public boolean generoEmUso(String id_gen) {
		return valorExiste("filme_genero", "ID_GEN", id_gen);
	}
	
	/**
	 * Verifica se um filme tem apenas determinado g�nero e mais nenhum.
	 * @param id_fil o ID do filme a verificar.
	 * @param id_gen o ID do g�nero a verificar.
	 * @return true, se o filme tem apenas esse g�nero e mais nenhum. false, caso contr�rio.
	 */
	public boolean filmeSoTemGenero(String id_fil, String id_gen) {
		String[] gens = getGenerosFilme(id_fil);
		return (gens.length == 1 && gens[0].equals(id_gen));
	}

	/**
	 * Verifica se determinado valor existe em determinado campo numa dada tabela (fun��o gen�rica).
	 * @param tabela a tabela a verificar.
	 * @param campo o campo cujo valor verificar.
	 * @param valor o valor a encontrar no campo.
	 * @return true, se o valor foi encontrado no campo referido de algum elemento. false, caso contr�rio.
	 */
	private boolean valorExiste(String tabela, String campo, String valor) {
		Vector<String> vec = select(tabela, campo);
		for(String val : vec) {
			if(val.equalsIgnoreCase(valor))
				return true;
		}
		return false;
	}
	
	/**
	 * Verifica se determinados valores existem (em simult�neo) em v�rios campos de uma dada tabela (fun��o gen�rica).
	 * @param tabela a tabela a verificar.
	 * @param campos os campos cujo valor verificar.
	 * @param valores os valores a encontrar nos campos.
	 * @return true, se os valores existem em simult�neo nos campos referidos de algum elemento. false, caso contr�rio.
	 */
	private boolean valorExiste(String tabela, String[] campos, String[] valores) {
		Vector<String[]> vec = select(tabela, campos);
		for(String[] vals : vec) {
			boolean all = true;
			for(int i=0; all && i<campos.length; i++) {
				if(!vals[i].equalsIgnoreCase(valores[i]))
					all = false;
			}
			if(all)
				return true;
		}
		return false;
	}

	/**
	 * Verifica se determinado valor existe em determinado campo numa dada tabela,
	 * exlu�ndo elementos com determinado valor em determinado campo (fun��o gen�rica).
	 * @param tabela a tabela a verificar.
	 * @param campo o campo cujo valor verificar.
	 * @param valor o valor a encontrar no campo.
	 * @param exceptCampo o campo a verificar para excluir elementos da procura.
	 * @param exceptValor o valor que o campo de exclus�o deve ter para excluir elementos da procura.
	 * @return true, se o valor foi encontrado no campo referido de algum elemento (exclu�ndo os devidos). false, caso contr�rio.
	 */
	private boolean valorExiste(String tabela, String campo, String valor, String exceptCampo, String exceptValor) {
		Vector<String[]> vec = select(tabela, new String[]{exceptCampo, campo});
		for(String[] val : vec) {
			if(val[1].equalsIgnoreCase(valor) && !val[0].equals(exceptValor))
				return true;
		}
		return false;
	}
	
	/* --------------------------------------------------------------------------- */
	/* ---------------------------- M�TODOS GEN�RICOS ---------------------------- */
	/* --------------------------------------------------------------------------- */
	/**
	 * Adiciona um objecto � BD. Fun��o gen�rica.
	 * @param tabela a tabela � qual adicionar o objecto.
	 * @param valores os valores do objecto a adicionar.
	 */
	private void adicionaObjecto(String tabela, String[] valores) {
		execute("INSERT INTO " + tabela + " VALUES(" + Utils.list(valores, ",") + ")");
	}
	
	/**
	 * Actualiza um objecto na BD. Fun��o gen�rica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a actualizar.
	 * @param valor o valor que deve ter o campo no objecto a actualizar.
	 * @param campoAct o campo a actualizar no objecto.
	 * @param valorAct o valor do campo a actualizar.
	 */
	private void actualizaObjecto(String tabela, String campo, String valor, String campoAct, String valorAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + campoAct + "=" + valorAct +
						 " WHERE " + campo + "=" + valor;
		execute(comando);
	}
	
	/**
	 * Actualiza um objecto na BD. Fun��o gen�rica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a actualizar.
	 * @param valor o valor que deve ter o campo no objecto a actualizar.
	 * @param camposAct os campos a actualizar no objecto.
	 * @param valoresAct os valores dos campos a actualizar.
	 */
	private void actualizaObjecto(String tabela, String campo, String valor, String[] camposAct, String[] valoresAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + Utils.list(camposAct, "=", valoresAct, ",") +
						 " WHERE " + campo + "=" + valor;
		execute(comando);
	}
	
	/**
	 * Actualiza um objecto na BD. Fun��o gen�rica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campos os campos utilizados para encontrar o objecto a actualizar.
	 * @param valores os valores que devem ter os campos no objecto a actualizar.
	 * @param campoAct o campo a actualizar no objecto.
	 * @param valorAct o valor do campo a actualizar.
	 */
	private void actualizaObjecto(String tabela, String[] campos, String[] valores, String campoAct, String valorAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + campoAct + "=" + valorAct +
						 " WHERE " + Utils.list(campos, "=", valores, " AND ");
		execute(comando);
	}
	
	/**
	 * Actualiza um objecto na BD. Fun��o gen�rica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campos os campos utilizados para encontrar o objecto a actualizar.
	 * @param valores os valores que devem ter os campos no objecto a actualizar.
	 * @param camposAct os campos a actualizar no objecto.
	 * @param valoresAct os valores dos campos a actualizar.
	 */
	private void actualizaObjecto(String tabela, String[] campos, String[] valores, String[] camposAct, String[] valoresAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + Utils.list(camposAct, "=", valoresAct, ",") +
						 " WHERE " + Utils.list(campos, "=", valores, " AND ");
		execute(comando);
	}
	
	/**
	 * Invalida um objecto na BD. Fun��o gen�rica.
	 * @param tabela a tabela na qual invalidar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a invalidar.
	 * @param valor o valor que deve ter o campo no objecto a invalidar.
	 */
	private void invalidaObjecto(String tabela, String campo, String valor) {
		actualizaObjecto(tabela, campo, valor, "valido", "0");
	}
	
	/**
	 * Valida um objecto na BD. Fun��o gen�rica.
	 * @param tabela a tabela na qual validar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a validar.
	 * @param valor o valor que deve ter o campo no objecto a validar.
	 */
	private void validaObjecto(String tabela, String campo, String valor) {
		actualizaObjecto(tabela, campo, valor, "valido", "1");
	}
	
	/**
	 * Remove os objectos da BD que tenham determinado valor num determinado campo. Fun��o gen�rica.
	 * @param tabela a tabela da qual remover o(s) objecto(s).
	 * @param campo o campo a verificar para encontrar o(s) objecto(s) a remover.
	 * @param valor o valor do campo no(s) objecto(s) a ser removido(s).
	 */
	private void removeObjecto(String tabela, String campo, String valor) {
		execute("DELETE FROM " + tabela + " WHERE " + campo + " = " + valor);
	}
	
	/**
	 * Remove os objectos da BD que tenham determinados valores em determinados campos. Fun��o gen�rica.
	 * @param tabela a tabela da qual remover o(s) objecto(s).
	 * @param campos os campos a verificar para encontrar o(s) objecto(s) a remover.
	 * @param valores os valores do campos no(s) objecto(s) a ser removido(s).
	 */
	private void removeObjecto(String tabela, String[] campos, String[] valores) {
		execute("DELETE FROM " + tabela + " WHERE " + Utils.list(campos, "=", valores, " AND "));
	}
	
	/**
	 * Obt�m todos campos de todos os objectos existentes numa dada tabela.
	 * @param tabela tabela de onde obter os dados.
	 * @return Vector com os campos de cada linha da tabela.
	 */
	private Vector<String[]> select(String tabela) {
		Vector<String[]> objectos = new Vector<String[]>();

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT * FROM " + tabela);
			ResultSetMetaData rsmd = rset.getMetaData();
			int n = rsmd.getColumnCount();

			while (rset.next()) {
				String[] objecto = new String[n];
				for (int i = 0; i < n; i++)
					objecto[i] = rset.getString(i+1);
				objectos.add(objecto);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return objectos;
	}

	/**
	 * Obt�m os campos seleccionados dos objectos existentes numa dada tabela.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campos nomes das colunas a obter da tabela.
	 * @return Vector com os valores dos campos seleccionados de cada linha da tabela.
	 */
	private Vector<String[]> select(String tabela, String[] campos) {
		Vector<String[]> objectos = new Vector<String[]>();
		int nColunas = campos.length;

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT " + Utils.list(campos, ",") + " FROM " + tabela);

			while (rset.next()) {
				String[] objecto = new String[nColunas];
				for (int i = 0; i < nColunas; i++)
					objecto[i] = rset.getString(campos[i]);
				objectos.add(objecto);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return objectos;
	}
	
	/**
	 * Obt�m o campo seleccionado dos objectos existentes numa dada tabela.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campo nome da coluna a obter da tabela.
	 * @return Vector com os valores do campo seleccionado de cada linha da tabela.
	 */
	private Vector<String> select(String tabela, String campo) {
		Vector<String> objectos = new Vector<String>();

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT " + campo + " FROM " + tabela);

			while (rset.next()) {
				objectos.add(rset.getString(campo));
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return objectos;
	}
	
	/**
	 * Obt�m todos os campos do objecto existente numa dada tabela que contiver
	 * certo valor num determinado campo.
	 * @param tabela tabela de onde obter os dados.
	 * @param campo o campo que seleccionar� o objecto.
	 * @param valor o valor a procurar no campo.
	 * @return Vector com todos os campos dos objectos.
	 */
	private Vector<String[]> select(String tabela, String campo, String valor) {
		Vector<String[]> objectos = new Vector<String[]>();

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT * FROM " + tabela + " WHERE " + campo + "=" + valor);
			ResultSetMetaData rsmd = rset.getMetaData();
			int n = rsmd.getColumnCount();

			while (rset.next()) {
				String[] objecto = new String[n];
				for (int i = 0; i < n; i++)
					objecto[i] = rset.getString(i+1);
				objectos.add(objecto);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return objectos;
	}
	
	/**
	 * Obt�m os campos seleccionados dos objectos existentes numa dada tabela que contiverem
	 * certo valor num determinado campo.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campos nomes das colunas a obter da tabela.
	 * @param campo o campo que seleccionar� o objecto.
	 * @param valor o valor a procurar no campo.
	 * @return Vector com os campos seleccionados dos objectos.
	 */
	private Vector<String[]> select(String tabela, String[] campos, String campo, String valor) {
		Vector<String[]> objectos = new Vector<String[]>();
		int nColunas = campos.length;

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT " + Utils.list(campos, ",") + " FROM " + tabela + " WHERE " + campo + "=" + valor);
			
			while (rset.next()) {
				String[] objecto = new String[nColunas];
				for (int i = 0; i < nColunas; i++)
					objecto[i] = rset.getString(campos[i]);
				objectos.add(objecto);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return objectos;
	}
	
	/**
	 * Obt�m os campos seleccionados dos objectos existentes numa dada tabela que contiverem
	 * certos valores em determinados campos.
	 * @param tabela tabela onde fazer SELECT.
	 * @param camposSel nomes das colunas a obter da tabela.
	 * @param campos os campos que seleccionar�o o objecto.
	 * @param valores os valores a procurar nos campos.
	 * @return Vector com os campos seleccionados dos objectos.
	 */
	private Vector<String[]> select(String tabela, String[] camposSel, String[] campos, String[] valores) {
		Vector<String[]> objectos = new Vector<String[]>();
		int nColunas = camposSel.length;

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT " + Utils.list(camposSel, ",") + " FROM " + tabela + " WHERE " + Utils.list(campos, "=", valores, "AND"));
			
			while (rset.next()) {
				String[] objecto = new String[nColunas];
				for (int i = 0; i < nColunas; i++)
					objecto[i] = rset.getString(camposSel[i]);
				objectos.add(objecto);
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return objectos;
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
			Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- OUTROS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Coloca plicas na string passada. Substitui todos os ap�strofes na palavra
	 * por ap�strofes duplos para fazer "escape".
	 * @param s a string � qual aplicar plicas.
	 * @return a string, com plicas e os ap�strofes diplicados.
	 */
	private String p(String s) {
		return "'" + s.replace("'", "''") + "'";
	}
}
