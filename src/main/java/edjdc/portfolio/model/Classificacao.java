package edjdc.portfolio.model;

public enum Classificacao {
	
	BAIXO("Baixo risco"), 
	MEDIO("Médio risco"),
	ALTO("Alto risco");
	
	private String nome;
	
	Classificacao(String nome) {
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}
}
