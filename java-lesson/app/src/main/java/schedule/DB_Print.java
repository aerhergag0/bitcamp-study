package schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DBTablePrinter.java 필요
public class DB_Print{    

  Boot boot = new Boot();
  //db_print(쿼리문)
  public void db_print(String query) {
    Connection CN = null;
    String msg = null;
    try {

      CN = DriverManager.getConnection(boot.url,boot.id,boot.pwd);
      Statement ST = CN.createStatement();
      msg = query;
      ResultSet RS= ST.executeQuery(msg);

      DBTablePrinter.printResultSet(RS);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
