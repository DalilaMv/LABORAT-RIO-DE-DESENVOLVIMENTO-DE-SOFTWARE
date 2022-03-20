
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriarBancoSQLite {

  private final ConexaoSQLite conexaoSQLite;

  public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite){
    this.conexaoSQLite = pConexaoSQLite;
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

