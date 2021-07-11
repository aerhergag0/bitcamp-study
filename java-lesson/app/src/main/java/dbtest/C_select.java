package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 완료된 일정 보기
public class C_select {
  Scanner sc = new Scanner(System.in);
  String msg;
  ResultSet RS;

  public void c_select(String id) {
    try {
      Boot boot = new Boot();   
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      msg = "select * from c_seet_"+id;
      ST.executeUpdate(msg);
      RS = ST.executeQuery(msg);
      if(RS.next() == false) 
        System.out.println("게시글이 존재하지 않습니다.");
      else {
        while(RS.next()==true) {
          String c_date = RS.getString("p_date");
          String c_title = RS.getString("title");
          String c_contents = RS.getString("contents");
          System.out.println(c_date+"\t" + c_title+"\t" + c_contents+"\t");
        }
      } // 게시물 확인end

    } catch (Exception E) {}
  }
}
