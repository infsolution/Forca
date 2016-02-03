package br.com.infsolution.forca.model;

public class Player {
private String namePlayer;
private int escore;


public String getNamePlayer() {
	return namePlayer;
}
public void setNamePlayer(String namePlayer) {
	this.namePlayer = namePlayer;
}


public Player(){
}
public int getEscore() {
	return escore;
}
public void setEscore(int escore) {
	this.escore = escore;
}
public void incremetScore(int escore){
	this.escore+=escore;
}

public String getNome() {
	return namePlayer;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: "+this.namePlayer+"\nPontuação: "+this.escore;
	}
}
