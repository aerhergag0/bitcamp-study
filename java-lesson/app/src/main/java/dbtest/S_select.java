package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class S_select {
  Scanner sc = new Scanner(System.in);
  String msg;
  ResultSet RS;

  public void s_select(String id) {
    try {
      Boot boot = new Boot();   
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      msg = "select * from s_seet_"+id;
      ST.executeUpdate(msg);
      RS = ST.executeQuery(msg);
      if(RS.next() == false) 
        System.out.println("게시글이 존재하지 않습니다.");
      else {
        while(RS.next()==true) {
          String s_date = RS.getString("s_date");
          String s_title = RS.getString("title");
          String s_contents = RS.getString("contents");
          System.out.println(s_date+"\t" + s_title+"\t" + s_contents+"\t");
        }
      } // 게시물 확인end
    } catch (Exception E) {}
  }
}
