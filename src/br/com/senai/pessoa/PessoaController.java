package br.com.senai.pessoa;

import java.util.List;
import java.util.Scanner;

public class PessoaController {

	private Scanner in;

	public PessoaController() {
		in = new Scanner(System.in);
	}

	public void menuPessoa(List<Pessoa> pessoas) {
		System.out.println("\n------- MENU PESSOA -------");
		System.out.println("1 - Cadastrar pessoa");
		System.out.println("2 - Listar pessoas");
		System.out.println("3 - Editar pessoa");
		System.out.println("4 - Excluir pessoa");
		System.out.println("--------------------");

		System.out.print("> ");
		int opcao = in.nextInt();

		switch (opcao) {
			case 1:
				pessoas.add(cadastrarPessoa());
				break;

			case 2:
				listarPessoas(pessoas);
				break;

			case 3:
				editarPessoa(pessoas);
				break;

			case 4:
				excluirPessoa(pessoas);
				break;

			default:
				System.out.println("\nOp��o Inv�lida!");
		}
	}

	public Pessoa cadastrarPessoa() {
		Pessoa pessoa = new Pessoa();

		System.out.println("\n--- CADASTRAR PESSOA ---");

		System.out.print("Informe o nome: ");
		pessoa.setNome(in.next());

		System.out.print("Informe o ano de nascimento: ");
		pessoa.setAnoNascimento(in.nextInt());

		System.out.print("Informe a altura: ");
		pessoa.setAltura(in.nextDouble());
		/*
		 * System.out.print("Informe o pais: "); in.nextLine();
		 * pessoa.setNomePais(in.nextLine());
		 * 
		 * System.out.print("Informe a sigla do pais: ");
		 * pessoa.setSiglaPais(in.nextLine());
		 * 
		 * System.out.print("Informe o nome do estado: ");
		 * pessoa.setNomeEstado(in.nextLine());
		 * 
		 * System.out.print("Informe a sigla do estado: ");
		 * pessoa.setSiglaEstado(in.nextLine());
		 * 
		 * System.out.print("Informe o nome da cidade: ");
		 * pessoa.setNomeCidade(in.nextLine());
		 * 
		 * System.out.print("Informe o nome do bairro: ");
		 * pessoa.setNomeBairro(in.nextLine());
		 * 
		 * System.out.print("Informe o nome da rua: ");
		 * pessoa.setNomeRua(in.nextLine());
		 * 
		 * System.out.print("Informe o n�mero: "); pessoa.setNumero(in.nextInt());
		 * 
		 * System.out.print("Informe o complemento: "); in.nextLine();
		 * pessoa.setComplemento(in.nextLine());
		 */
		System.out.println("\nPessoa cadastrada");

		return pessoa;
	}

	public List<Pessoa> listarPessoas(List<Pessoa> pessoas) {

		if (pessoas.isEmpty()) {
			System.out.println("\nN�o possui pessoas cadastradas.");
			return null;
		}

		System.out.println("\n--- PESSOAS CADASTRADAS ---");

		System.out.printf(
				"| %2s | %12s | %4s | %5s | %6s | %6s | %10s | %14s | %12s | %14s | %14s | %17s | %6s | %14s |\n", "Id",
				"Nome", "Ano", "Idade", "Altura", "Pais", "Sigla Pais", "Estado", "Sigla Estado", "Nome Cidade",
				"Nome Bairro", "Nome Rua", "N�mero", "Complemento");

		for (int i = 0; i < pessoas.size(); i++) {
			System.out.printf(
					"| %2d | %12s | %4d | %5d | %6.2f | %6s | %10s | %14s | %12s | %14s | %14s | %17s | %6d | %14s |\n",
					i + 1, pessoas.get(i).getNome(), pessoas.get(i).getAnoNascimento(), pessoas.get(i).getIdade(),
					pessoas.get(i).getAltura(), pessoas.get(i).getNomePais(), pessoas.get(i).getSiglaPais(),
					pessoas.get(i).getNomeEstado(), pessoas.get(i).getSiglaEstado(), pessoas.get(i).getNomeCidade(),
					pessoas.get(i).getNomeBairro(), pessoas.get(i).getNomeRua(), pessoas.get(i).getNumero(),
					pessoas.get(i).getComplemento());
		}

		return pessoas;
	}

	public List<Pessoa> editarPessoa(List<Pessoa> pessoas) {

		Pessoa pessoa = new Pessoa();

		listarPessoas(pessoas);

		if (pessoas.isEmpty()) {
			return null;
		}

		System.out.print("\nInforme o Id da pessoa para editar: ");
		int idPessoa = in.nextInt() - 1;

		System.out.println("\n1) Editar o nome da pessoa");
		System.out.println("2) Editar o ano de nascimento");
		System.out.println("3) Editar a altura");
		System.out.println("4) Editar o nome do pais");
		System.out.println("5) Editar a sigla do pais");
		System.out.println("6) Editar o nome do estado");
		System.out.println("7) Editar a sigla do estado");
		System.out.println("8) Editar o nome da cidade");
		System.out.println("9) Editar o nome do bairro");
		System.out.println("10) Editar o nome da rua");
		System.out.println("11) Editar o n�mero da casa");
		System.out.println("12) Editar o complemento");

		System.out.print("\nInforme o campo para ser editado: ");
		int opcao = in.nextInt();
		in.nextLine();

		switch (opcao) {
			case 1:
				System.out.println("\n--- EDITAR O NOME DA PESSOA ---");

				System.out.print("Informe o novo nome da pessoa: ");
				pessoa.setNome(in.next());

				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nNome alterado!");
				break;

			case 2:
				System.out.println("\n--- EDITAR O ANO DE NASCIMENTO DA PESSOA ---");

				System.out.print("Informe o novo ano de nascimento da pessoa: ");
				pessoa.setAnoNascimento(in.nextInt());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nAno de nascimento alterado!");
				break;

			case 3:
				System.out.println("\n--- EDITAR A ALTURA DA PESSOA ---");

				System.out.print("Informe a nova altura da pessoa: ");
				pessoa.setAltura(in.nextDouble());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nAltura alterada!");
				break;

			case 4:
				System.out.println("\n--- EDITAR O NOME DO PAIS DA PESSOA ---");

				System.out.print("Informe o novo nome do pais da pessoa: ");
				pessoa.setNomePais(in.next());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nPais alterado!");
				break;

			case 5:
				System.out.println("\n--- EDITAR A NOVA SIGLA DO PAIS DA PESSOA ---");

				System.out.print("Informe a nova sigla do pais da pessoa: ");
				pessoa.setSiglaPais(in.next());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nSigla alterada!");
				break;

			case 6:
				System.out.println("\n--- EDITAR O NOME DO ESTADO DA PESSOA ---");

				System.out.print("Informe o novo nome do estado da pessoa: ");
				pessoa.setNomeEstado(in.nextLine());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nEstado alterado!");
				break;

			case 7:
				System.out.println("\n--- EDITAR A SIGLA DO ESTADO DA PESSOA ---");

				System.out.print("Informe a nova sigla do estado da pessoa: ");
				pessoa.setSiglaEstado(in.next());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nSigla alterada!");
				break;

			case 8:
				System.out.println("\n--- EDITAR O NOME DA CIDADE DA PESSOA ---");

				System.out.print("Informe o novo nome da cidade da pessoa: ");
				pessoa.setNomeCidade(in.nextLine());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nCidade alterada!");
				break;

			case 9:
				System.out.println("\n--- EDITAR O NOME DO BAIRRO DA PESSOA ---");

				System.out.print("Informe o novo nome do bairro da pessoa: ");
				pessoa.setNomeBairro(in.nextLine());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nBairro alterado!");
				break;

			case 10:
				System.out.println("\n--- EDITAR O NOME DA RUA DA PESSOA ---");

				System.out.print("Informe o novo nome da rua da pessoa: ");
				pessoa.setNomeRua(in.nextLine());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nRua alterada!");
				break;

			case 11:
				System.out.println("\n--- EDITAR O N�MERO DA CASA DA PESSOA ---");

				System.out.print("Informe o novo n�mero da casa da pessoa: ");
				pessoa.setNumero(in.nextInt());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setComplemento(pessoas.get(idPessoa).getComplemento());

				System.out.println("\nN�mero alterado!");
				break;

			case 12:
				System.out.println("\n--- EDITAR O COMPLEMENTO DA PESSOA ---");

				System.out.print("Informe o novo complemento da pessoa: ");
				pessoa.setComplemento(in.nextLine());

				pessoa.setNome(pessoas.get(idPessoa).getNome());
				pessoa.setAnoNascimento(pessoas.get(idPessoa).getAnoNascimento());
				pessoa.setAltura(pessoas.get(idPessoa).getAltura());
				pessoa.setNomePais(pessoas.get(idPessoa).getNomePais());
				pessoa.setSiglaPais(pessoas.get(idPessoa).getSiglaPais());
				pessoa.setNomeEstado(pessoas.get(idPessoa).getNomeEstado());
				pessoa.setSiglaEstado(pessoas.get(idPessoa).getSiglaEstado());
				pessoa.setNomeCidade(pessoas.get(idPessoa).getNomeCidade());
				pessoa.setNomeBairro(pessoas.get(idPessoa).getNomeBairro());
				pessoa.setNomeRua(pessoas.get(idPessoa).getNomeRua());
				pessoa.setNumero(pessoas.get(idPessoa).getNumero());

				System.out.println("\nComplemento alterado!");
				break;

			default:
				System.out.println("Op��o Inv�lida!");
				break;
		}

		pessoas.set(idPessoa, pessoa);

		return pessoas;

	}

	public void excluirPessoa(List<Pessoa> pessoas) {

		listarPessoas(pessoas);

		if (pessoas.isEmpty()) {
			return;
		}

		System.out.println("\n--- EXCLUIR PESSOA ---");

		System.out.print("\nInforme o Id da pessoa para excluir: ");
		int idPessoa = in.nextInt() - 1;

		if (pessoas.size() <= idPessoa) {
			System.out.println("\nPessoa n�o cadastrado.");

			return;
		}

		pessoas.remove(idPessoa);

		System.out.println("\nPessoa excluída!");

	}

}
