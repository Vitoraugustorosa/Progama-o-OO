package br.com.senai;

import java.util.Scanner;

public class Menu {
	
	private Scanner in = new Scanner(System.in);

	public int leOpcao() {
		System.out.print("> ");
		return in.nextInt();
	}
	
	public void menuPrincipal() {
		System.out.println("\n------- MENU PRINCIPAL -------");
		System.out.println("1 - Registro Pessoa");
		System.out.println("2 - Registro Produto");
		System.out.println("3 - Registro Venda");
		System.out.println("0 - Sair do sistema");
		System.out.println("--------------------");
	}
	
}