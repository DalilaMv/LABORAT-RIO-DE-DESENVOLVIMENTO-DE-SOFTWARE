import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private ArrayList<Disciplina> disciplinasLecionadas = new ArrayList<>();
    public void setDisciplina(ArrayList<Disciplina> disciplinasLecionadas){
        this.disciplinasLecionadas = disciplinasLecionadas;
    }
    public ArrayList<Disciplina> getDisciplina(){
        return this.disciplinasLecionadas;
    }

    public void FiltroProf(List<Oferta> lista){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        boolean conectou = false;
        conectou = conexaoSQLite.conectar();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        for (int l = 0; l<lista.size(); l+=1){
            String sqlselect = "SELECT * "
            + " FROM matricula"
            + " WHERE oferta = ?";

            preparedStatement = conexaoSQLite.criarPreparedStatement(sqlselect);

            int count = 0;
            try {
                preparedStatement.setInt(1, lista.get(l).getOfertaid());
            
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    while(resultSet.next()){
                        count += 1;
                    }

                    System.out.println(count+" aluno(s) cadastrado(s) na sua oferta de disciplina de ID"+ lista.get(l).getOfertaid());
                } else {
                    System.out.println("nenhum aluno cadastrado na sua oferta de disciplina de ID"+ lista.get(l).getOfertaid());
                }
            }catch(SQLException e) {
                System.out.println(e);
            }finally{
                if(conectou){
                    conexaoSQLite.desconectar();
                }
            }
        }
    };

    public void VisualizarDisciplinas(int matricula){
       
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        boolean conectou = false;
        conectou = conexaoSQLite.conectar();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sqlselect = "SELECT * "
                + " FROM oferta"
                + " WHERE professor = ?";
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlselect);

        List<Oferta> lista = new ArrayList<Oferta>();
        try {
        preparedStatement.setInt(1, matricula);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            while(resultSet.next()){
                Oferta oferta = new Oferta();
                oferta.setOfertaid(resultSet.getInt("ofertaid"));
                lista.add(oferta);
            }
        } else {
            System.out.println("Você não está lecionando nenhuma disciplina");
        }
        }catch(SQLException e) {
            System.out.println(e);
        }finally{
            if(conectou){
                conexaoSQLite.desconectar();
            }
            FiltroProf(lista);
        }
    }
    @Override
    public boolean fazerLogin(String senha, int matricula) {
        ConexaoSQLite c = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(c);
        boolean is_registered = criarBancoSQLite.login(senha, matricula, 3);
        return is_registered;
    }

    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getCPF(){
        return this.CPF;
    }

    @Override
    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    @Override
    public String getSenhaSistema(){
        return this.senhaSistema;
    }

    @Override
    public void setSenhaSistema(String senhaSistema) {
        this.senhaSistema = senhaSistema;
    }


    @Override
    public int getMatricula(){
        return this.matricula;
    }

    @Override
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    @Override
    public int getTipo() {
        return this.tipo;
    };

    @Override
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}