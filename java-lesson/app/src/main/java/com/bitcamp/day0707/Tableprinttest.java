package com.bitcamp.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tableprinttest{    
  public void printer(String query) {
    Connection conn = null;
    String msg = null;
    try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
      Statement stmt = conn.createStatement();
      msg = query;
      ResultSet rs= stmt.executeQuery(msg);

      DBTablePrinter.printResultSet(rs);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    Tableprinttest tp = new Tableprinttest();
    tp.printer("Select title as title2, name as 이름2 from test");
    tp.printer("select rownum, a.* from test a");
    tp.printer("select rownum, a.* from test a");
    tp.printer("select to_char(cnt,'999') from test");
    tp.printer("select to_char(rownum,'9999') as nnuumm ,name , to_char(cnt,'999') as 조회수 from test");

  }
}
