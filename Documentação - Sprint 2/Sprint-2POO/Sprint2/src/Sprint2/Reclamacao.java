package Sprint2;

public class Reclamacao extends Mensagem{

	private Funcionario responsavel;
	private String resposta;
	private String solucao;
	


	public Reclamacao(String mensagem, int esg, int setor, Cliente cliente, int status, String data,
			Funcionario responsavel, String resposta, String solucao) {
		super(mensagem, esg, setor, cliente, status, data);
		this.responsavel = responsavel;
		this.resposta = resposta;
		this.solucao = solucao;
	}
	
	public void responder(String resposta) {
		this.resposta=resposta;
	}
	
	public void solucao(String solucao) {
		this.solucao=solucao;
	}
	
}
