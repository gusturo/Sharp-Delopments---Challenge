package lista;

public class ListaEncadeada {

	private class NO {
		String tema;
		int dado;
		NO prox;
	}

	private NO lista = null;

	public void insere(int elem, String tema) {
		// Etapa 1: alocar novo nó
		NO novo = new NO();
		novo.dado = elem;
		novo.tema = tema;

		// Etapa 2: encontrar a posição para inserção
		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado > lista.dado) {
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;

				while (aux.prox != null && !achou) {
					if (aux.prox.dado > novo.dado) {
						aux = aux.prox;
					} else {
						achou = true;
					}
				}

				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}
	}

	public void apresenta() {
		NO aux = lista;
		System.out.println("\n*********** LISTA **********");

		while (aux != null) {
			System.out.println("Tema: " + aux.tema + "\t" + "Feedbacks: " + aux.dado);
			aux = aux.prox;
		}

	}

}
