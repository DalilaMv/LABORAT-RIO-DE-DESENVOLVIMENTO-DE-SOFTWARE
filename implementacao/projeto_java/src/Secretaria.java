public class Secretaria{
    private ArrayList<Curso> cursos = new ArrayList<>();
    public void setCursos(Curso cursos){
        this.cursos = cursos;
    }
    public String getCursos(){
        return this.cursos;
    }
    public void gerarCurriculoSemestre(int idDisciplina){
        System.out.printl "Cursos: " + this.cursos.stream()
                                                  .filter(item -> item.getIdCurso() == idDisciplina)
                                                  .collect(Collectors.toList());
    }
}