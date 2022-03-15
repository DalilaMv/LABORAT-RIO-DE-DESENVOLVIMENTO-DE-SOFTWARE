import java.util.ArrayList;

public class Disciplina{
    private String nome;
    private ArrayList<Curso> cursosAssocidos = new ArrayList<>();
    private int cargaHoraria;
    private boolean obrigatoria;
    private int qtdAlunosMatriculados;
    private boolean matriculasAbertas;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public String setCurso(Curso cursosAssocidos){
        this.cursosAssocidos = cursosAssocidos;
    }
    public Curso getCurso(){
        return this.nome;
    }
    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    public int getCargaHoraria(){
        return this.cargaHoraria;
    }
    public void setObrigatoria(boolean obrigatoria){
        this.obrigatoria = obrigatoria;
    }
    public boolean getObrigatoria(){
        return this.obrigatoria;
    }
    public void setQtdAlunosMatriculados(int qtdAlunosMatriculados){
        this.qtdAlunosMatriculados = qtdAlunosMatriculados;
    }
     public int getQtdAlunosMatriculados(){
        return this.qtdAlunosMatriculados;
    }
    public void setMatriculasAbertas(boolean matriculasAbertas){
        this.matriculasAbertas = matriculasAbertas;
    }
    public boolean getMatriculasAbertas(){
        return this.matriculasAbertas;
    }
    public void setAluno(Disciplina alunos){
        this.alunos = alunos;
    }
    public String getAluno(){
        return this.alunos;
    }
    public Aluno getAlunosMatriculados(){
        return this.alunos.stream()
                .map(Aluno::getCursoMatriculado)
                .sum();
    }
}