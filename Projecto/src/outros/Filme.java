package outros;

public class Filme
{
	private String titulo;
	private String ano;
	private String realizador;
	private String ratingIMDB;
	private String pais;
	private String produtora;
	private String descricao;
	private String capa;
	private String valido;
	private String[] generos;

	public Filme(
    		String titulo,
    		String ano,
            String realizador,
            String ratingIMDB,
            String pais,
            String produtora,
            String descricao,
            String capa,
            String valido,
            String[] generos) {

       this.titulo = titulo;
       this.ano = ano;
       this.realizador = realizador;
       this.ratingIMDB = ratingIMDB;
       this.pais = pais;
       this.produtora = produtora;
       this.descricao = descricao;
       this.capa = capa;
       this.setValido(valido);
       this.generos = generos;

    }

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getRatingIMDB() {
		return ratingIMDB;
	}

	public void setRatingIMDB(String ratingIMDB) {
		this.ratingIMDB = ratingIMDB;
	}

	public String getRealizador() {
		return realizador;
	}

	public void setRealizador(String realizador) {
		this.realizador = realizador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setValido(String valido) {
		this.valido = valido;
	}

	public String getValido() {
		return valido;
	}

	public String[] getGeneros() {
		return generos;
	}

	public void setGeneros(String[] generos) {
		this.generos = generos;
	}
}
