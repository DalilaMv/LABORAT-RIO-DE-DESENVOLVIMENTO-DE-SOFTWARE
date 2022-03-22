import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Pessoa {
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Curso> cursoMatriculado = new ArrayList<>();
    private ArrayList<Disciplina> disciplinasMatriculadasObrigatorias = new ArrayList<>();
    private ArrayList<Disciplina> disciplinasMatriculadasOpcionais = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void MatricularEmDisciplina(int idDisciplina){
        int leitor;
        Disciplina disciplinaEscolhida;
        System.out.println("Digite o ID da disciplina desejada para realizar a matrícula.");

        this.disciplinas.stream()
            .forEach(disciplina -> System.out.println(disciplina.getNome() + "-" + disciplina.getDisciplinaid()));
        
        leitor = sc.nextInt();

        disciplinaEscolhida = (Disciplina) this.disciplinas.stream()
            .filter(disciplina -> disciplina.getDisciplinaid() == leitor);

        disciplinaEscolhida.setAlunosMatriculados(this);

        System.out.println("Disciplina matriculada com sucesso!");
    }


    public void cancelarEmDiscplina(int idDisciplina){
        int leitor;
        Disciplina disciplinaEscolhida;
        System.out.println("Digite o ID da disciplina desejada para cancelar a matrícula.");
        this.disciplinas.stream()
            .forEach(disciplina -> System.out.println(disciplina.getNome() + "-" + disciplina.getDisciplinaid()));

        leitor = sc.nextInt();

        disciplinaEscolhida = (Disciplina) this.disciplinas.stream()
            .filter(disciplina -> disciplina.getDisciplinaid() == leitor);

        disciplinaEscolhida.cancelarMatricula(this);

        System.out.println("Matricula cancelada com sucesso!");
    }

    @Override
    public boolean fazerLogin(String senha, int matricula) {
        ConexaoSQLite c = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(c);
        boolean is_registered = criarBancoSQLite.login(senha, matricula, 2);
        return is_registered;
    }
    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getCPF(){
        return this.CPF;
    }

    @Override
    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    @Override
    public String getSenhaSistema(){
        return this.senhaSistema;
    }

    @Override
    public void setSenhaSistema(String senhaSistema) {
        this.senhaSistema = senhaSistema;
    }


    @Override
    public int getMatricula(){
        return this.matricula;
    }

    @Override
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }


    @Override
    public int getTipo() {
        return this.tipo;
    };

    @Override
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}