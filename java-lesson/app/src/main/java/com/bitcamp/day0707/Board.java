package com.bitcamp.day0707;

public class Board {
  DBinfo dbinfo = new DBinfo();

  public static void main(String[] args) {
    try {
      Class.forName();

    } catch(Exception ex) {}
  }

  public class DBInfo {

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    String userid = "system";
    String pwd = "1234";
  }
}
