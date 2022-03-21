
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriarBancoSQLite {

  private final ConexaoSQLite conexaoSQLite;

  public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite){
    this.conexaoSQLite = pConexaoSQLite;
  }

  public boolean login(String senha, int matricula, int tipo) {

    boolean conectou = false;
    conectou = this.conexaoSQLite.conectar();

    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    String sqlselect = "SELECT * "
            + " FROM pessoa"
            + " WHERE senhaSistema = ? AND matricula = ? AND tipo = ?";
    preparedStatement = this.conexaoSQLite.criarPreparedStatement(sqlselect);

    try {
      preparedStatement.setString(1, senha);
      preparedStatement.setInt(2, matricula);
      preparedStatement.setInt(3, tipo);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        return true;
      } else {
        return false;
      }
    }catch(SQLException e) {
      return false;
    }finally{
      if(conectou){
        this.conexaoSQLite.desconectar();
      }
    }
  }

  public void criarTabelaPessoa() {
    
    String sql = "CREATE TABLE IF NOT EXISTS pessoa"
            + "("
            + "nome text NOT NULL,"
            + "CPF integer NOT NULL,"
            + "matricula integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
            + "senhaSistema text NOT NULL,"
            + "tipo integer NOT NULL"
            + ");";

    boolean conectou = false;

    try{
      conectou = this.conexaoSQLite.conectar();
      
      Statement stmt = this.conexaoSQLite.criarStatement();
      stmt.execute(sql);

      System.out.println("Tabela Criada");
    }catch(SQLException e){
      System.out.println("Não foi possivel criar a tabela");
    }finally{
      if(conectou){
        this.conexaoSQLite.desconectar();
      }
    }
  }
}

