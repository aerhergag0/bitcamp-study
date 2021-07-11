package com.bitcamp.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
  Connection CN = null;  
  Statement ST = null;  
  ResultSet RS = null; 
  String msg = "";

  //connectDB("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
  public void connectDB(String driver, String url, String id, String pwd) {
    try {
      Class.forName(driver);
      CN=DriverManager.getConnection(url, id, pwd);
      System.out.println("오라클 드라이버 연결 성공");
      ST = CN.createStatement();
    } catch (Exception ex) {System.out.println(ex);}
  }
}
