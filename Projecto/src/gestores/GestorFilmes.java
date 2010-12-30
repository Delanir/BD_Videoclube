package gestores;

import java.util.Vector;

import outros.Consts;
import outros.Utils;

import bd.DBHandler;

/**
 * Trata da gestão de filmes, stocks, formatos, géneros e requisições.
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
	 * Obtém os campos do filme, na ordem definida pela BD.
	 * Contém os nomes dos géneros do filme no fim do array.
	 */
	public String[] getFilme(String id) {
		String[] filme = DBHandler.getFilme(id);
		String[] generosFilme = DBHandler.getGenerosFilmeNome(id);
		return Utils.extend(filme, generosFilme);
	}
	
	/**
	 * Adiciona um filme à base de dados
	 * String[] generos deve conter os nomes dos géneros e não os seus IDs.
	 */
	// TODO: adicionar generos
	public String adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos) {
		DBHandler.adicionaFilme(titulo, ano, realizador, ratingIMDB, pais, produtora, descricao, capa);
		Utils.dbg("O seguinte filme foi adicionado: (" + ano + ") " + titulo);
		return "O seguinte filme foi adicionado: (" + ano + ") " + titulo;
	}

	/**
	 *  String[] generos deve conter os nomes dos géneros e não os seus IDs.
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
	 * Cada parÃ¢metro pode ser null se nÃ£o for para ser utilizado na mega query
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
	 * "nome_formato" : "disponiveis" unid. disponíveis, "custo_aluguer" €
	 */
	public String[] verListaStocksFilme(String id_fil) {
		Vector<String[]> vec = DBHandler.getStocksDeFilme(id_fil);
		return Utils.formattedFromVector(vec, "%s : %s unid. disponíveis, %s €", new int[]{6, 2, 5});
	}
	
	/**
	 * Query para ver os stocks de um filme com toda a informação (para administração).
	 * "nome_formato" : "disponiveis"/"quant" disp., "custo_aluguer" € (orig. "custo_compra" €)
	 */
	public String[] verListaStocksFilmeFull(String id_fil) {
		Vector<String[]> vec = DBHandler.getStocksDeFilme(id_fil);
		return Utils.formattedFromVector(vec, "%s : %s/%s disp., %s € (orig. %s €)", new int[]{6, 2, 3, 5, 4});
	}
	
	/**
	 * @param id_fil identificador unÃ­voco do filme na base de dados
	 * @param formato bluray, dvd, etc..
	 * @quant quant número inicial de exemplares no stock (o valor de disponíveis é colocado a este valor)
	 * @param custo_compra quanto Ã© que o filme custou ao videoclube
	 * @param custo_aluguer preÃ§o praticado no aluguer
	 * @return
	 */
	public String adicionaStock(String id_fil, String formato, String quant, String custo_compra, String custo_aluguer) {
		if(!DBHandler.stockExisteNomeFormato(id_fil, formato)) {
			DBHandler.adicionaStockNomeFormato(id_fil, formato, quant, custo_compra, custo_aluguer);
			return "Novo stock adicionado.";
		} else {
			return "Já existe um stock desse filme no formato indicado.";
		}
	}
	
	//TODO: questão da quantidade.
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
	 * @param id_fil identificador unívoco do filme na base de dados
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
	 * Adiciona um novo formato à base de dados
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
	/* ---------------------------- GÉNEROS ---------------------------- */
	/* ----------------------------------------------------------------- */
	public String[] verListaGeneros() {
		Vector<String[]> vec = DBHandler.getGenerosOrdNome();
		return Utils.formattedFromVector(vec, "%s", new int[]{1});
	}
	
	public String getGeneroNome(String id) {
		return DBHandler.getGeneroNome(id);
	}
	
	/**
	 * Adiciona um novo género à base de dados.
	 */
	public String adicionaGenero(String nome) {
		if (!DBHandler.generoExiste("", nome)) {
			DBHandler.adicionaGenero(nome);
			return "Novo gï¿½nero adicionado: " + nome;
		} else
			return Consts.GENERO_EXISTE;
	}

	public String actualizaGenero(String id, String nome) {
		if (!DBHandler.generoExiste(id, nome)) {
			DBHandler.actualizaGenero(id, nome);
			return "Gï¿½nero actualizado.";
		} else
			return Consts.GENERO_EXISTE;
	}

	public String removeGenero(String id) {
		if (!DBHandler.generoEmUso(id)) {
			DBHandler.removeGenero(id);
			return "Gï¿½nero removido.";
		} else
			return Consts.GENERO_EM_USO;
	}
	
	public String removeGeneroNome(String nome) {
		if (!DBHandler.generoEmUsoNome(nome)) {
			DBHandler.removeGeneroNome(nome);
			return "Gï¿½nero removido.";
		} else
			return Consts.GENERO_EM_USO;
	}

	/* --------------------------------------------------------------------- */
	/* ---------------------------- REQUISIÇÕES ---------------------------- */
	/* --------------------------------------------------------------------- */
	
	/**
	 * "id : (data -- data_limite) : (ano) titulo [formato] (entregue a "data_entrega" {só se existir})"
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
	 * "(data -- data_limite) : (ano) titulo [formato] (entregue a "data_entrega" {só se existir})"
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
		return "Requisição adicionada.";
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

