
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		int option = 0;
		String lixo;
		Scanner teclado = new Scanner(System.in);
		int tipo_login;
		int matricula;
		String senha;
		boolean verify;
		int secretaria_opt;
		int aluno_opt;
		int prof_opt;
		int secretaria2_opt;

		
		do{
			System.out.println("");
			System.out.println("*----------- SELECIONE UMA OPCAO -----------*");
			System.out.println("[1] - Fazer Login");
			System.out.println("[0] - Sair.");
			System.out.println("*-------------------------------------------*");
			System.out.print("> ");
			try{
				option = teclado.nextInt();
				System.out.println("");
			}catch(InputMismatchException e){

				lixo = teclado.nextLine();
				System.out.println("--------------------------------------------");
				System.out.println("**Opcao invalida!");
				System.out.println("--------------------------------------------");

			}
			switch(option){

				case 1:
					lixo = teclado.nextLine();
					System.out.println("Tipo de usuário (digite uma opção):");
					System.out.println("[1] - Secretária");
					System.out.println("[2] - Aluno");
					System.out.println("[3] - Professor");
					tipo_login = teclado.nextInt();
					System.out.print(">");
					System.out.println("Número de matrícula:");
					System.out.print(">");
					matricula = teclado.nextInt();
					System.out.println("Senha:");
					System.out.print(">");
					senha = teclado.next();
					if (tipo_login == 1) {
						Secretaria s = new Secretaria();
						verify = s.fazerLogin(senha, matricula);
						if (verify == true) {
							do {	
								System.out.println("*----------- SELECIONE UMA OPCAO -----------*");
								System.out.println("[1] - Cadastrar usuário.");
								System.out.println("[2] - Gerar relatório de Alunos.");
								System.out.println("[3] - Gerar relatório de Professores.");
								System.out.println("[4] - Gerar currículo do Semestre.");
								System.out.println("[5] - Sair.");
								System.out.println("*-------------------------------------------*");
								secretaria_opt = teclado.nextInt();

								switch(secretaria_opt){
									case 1:
									  // metodo de cadastrar usuario
										do {
											System.out.println("*----------- SELECIONE UMA OPCAO -----------*");
											System.out.println("[1] - Cadastrar aluno.");		
											System.out.println("[2] - Cadastrar professor.");
											System.out.println("[3] - Voltar.");
											System.out.println("*-------------------------------------------*");
											secretaria2_opt = teclado.nextInt();
											String nome;
											int cpf;
											String senhasis;

											switch(secretaria2_opt){
												case 1:
													System.out.println("*----------- CADASTRAR ALUNO -----------*");
													System.out.println("Nome do aluno:");
													System.out.print(">");
													nome = teclado.next();
													System.out.println("CPF:");
													System.out.print(">");
													cpf = teclado.nextInt();
													System.out.println("Senha para acessar o sistema:");
													System.out.print(">");
													senhasis = teclado.next();
													s.criarPessoa(nome, cpf, senhasis, 2);
													break;
												case 2:
													System.out.println("*----------- CADASTRAR PROFESSOR -----------*");
													System.out.println("Nome do professor:");
													System.out.print(">");
													nome = teclado.next();
													System.out.println("CPF:");
													System.out.print(">");
													cpf = teclado.nextInt();
													System.out.println("Senha para acessar o sistema:");
													System.out.print(">");
													senhasis = teclado.next();
													s.criarPessoa(nome, cpf, senhasis, 3);
												break;
												default:
													System.out.println("--------------------------------------------");
													System.out.println("**Opcao Invalida!");
													System.out.println("--------------------------------------------");
												break;
											}
										}while(secretaria2_opt!=3);
									break;
									case 2:
										//metodo de gerar relatorio de alunos(tipo 2)
										s.gerarRelatorio(2);
									break;
									case 3:
										//metodo de gerar relatorio de alunos(tipo 3)
										s.gerarRelatorio(3);
									break;
									case 4:
										int semestre_opt;
										do {
											System.out.println("*----------- SELECIONE UMA OPCAO -----------*");
											System.out.println("[1] - Cadastrar disciplina.");
											System.out.println("[2] - Cadastrar curso.");
											System.out.println("[3] - Cadastrar nova oferta.");
											System.out.println("[4] - Voltar.");
											semestre_opt = teclado.nextInt();
											switch(secretaria_opt){
												case 1:
													break;
												case 2:
													break;
												case 3:
													break;
												case 4:
													break;
												default:
													System.out.println("--------------------------------------------");
													System.out.println("**Opcao Invalida!");
													System.out.println("--------------------------------------------");
													break;
											}
										} while (semestre_opt!=4)	;

									break;
									case 5:
										break;
									default:
										System.out.println("--------------------------------------------");
										System.out.println("**Opcao Invalida!");
										System.out.println("--------------------------------------------");
										break;
								}

							}while(secretaria_opt!=5);
						} else {
							System.out.println("");
							System.out.println("Senha e/ou matricula incorreta!!!");
						}
					} else if (tipo_login == 2) {
						Aluno a = new Aluno();
						verify = a.fazerLogin(senha, matricula);
						if (verify == true) {
							do {
								System.out.println("*----------- SELECIONE UMA OPCAO -----------*");
								System.out.println("[1] - Matricular em disciplina.");
								System.out.println("[2] - Cancelar matricula em disciplina.");
								System.out.println("[3] - Sair.");
								System.out.println("*-------------------------------------------*");
								aluno_opt= teclado.nextInt();
								switch(aluno_opt){
									case 1:
										//chama metodo de matricula em disciplina
										break;
									case 2:
										//chama metodo de cancelar matricula
										break;
									case 3:
										break;
									default:
										System.out.println("--------------------------------------------");
										System.out.println("**Opcao Invalida!");
										System.out.println("--------------------------------------------");
										break;
								}
							}while(aluno_opt!=3);
						} else {
							System.out.println("");
							System.out.println("Senha e/ou matricula incorreta!!!");
						}
					} else if (tipo_login == 3) {
						Professor p = new Professor();
						verify = p.fazerLogin(senha, matricula);
						if (verify == true) {
							do {
								System.out.println("*----------- SELECIONE UMA OPCAO -----------*");
								System.out.println("[1] - Visualizar alunos matriculados em disciplina");
								System.out.println("[2] - Sair.");
								System.out.println("*-------------------------------------------*");
								prof_opt= teclado.nextInt();
								switch(prof_opt){
									case 1:
										//chama metodo de visualizar alunos matriculados em determinada disciplina
										break;
									case 2:
										break;
									default:
										System.out.println("--------------------------------------------");
										System.out.println("**Opcao Invalida!");
										System.out.println("--------------------------------------------");
										break;
								}
							}while(prof_opt!=2);
						
						} else {
							System.out.println("");
							System.out.println("Senha e/ou matricula incorreta!!!");
						}
					} else {
						System.out.println("--------------------------------------------");
						System.out.println("**Opção Invalida!");
						System.out.println("--------------------------------------------");
						break;
					}
					break;
				case 0:
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
