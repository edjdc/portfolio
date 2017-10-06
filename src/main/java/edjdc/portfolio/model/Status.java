package edjdc.portfolio.model;

public enum Status {
	
	EM_ANALISE("Em análise"), 
	ANALISE_REALIDADE("Análise realizada"),
	ANALISE_APROVADA("Análise aprovada"),
	INICIADO("Iniciado"),
	PLANEJADO("Planejado"),
	EM_ANDAMENTO("Em andamento"),
	ENCERRADO("Encerrado"),
	CANCELADO("Cancelado");
	
	private String nome;
	
	Status(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Boolean hasStatusAprovado() {
		return this.equals(Status.INICIADO) || this.equals(Status.EM_ANDAMENTO) || this.equals(Status.ENCERRADO);
	}
	
}