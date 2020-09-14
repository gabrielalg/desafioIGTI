package entidades;

public class Funcionario {
	protected String nome;
	protected Double salarioBruto;
	
	public Funcionario(String nome, Double salarioBruto) {
		this.nome = nome;
		this.salarioBruto = salarioBruto;
	}
	
	public String toString() {
		return nome + " - " + salarioBruto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
}
