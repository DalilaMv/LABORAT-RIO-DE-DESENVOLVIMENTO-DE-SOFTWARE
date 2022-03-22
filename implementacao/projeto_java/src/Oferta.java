public class Oferta {

    private int semestre;
    private int ano;
    private int ofertaid;

    //   foreign keys
    private int disciplina;
    private int professor;



    public int getAno(){
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre(){
        return this.semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getDisciplina(){
        return this.disciplina;
    }

    public void setDisciplina(int disciplina) {
        this.disciplina = disciplina;
    }

    public int getProfessor(){
        return this.professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public int getOfertaid(){
        return this.professor;
    }

    public void setOfertaid(int ofertaid) {
        this.ofertaid = ofertaid;
    }


}
