package Sprint2;

public class Duvida extends Mensagem{
	
	private Funcionario responsavel;
	private String resposta;
	
	
	
	public Duvida(String mensagem, int esg, int setor, Cliente cliente, int status, String data,
			Funcionario responsavel, String resposta) {
		super(mensagem, esg, setor, cliente, status, data);
		this.responsavel = responsavel;
	}

	
	public void responder(String resposta) {
		this.resposta=resposta;
	}
	
	
	
}
