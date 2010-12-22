/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

/**
 * Trata da gestão de filmes
 * @author Daniela
 */
public class GestorFilmes
{
	/**
	 * Adiciona um filme à base de dados
	 * @param titulo
	 * @param ano
	 * @param generos
	 * @param realizador
	 * @param produtor
	 * @param pais
	 * @param pathCapa
	 * @param descricao
	 * @return
	 */
	public String addMovie(String titulo, int ano, String[] generos, String realizador, String produtor, String pais, String pathCapa, String descricao,double ratingIMDB) {
                //TODO: FAZER!

		return "Adicionado: "+titulo+
                        " "+ano+
                        "\n"+generos[0]
                        +"\n"+realizador
                        +"\n"+produtor
                        +"\n"+pais
                        +"\n"+pathCapa
                        +"\n"+descricao
                        +"\n"+ratingIMDB;
	}

	/**
	 * @param idMovie identificador unívoco do filme na base de dados
	 * @param formato bluray, dvd,etc..
	 * @param custo quanto é que o filme custou ao videoclube
	 * @param custoAluger preço praticado no aluguer
	 * @return
	 */
	public String addStock(String idMovie, String formato, String custo, String custoAluger) {

		return null;

	}

	/**
	 * @param idMovie identificador unívoco do filme na base de dados
	 * @param formato bluray, dvd,etc..
	 * @param quantidade número de cópias a eliminar
	 * @return
	 */
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
	public String[] searchMovie(String id,String titulo, int anoInicio,int anoFim, double imdbBegin, double imdbEnd, String realizador, String produtor, String pais) {
            String []listaResultados= new String[6];
            listaResultados[0]="222";
            listaResultados[1]="Toy Story 3";
            listaResultados[2]="34";
            listaResultados[3]="Inception";
            listaResultados[2]="4";
            listaResultados[3]="The Pianist";
            
            return listaResultados;
	}

	/**
	 * Query à bd para ver quantas unidades disponiveis do filme há
	 * @param idFilme
	 * @param formato
	 * @return
	 */
	public String listarFormato(String idFilme, String formato) {
		System.out.println(formato);
		return "ID: " + idFilme + " Formato: " + formato + "\nQuantidade Stock: " + "3" + "\nQuantidade Disponível" + "1";
	}

	/**
	 * Adiciona um novo género à base de dados
	 * @param novoGenero
	 */
	public void adicionaGenero(String novoGenero) {
		if (novoGenero != null && novoGenero.length() < 3) {
			// pede à base de DADOS para adicionar
			System.out.println("gestorFilmes: genero adicionado");
		}
	}

	/**
	 * Actualiza lista de géneros
	 * @param novoGenero
	 */
	public String[] verListaGeneros() {
		String[] listaGeneros = new String[3];
		listaGeneros[0] = "Tragédia";
		listaGeneros[1] = "Drama";
		listaGeneros[2] = "Horror";
		return listaGeneros;
	}
}