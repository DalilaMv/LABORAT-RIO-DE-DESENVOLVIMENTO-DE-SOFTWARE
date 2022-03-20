
abstract class Pessoa{
    public String nome;
    public int CPF;
    public int matricula;
    public String senhaSistema;
    public int tipo;

    public abstract boolean fazerLogin(String senha, int matricula);

    public abstract String getNome();
    public abstract void setNome(String nome);
    public abstract void setCPF(int CPF);
    public abstract int getCPF();
    public abstract void setSenhaSistema(String senhaSistema);
    public abstract String getSenhaSistema();
    public abstract void setMatricula(int matricula);
    public abstract int getMatricula();
    public abstract int getTipo();
    public abstract void setTipo(int tipo);

}