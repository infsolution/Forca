package br.com.infsolution.forca.model;
import java.awt.peer.TrayIconPeer;
import java.math.*;
import java.io.*;
import java.io.IOException;
import java.util.*;
public class Palavras {
	private ArrayList<String> palavras; 

public  Palavras(){

}

public ArrayList<String> loadArquivo(String arquivo){
	palavras = new ArrayList<>(); 
	try{
		FileReader arq = new FileReader(arquivo);
		BufferedReader lerArqT = new BufferedReader(arq);
		String word= "";	
		while(word != null){
			word=lerArqT.readLine();
			this.palavras.add(word);
		}
		arq.close();		
		}catch(IOException e){
			System.out.println("Arquivo não encontrado!");
			e.getMessage();
		}
	return this.palavras;
}

public void addTema(String arquivo, String tema,ArrayList<String> temas){
	try {
		FileWriter gravar = new FileWriter(arquivo);
		BufferedWriter buffWrite = new BufferedWriter(gravar);
	/*	for(int i=0;i<temas.size();i++){
		linha+=temas.get(i);	
		linha+="\n";
		}
		buffWrite.append(linha);
		buffWrite.close();*/
		
		temas.add(tema);
		for(int i=0;i<temas.size();i++){
			buffWrite.append(temas.get(i));
			buffWrite.newLine();
		}
		buffWrite.flush();
		buffWrite.close();
		//buffWrite.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public ArrayList<String> getPalav() {
	return this.palavras;
}
 
/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.palavras.get(4);
	}*/
}
