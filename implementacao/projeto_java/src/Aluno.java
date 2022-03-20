import java.util.ArrayList;

public class Aluno extends Pessoa {
    private ArrayList<Curso> cursoMatriculado = new ArrayList<>();
    private ArrayList<Disciplina> disciplinasMatriculadasObrigatorias = new ArrayList<>();
    private ArrayList<Disciplina> disciplinasMatriculadasOpcionais = new ArrayList<>();

    public void MatricularEmDisciplina(int idDisciplina){}
    public void cancelarEmDiscplina(int idDisciplina){}

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