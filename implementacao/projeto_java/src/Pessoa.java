public interface Pessoa{
    private String nome;
    private String CPF;
    private int matricula;
    private String senhaSistema;

    public boolean fazerLogin(String senha, int matricula){
        
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }    
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public String getCPF(){
        return this.CPF;
    }   
    public void setSenhaSistema(String senhaSistema){
        this.senhaSistema = senhaSistema;
    } 
    public String getSenhaSistema(){
        return this.senhaSistema;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public int getMatricula(){
        return this.matricula;
    }
    public void gerarRelatorio(matricula:int){
        System.out.printl "matricula";
    }
}