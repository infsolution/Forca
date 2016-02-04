package br.com.infsolution.forca.aplication;
import br.com.infsolution.forca.model.*;
import java.io.*;
import java.util.*;
public class Jogo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		Forca forca = Forca.getInstance();
		Rodada rodada;
		String namePlayer;
		boolean sair = true;
		ArrayList<String> palSor = new ArrayList<>();
		ArrayList<String> palMos = new ArrayList<>();
		String palDes;
		int opt=0;
		while(opt!=9){
			System.out.println("Menu:\n01- Jogar.\n02- Ver escores.\n03- Cadastrar Tema/palavra\n09- Sair");
			opt=ler.nextInt();
			if(opt==1){
				forca.getRodada().getBoneco().setErros(0);
				rodada=new Rodada();
				System.out.println("Diga seu nome.");
				namePlayer=ler.next().toUpperCase();
				forca.addRodada(rodada,namePlayer);		
				palSor=forca.getRodada().letterOfWord(forca.getRodada().getPalavras());
				System.out.println(forca.toString());
				//System.out.println(forca.getRodada().getPalavraSorte());
				System.out.println("Dica de Palavra:\n"+">>>>>"+forca.getRodada().getDica()+"<<<<<");
				palMos=forca.getRodada().hideWord(palSor);
				do{
			System.out.println(forca.getRodada().getBoneco());
			System.out.println(palMos);
			System.out.println("\nDigite uma palavra ou letra.\n");
			String palpite = ler.next().toUpperCase();
			palMos=forca.getRodada().upPlayer(palSor,palMos,palpite);
			//System.out.println(forca.getRodada().getWordPat());
			System.out.println(forca.toString());
			if(forca.getRodada().getBoneco().getErros()==6){
				System.out.println("Voce perdeu! Tente novamente.");
				break;
			}else if(palpite.equals(forca.getRodada().getPalavraSorte())){
				System.out.println("Parabéns voce acertou.");
				break;
			}else if(palMos.equals(palSor)){
				System.out.println("Parabéns voce acertou.");
				break;
			}
		}while(true);
		}else if(opt==2){
			System.out.println("Jogadores:\n");
			for(int i=0;i<forca.mostraRodadas().size();i++){
				System.out.println(forca.mostraRodadas().get(i).toString());
			}
		}else if(opt==3){
			System.out.println("Informe um Tema.");
			String tema= ler.next().toUpperCase();
			forca.getRodada().setNewTema(tema);
		}
		
					}
	}
		}
	
