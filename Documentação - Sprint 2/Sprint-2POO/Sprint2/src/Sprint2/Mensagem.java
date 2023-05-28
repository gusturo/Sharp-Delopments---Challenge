package Sprint2;

public abstract class Mensagem {

	private String mensagem;
	private int esg;
	private int setor;
	private Cliente cliente;
	private int Status;
	private String data;
	
	
	public Mensagem(String mensagem, int esg, int setor, Cliente cliente, int status, String data) {
		super();
		this.mensagem = mensagem;
		this.esg = esg;
		this.setor = setor;
		this.cliente = cliente;
		Status = status;
		this.data = data;
	}
	
	
	
	
	
	
	
	
	
}
