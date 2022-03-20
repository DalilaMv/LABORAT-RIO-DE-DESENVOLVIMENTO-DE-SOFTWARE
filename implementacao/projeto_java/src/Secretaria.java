import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// PreparedStatement preparedStatement = this.conexaoSQLite.criarPreparedStatement(sqlInsert);
public class Secretaria extends Pessoa{

    @Override
    public boolean fazerLogin(String senha, int matricula) {
        ConexaoSQLite c = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(c);
        boolean is_registered = criarBancoSQLite.login(senha, matricula, 1);
        return is_registered;
    }

    public void criarDisciplina(){

    }

    public void criarMatricula(){

    }

     public void criarOferta(){

     }

    public void criarPessoa(String nome, int CPF,String senhaSistema, int tipo) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();
        String sqlInsert = " INSERT INTO pessoa ("
                        + "nome,"
                        + "CPF,"
                        + "senhaSistema,"
                        + "tipo"
                        + ") VALUES(?,?,?,?)"
                        +";";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, CPF);
            preparedStatement.setString(3, senhaSistema);
            preparedStatement.setInt(4, tipo);

            int resultado = preparedStatement.executeUpdate();
            if(resultado == 1) {
                System.out.println("pessoa cadastrada");
            } else {
                System.out.println("não foi possivel cadastrar essa pessoa");
            }
        }catch(SQLException e){
            System.out.println("não foi possivel cadastrar essa pessoa");
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch(SQLException ex) {
                    Logger.getLogger(CriarBancoSQLite.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexaoSQLite.desconectar();
        }
    }

    public void gerarRelatorio(int tipo){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        ResultSet resultSet = null;
        Statement statement = null;
        String query;
        conexaoSQLite.conectar();

        // tipo 2 é aluno, 3 é prof, 1 é secretaria
        if (tipo == 2) {
            query = "SELECT * FROM pessoa where tipo = 2";
        }else{
            query = "SELECT * FROM pessoa where tipo = 3";
        }

        statement = conexaoSQLite.criarStatement();
        try{
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
            System.out.println("-------------------------------------------");
            System.out.println("Dados da(o): "+resultSet.getString("nome"));
            System.out.println("Matricula: "+resultSet.getInt("matricula"));
            System.out.println("Senha: "+resultSet.getString("senhaSistema"));
            System.out.println("CPF: "+resultSet.getInt("CPF"));
            System.out.println("-------------------------------------------");
            }
        
            if(!resultSet.next()){
                System.out.println(" ");
            }
        
        }catch (SQLException e) {
            System.out.println("erro no sql");
        }finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }catch (SQLException ex){
                System.out.println("algum erro de fechamento");
            }
        }
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