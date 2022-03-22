import java.util.ArrayList;

public class Disciplina{
    private String nome;
    private String tipo;
    private int disciplinaid;

    //    foreign key
    private int curso;


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

//    public Aluno getAlunosMatriculados(){
//        return this.alunos.stream()
//                .map(Aluno::getCursoMatriculado)
//                .sum();
//    }
}