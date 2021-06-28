package br.com.senai.produto;

public class Produto {

	private String nomeDoProduto;
	private double valorUnitarioDoProduto;
	private double valorTotalDoProduto;
	private int quantidadeDoProduto;

	public Produto() {
	}

	public Produto(String nomeDoProduto, double valorUnitarioDoProduto, int quantidadeDoProduto, double valorTotalDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
		this.valorUnitarioDoProduto = valorUnitarioDoProduto;
		this.valorTotalDoProduto = valorTotalDoProduto;
		this.quantidadeDoProduto = quantidadeDoProduto;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public double getValorUnitarioDoProduto() {
		return valorUnitarioDoProduto;
	}

	public void setValorUnitarioDoProduto(double valorUnitarioDoProduto) {
		this.valorUnitarioDoProduto = valorUnitarioDoProduto;
	}

	public double getValorTotalDoProduto() {
		return valorTotalDoProduto;
	}

	public void setValorTotalDoProduto(double valorTotalDoProduto) {
		this.valorTotalDoProduto = valorTotalDoProduto;
	}

	public int getQuantidadeDoProduto() {
		return quantidadeDoProduto;
	}

	public void setQuantidadeDoProduto(int quantidadeDoProduto) {
		this.quantidadeDoProduto = quantidadeDoProduto;
	}

}
