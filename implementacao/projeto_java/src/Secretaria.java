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
        return criarBancoSQLite.login(senha, matricula, 1);
    }

    public void criarDisciplina(Disciplina d1){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();
        String sqlInsert = " INSERT INTO disciplina ("
                + "nome,"
                + "tipo,"
                + "curso"
                + ") VALUES(?,?,?)"
                +";";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try{
            preparedStatement.setString(1, d1.getNome());
            preparedStatement.setString(2, d1.getTipo());
            preparedStatement.setInt(3, d1.getCurso());

            int resultado = preparedStatement.executeUpdate();
            if(resultado == 1) {
                System.out.println("disciplina cadastrado");
            } else {
                System.out.println("não foi possivel cadastrar essa disciplina");
            }
        }catch(SQLException e){
            System.out.println("não foi possivel cadastrar essa disciplina");
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

    public void criarCurso(Curso c1){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();
        String sqlInsert = " INSERT INTO curso ("
                        + "nome,"
                        + "qtdSemestres,"
                        + "qtdCreditos"
                        + ") VALUES(?,?,?)"
                        +";";
        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try{
            preparedStatement.setString(1, c1.getNome());
            preparedStatement.setInt(2, c1.getQtdSemestres());
            preparedStatement.setInt(3, c1.getQtdCreditos());

            int resultado = preparedStatement.executeUpdate();
            if(resultado == 1) {
                System.out.println("curso cadastrado");
            } else {
                System.out.println("não foi possivel cadastrar esse curso");
            }
        }catch(SQLException e){
            System.out.println("não foi possivel cadastrar esse curso");
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

    public void criarOferta(){

    }

    public void criarPessoa(Pessoa p1) {
        System.out.println(p1.getNome());
            System.out.println(p1.getCPF());
            System.out.println(p1.getSenhaSistema());
            System.out.println(p1.getTipo());
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
            preparedStatement.setString(1, p1.getNome());
            preparedStatement.setInt(2, p1.getCPF());
            preparedStatement.setString(3, p1.getSenhaSistema());
            preparedStatement.setInt(4, p1.getTipo());

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

    public void getCursos(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        ResultSet resultSet = null;
        Statement statement = null;
        String query;
        conexaoSQLite.conectar();


        query = "SELECT * FROM curso";


        statement = conexaoSQLite.criarStatement();
        try{
            resultSet = statement.executeQuery(query);
            int count = 0;
            while(resultSet.next()) {
                count += 1;
                System.out.println("["+resultSet.getInt("cursoid")+"] - "+resultSet.getString("nome"));
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


    public void cadastrarDisciplina(Disciplina d1) {

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
    public int getTipo() { return this.tipo; }

    @Override
    public void setTipo(int tipo){
        this.tipo = tipo;
    }

}