package gestores;

import java.util.Vector;

import outros.Consts;
import outros.Utils;

import bd.DBHandler;

/**
 * Trata da gest�o de filmes, stocks, formatos, g�neros e requisi��es.
 */
public class GestorFilmes
{
	/* ---------------------------------------------------------------- */
	/* ---------------------------- FILMES ---------------------------- */
	/* ---------------------------------------------------------------- */
	public String[] verListaFilmes() {
		Vector<String[]> vec = DBHandler.getFilmes();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesOrdTitulo() {
		Vector<String[]> vec = DBHandler.getFilmesOrdTitulo();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesOrdAno() {
		Vector<String[]> vec = DBHandler.getFilmesOrdAno();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesOrdRankIMDB() {
		Vector<String[]> vec = DBHandler.getFilmesOrdRankIMDB();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesPlusInvalidos() {
		Vector<String[]> vec = DBHandler.getFilmesPlusInvalidos();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesOrdTituloPlusInvalidos() {
		Vector<String[]> vec = DBHandler.getFilmesOrdTituloPlusInvalidos();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesOrdAnoPlusInvalidos() {
		Vector<String[]> vec = DBHandler.getFilmesOrdAnoPlusInvalidos();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] verListaFilmesOrdRankIMDBPlusInvalidos() {
		Vector<String[]> vec = DBHandler.getFilmesOrdRankIMDBPlusInvalidos();
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	/**
	 * Obt�m os campos do filme, na ordem definida pela BD.
	 * Cont�m os nomes dos g�neros do filme no fim do array.
	 */
	public String[] getFilme(String id) {
		String[] filme = DBHandler.getFilme(id);
		String[] generosFilme = DBHandler.getGenerosFilmeNome(id);
		return Utils.extend(filme, generosFilme);
	}
	
	/**
	 * Adiciona um filme � base de dados
	 * String[] generos deve conter os nomes dos g�neros e n�o os seus IDs.
	 */
	// TODO: adicionar generos
	public String adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos) {
		DBHandler.adicionaFilme(titulo, ano, realizador, ratingIMDB, pais, produtora, descricao, capa);
		Utils.dbg("O seguinte filme foi adicionado: (" + ano + ") " + titulo);
		return "O seguinte filme foi adicionado: (" + ano + ") " + titulo;
	}

	/**
	 *  String[] generos deve conter os nomes dos g�neros e n�o os seus IDs.
	 */
	// TODO: adicionar generos
	public String actualizaFilme(String id, String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos) {
		DBHandler.actualizaFilme(id, titulo, ano, realizador, ratingIMDB, pais, produtora, descricao, capa);
		Utils.dbg("O filme com o ID " + id + " foi actualizado.");
		return "O filme foi actualizado.";
	}
	
	public String invalidaFilme(String id) {
		DBHandler.invalidaFilme(id);
		Utils.dbg("O filme com o ID " + id + " foi invalidado.");
		return "O filme foi invalidado.";
	}
	
	public String validaFilme(String id) {
		DBHandler.validaFilme(id);
		Utils.dbg("O filme com o ID " + id + " foi re-validado.");
		return "O filme foi re-validado.";
	}
	
	/**
	 * Cada parâmetro pode ser null se não for para ser utilizado na mega query
	 * Strings devolvidas em formato "id : (ano) titulo"
	 */
	public String[] procuraFilmes(String titulo, String anoLow, String anoHigh, String realizador, String ratingIMDBLow, String ratingIMDBHigh, String pais, String produtora, String[] generos) {
		Vector<String[]> vec = DBHandler.procuraFilmes(titulo, anoLow, anoHigh, realizador, ratingIMDBLow, ratingIMDBHigh, pais, produtora, generos);
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	public String[] procuraFilmesPlusInvalidos(String titulo, String anoLow, String anoHigh, String realizador, String ratingIMDBLow, String ratingIMDBHigh, String pais, String produtora, String[] generos) {
		Vector<String[]> vec = DBHandler.procuraFilmesPlusInvalidos(titulo, anoLow, anoHigh, realizador, ratingIMDBLow, ratingIMDBHigh, pais, produtora, generos);
		return Utils.formattedFromVector(vec, "%s : (ano) %s", new int[]{0, 1, 2});
	}
	
	/* ---------------------------------------------------------------- */
	/* ---------------------------- STOCKS ---------------------------- */
	/* ---------------------------------------------------------------- */
	/**
	 * Query para ver os stocks de um filme.
	 * "nome_formato" : "disponiveis" unid. dispon�veis, "custo_aluguer" �
	 */
	public String[] verListaStocksFilme(String id_fil) {
		Vector<String[]> vec = DBHandler.getStocksDeFilme(id_fil);
		return Utils.formattedFromVector(vec, "%s : %s unid. dispon�veis, %s �", new int[]{6, 2, 5});
	}
	
	/**
	 * Query para ver os stocks de um filme com toda a informa��o (para administra��o).
	 * "nome_formato" : "disponiveis"/"quant" disp., "custo_aluguer" � (orig. "custo_compra" �)
	 */
	public String[] verListaStocksFilmeFull(String id_fil) {
		Vector<String[]> vec = DBHandler.getStocksDeFilme(id_fil);
		return Utils.formattedFromVector(vec, "%s : %s/%s disp., %s � (orig. %s �)", new int[]{6, 2, 3, 5, 4});
	}
	
	/**
	 * @param id_fil identificador unívoco do filme na base de dados
	 * @param formato bluray, dvd, etc..
	 * @quant quant n�mero inicial de exemplares no stock (o valor de dispon�veis � colocado a este valor)
	 * @param custo_compra quanto é que o filme custou ao videoclube
	 * @param custo_aluguer preço praticado no aluguer
	 * @return
	 */
	public String adicionaStock(String id_fil, String formato, String quant, String custo_compra, String custo_aluguer) {
		if(!DBHandler.stockExisteNomeFormato(id_fil, formato)) {
			DBHandler.adicionaStockNomeFormato(id_fil, formato, quant, custo_compra, custo_aluguer);
			return "Novo stock adicionado.";
		} else {
			return "J� existe um stock desse filme no formato indicado.";
		}
	}
	
	//TODO: quest�o da quantidade.
	public String actualizaStock(String id_fil, String formato, String quant, String custo_compra, String custo_aluguer) {
		DBHandler.actualizaStockNomeFormato(id_fil, formato, quant, custo_compra, custo_aluguer);
		return "Stock actualizado.";
	}
	
	public String actualizaQuantStock(String id_fil, String formato, String quant) {
		DBHandler.actualizaQuantStock(id_fil, formato, quant);
		return "Stock actualizado.";
	}
	
	public String actualizaQuantStockIncr(String id_fil, String formato, String incr) {
		DBHandler.actualizaQuantStockIncr(id_fil, formato, incr);
		return "Stock actualizado.";
	}
	
	/**
	 * @param id_fil identificador un�voco do filme na base de dados
	 * @param formato bluray, dvd, etc..
	 * @return
	 */
	public String removeStock(String id_fil, String formato) {
		DBHandler.removeStockNomeFormato(id_fil, formato);
		return "Stock removido.";
	}
	
	/* ------------------------------------------------------------------ */
	/* ---------------------------- FORMATOS ---------------------------- */
	/* ------------------------------------------------------------------ */
	public String[] verListaFormatos() {
		Vector<String[]> vec = DBHandler.getFormatosOrdNome();
		return Utils.formattedFromVector(vec, "%s", new int[]{1});
	}
	
	public String getFormatoNome(String id) {
		return DBHandler.getFormatoNome(id);
	}
	
	/**
	 * Adiciona um novo formato � base de dados
	 */
	public String adicionaFormato(String nome) {
		if (!DBHandler.formatoExiste("", nome)) {
			DBHandler.adicionaFormato(nome);
			return "Novo formato adicionado.";
		} else
			return Consts.FORMATO_EXISTE;
	}

	public String actualizaFormato(String id, String nome) {
		if (!DBHandler.formatoExiste(id, nome)) {
			DBHandler.actualizaFormato(id, nome);
			return "Formato actualizado.";
		} else
			return Consts.FORMATO_EXISTE;
	}
	
	public String removeFormato(String id) {
		if (!DBHandler.formatoEmUso(id)) {
			DBHandler.removeFormato(id);
			return "Formato removido.";
		} else
			return Consts.FORMATO_EM_USO;
	}
	
	public String removeFormatoNome(String nome) {
		if (!DBHandler.formatoEmUsoNome(nome)) {
			DBHandler.removeFormato(nome);
			return "Formato removido.";
		} else
			return Consts.FORMATO_EM_USO;
	}

	/* ----------------------------------------------------------------- */
	/* ---------------------------- G�NEROS ---------------------------- */
	/* ----------------------------------------------------------------- */
	public String[] verListaGeneros() {
		Vector<String[]> vec = DBHandler.getGenerosOrdNome();
		return Utils.formattedFromVector(vec, "%s", new int[]{1});
	}
	
	public String getGeneroNome(String id) {
		return DBHandler.getGeneroNome(id);
	}
	
	/**
	 * Adiciona um novo g�nero � base de dados.
	 */
	public String adicionaGenero(String nome) {
		if (!DBHandler.generoExiste("", nome)) {
			DBHandler.adicionaGenero(nome);
			return "Novo g�nero adicionado: " + nome;
		} else
			return Consts.GENERO_EXISTE;
	}

	public String actualizaGenero(String id, String nome) {
		if (!DBHandler.generoExiste(id, nome)) {
			DBHandler.actualizaGenero(id, nome);
			return "G�nero actualizado.";
		} else
			return Consts.GENERO_EXISTE;
	}

	public String removeGenero(String id) {
		if (!DBHandler.generoEmUso(id)) {
			DBHandler.removeGenero(id);
			return "G�nero removido.";
		} else
			return Consts.GENERO_EM_USO;
	}
	
	public String removeGeneroNome(String nome) {
		if (!DBHandler.generoEmUsoNome(nome)) {
			DBHandler.removeGeneroNome(nome);
			return "G�nero removido.";
		} else
			return Consts.GENERO_EM_USO;
	}

	/* --------------------------------------------------------------------- */
	/* ---------------------------- REQUISI��ES ---------------------------- */
	/* --------------------------------------------------------------------- */
	
	/**
	 * "id : (data -- data_limite) : (ano) titulo [formato] (entregue a "data_entrega" {s� se existir})"
	 */
	public String[] verListaRequisicoesCliente(String id) {
		Vector<String[]> vec = DBHandler.getRequisicoesClientePlus(id);
		String[] out = Utils.formattedFromVector(vec, "%s : (%s -- %s) : (%s) %s [%s]", new int[]{0, 6, 7, 9, 10, 11});
		int i=0;
		for(String[] sa : vec) {
			if(sa[8] != null)
				out[i] = out[i] + " (entregue a " + sa[8] + ")";
			i++;
		}
		return out;
	}
	
	/**
	 * "(data -- data_limite) : (ano) titulo [formato] (entregue a "data_entrega" {s� se existir})"
	 */
	public String[] verListaRequisicoesClienteBI(String bi) {
		Vector<String[]> vec = DBHandler.getRequisicoesClienteBIPlus(bi);
		String[] out = Utils.formattedFromVector(vec, "%s : (%s -- %s) : (%s) %s [%s]", new int[]{0, 6, 7, 9, 10, 11});
		int i=0;
		for(String[] sa : vec) {
			if(sa[8] != null)
				out[i] = out[i] + " (entregue a " + sa[8] + ")";
			i++;
		}
		return out;
	}
	
	public String adicionaRequisicao(String id_maq, String emp_bi, String bi, String id_fil, String formato) {
		DBHandler.adicionaRequisicaoNomeFormato(id_maq, emp_bi, bi, id_fil, formato); 
		return "Requisi��o adicionada.";
	}
	
	public String entregaRequisicao(String id_req) {
		DBHandler.actualizaRequisicao(id_req); 
		return "Material requisitado registado como entregue.";
	}

	public String calcularPrecoRequisicao(String idMovie) {
		// TODO Auto-generated method stub
		return null;
	}
}

