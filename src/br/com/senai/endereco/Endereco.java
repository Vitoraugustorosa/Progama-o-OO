package br.com.senai.endereco;

public class Endereco extends Cidade {

	private String nomeBairro;
	private String nomeRua;
	private int numero;
	private String complemento;

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numeroCasa) {
		this.numero = numeroCasa;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
