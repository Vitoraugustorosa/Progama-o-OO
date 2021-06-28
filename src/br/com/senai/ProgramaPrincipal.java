package br.com.senai;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.loja.VendaController;
import br.com.senai.pessoa.Pessoa;
import br.com.senai.pessoa.PessoaController;
import br.com.senai.produto.Produto;
import br.com.senai.produto.ProdutoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList<>();
		List<Produto> produtos = new ArrayList<Produto>();

		Menu menu = new Menu();
		PessoaController pessoaController = new PessoaController();
		ProdutoController produtoController = new ProdutoController();
		VendaController vendaController = new VendaController();

		boolean sair = false;

		do {
			menu.menuPrincipal();

			int opcao = menu.leOpcao();

			switch (opcao) {
				case 1:
					pessoaController.menuPessoa(pessoas);
					break;

				case 2:
					produtoController.menuProduto(produtos);
					break;

				case 3:
					vendaController.menuVenda(pessoas, produtos);
					break;

				case 0:
					sair = true;
					break;

				default:
					System.out.println("\nOpção inválida!");
			}

		} while (!sair);

		System.out.println("\nSistema finalizado!");

	}

}
