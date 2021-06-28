package br.com.senai.loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class VendaController {
	private Scanner in;
	private ProdutoController produtoController;
	private PessoaController pessoaController;
	private List<Venda> vendas = new ArrayList<Venda>();

	public VendaController() {
		in = new Scanner(System.in);
		produtoController = new ProdutoController();
		pessoaController = new PessoaController();
	}

	public void menuVenda(List<Pessoa> pessoas, List<Produto> produtos) {
		System.out.println("\n------- MENU VENDA -------");
		System.out.println("1 - Cadastrar venda");
		System.out.println("2 - Listar vendas");
		System.out.println("--------------------");

		System.out.print("> ");
		int opcao = in.nextInt();

		switch (opcao) {
			case 1:
				vendas.add(cadastrarVenda(produtos, pessoas));
				break;

			case 2:
				listarVenda(vendas);
				break;

			default:
				System.out.println("\nOp��o Inv�lida");
		}
	}

	public Venda cadastrarVenda(List<Produto> produtos, List<Pessoa> pessoas) {

		if (produtos.isEmpty() || pessoas.isEmpty()) {
			System.out.println("\nImpossível realizar vendas sem PRODUTOS ou PESSOAS cadastradas.");
			return null;
		}

		pessoaController.listarPessoas(pessoas);
		produtoController.listarProdutos(produtos);

		Venda venda = new Venda();
		Produto produto = new Produto();
		Pessoa pessoa = new Pessoa();

		System.out.print("\nInforme o Id da pessoa: ");
		int idPessoa = in.nextInt() - 1;

		pessoa.setNome(pessoas.get(idPessoa).getNome());
		pessoa.setAltura(pessoas.get(idPessoa).getAltura());
		pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());

		venda.setPessoa(pessoa);

		System.out.print("Informe o Id do produto: ");
		int idProduto = in.nextInt() - 1;

		produto.setNomeDoProduto(produtos.get(idProduto).getNomeDoProduto());
		produto.setQuantidadeDoProduto(produtos.get(idProduto).getQuantidadeDoProduto());
		produto.setValorUnitarioDoProduto(produtos.get(idProduto).getValorUnitarioDoProduto());
		produto.setValorTotalDoProduto(produtos.get(idProduto).getValorTotalDoProduto());

		venda.setProduto(produto);

		System.out.print("Informe a quantidade desejada: ");
		venda.setQuantidade(in.nextInt());

		venda.setValor(produto.getValorUnitarioDoProduto() * venda.getQuantidade());

		System.out.println("\nVenda cadastrada!");

		return venda;
	}

	public List<Venda> listarVenda(List<Venda> vendas) {

		System.out.println("\n--- VENDAS REALIZADAS ---");

		System.out.printf("| %10s | %10s | %4s | %6s\n", "Cliente", "Produto", "Qtd", "Valor");

		for (int i = 0; i < vendas.size(); i++) {
			System.out.printf("| %10s | %10s | %4d | %6.2f |\n", vendas.get(i).getPessoa().getNome(),
					vendas.get(i).getProduto().getNomeDoProduto(), vendas.get(i).getQuantidade(),
					vendas.get(i).getValor());
		}

		return vendas;
	}

}
