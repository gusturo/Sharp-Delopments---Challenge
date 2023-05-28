package teste;

import java.util.Scanner;

import lista.ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListaEncadeada lista = new ListaEncadeada();

		int opcao, feedback, emb = 0, prc = 0, pdt = 0, pol = 0, atd = 0;
		String tema;
		
		System.out.println("Quer deixar algum feedback?");
		System.out.println();

		do {
			System.out.println("Temas:");
			System.out.println("1. Embalagem");
			System.out.println("2. Preco");
			System.out.println("3. Produto");
			System.out.println("4. Poluicao");
			System.out.println("5. Atendimento");
			System.out.println("0. Sair");
			System.out.print("Digite a opção desejada: ");
			opcao = sc.nextInt();
			System.out.println();

			switch (opcao) {
			case 1:
				tema = "Embalagem";
				emb++;
				lista.insere(emb, tema);
				System.out.println("Como você avalia nossa embalagem?");
				System.out.println("1. ruim  2. regular  3. bom");
				feedback = sc.nextInt();
				while (feedback >3 || feedback <1) {
					System.out.println("Opção inválida! Digite novamente: ");
					System.out.println("1. ruim  2. regular  3. bom");
					feedback = sc.nextInt();
				}
				break;
			case 2:
				tema = "Preco";
				prc++;
				lista.insere(prc, tema);
				System.out.println("Como você avalia o preco de nossos produtos?");
				System.out.println("1. ruim  2. regular  3. bom");
				feedback = sc.nextInt();
				while (feedback >3 || feedback <1) {
					System.out.println("Opção inválida! Digite novamente: ");
					System.out.println("1. ruim  2. regular  3. bom");
					feedback = sc.nextInt();
				}
				break;
			case 3:
				tema = "Produto";
				pdt++;
				lista.insere(pdt, tema);
				System.out.println("Como você avalia nosso produto?");
				System.out.println("1. ruim  2. regular  3. bom");
				feedback = sc.nextInt();
				while (feedback >3 || feedback <1) {
					System.out.println("Opção inválida! Digite novamente: ");
					System.out.println("1. ruim  2. regular  3. bom");
					feedback = sc.nextInt();
				}
				break;
			case 4:
				tema = "Poluicao";
				pol++;
				lista.insere(pol, tema);
				System.out.println("Como você avalia nosso trabalho contra a poluição?");
				System.out.println("1. ruim  2. regular  3. bom");
				feedback = sc.nextInt();
				while (feedback >3 || feedback <1) {
					System.out.println("Opção inválida! Digite novamente: ");
					System.out.println("1. ruim  2. regular  3. bom");
					feedback = sc.nextInt();
				}
				break;
			case 5:
				tema = "Atendimento";
				atd++;
				lista.insere(atd, tema);
				System.out.println("Como você avalia nosso atendimento?");
				System.out.println("1. ruim  2. regular  3. bom");
				feedback = sc.nextInt();
				while (feedback >3 || feedback <1) {
					System.out.println("Opção inválida! Digite novamente: ");
					System.out.println("1. ruim  2. regular  3. bom");
					feedback = sc.nextInt();
				}
				break;
			case 0:
				System.out.println("Saindo do programa");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
			System.out.println();

		} while (opcao != 0);
		lista.apresenta();

		sc.close();
	}

}
