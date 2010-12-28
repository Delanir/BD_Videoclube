package outros;

public class Excepcao extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	private String erro;
	
	public Excepcao(String erro) {
		this.erro = erro;
	}
	
	public String getErro() {
		return erro;
	}
}
