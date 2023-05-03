package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	// método para realizar um fluxo de cadastro de clientes
	public void cadastrarCliente() {

		System.out.println("\n*** CADASTRO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		try {

			Cliente cliente = new Cliente();

			System.out.print("INFORME O NOME.........: ");
			cliente.setNome(scanner.nextLine());

			System.out.print("INFORME O EMAIL........: ");
			cliente.setEmail(scanner.nextLine());

			System.out.print("INFORME O TELEFONE.....: ");
			cliente.setTelefone(scanner.nextLine());

			System.out.print("INFORME O CPF..........: ");
			cliente.setCpf(scanner.nextLine());

			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);

			System.out.println("\nCliente cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar cliente: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	public void atualizarCliente() {

		System.out.println("\n *** ATUALIZACAO DE CLIENTE *** \n");
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.print("INFORME O ID DO CLIENTE: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			if (cliente != null) {

				System.out.print("ALTERE O NOME.......: ");
				cliente.setNome(scanner.nextLine());

				System.out.print("ALTERE O EMAIL.......: ");
				cliente.setEmail(scanner.nextLine());

				System.out.print("ALTERE O CPF.......:  ");
				cliente.setCpf(scanner.nextLine());

				System.out.print("ALTERE O TELEFONE.......: ");
				cliente.setTelefone(scanner.nextLine());

				clienteRepository.update(cliente);
				System.out.println("\nCliente atualizado com sucesso!");

			} else {
				System.out.println("\nCliente não encontrado!");
			}

		} catch (Exception e) {

			System.out.println("\nFalha ao Atualizar cliente: " + e.getMessage());

		} finally {
			scanner.close();
		}
	}

	public void excluirCliente() {
		System.out.println("\n*** EXCLUSÃO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.print("INFORME O ID DO CLIENTE: ");
			Integer idCliente = Integer.parseInt(scanner.nextLine());

			// buscando o cliente no banco de dados através do id
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);

			// verificando se o cliente foi encontrado
			if (cliente != null) {

				// excluindo o cliente
				clienteRepository.delete(cliente);

				System.out.println("\nCliente excluído com sucesso.");
			} else {
				System.out.println("\nCliente não encontrado.");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao excluir cliente: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	// método para realizar um fluxo de consulta de clientes
	public void consultarClientes() {

		System.out.println("\n*** CONSULTA DE CLIENTES ***\n");

		try {

			ClienteRepository clienteRepository = new ClienteRepository();
			List<Cliente> lista = clienteRepository.findAll();

			// for each
			for (Cliente cliente : lista) {

				// imprimindo os dados de cada cliente
				System.out.println("ID DO CLIENTE....: " + cliente.getIdCliente());
				System.out.println("NOME.............: " + cliente.getNome());
				System.out.println("EMAIL............: " + cliente.getEmail());
				System.out.println("TELEFONE.........: " + cliente.getTelefone());
				System.out.println("CPF..............: " + cliente.getCpf());
				System.out.println("..");
			}

			System.out.println("\nQuantidade de clientes obtidos: " + lista.size());
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar clientes: " + e.getMessage());
		}
	}

}
