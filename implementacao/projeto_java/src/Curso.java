public class Curso{
    private String name;
    private int qtdSemestres;
    private int idCurso;
    private int qtdCreditos;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setQtdSemestres(int qtdSemestres){
        this.qtdSemestres = qtdSemestres;
    }
    public int getQtdSemestres(){
        return this.qtdSemestres;
    }
    public void setIdCurso(int idCurso){
        this.idCurso = idCurso;
    }
     public int getIdCurso(){
        return this.idCurso;
    }
    public void setQtdCreditos(int qtdCreditos){
        this.qtdCreditos = qtdCreditos;
    }
     public int getQtdCreditos(){
        return this.qtdCreditos;
    }
    public void gerarRelatorioCurso(int idCurso){
        System.out.println("Nome: " + this.name+ "\n" + "Quantidade de Semestres: " + this.qtdSemestres + 
        "Quantidade de Créditos:" +this.qtdCreditos);
    }
}