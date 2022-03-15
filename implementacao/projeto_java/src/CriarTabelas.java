
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

  private final ConexaoSQLite conexaoSQLite;

  public CriarTabelas(ConexaoSQLite pConexaoSQLite){
    this.conexaoSQLite = pConexaoSQLite;
  }

  public void criarTabelaPessoa() {
    String sql = "CREATE TABLE IF NOT EXISTS pessoa"
            + "("
            + "id integer PRIMARY KEY,"
            + "nome text NOT NULL,"
            + "CPF integer NOT NULL,"
            + "matricula integer NOT NULL,"
            + "senhaSistema text NOT NULL"
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

