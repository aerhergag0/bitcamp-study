package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DBTablePrinter.java 필요
public class DB_Print{    

  //db_print(쿼리문)
  public void db_print(String query) {
    Connection conn = null;
    String msg = null;
    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
      Statement stmt = conn.createStatement();
      msg = query;
      ResultSet rs= stmt.executeQuery(msg);

      DBTablePrinter.printResultSet(rs);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
