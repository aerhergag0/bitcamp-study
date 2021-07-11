package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class C_delete {
  Scanner sc = new Scanner(System.in);
  String msg;
  ResultSet RS;

  public void c_delete(String id) {
    try {
      Boot boot = new Boot();   
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      System.out.print("완료 일정을 전부 삭제하시겠습니까?(y/n) >> ");
      if(sc.nextLine()=="y") {
        msg = "delete from c_seet_"+id;
        ST.executeUpdate(msg);
        System.out.println(id+"님의 완료 일정이 삭제되었습니다.");
      }
      else {
        System.out.println("삭제를 취소하였습니다.");
        return;
      }
    } catch (Exception E) {}
  }
}
