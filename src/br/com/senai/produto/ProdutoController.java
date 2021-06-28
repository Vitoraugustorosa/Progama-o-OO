package br.com.senai.produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoController {

	private Scanner in;

	public ProdutoController() {
		in = new Scanner(System.in);
	}

	public void menuProduto(List<Produto> produtos) {
		System.out.println("\n------- MENU PRODUTO -------");
		System.out.println("1 - Adicionar produto");
		System.out.println("2 - Listar produto");
		System.out.println("3 - Editar produto");
		System.out.println("4 - Excluir produto");
		System.out.println("--------------------");

		System.out.print("> ");
		int opcao = in.nextInt();

		switch (opcao) {
			case 1:
				produtos.add(adicionarProduto());
				break;

			case 2:
				listarProdutos(produtos);
				break;

			case 3:
				editarProduto(produtos);
				break;

			case 4:
				excluirProduto(produtos);
				break;

			default:
				System.out.println("\nOp��o Inv�lida!");
				break;
		}
	}

	public Produto adicionarProduto() {
		Produto produto = new Produto();

		System.out.println("\n--- ADICIONAR PRODUTO ---");

		System.out.print("Informe o nome do produto: ");
		produto.setNomeDoProduto(in.next());

		System.out.print("Informe o valor unit�rio do produto: ");
		produto.setValorUnitarioDoProduto(in.nextDouble());

		System.out.print("Informe a quantidade do produto: ");
		produto.setQuantidadeDoProduto(in.nextInt());
		produto.setValorTotalDoProduto(produto.getValorUnitarioDoProduto() * produto.getQuantidadeDoProduto());

		System.out.println("\nProduto adicionado");

		return produto;
	}

	public List<Produto> listarProdutos(List<Produto> produtos) {

		if (produtos.isEmpty()) {
			System.out.println("\nN�o possui produtos cadastrados.");

			return null;
		}

		System.out.println("\n--- PRODUTOS ADICIONADOS ---");

		System.out.printf("| %2s | %4s | %14s | %10s | %11s |\n", "Id", "Nome", "Valor Unit�rio", "Quantidade",
				"Valor Total");

		for (int i = 0; i < produtos.size(); i++) {
			System.out.printf("| %2d | %4s | %14.2f | %10d | %11.2f |\n", i + 1, produtos.get(i).getNomeDoProduto(),
					produtos.get(i).getValorUnitarioDoProduto(), produtos.get(i).getQuantidadeDoProduto(),
					produtos.get(i).getValorTotalDoProduto());
		}

		return produtos;
	}

	public List<Produto> editarProduto(List<Produto> produtos) {

		Produto produto = new Produto();

		listarProdutos(produtos);

		if (produtos.isEmpty()) {
			return null;
		}

		System.out.print("\nInforme o Id do produto para editar: ");
		int idProduto = in.nextInt() - 1;

		System.out.println("\n1) Editar o nome do produto");
		System.out.println("2) Editar o valor unit�rio do produto");
		System.out.println("3) Editar a quantidade do produto");

		System.out.print("\nInforme o campo para ser editado: ");
		int opcao = in.nextInt();

		switch (opcao) {
			case 1:
				System.out.println("\n--- EDITAR O NOME O PRODUTO ---");

				System.out.print("Informe o novo nome do produto: ");
				produto.setNomeDoProduto(in.next());

				produto.setQuantidadeDoProduto(produtos.get(idProduto).getQuantidadeDoProduto());
				produto.setValorUnitarioDoProduto(produtos.get(idProduto).getValorUnitarioDoProduto());
				produto.setValorTotalDoProduto(produtos.get(idProduto).getValorTotalDoProduto());

				produtos.set(idProduto, produto);

				System.out.println("\nNome alterado!");
				break;

			case 2:
				System.out.println("\n--- EDITAR O VALOR UNIT�RIO DO PRODUTO ---");

				System.out.print("Informe o novo valor unit�rio do produto: ");
				produto.setValorUnitarioDoProduto(in.nextDouble());

				produto.setNomeDoProduto(produtos.get(idProduto).getNomeDoProduto());
				produto.setQuantidadeDoProduto(produtos.get(idProduto).getQuantidadeDoProduto());
				produto.setValorTotalDoProduto(produto.getValorUnitarioDoProduto() * produto.getQuantidadeDoProduto());

				produtos.set(idProduto, produto);

				System.out.println("\nValor unit�rio alterado!");
				break;

			case 3:
				System.out.println("\n--- EDITAR A QUANTIDADE DO PRODUTO ---");

				System.out.print("Informe a nova quantidade do produto: ");
				produto.setQuantidadeDoProduto(in.nextInt());

				produto.setNomeDoProduto(produtos.get(idProduto).getNomeDoProduto());
				produto.setValorUnitarioDoProduto(produtos.get(idProduto).getValorUnitarioDoProduto());
				produto.setValorTotalDoProduto(produto.getValorUnitarioDoProduto() * produto.getQuantidadeDoProduto());

				produtos.set(idProduto, produto);

				System.out.println("\nQuantidade alterada!");
				break;

			default:
				System.out.println("Op��o Inv�lida!");
				break;
		}

		return produtos;

	}

	public void excluirProduto(List<Produto> produtos) {

		listarProdutos(produtos);

		if (produtos.isEmpty()) {
			return;
		}

		System.out.println("\n--- EXCLUIR PRODUTO ---");

		System.out.print("\nInforme o Id do produto para excluir: ");
		int idProduto = in.nextInt() - 1;

		if (produtos.size() <= idProduto) {
			System.out.println("\nProduto n�o cadastrado.");

			return;
		}

		produtos.remove(idProduto);

		System.out.println("\nProduto excluído!");

	}

}
