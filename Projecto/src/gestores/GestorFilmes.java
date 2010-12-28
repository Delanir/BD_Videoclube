package gestores;

import java.util.Vector;

import outros.Consts;
import outros.Excepcao;
import outros.Utils;

import bd.DBHandler;

/**
 * Trata da gestão de filmes
 * @author Daniela
 */
public class GestorFilmes
{
	/* ---------------------------------------------------------------- */
	/* ---------------------------- FILMES ---------------------------- */
	/* ---------------------------------------------------------------- */
	public Vector<String[]> verListaFilmes() {
		return DBHandler.getFilmes();
	}
	
	public Vector<String[]> getFilmesOrdTitulo() {
		return DBHandler.getFilmesOrdTitulo();
	}
	
	public Vector<String[]> getFilmesOrdAno() {
		return DBHandler.getFilmesOrdAno();
	}
	
	public Vector<String[]> getFilmesOrdRankIMDB() {
		return DBHandler.getFilmesOrdRankIMDB();
	}
	
	//TODO: Gui String[] em vez de Filme
	public String[] getFilme(String id) {
		String[] filme = DBHandler.getFilme(id);
		String[] generosFilme = DBHandler.getGenerosFilmeNome(id);
		return Utils.extend(filme, generosFilme);
	}
	
	/**
	 * Adiciona um filme à base de dados
	 */
	// TODO: assumi que "String[] generos" cont�m IDs e n�o nomes de g�neros.
	// tamb�m assumi que o ano e ratingIMDB v�m correctos, embora ainda tenha a verifica��o
	// TODO: gui ver ordem dos m�todos
	// TODO: gui adicionaFilme em vez de addFilme
	// TODO: adicionar generos (dif�cil. tenho de saber o ID do filme k acabei de adicionar)
	public String adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos) throws Excepcao {
		DBHandler.adicionaFilme(titulo, ano, realizador, ratingIMDB, pais, produtora, descricao, capa);
		System.out.println("O seguinte filme foi adicionado: (" + ano + ") " + titulo);
		return "O seguinte filme foi adicionado: (" + ano + ") " + titulo;
	}

	// TODO: gui ver ordem dos m�todos
	// TODO: adicionar generos (dif�cil. tenho de saber o ID do filme k acabei de adicionar)
	public String actualizaFilme(String id, String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos) throws Excepcao {
		DBHandler.actualizaFilme(id, titulo, ano, realizador, ratingIMDB, pais, produtora, descricao, capa);
		System.out.println("O filme com o ID " + id + " foi actualizado.");
		return "O filme foi actualizado.";
	}
	
	public String invalidaFilme(String id) {
		DBHandler.invalidaFilme(id);
		System.out.println("O filme com o ID " + id + " foi invalidado.");
		return "O filme foi invalidado.";
	}
	
	public String validaFilme(String id) {
		DBHandler.validaFilme(id);
		System.out.println("O filme com o ID " + id + " foi re-validado.");
		return "O filme foi re-validado.";
	}
	
	
	/* --------------------------------------------------------------------------------- */
	/**
	 * @param idMovie identificador unívoco do filme na base de dados
	 * @param formato bluray, dvd,etc..
	 * @param custo quanto é que o filme custou ao videoclube
	 * @param custoAluger preço praticado no aluguer
	 * @return
	 */
	// TODO: do it
	public String addStock(String idMovie, String formato, String custo, String custoAluger) {

		return null;

	}

	/**
	 * @param idMovie identificador unívoco do filme na base de dados
	 * @param formato bluray, dvd,etc..
	 * @param quantidade número de cópias a eliminar
	 * @return
	 */
	// TODO: do it
	public String deleteStock(String idMovie, String formato, int quantidade) {
		System.out.println("gestorFilmes: Eliminou Supostamente:" + idMovie + " " + formato + " " + quantidade);
		return null;
	}

	/**
	 * Cada parâmetro pode ser null se não for para ser utilizado na mega
	 * query
	 * @param titulo
	 * @param ano
	 * @param imdbBegin
	 * @param imdbEnd
	 * @param realizador
	 * @param produtor
	 * @param pais
	 * @return lista com resultados
	 */
	// TODO: gui procuraFilmes em vez de searchMovie
	public Vector<String[]> procuraFilmes(String titulo, String anoLow, String anoHigh, String realizador, String ratingIMDBLow, String ratingIMDBHigh, String pais, String produtora, String[] generos) {
			/*String []listaResultados= new String[6];
			listaResultados[0]="222 Apocalipse Now";
			listaResultados[1]="2 Toy Story 3";
			listaResultados[2]="34 Tangled";
			listaResultados[3]="666 Inception";
			listaResultados[2]="4 Titanic";
			listaResultados[3]="1 The Pianist";*/
			return DBHandler.procuraFilmes(titulo, anoLow, anoHigh, realizador, ratingIMDBLow, ratingIMDBHigh, pais, produtora, generos);
	}

	/**
	 * Query à bd para ver quantas unidades disponiveis do filme há
	 * @param idFilme
	 * @param formato
	 * @return
	 */
	// TODO: do it
	public String listarFormato(String idFilme, String formato) {
		System.out.println(formato);
		return "ID: " + idFilme + " Formato: " + formato +
			   "\nQuantidade Stock: " + "3" +
			   "\nQuantidade Disponível" + "1";
	}
	
	/* ------------------------------------------------------------------ */
	/* ---------------------------- FORMATOS ---------------------------- */
	/* ------------------------------------------------------------------ */
	// TODO: atencao na GUI. Mudar de String[] para Vector<String[]>
	public Vector<String[]> verListaFormatos() {
		return DBHandler.getFormatosOrdNome();
	}
	
	public String getFormatoNome(String id) {
		return DBHandler.getFormatoNome(id);
	}
	
	/**
	 * Adiciona um novo formato � base de dados
	 */
	// TODO: catch exception na GUI
	public void adicionaFormato(String nome) throws Excepcao {
		if (!DBHandler.formatoExiste("", nome)) {
			DBHandler.adicionaFormato(nome);
			System.out.println("Novo formato adicionado: " + nome);
		} else
			throw new Excepcao(Consts.FORMATO_EXISTE);
	}

	// TODO: catch exception na GUI
	public void actualizaFormato(String id, String nome) throws Excepcao {
		if (!DBHandler.formatoExiste(id, nome)) {
			DBHandler.actualizaFormato(id, nome);
			System.out.println("Formato actualizado: " + id);
		} else
			throw new Excepcao(Consts.FORMATO_EXISTE);
	}
	
	public void removeFormato(String id) throws Excepcao {
		if (!DBHandler.formatoEmUso(id)) {
			DBHandler.removeFormato(id);
			System.out.println("Formato removido: " + id);
		} else
			throw new Excepcao(Consts.FORMATO_EM_USO);
	}
	
	public void removeFormatoNome(String nome) throws Excepcao {
		if (!DBHandler.formatoEmUsoNome(nome)) {
			DBHandler.removeFormato(nome);
			System.out.println("Formato removido: " + nome);
		} else
			throw new Excepcao(Consts.FORMATO_EM_USO);
	}

	/* ----------------------------------------------------------------- */
	/* ---------------------------- G�NEROS ---------------------------- */
	/* ----------------------------------------------------------------- */
	// TODO: atencao na GUI. Mudar de String[] para Vector<String[]>
	public Vector<String[]> verListaGeneros() {
		return DBHandler.getGenerosOrdNome();
	}
	
	public String getGeneroNome(String id) {
		return DBHandler.getGeneroNome(id);
	}
	
	/**
	 * Adiciona um novo g�nero � base de dados
	 */
	// TODO: catch exception na GUI
	public void adicionaGenero(String nome) throws Excepcao {
		if (!DBHandler.generoExiste("", nome)) {
			DBHandler.adicionaGenero(nome);
			System.out.println("Novo g�nero adicionado: " + nome);
		} else
			throw new Excepcao(Consts.GENERO_EXISTE);
	}

	// TODO: catch exception na GUI
	public void actualizaGenero(String id, String nome) throws Excepcao {
		if (!DBHandler.generoExiste(id, nome)) {
			DBHandler.actualizaGenero(id, nome);
			System.out.println("G�nero actualizado: " + id);
		} else
			throw new Excepcao(Consts.GENERO_EXISTE);
	}

	// TODO: catch exception na GUI
	public void removeGenero(String id) throws Excepcao {
		if (!DBHandler.generoEmUso(id)) {
			DBHandler.removeGenero(id);
			System.out.println("G�nero removido: " + id);
		} else
			throw new Excepcao(Consts.GENERO_EM_USO);
	}
	
	public void removeGeneroNome(String nome) throws Excepcao {
		if (!DBHandler.generoEmUsoNome(nome)) {
			DBHandler.removeGeneroNome(nome);
			System.out.println("G�nero removido: " + nome);
		} else
			throw new Excepcao(Consts.GENERO_EM_USO);
	}
}
