package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Funcionario;

public class ControleRH {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Funcionario> funcionarios = new ArrayList<>();

	public void iniciar() {
		iniciarInformacoes();
		String opcao = mostrarMenu();
		while (!opcao.equals("3")) {
			switch (opcao.toLowerCase()) {
	         case "1":
	             perguntaFuncionario();
	             opcao = mostrarMenu();
	             break;
	         case "2":
	             perguntaContracheque();
	             opcao = mostrarMenu();
	             break;
	         default:
	        	 System.out.println("\n> Opção inválida.\n");
	        	 opcao = mostrarMenu();
	        	 break;
			 }
		}
		
		System.out.println("\nObrigado por utilizar o sistema de RH!");
		 
	}
	
	private String mostrarMenu() {
		System.out.println("\nO que deseja fazer? \n1 - Cadastrar Funcionário | 2 - Imprimir Contracheque | 3 - Sair");
		return scanner.nextLine();
	}

	private void iniciarInformacoes() {
		Funcionario funcionario1 = new Funcionario("João", 5000.00);
		Funcionario funcionario2 = new Funcionario("Carla", 7000.00);
		
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
	}
	
	private void  perguntaFuncionario() {
		System.out.println("Qual o nome do funcionário?");
		String nome = scanner.nextLine();
		 if (nome == "" || nome.length() < 3 ) {
		 	System.out.println("\n> Digite um nome válido.\n");
            perguntaFuncionario();
        } else {
        	Double salario = perguntaSalario(nome);
        	
        	Funcionario funcionario = new Funcionario(nome, salario);
        	funcionarios.add(funcionario);
        }
	}
	
	private Double perguntaSalario(String nome) {
		Double salarioDouble = null;
		System.out.println("Qual o salario bruto de " + nome + "?");
    	String salario = scanner.nextLine();
    	    	
    	try {
    		salarioDouble = Double.parseDouble(salario);
	    } catch (NumberFormatException e) {
	    	System.out.println("\n> Digite um salário válido.\n");
	    	return perguntaSalario(nome);
	    }
    	return salarioDouble;
	}
	
	private void perguntaContracheque() {
		System.out.println("De quem você quer imprimir o Contracheque?");
		for (int i = 0; i < funcionarios.size(); i++) {
			System.out.println(i+1 + " - " + funcionarios.get(i).getNome());
		}	
    	String index = scanner.nextLine();
    	Integer indexInt = null;
		
    	try {
    		indexInt = Integer.parseInt(index) - 1;
	    } catch (NumberFormatException e) {
	    	System.out.println("\n> Não existe funcionário nessa posição.\n");
	    	perguntaContracheque();
	    }
    	
    	if ((indexInt != null) && ((indexInt > funcionarios.size() - 1) || (indexInt < 0))) {
    		System.out.println("\n> Não existe funcionário nessa posição.\n");
	    	perguntaContracheque();
    	} 
    	
    	if (indexInt != null) {
    		Funcionario funcionario = funcionarios.get(indexInt);
    		Double inss = calcularINSS(funcionario);
    		Double irrf = calcularIRRF(funcionario, inss); 
    		Double salarioLiquido = funcionario.getSalarioBruto() - inss - irrf;
    		
    		System.out.println("\n----- HOLERITE -----");
    		System.out.println("Funcionário(a):  " + funcionario.getNome());
    		System.out.println("Salário Bruto:   " + funcionario.getSalarioBruto());
    		System.out.println("Desconto INSS:   " + inss);
    		System.out.println("Desconto IRRF:   " + irrf);
    		System.out.println("Salário líquido: " + salarioLiquido);
    		System.out.println("--------------------");
    		
    		indexInt = null;

    	}
    	
	}
	
	private Double calcularINSS(Funcionario funcionario) { 
		Double salario = funcionario.getSalarioBruto();
	    Double descontoINSS = 0.0;
	
	    if (salario <= 1045.00) {
	        descontoINSS = salario * 0.075;
	    } else if (salario - 1045 >= 0) {
	        descontoINSS = 1045 * 0.075;
	    } 
	    if (salario > 1045.00 && salario <= 2089.60) {
	        descontoINSS += (salario - 1045.01) * 0.09;
	    } else if (salario - 2089.60 > 0 ) {
	        descontoINSS += (2089.60 - 1045.01) * 0.09;
	    } 
	    if (salario > 2089.61 && salario <= 3134.40) {
	        descontoINSS += (salario - 2089.61) * 0.12;
	    } else if (salario - 3134.40 > 0) {
	        descontoINSS += (3134.40 - 2089.61) * 0.12;
	    }
	    if (salario > 3134.41 && salario <= 6101.06) {
	        descontoINSS += (salario - 3134.41) * 0.14;
	    } else if (salario - 6101.06 > 0) {
	        descontoINSS = 713.10;
	    }
 	    
// 	    System.out.print(descontoINSS);
 	    return Math.round(descontoINSS * 100.0) / 100.0;
	}
	
	private Double calcularIRRF(Funcionario funcionario, Double inss) { 
		Double salario = funcionario.getSalarioBruto() - inss;
	    Double irrf = 0.0;

	    if (salario > 1903.98 && salario <= 2826.65) {
	        irrf = salario * 0.075 - 142.80; 
	    } else if (salario > 2826.65 && salario <= 3751.05) {
	        irrf = salario * 0.15 - 354.80;
	    } else if (salario > 3751.05 && salario <= 4664.68) {
	        irrf = salario * 0.225 - 636.13;
	    } else if (salario > 4664.68) {
	        irrf = salario * 0.275 - 869.36;
	    }

	    return Math.round(irrf * 100.0) / 100.0;
	} 	
  

}
