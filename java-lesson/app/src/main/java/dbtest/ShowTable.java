package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowTable {

  ResultSet RS;
  String msg;

  //번호 날짜 제목 내용
  public void showtableContents(String id) {
    try {
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      msg = "select rownum, a.p_date, a.title, a.contents from (select * from seet_"+id+" order by p_date) a";
      RS = ST.executeQuery(msg);
      while (RS.next() == true) {
        int rownum = RS.getInt("rownum");
        java.util.Date p_date = RS.getDate("p_date");
        String title = RS.getString("title");
        String contents = RS.getString("contents");

        System.out.printf("   번호\t %s\n   ", rownum);
        System.out.printf("날짜 %s\n   ", p_date);
        System.out.printf("제목 %s\n   ", title);
        System.out.printf("내용 %s\n   ", contents);
        System.out.println();

      }
      CN.close();
    } catch(Exception e) {}
  } //Method End

  //번호 날짜 제목 코드
  public void showtableCode(String id) {
    try {
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      msg = "select rownum, a.p_date, a.title, a.p_id from (select * from seet_"+id+" order by p_date) a";
      RS = ST.executeQuery(msg);
      while (RS.next() == true) {
        int rownum = RS.getInt("rownum");
        java.util.Date p_date = RS.getDate("p_date");
        String title = RS.getString("title");
        String p_id = RS.getString("p_id");

        System.out.printf("   번호\t %s\n   ", rownum);
        System.out.printf("날짜 %s\n   ", p_date);
        System.out.printf("제목 %s\n   ", title);
        System.out.printf("코드 %s\n   ", p_id);
        System.out.println();

      }
      CN.close();
    } catch(Exception e) {}

  } //Method End
} //class End
