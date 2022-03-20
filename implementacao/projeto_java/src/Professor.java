import java.util.ArrayList;

public class Professor extends Pessoa {
    private ArrayList<Disciplina> disciplinasLecionadas = new ArrayList<>();
    public void setDisciplina(ArrayList<Disciplina> disciplinasLecionadas){
        this.disciplinasLecionadas = disciplinasLecionadas;
    }
    public ArrayList<Disciplina> getDisciplina(){
        return this.disciplinasLecionadas;
    }


    @Override
    public boolean fazerLogin(String senha, int matricula) {
        ConexaoSQLite c = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(c);
        boolean is_registered = criarBancoSQLite.login(senha, matricula, 3);
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