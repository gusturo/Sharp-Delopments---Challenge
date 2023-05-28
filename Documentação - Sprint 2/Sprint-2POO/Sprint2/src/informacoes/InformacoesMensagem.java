package informacoes;

import consumidores.Consumidor;

public class InformacoesMensagem {

	Consumidor consumidor;
	private int motivo;
	private String texto;
	private int idMensagem;
	
	public InformacoesMensagem(Consumidor consumidor, int motivo, String texto, int idMensagem) {
		super();
		this.consumidor = consumidor;
		this.motivo = motivo;
		this.texto = texto;
		this.idMensagem = idMensagem;
	}

	public Consumidor getConsumdior() {
		return consumidor;
	}

	public void setConsumdior(Consumidor consumdior) {
		this.consumidor = consumdior;
	}

	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getDadosfuncionario() {
		return "\n"+"Mensagem:"
		+"\n"+consumidor.getDados()
		+"\n Motivo do contato: "+motivo
		+"\n Texto: "+texto
		+"\n Protocolo da conversa: "+idMensagem;
	}
	
	
	
}
