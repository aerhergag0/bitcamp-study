package dbtest;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SignUp {

  Scanner keyScan = new Scanner(System.in);
  String msg;
  String name;
  String id;
  String pw;
  String email;
  String phone;
  boolean check;

  public void signup() {
    try {
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      // 이름 작성
      while (true) {
        System.out.print("이름 : ");
        name = keyScan.nextLine();
        if (name.isEmpty()) {
          System.out.println("이름을 입력하여 주세요."); continue;
        } else {break;}
      }

      // 아이디 작성
      while (true) {
        try {
          while (true) {
            System.out.print("아이디 : ");
            id = keyScan.nextLine();
            check = Pattern.matches("^[0-9a-zA-Z]*$", id);
            int a = id.length();
            if (check != true) {
              System.out.println("영어와 숫자만 적어주세요.");
              continue;}
            if (a > 20 || a < 8) {
              System.out.println("아이디는 최소 8자에서 최대 20자 사이 입니다.");
              continue;}
            break;
          }
          msg = "insert into profile (id) values ('"+id+"')";
          ST.executeUpdate(msg); break;
        } catch (Exception e) {System.out.println("동일한 아이디가 존재합니다. 다른 아이디를 입력하여 주세요."); continue;}
      }

      // 비밀번호 작성
      while(true) {
        System.out.print("비밀번호 : ");
        pw = keyScan.nextLine();
        check = Pattern.matches("^[0-9a-zA-Z]*$", pw);
        int a = pw.length();
        if (check != true) {
          System.out.println("영어와 숫자만 적어주세요.");
          continue;}
        if (a > 20 || a < 8) {
          System.out.println("비밀번호는 최소 8자에서 최대 20자 사이 입니다.");
          continue;}
        System.out.print("비밀번호 확인 : ");
        String pw_check = keyScan.nextLine();
        if (pw.equals(pw_check)) {
          break; } else {
            System.out.println("비밀번호가 일치하지 않습니다. 비밀번호를 다시 입력하여 주세요.");
            continue;}
      }

      // 이메일 작성
      while(true) {
        System.out.print("이메일 : ");
        email = keyScan.nextLine();
        check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
        if (check == true) {
          break;
        } else {System.out.println("이메일형식이 올바르지 않습니다. 다시 입력하여 주세요.");
        continue;}
      }

      // 휴대전화번호 작성
      while (true) {
        System.out.print("휴대전화번호 : ");
        phone = keyScan.nextLine();
        check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone);
        if(check != true) {
          System.out.println("휴대전화번호 형식이 올바르지 않습니다. -를 이용하여 다시 입력하여 주세요.");
          continue;
        }
        break;
      }

      // 회원정보 업데이트
      msg = "update profile set "
          + "name='"+name+"', "
          + "pw='"+pw+"', "
          + "email='"+email+"', "
          + "phone='"+phone+"' "
          + "where id='"+id+"'";
      ST.executeUpdate(msg);

      // 회원전용 테이블 생성
      msg = "create table seet_"+id+"("
          + "p_date date, "
          + "title varchar2(100), "
          + "contents varchar2(4000) "
          + ")";
      ST.executeUpdate(msg);

      msg = "create table c_seet_"+id+"("
          + "p_date date, "
          + "title varchar2(100), "
          + "contents varchar2(4000) "
          + ")";
      ST.executeUpdate(msg);

      msg = "create table s_seet_"+id+"("
          + "p_date date, "
          + "title varchar2(100), "
          + "contents varchar2(4000) "
          + ")";
      ST.executeUpdate(msg);

      System.out.println(name+" 회원님의 아이디는 "+id+" 입니다.");
      System.out.println("회원가입이 완료되었습니다.");
    } catch (Exception e) {}
  }
}