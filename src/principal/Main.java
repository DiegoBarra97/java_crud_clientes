package principal;

import java.util.Scanner;

import controllers.ClienteController;

public class Main {

	public static void main(String[] args) {

		/*executando o cadastro do cliente
		ClienteController clienteController = new ClienteController();
		clienteController.cadastrarCliente();*/
		
		ClienteController clienteController = new ClienteController();
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("(1) CADASTRAR CLIENTES");
			System.out.println("(2) ATUALIZAR CLIENTES");
			System.out.println("(3) EXCLUIR CLIENTES");
			System.out.println("(4) CONSULTAR TODOS OS CLIENTES");
			
			System.out.println("\nInforme a opção desejada..: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			
			switch(opcao) {
			case 1:
				clienteController.cadastrarCliente();
				break;
				
			case 2:
				clienteController.atualizarCliente();
				break;
				
			case 3:
				clienteController.excluirCliente();
				break;
				
			case 4:
				clienteController.consultarClientes();
				break;
				
			default:
				System.out.println("\nOpção Inválida!");
				break;
				
				
			}

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			scanner.close();
		}
			
		}

}
