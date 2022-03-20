import java.util.ArrayList;

public class Aluno extends Pessoa {
    private ArrayList<Curso> cursoMatriculado = new ArrayList<>();
    private ArrayList<Disciplina> disciplinasMatriculadasObrigatorias = new ArrayList<>();
    private ArrayList<Disciplina> disciplinasMatriculadasOpcionais = new ArrayList<>();
    private Semestre semestreAtual;
    public void MatricularEmDisciplina(int idDisciplina){}
    public void cancelarEmDiscplina(int idDisciplina){}

    @Override
    public boolean fazerLogin(String senha, int matricula) {
        // TODO Auto-generated method stub
        return true;
    }

}