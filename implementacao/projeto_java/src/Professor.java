import java.util.ArrayList;

public class Professor implements Pessoa {
    private ArrayList<Disciplina> disciplinasLecionadas = new ArrayList<>();
    public void setDisciplina(ArrayList<Disciplina> disciplinasLecionadas){
        this.disciplinasLecionadas = disciplinasLecionadas;
    }
    public ArrayList<Disciplina> getDisciplina(){
        return this.disciplinasLecionadas;
    }
    @Override
    public void setNome(String nome) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void setCPF(String CPF) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getCPF() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void setSenhaSistema(String senhaSistema) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getSenhaSistema() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void setMatricula(int matricula) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int getMatricula() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void gerarRelatorio() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public boolean fazerLogin(String senha, int matricula) {
        // TODO Auto-generated method stub
        return false;
    }
}