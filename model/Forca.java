package br.com.infsolution.forca.model;

import java.util.ArrayList;

public class Forca {
private static Forca forca;
private Rodada rodada = new Rodada();
private ArrayList<Rodada> rodadas = new ArrayList<>();

private Forca(){
}

public static Forca getInstance(){
if(forca == null)
	forca = new Forca();
return forca;
}
public void addRodada(Rodada rodada,String namePlayer){
	rodada.setPlayer(namePlayer);
	this.rodada=rodada;
	this.rodadas.add(this.rodada);
}
public Rodada getRodada(){
	return this.rodada;
}
public ArrayList<Rodada> mostraRodadas(){
	return rodadas;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return rodada.toString();
	}
}
