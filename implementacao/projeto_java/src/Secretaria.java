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
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sqlselect = "SELECT * "
                    + " FROM pessoa"
                    + " WHERE senhaSistema = ? AND matricula = ? AND tipo = 1";
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlselect);

        System.out.println(preparedStatement);
        try {
            System.out.println(sqlselect);
            preparedStatement.setString(1, senha);
            preparedStatement.setInt(2, matricula);

            resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet);
            return true;
        }catch(SQLException e) {
            return false;
        }
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
                System.out.println("Sem dados.");
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


    // private ArrayList<Curso> cursos = new ArrayList<>();
    // public void setCursos(Curso cursos){
    //     this.cursos = cursos;
    // }
    // public String getCursos(){
    //     return this.cursos;
    // }
    // public void gerarCurriculoSemestre(int idDisciplina){
    //     System.out.printl "Cursos: " + this.cursos.stream()
    //                                               .filter(item -> item.getIdCurso() == idDisciplina)
    //                                               .collect(Collectors.toList());
    // }


}