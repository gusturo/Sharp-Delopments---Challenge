package Sprint2;

public class Sugestao extends Mensagem{

	private Acao acao;

	
	public Sugestao(String mensagem, int esg, int setor, Cliente cliente, int status, String data, Acao acao) {
		super(mensagem, esg, setor, cliente, status, data);
		this.acao = acao;
	}

	
	
	
	
	
	
}
