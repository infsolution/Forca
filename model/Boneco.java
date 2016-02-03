package br.com.infsolution.forca.model;

public class Boneco {
	private int erros;
	private final String cabeca="O";
	private final String bracoEsquerdo="/";
	private final String peEsquerdo="/";
	private final String corpo="|";
	private final String bracoDireito="\\";
	private final String peDireito="\\";
	public String getCabeca() {
		if(this.erros>=1)
			return cabeca;
		return "";
		
	}
	public String getBracoDireito() {
		if(this.erros>=4)
			return bracoDireito;
		return "";
		
	}
	public String getPeDireito() {
		if(this.erros>=6)
			return peDireito;
		return "";	
	}
	public String getCorpo() {
		if(this.erros==2)
			return " "+corpo;
		if(this.erros>2)
			return corpo;
		return "";
	}
	public String getBracoEsquerdo() {
		if(this.erros>=3)	
			return bracoEsquerdo;
		return "";
	}
	public String getPeEsquerdo() {
		if(this.erros>=5)
			return peEsquerdo;
		return "";
	}
	public int getErros() {
		return erros;
	}
	public void setErros(int erros) {
		this.erros = erros;
	}
	public void setIncrementErros(){
		this.erros+=1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "_____\n"+"|   |\n"+"|  "+" "+getCabeca()+"\n|  "+getBracoEsquerdo()
		+getCorpo()+getBracoDireito()+"\n| "+" "+getPeEsquerdo()+" "+getPeDireito();
	}
	
}
