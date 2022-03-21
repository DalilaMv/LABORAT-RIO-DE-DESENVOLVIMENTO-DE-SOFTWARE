public class Curso{
    private String nome;
    private int qtdSemestres;
    private int cursoid;
    private int qtdCreditos;
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setQtdSemestres(int qtdSemestres){
        this.qtdSemestres = qtdSemestres;
    }
    public int getQtdSemestres(){
        return this.qtdSemestres;
    }
    public void setCursoid(int cursoid){
        this.cursoid = cursoid;
    }
     public int getCursoid(){
        return this.cursoid;
    }
    public void setQtdCreditos(int qtdCreditos){
        this.qtdCreditos = qtdCreditos;
    }
    public int getQtdCreditos(){
        return this.qtdCreditos;
    }
    public void gerarRelatorioCurso(int cursoid){
        System.out.println("Nome: " + this.nome+ "\n" + "Quantidade de Semestres: " + this.qtdSemestres + 
        "Quantidade de Créditos:" +this.qtdCreditos);
    }
}