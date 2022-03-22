import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Disciplina{
    private String nome;
    private String tipo;
    private int curso;
    private int disciplinaid;
    private boolean obrigatoria;
    private List<Aluno> alunosMatriculados = new LinkedList<Aluno>();


    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setDisciplinaid(int disciplinaid){
        this.disciplinaid = disciplinaid;
    }

    public int getDisciplinaid(){
        return this.disciplinaid;
    }


    public void setCurso(int curso){
        this.curso = curso;
    }

    public int getCurso(){
        return this.curso;
    }

    public void setAlunosMatriculados(Aluno aluno){
        alunosMatriculados.add(aluno);
    }

    public void cancelarMatricula(Aluno aluno){
        alunosMatriculados.remove(aluno);
    }

//    public Aluno getAlunosMatriculados(){
//        return this.alunosMatriculados.stream()
//                .map(Aluno::getCursoMatriculado)
//                .sum();
//    }
}