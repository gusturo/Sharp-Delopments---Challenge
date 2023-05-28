package consumidores;

public class Consumidor {

	private String nome;
	private String email;
	private long telefone;
	private String cargo;
	private int idConsumidor;
	
	public Consumidor(String nome, String email, String cargo, long telefone, int idConsumidor) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
		this.idConsumidor = idConsumidor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public int getIdConsumidor() {
		return idConsumidor;
	}

	public void setIdConsumidor(int idConsumidor) {
		this.idConsumidor = idConsumidor;
	}
	
	public String getDados() {
		return "\n"+"Consumidor:"
		+"\n Nome:"+nome
		+"\n Email: "+email
		+"\n Telefone: "+telefone
		+"\n Cargo funcionsrio: "+cargo
		+"\n ID funcionario: "+idConsumidor;
	}
}
