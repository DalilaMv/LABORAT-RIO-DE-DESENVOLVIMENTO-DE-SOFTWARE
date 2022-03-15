
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int option = 0;
				Scanner teclado = new Scanner(System.in);
        String lixo;
        int tipo_login;
        int matricula;
        String senha;

				ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

				// chama o metodo de criar tabelas
        CriarTabelas criarTabelas = new CriarTabelas(conexaoSQLite);
				criarTabelas.criarTabelaPessoa();

        do{
            System.out.println("");
						System.out.println("*-- SELECIONE UMA OPCAO --*");
						System.out.println("[1] - Fazer Login");
						System.out.println("[0] - Sair.");
						System.out.print("-> ");
            try{
							option = teclado.nextInt();
							System.out.println("");
						}catch(InputMismatchException e){
							lixo = teclado.nextLine();
							System.out.println("--------------------------------------------");
							System.out.println("**Valor invalido!");
							System.out.println("--------------------------------------------");
						}
            switch(option){
				case 1:
					lixo = teclado.nextLine();

					// conecta no banco de dados
					conexaoSQLite.conectar();

					System.out.println("Tipo de usuário (digite uma opção):");
					System.out.println("[1] - Professor");
					System.out.println("[2] - Aluno");
					System.out.println("[3] - Secretaria");
					tipo_login = teclado.nextInt();
					System.out.print("-> ");

					System.out.println("Número de matrícula:");
					System.out.print("-> ");
					matricula = teclado.nextInt();

					System.out.println("Senha:");
					System.out.print("-> ");
					senha = teclado.next();

					break;
				case 0:
				  // desconecta do banco
          conexaoSQLite.desconectar();
					break;
				default:
					System.out.println("--------------------------------------------");
					System.out.println("**Opcao Invalida!");
					System.out.println("--------------------------------------------");
					break;
			}
        }while(option!=0);
    }
}
