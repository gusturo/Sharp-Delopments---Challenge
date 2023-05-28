package filas;

import informacoes.InformacoesMensagem;

public class FilaMensagens {

	public final int N=15;
	InformacoesMensagem dados[] = new InformacoesMensagem[N];
	int ini, fim, cont;
	
	public void init() {
		ini = fim = 0;
		cont=0;
	}
	public boolean isEmpty() {
		if (cont==0)
			return true;
		else
			return false;
	}
	public boolean isFull() {
		if (cont==N)
			return true;
		else
			return false;
	}
	public void enqueue(InformacoesMensagem mensagem) {
		if (isFull())
			System.out.println("Fila cheia");
		else {
			dados[fim] = mensagem;
			fim = (fim+1)%N;
			cont++;
		}
	}
	public InformacoesMensagem dequeue() {
		if (isEmpty()) {
			System.out.println("Fila vazia");
			return null;
		} else {
			InformacoesMensagem mensagem = dados[ini];
			ini = (ini + 1) % N;
			cont--;
			return mensagem;
		}
	}

	public InformacoesMensagem first() {
		if (isEmpty()) {
			System.out.println("Fila vazia");
			return null;
		} else {
			return dados[ini];
		}
	}
}
