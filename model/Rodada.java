package br.com.infsolution.forca.model;

import java.util.ArrayList;
import java.math.*;
public class Rodada {
	private final int pontosPalavra=100;
	private final int pontosLetra=15;
	private int totalPontos;
	private int sor;
	private boolean status=true;
	private String dica;
	private String palavraSorte;
	private Player player = new Player();
	private Boneco boneco = new Boneco();
	private Palavras palavras = new Palavras(); 
	private boolean sai = true;
	private ArrayList<String> letterError = new ArrayList<>();
	private ArrayList<String> letterOk = new ArrayList<>();
	private ArrayList<String> letterOfWord = new ArrayList<>();
	private ArrayList<String> letterShow = new ArrayList<>();
	private ArrayList<String> palavra = new ArrayList<>(); 
	private ArrayList<String> temas= new ArrayList<>();
	public String  getPalavras(){
		this.temas=this.palavras.loadArquivo("C:\\ArquiTxt\\ArquiTemas\\Temas.txt");
		int indTema=temas.size()-1;
		int sor=sorteaWord(indTema);
		//System.out.println("INDICE DO ARRAY DE TEMAS "+sor);
		this.palavra=this.palavras.loadArquivo("C:\\ArquiTxt\\"+this.temas.get(sor)+".txt");
		this.dica=this.temas.get(sor);
		int indWord=palavra.size();
		int sor1=sorteaWord(indWord);
		this.palavraSorte=this.palavra.get(sor1);
		return this.palavra.get(sor1);	
	}
	public String getPalavraSorte(){
		return this.palavraSorte;
	}
	public void setNewTema(String tema){
		ArrayList<String> temasTem = new ArrayList<>();
		temasTem=this.palavras.loadArquivo("C:\\ArquiTxt\\ArquiTemas\\Temas.txt");
		temasTem.add(tema);
		this.palavras.addTema("C:\\ArquiTxt\\ArquiTemas\\Temas.txt", tema,temasTem);
	}
		
	
	public ArrayList<String> letterOfWord(String word){
		ArrayList<String> wordSor = new ArrayList<>();
		for(int i = 0;i<word.length();i++){
			wordSor.add(word.substring(i, i+1));
		}
		return wordSor;
	}

	
	
	public ArrayList<String> upPlayer(ArrayList<String> word,ArrayList<String> wordShow,String letter){
		int conErr=0;
		if(letter.equals(this.palavraSorte)){
			this.player.incremetScore(100);
		}
		for(int i=0;i<word.size();i++){
			if(word.get(i).equals(letter)){
				wordShow.remove(i);
				wordShow.add(i, letter);
				this.letterOk.add(letter);
				this.player.incremetScore(15);
			}else{
				this.letterError.add(letter);

			}
		}
		if(!word.contains(letter)){
		this.boneco.setIncrementErros();}	
		
		return wordShow;
	}
	public ArrayList<String> hideWord(ArrayList <String> word){
		ArrayList<String> hidWor= new ArrayList<>();
		for(int i=0;i<word.size();i++){
			hidWor.add("__ ");
		}
		
		return hidWor;
	}

	public void  setLetterError(String letter){
		this.letterError.add(letter);
	}
	public ArrayList<String> getLetterError(){
		return this.letterError;
	}
	public void  setLetterOk(String letter){
		this.letterError.add(letter);
	}
	public ArrayList<String> getLetterOK(){
		return this.letterOk;
	}
	public void setPlayer(String namePlayer){
		this.player.setNamePlayer(namePlayer);
		this.player.setEscore(0);
	}
	public Player getPlayer(){
		return this.player;
	}
	public String getDica(){
		return this.dica;
	}
	public String getPalavraSorteada(){
		return this.palavraSorte;
	}
	public int sorteaWord(int numInd){
		int ind;
		ind=(int) (Math.random()*numInd);
		return ind;
	}

	public int getTotalPontos() {
		return totalPontos;
	}
	public void setTotalPontos(int totalPontos) {
		this.totalPontos = totalPontos;
	}
	public Boneco getBoneco() {
		return boneco;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getPontosPalavra() {
		return pontosPalavra;
	}
	public int getPontosLetra() {
		return pontosLetra;
	}
	
	public boolean isSai() {
		return sai;
	}
	public void setSai(boolean sai) {
		this.sai = sai;
	}
	public ArrayList<String> getLetterOfWord() {
		return letterOfWord;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Jogador: "+this.player.getNamePlayer()+"\nPontos: "+this.player.getEscore();
	}
	
}
