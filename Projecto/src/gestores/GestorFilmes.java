package gestores;

import java.util.Vector;

import outros.Consts;
import outros.Utils;

import bd.DBHandler;
import java.util.GregorianCalendar;

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
	 * Adiciona um filme � base de dados
	 */
	// TODO: assumi que "String[] generos" cont�m IDs e n�o nomes de g�neros.
	// tamb�m assumi que o ano e ratingIMDB v�m correctos, embora ainda tenha a verifica��o
	// TODO: adicionar generos (dif�cil. tenho de saber o ID do filme k acabei de adicionar)
	public String adicionaFilme(String titulo, String ano, String realizador, String ratingIMDB, String pais, String produtora, String descricao, String capa, String[] generos) {
		DBHandler.adicionaFilme(titulo, ano, realizador, ratingIMDB, pais, produtora, descricao, capa);
		Utils.dbg("O seguinte filme foi adicionado: (" + ano + ") " + titulo);
		return "O seguinte filme foi adicionado: (" + ano + ") " + titulo;
	}

	// TODO: adicionar generos (dif�cil. tenho de saber o ID do filme k acabei de adicionar)
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
		Utils.dbg("gestorFilmes: Eliminou Supostamente:" + idMovie + " " + formato + " " + quantidade);
		return null;
	}

	/**
	 * Cada parâmetro pode ser null se não for para ser utilizado na mega query
	 */
	 //Strings devolvidas em formato "id: (ano) titulo"
	public String[] procuraFilmes(String titulo, String anoLow, String anoHigh, String realizador, String ratingIMDBLow, String ratingIMDBHigh, String pais, String produtora, String[] generos) {
		/*String []listaResultados= new String[6];
		listaResultados[0]="222 Apocalipse Now";
		listaResultados[1]="2 Toy Story 3";
		listaResultados[2]="34 Tangled";
		listaResultados[3]="666 Inception";
		listaResultados[2]="4 Titanic";
		listaResultados[3]="1 The Pianist";*/
		Vector<String[]> vec = DBHandler.procuraFilmes(titulo, anoLow, anoHigh, realizador, ratingIMDBLow, ratingIMDBHigh, pais, produtora, generos); 
		String[] ret = new String[vec.size()];
		int i=0;
		for(String[] sa : vec) {
			ret[i] = sa[0] + ": (" + sa[1] + ") " + sa[2];
			i++;
		}
		return ret;
	}

	/**
	 * Query à bd para ver quantas unidades disponiveis do filme há
	 * @param idFilme
	 * @param formato
	 * @return
	 */
	// TODO: do it
	public String listarFormato(String idFilme, String formato) {
		Utils.dbg(formato);
		return "ID: " + idFilme + " Formato: " + formato +
			   "\nQuantidade Stock: " + "3" +
			   "\nQuantidade Disponível" + "1";
	}
	
	/* ------------------------------------------------------------------ */
	/* ---------------------------- FORMATOS ---------------------------- */
	/* ------------------------------------------------------------------ */
	public Vector<String[]> verListaFormatos() {
		return DBHandler.getFormatosOrdNome();
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
	public Vector<String[]> verListaGeneros() {
		return DBHandler.getGenerosOrdNome();
	}
	
	public String getGeneroNome(String id) {
		return DBHandler.getGeneroNome(id);
	}
	
	/**
	 * Adiciona um novo g�nero � base de dados
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

    /**
     * gera uma string com as estatisticas mais relevantes relativas aos clientes
     * @param begin
     * @param end
     * @return
     */
	// TODO: do it
    public String estatisticasFilmes(GregorianCalendar begin,GregorianCalendar end){
        if(begin!=null&&end!=null){
            //estatisticas num intrevalo de tempo
        }else{

        }
        return "Estatisticas Filmes:\n------------------------\n";
    }

    /**
     * -----------------------------ALUGUER------------------------------------
     */

    /**
     *
     * @param idFilme
     * @param formato
     * @param idCliente
     * @param idEmpregado
     * @return
     */
    public String alugaFilme(String idFilme, String formato, String idCliente, String idEmpregado){
        return "Alugado/Não Alugado";
    }
    
    /**
     * vai buscar os formatos e o pre�o do aluguer de um filme
     */
    // TODO
    public String [] getFormatoPreco(String idMovie){
        //pode devolver no formato pre�o + formatos para ser mais simples digo eu
        return null;
    }

}
