package br.com.senai.pessoa;

import java.util.Calendar;

import br.com.senai.endereco.Endereco;

// Classe
public class Pessoa extends Endereco {

	// Atributos
	private String nome;
	private int anoNascimento;
	private int idade;
	private double altura;

	// Métodos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
		setIdade();
	}

	public int getIdade() {
		return idade;
	}

	private void setIdade() {
		Calendar calendar = Calendar.getInstance();

		this.idade = calendar.get(Calendar.YEAR) - getAnoNascimento();
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
