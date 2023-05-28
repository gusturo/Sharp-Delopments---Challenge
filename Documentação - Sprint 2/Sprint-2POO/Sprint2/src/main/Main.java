

//PARTICIPANTES DO GRUPO:
//Rafael Fiel Cruz Miranda - RM94654
//Erik Hoon Ko - RM93599
//Fernanda Freitas - RM95465
//Giovana Arruda da Costa - RM94584
//Gabrielly Fabricio Ramos - RM95413

package main;

import filas.FilaMensagens;
import informacoes.InformacoesMensagem;
import java.util.Random;

import consumidores.Consumidor;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

		static  Random random = new Random();
		
 		public static void main(String[] args) {
			FilaMensagens filaReclamacao = new FilaMensagens();
			FilaMensagens filaSugestao = new FilaMensagens();
			FilaMensagens filaElogio = new FilaMensagens();
			InformacoesMensagem mensagem = new InformacoesMensagem(null, 0, null, 0);
			int opcaoMenu;
			
			filaSugestao.init();
			filaReclamacao.init();
			filaElogio.init();
			
			do {
				opcaoMenu = parseInt(showInputDialog(gerarMenu()));
				if(opcaoMenu < 1 || opcaoMenu > 3) {
					showMessageDialog(null, "Opcao invalida");
				} else {
					switch(opcaoMenu) {
						case 1:
							showMessageDialog(null, "Programa encerrado");
							break;
						case 2:
							mensagem=receberMensagem(null, null, null);
			        		if (mensagem.getMotivo() == 1) {
			        			filaReclamacao.enqueue(mensagem);
			        		} else if (mensagem.getMotivo() == 2){
			        			filaSugestao.enqueue(mensagem);
			        		} else {
			        			filaElogio.enqueue(mensagem);	        			
			        		}       		
							break;
						case 3:			            	
			            	if (!filaReclamacao.isEmpty() || !filaSugestao.isEmpty() || !filaElogio.isEmpty()) {
			            			atenderMensagem(filaReclamacao, filaSugestao, filaElogio);
			            	} else {
			            		showMessageDialog(null, "Nao ha mensagem a ser atendida");
			            	}
							break;
					}
				}
	        } while(opcaoMenu != 1);
		}
		
		public static InformacoesMensagem receberMensagem(FilaMensagens filaReclamacao, FilaMensagens filaSugestao, FilaMensagens filaElogio) {
			String texto;
			int motivo, tipoConsumidor;
			int idMensagem = random.nextInt(1000000)+1;
			Consumidor consumidor = new Consumidor(null, null, null, 0, 0);
						
		    consumidor.setNome(showInputDialog("Digite seu nome:"));
		    
		    consumidor.setEmail(showInputDialog("Digite seu email:"));
			while (consumidor.getEmail() == null) {
				consumidor.setEmail(showInputDialog("Digite seu email:"));
			}
		    
			consumidor.setTelefone(parseLong(showInputDialog("Digite seu telefone:")));
			while (consumidor.getTelefone() == 0) {
				consumidor.setTelefone(parseLong(showInputDialog("Digite seu telefone:")));
			}
			
			tipoConsumidor = parseInt(showInputDialog("Qual o tipo de consumidor:\n1. Cliente\n2. Funcionario"));
			while (tipoConsumidor < 1 && tipoConsumidor > 2) {
				tipoConsumidor = parseInt(showInputDialog("Informacao obrigatoria, campo nao pode ficar em branco!\nQual o tipo de consumidor:\\n1. Cliente\\n2. Funcionario"));
			}
			
			if (tipoConsumidor == 2) {				
				consumidor.setCargo(showInputDialog("Qual o cargo do funcionario:"));
				while (consumidor.getCargo() == null) {
					consumidor.setCargo(showInputDialog("Qual o cargo do funcionario:"));
				}
				
				consumidor.setIdConsumidor(parseInt(showInputDialog("Qual o id do funcionario:")));
				while (consumidor.getIdConsumidor() < 1) {
					consumidor.setIdConsumidor(parseInt(showInputDialog("Qual o id do funcionario:")));
				}
			}
			
			motivo = parseInt(showInputDialog("Motivo do contato:\n1. Reclamacao\n2. Sugestao\n3. Elogio"));
			while (motivo < 1 && motivo > 3) {
				motivo = parseInt(showInputDialog("Informacao obrigatoria, campo nao pode ficar em branco!\nDigite sua e-mail:"));
			}
			
			texto = showInputDialog("Digite o texto:");
			while (texto == null) {
				texto = showInputDialog("Informacao obrigatoria, campo nao pode ficar em branco!\nDigite o texto:");
			}

			showMessageDialog(null, "Obrigado por contribuir com sua mensagem\nVoce recebera um codigo de protocolo para identificar a conversa\nSeu codigo: "+idMensagem);

			InformacoesMensagem mensagem = new InformacoesMensagem(consumidor, motivo, texto, idMensagem);
			return mensagem;	
		}
		
		public static void atenderMensagem(FilaMensagens filaReclamacao, FilaMensagens filaSugestao, FilaMensagens filaElogio) {
			InformacoesMensagem msg=null;
			
			do {
				int aux = parseInt(showInputDialog("Qual mensagem deseja atender:\n1. Reclamacao\n2. Sugestao\n3. Elogio"));
				while (aux < 1 && aux > 3) {
					aux = parseInt(showInputDialog("Informacao obrigatoria, campo nao pode ficar vazio\nQual mensagem deseja atender:\n1. Reclamacao\n2. Sugestao\n3. Elogio"));
				}
				
				if(aux==1) {
					if(!filaReclamacao.isEmpty()) {
						msg=filaReclamacao.dequeue();
				}else{
					showMessageDialog(null, "Nao ha reclamacoes, tente outros tipos de mensagem");
					}	
				}
				
				if (aux==2){
					if(!filaSugestao.isEmpty()) {
						msg=filaSugestao.dequeue();
					}else {
						showMessageDialog(null, "Nao ha reclamacoes, tente outros tipos de mensagem");	
					}
				}
				
				if (aux==3){
					if(!filaElogio.isEmpty()) {
						msg=filaElogio.dequeue();
					}else {
						showMessageDialog(null, "Nao ha reclamacoes, tente outros tipos de mensagem");	
					}
				}

			}while(msg == null);
			
			showMessageDialog(null, msg.toString());
				 
		}	
	
		public static String gerarMenu() {
			String aux = "\nBem vindo ao canal de comunicacao\n";
			aux += "\n";
			aux += "Selecione uma das opcoes abaixo:\n";
			aux += "1. Encerrar programa\n";
			aux += "2. Receber mensagem\n";
			aux += "3. Atender mensagem\n";
			return aux;
		}
}
