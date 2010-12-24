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

import javax.swing.Icon;

import outros.Consts;
import outros.Utils;

/**
 * A classe-invólucro da Base de Dados (BD).
 * Comunica directamente com ela e executa queries e updates.
 */
public class DatabaseHandler
{
	private Connection conn;
	
	/**
	 * O método main. Apenas para propósitos de teste.
	 * @param args os argumentos da linha de comandos.
	 */
	public static void main(String args[]) {
		DatabaseHandler dbh = new DatabaseHandler();
		if (dbh.conn != null) {
			//Utils.printStringArrayVector(dbh.getFilmes());
			System.out.println();
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
	

	/* ----------------------------------------------------------------- */
	/* ---------------------------- LIGAÇÃO ---------------------------- */
	/* ----------------------------------------------------------------- */
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
	 * Obtém os clientes existentes.
	 * @return Vector com os campos de cada cliente.
	 */
	public Vector<String[]> getClientes() {
		return select("clientes");
	}

	/**
	 * Adiciona um cliente à BD.
	 * @param nome o nome do cliente a adicionar.
	 * @param bi o BI do cliente a adicionar.
	 * @param password a password do cliente a adicionar.
	 * @param morada a morada do cliente a adicionar.
	 * @param email o e-mail do cliente a adicionar.
	 * @param telefone o número de telefone do cliente a adicionar.
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
	 * @param telefone o novo número de telefone do cliente a actualizar.
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
	 * Obtém os empregados existentes.
	 * @return Vector com os campos de cada empregado.
	 */
	public Vector<String[]> getEmpregados() {
		return select("empregados");
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
	public void adicionaEmpregado(String is_admin, String salario, String nome, String bi, String password, String morada, String email, String telefone, String data_registo) {
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
	 * Obtém os filmes existentes.
	 * @return Vector com os campos de cada filme.
	 */
	public Vector<String[]> getFilmes() {
		return select("filmes");
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
	//TODO: perceber como se adicionam Icons como elemento do tipo BLOB
	public void adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, Icon capa) {
		adicionaObjecto("filmes",
						new String[]{"seq_filme_id.NEXTVAL", p(titulo), p(ano), p(realizador), p(ratingIMDB), p(pais), p(produtora), p(descricao), "null"});
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
	//TODO: perceber como se adicionam Icons como elemento do tipo BLOB
	public void actualizaFilme(String id, String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, Icon capa) {
		actualizaObjecto("filmes", "ID_FIL", id,
						 getToSetCamposFilmes(),
					 	 new String[]{p(titulo), ano, p(realizador), ratingIMDB, p(pais), p(produtora), p(descricao), "null"});
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
	/* ---------------------------- FILME/GÉNERO ---------------------------- */
	/* ---------------------------------------------------------------------- */
	/**
	 * Obtém as relações filme/género.
	 * @return Vector com os IDs do filme e género que formam a relação.
	 */
	public Vector<String[]> getFilmeGenero() {
		return select("filme_genero");
	}

	/**
	 * Adiciona uma relação filme/género à BD.
	 * @param id_fil ID do filme na relação.
	 * @param id_gen ID do género na relação.
	 */
	public void adicionaFilmeGenero(String id_fil, String id_gen) {
		adicionaObjecto("filme_genero",
						new String[]{id_fil, id_gen});
	}

	/**
	 * Remove uma relação filme/género da BD.
	 * @param id_fil ID do filme na relação.
	 * @param id_gen ID do género na relação.
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
	 * Obtém os formatos de filme existentes.
	 * @return Vector com os campos de cada formato.
	 */
	public Vector<String[]> getFormatos() {
		return select("formatos");
	}

	/**
	 * Adiciona um formato à BD.
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
		actualizaObjecto("formatos",  "ID_FOR", id,
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
	/* ---------------------------- GÉNEROS ---------------------------- */
	/* ----------------------------------------------------------------- */
	/**
	 * Obtém os géneros de filme existentes.
	 * @return Vector com os campos de cada género.
	 */
	public Vector<String[]> getGeneros() {
		return select("generos");
	}

	/**
	 * Adiciona um género à BD.
	 * @param nome o nome do género a adicionar.
	 */
	public void adicionaGenero(String nome) {
		adicionaObjecto("generos",
						new String[]{"seq_genero_id.NEXTVAL", p(nome)});
	}
	
	/**
	 * Actualiza um género na BD.
	 * @param id o ID do género a actualizar.
	 * @param nome o novo nome para o género a actualizar.
	 */
	public void actualizaGenero(String id, String nome) {
		actualizaObjecto("generos",  "ID_GEN", id,
						 getToSetCamposGeneros(),
						 new String[]{p(nome)});
	}

	/**
	 * Remove um género da BD.
	 * @param id o ID do género a remover.
	 */
	public void removeGenero(String id) {
		removeObjecto("generos", "ID_GEN", id);
	}

	/**
	 * Remove da BD os géneros com um dado nome.
	 * @param nome o nome do género a remover.
	 */
	public void removeGeneroNome(String nome) {
		removeObjecto("generos", "NOME_GENERO", p(nome));
	}

	/* ---------------------------------------------------------------------- */
	/* ---------------------------- MÁQUINAS ATM ---------------------------- */
	/* ---------------------------------------------------------------------- */
	/**
	 * Obtém as máquinas ATM existentes.
	 * @return Vector com os campos de cada máquina ATM.
	 */
	public Vector<String[]> getMaquinasATM() {
		return select("maquinasatm");
	}

	/**
	 * Adiciona uma máquina ATM à BD.
	 * @param preco o preço da máquina a adicionar.
	 * @param data_instalacao a data de instalação da máquina a adicionar.
	 */
	public void adicionaMaquinaATM(String preco, String data_instalacao) {
		adicionaObjecto("maquinasatm",
						new String[]{"seq_maquinaatm_id.NEXTVAL", preco, "1", p(data_instalacao)});
	}
	
	/**
	 * Actualiza uma máquina ATM na BD.
	 * @param id o ID da máquina a actualizar.
	 * @param preco o novo preço da máquina a actualizar.
	 * @param data_instalacao a nova data de instalação da máquina a actualizar.
	 */
	public void actualizaMaquinaATM(String id, String preco, String data_instalacao) {
		actualizaObjecto("maquinasatm", "ID_MAQ", id,
						 getToSetCamposMaquinasATM(),
						 new String[]{preco, p(data_instalacao)});
	}

	/**
	 * Invalida uma máquina ATM na BD.
	 * @param id o ID da máquina ATM a invalidar.
	 */
	public void invalidaMaquinaATM(String id) {
		invalidaObjecto("maquinasatm", "ID_MAQ", id);
	}
	
	/**
	 * Re-valida uma máquina ATM na BD.
	 * @param id o ID da máquina ATM a re-validar.
	 */
	public void validaMaquinaATM(String id) {
		invalidaObjecto("maquinasatm", "ID_MAQ", id);
	}

	/* -------------------------------------------------------------------- */
	/* ---------------------------- PAGAMENTOS ---------------------------- */
	/* -------------------------------------------------------------------- */
	/**
	 * Obtém os pagamentos existentes.
	 * @return Vector com os campos de cada pagamento.
	 */
	public Vector<String[]> getPagamentos() {
		return select("pagamentos");
	}

	/**
	 * Adiciona um pagamento à BD.
	 * @param id_req o ID da requisição do pagamento a adicionar.
	 * @param montante o montante do pagamento a adicionar.
	 */
	public void adicionaPagamento(String id_req, String montante) {
		adicionaObjecto("pagamentos",
						new String[]{id_req, montante});
	}
	
	/**
	 * Actualiza um pagamento na BD.
	 * @param id o ID da requisição do pagamento a actualizar.
	 * @param montante o novo montante para o pagamento a actualizar.
	 */
	public void actualizaPagamento(String id, String montante) {
		actualizaObjecto("pagamentos",  "ID_REQ", id,
						 getToSetCamposPagamentos(),
						 new String[]{montante});
	}

	/**
	 * Remove um pagamento da BD.
	 * @param id o ID da requisição do pagamento a remover.
	 */
	public void removePagamento(String id) {
		removeObjecto("pagamentos", "ID_REQ", id);
	}

	/* --------------------------------------------------------------------- */
	/* ---------------------------- REQUISIÇÕES ---------------------------- */
	/* --------------------------------------------------------------------- */
	/**
	 * Obtém as requisições existentes.
	 * @return Vector com os campos de cada requisição.
	 */
	public Vector<String[]> getRequisicao() {
		return select("requisicoes");
	}

	/**
	 * Adiciona uma requisição à BD.
	 * @param data a data da requisição.
	 * @param data_limite a nova data limite de entrega do material da requisição.
	 */
	public void adicionaRequisicao(String data, String data_limite) {
		adicionaObjecto("requisicoes",
						new String[]{p(data), p(data_limite), "null"});
	}
	
	/**
	 * Actualiza uma requisição na BD.
	 * @param id o ID da requisição a actualizar.
	 * @param data_limite a nova data limite de entrega do material da requisição.
	 * @param data_entrega a data de entrega do material da requisição.
	 */
	public void actualizaRequisicao(String id, String data_limite, String data_entrega) {
		actualizaObjecto("requisicoes", "ID_REQ", id,
						 getToSetCamposRequisicoes(),
						 new String[]{data_limite, p(data_entrega)});
	}
	
	/**
	 * Actualiza uma requisição na BD com a data de entrega.
	 * @param id o ID da requisição a actualizar.
	 * @param data_entrega a data de entrega do material da requisição.
	 */
	public void actualizaRequisicao(String id, String data_entrega) {
		actualizaObjecto("requisicoes", "ID_REQ", id, "DATA_ENTREGA", p(data_entrega));
	}

	/**
	 * Remove uma requisição da BD.
	 * @param id o ID da requisição a remover.
	 */
	public void removeRequisicao(String id) {
		removeObjecto("requisicoes", "ID_REQ", id);
	}

	/* ---------------------------------------------------------------- */
	/* ---------------------------- STOCKS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Obtém os stocks existentes.
	 * @return Vector com os campos de cada stock.
	 */
	public Vector<String[]> getStocks() {
		return select("stocks");
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
	public void adicionaStock(String id_fil, String id_for, String disponiveis, String quant, String custo_compra, String custo_aluguer) {
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
	public void actualizaStock(String id_fil, String id_for, String disponiveis, String quant, String custo_compra, String custo_aluguer) {
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
	/* ---------------------------- MÉTODOS DE VERIFICAÇÃO ---------------------------- */
	/* -------------------------------------------------------------------------------- */
	// TODO: Javadoc
	public boolean biClienteExiste(String id_cli, String bi) {
		return valorExiste("clientes", "BI", bi, "ID_CLI", id_cli);
	}
	
	// TODO: Javadoc
	public boolean biEmpregadoExiste(String id_emp, String bi) {
		return valorExiste("empregados", "BI", bi, "ID_EMP", id_emp);
	}
	
	// TODO: Javadoc
	public boolean empregadoEUnicoAdmin(String id_emp) {
		return !valorExiste("empregados", "IS_ADMIN", "1", "ID_EMP", id_emp);
	}
	
	// TODO: Javadoc
	public boolean nomeGeneroExiste(String id_gen, String nome) {
		return valorExiste("generos", "NOME_GENERO", nome, "ID_GEN", id_gen);
	}
	
	// TODO: Javadoc
	public boolean nomeFormatoExiste(String id_for, String nome) {
		return valorExiste("formatos", "NOME_FORMATO", nome, "ID_FOR", id_for);
	}

	// TODO: Javadoc
	public boolean stockExiste(String id_fil, String id_for) {
		return valorExiste("stocks",
						   new String[]{"ID_FIL", "ID_FOR"},
						   new String[]{id_fil, id_for});
	}

	// TODO
	public boolean stockParaFormatoExiste(String id_for) {
		return false;
	}
	
	// TODO
	public boolean generoEmUso(String id_gen) {
		return false;
	}
	
	// TODO
	public boolean filmeSoTemGenero(String id_fil, String id_gen) {
		return false;
	}

	// TODO: Javadoc
	private boolean valorExiste(String tabela, String campo, String valor) {
		Vector<String> vec = select(tabela, campo);
		for(String val : vec) {
			if(val.equalsIgnoreCase(valor))
				return true;
		}
		return false;
	}
	
	// TODO: Javadoc
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

	// TODO: Javadoc
	private boolean valorExiste(String tabela, String campo, String valor, String exceptCampo, String exceptValor) {
		Vector<String[]> vec = select(tabela, new String[]{exceptCampo, campo});
		for(String[] val : vec) {
			if(val[1].equalsIgnoreCase(valor) && !val[0].equals(exceptValor))
				return true;
		}
		return false;
	}
	
	/* --------------------------------------------------------------------------- */
	/* ---------------------------- MÉTODOS GENÉRICOS ---------------------------- */
	/* --------------------------------------------------------------------------- */
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
	 * Actualiza um objecto na BD. Função genérica.
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
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a actualizar.
	 * @param valor o valor que deve ter o campo no objecto a actualizar.
	 * @param camposAct os campos a actualizar no objecto.
	 * @param valoresAct os valores dos campos a actualizar.
	 */
	private void actualizaObjecto(String tabela, String campo, String valor, String[] camposAct, String[] valoresAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + list(camposAct, "=", valoresAct, ",") +
						 " WHERE " + campo + "=" + valor;
		execute(comando);
	}
	
	/**
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campos os campos utilizados para encontrar o objecto a actualizar.
	 * @param valores os valores que devem ter os campos no objecto a actualizar.
	 * @param campoAct o campo a actualizar no objecto.
	 * @param valorAct o valor do campo a actualizar.
	 */
	private void actualizaObjecto(String tabela, String[] campos, String[] valores, String campoAct, String valorAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + campoAct + "=" + valorAct +
						 " WHERE " + list(campos, "=", valores, " AND ");
		execute(comando);
	}
	
	/**
	 * Actualiza um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual actualizar o objecto.
	 * @param campos os campos utilizados para encontrar o objecto a actualizar.
	 * @param valores os valores que devem ter os campos no objecto a actualizar.
	 * @param camposAct os campos a actualizar no objecto.
	 * @param valoresAct os valores dos campos a actualizar.
	 */
	private void actualizaObjecto(String tabela, String[] campos, String[] valores, String[] camposAct, String[] valoresAct) {
		String comando = "UPDATE " + tabela +
						 " SET " + list(camposAct, "=", valoresAct, ",") +
						 " WHERE " + list(campos, "=", valores, " AND ");
		execute(comando);
	}
	
	/**
	 * Invalida um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual invalidar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a invalidar.
	 * @param valor o valor que deve ter o campo no objecto a invalidar.
	 */
	private void invalidaObjecto(String tabela, String campo, String valor) {
		actualizaObjecto(tabela, campo, valor, new String[]{"valido"}, new String[]{"0"});
	}
	
	/**
	 * Valida um objecto na BD. Função genérica.
	 * @param tabela a tabela na qual validar o objecto.
	 * @param campo o campo utilizado para encontrar o objecto a validar.
	 * @param valor o valor que deve ter o campo no objecto a validar.
	 */
	private void validaObjecto(String tabela, String campo, String valor) {
		actualizaObjecto(tabela, campo, valor, new String[]{"valido"}, new String[]{"1"});
	}
	
	/**
	 * Remove os objectos da BD que tenham determinado valor num determinado campo. Função genérica.
	 * @param tabela a tabela da qual remover o(s) objecto(s).
	 * @param campo o campo a verificar para encontrar o(s) objecto(s) a remover.
	 * @param valor o valor do campo no(s) objecto(s) a ser removido(s).
	 */
	private void removeObjecto(String tabela, String campo, String valor) {
		execute("DELETE FROM " + tabela + " WHERE " + campo + " = " + valor);
	}
	
	/**
	 * Remove os objectos da BD que tenham determinados valores em determinados campos. Função genérica.
	 * @param tabela a tabela da qual remover o(s) objecto(s).
	 * @param campos os campos a verificar para encontrar o(s) objecto(s) a remover.
	 * @param valores os valores do campos no(s) objecto(s) a ser removido(s).
	 */
	private void removeObjecto(String tabela, String[] campos, String[] valores) {
		execute("DELETE FROM " + tabela + " WHERE " + list(campos, "=", valores, " AND "));
	}
	
	/**
	 * Obtém o campo seleccionado dos objectos existentes numa dada tabela.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campo nome da coluna a obter da tabela.
	 * @return Vector com os valores do campo seleccionado de cada linha da tabela.
	 */
	private Vector<String> select(String tabela, String campo) {
		Vector<String> linhas = new Vector<String>();

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT " + campo + " FROM " + tabela);

			while (rset.next()) {
				linhas.add(rset.getString(campo));
			}
			st.close();
		} catch (SQLException e) {
			Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return linhas;
	}

	/**
	 * Obtém os campos seleccionados dos objectos existentes numa dada tabela.
	 * @param tabela tabela onde fazer SELECT.
	 * @param campos nomes das colunas a obter da tabela.
	 * @return Vector com os valores dos campos seleccionados de cada linha da tabela.
	 */
	private Vector<String[]> select(String tabela, String[] campos) {
		Vector<String[]> linhas = new Vector<String[]>();
		int nColunas = campos.length;

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT " + list(campos, ",") + " FROM " + tabela);

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
	 * Obtém todos campos de todos os objectos existentes numa dada tabela.
	 * @param tabela tabela de onde obter os dados.
	 * @return Vector com os campos de cada linha da tabela.
	 */
	private Vector<String[]> select(String tabela) {
		Vector<String[]> linhas = new Vector<String[]>();

		try {
			Statement st = this.conn.createStatement();
			ResultSet rset = st.executeQuery("SELECT * FROM " + tabela);
			ResultSetMetaData rsmd = rset.getMetaData();
			int n = rsmd.getColumnCount();

			while (rset.next()) {
				String[] linha = new String[n];
				for (int i = 0; i < n; i++)
					linha[i] = rset.getString(i+1);
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

	/* ---------------------------------------------------------------- */
	/* ---------------------------- OUTROS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Coloca plicas na string passada. Substitui todos os apóstrofes na palavra
	 * por apóstrofes duplos para fazer "escape".
	 * @param s a string à qual aplicar plicas.
	 * @return a string, com plicas e os apóstrofes diplicados.
	 */
	private String p(String s) {
		return "'" + s.replace("'", "''") + "'";
	}
	
	/**
	 * Devolve uma string com os elementos "strs" separados pela string "sep".
	 * @param strs os elementos a juntar numa string apenas.
	 * @param sep o separador a usar para separar os elementos.
	 * @return uma string com os elementos "strs" separados pela string "sep".
	 */
	private String list(String[] strs, String sep) {
		String lista = strs[0];
		for (int i = 1; i < strs.length; i++)
			lista += sep + strs[i];
		return lista;
	}
	
	/**
	 * Devolve uma string organizada em pares (separados pela string "sep2") de
	 * "strs" e "strs2" (separados por "sep").
	 * @param strs a primeira parte dos elementos a juntar em pares numa string apenas.
	 * @param sep o separador a usar para separar cada dois elementos (par. um de cada lista).
	 * @param strs2 a segunda parte dos elementos a juntar em pares numa string apenas.
	 * @param sep2 o separador a usar para separar cada par de elementos dos outros pares.
	 * @return uma string organizada em pares (separados pela string "sep2") de
	 * "strs" e "strs2" (separados por "sep").
	 */
	private String list(String[] strs, String sep, String[] strs2, String sep2) {
		String lista = strs[0] + sep + strs2[0];
		for (int i = 1; i < strs.length; i++)
			lista += sep2 + strs[i] + sep + strs2[i];
		return lista;
	}
}
