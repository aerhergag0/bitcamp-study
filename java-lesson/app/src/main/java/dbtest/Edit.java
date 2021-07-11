package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Edit {

  Scanner keyScan = new Scanner(System.in);
  ResultSet RS;
  String msg;
  String name;
  String pw;
  String email;
  String phone;
  boolean check;

  public void edit(String id) {
    try {
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      // 비밀번호 입력
      System.out.println("개인정보 보호를 위해 비밀번호를 입력해주세요.");
      loop : while (true) {
        while (true) {
          System.out.print("비밀번호 : ");
          pw = keyScan.nextLine();
          if (pw.isEmpty()) {
            System.out.println("비밀번호를 입력하여 주세요."); continue;
          } else { break; }
        }

        // 비밀번호 검사
        msg = "select * from profile where id='"+id+"'";
        RS = ST.executeQuery(msg);
        while (RS.next() == true) {
          if (RS.getString("pw").equals(pw)) {
            break loop;
          } else { System.out.println("비밀번호가 일치하지 않습니다.");}
        }
      }

      // 회원정보 출력
      msg = "select * from profile where id='"+id+"'";
      RS = ST.executeQuery(msg);
      while (RS.next() == true) {
        String name = RS.getString("name");
        String pw = RS.getString("pw");
        String email = RS.getString("email");
        String phone = RS.getString("phone");
        System.out.printf("이름 : %s\n비밀번호 : %s\n이메일 : %s\n휴대전화번호 : %s\n", name, pw, email, phone);
      }

      while (true) {
        System.out.println("변경하실 회원정보를 입력하여 주세요.");
        System.out.println("1. 이름 2. 비밀번호 3. 이메일 4. 휴대전화번호 0.뒤로가기");
        System.out.print("번호 입력 : ");
        String num = keyScan.nextLine();

        if (num.equals("0")) { return; }

        switch (num) {
          // 이름 수정
          case "1" :
            while (true) {
              System.out.print("이름 : ");
              name = keyScan.nextLine();
              if (name.isEmpty()) {
                System.out.println("이름을 입력하여 주세요."); continue;
              } else {break;}
            }
            msg = "update profile set name='"+name+"' where id='"+id+"'";
            ST.executeUpdate(msg);
            System.out.println("회원정보 변경이 완료되었습니다.");
            break;

            // 비밀번호 수정
          case "2" :
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
            msg = "update profile set pw='"+pw+"' where id='"+id+"'";
            ST.executeUpdate(msg);
            System.out.println("회원정보 변경이 완료되었습니다.");
            break;

            // 이메일 수정
          case "3" :
            while(true) {
              System.out.print("이메일 : ");
              email = keyScan.nextLine();
              check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
              if (check == true) {
                break;
              } else {System.out.println("이메일형식이 올바르지 않습니다. 다시 입력하여 주세요.");
              continue;}
            }
            msg = "update profile set email='"+email+"' where id='"+id+"'";
            ST.executeUpdate(msg);
            System.out.println("회원정보 변경이 완료되었습니다.");
            break;

            // 휴대전화번호 수정
          case "4" :
            while (true) {
              System.out.print("휴대전화번호 : ");
              phone = keyScan.nextLine();
              check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone);
              if(check != true) {
                System.out.println("휴대전화번호 형식이 올바르지 않습니다. -를 이용하여 다시 입력하여 주세요.");
                continue;
              } break;
            }
            msg = "update profile set phone='"+phone+"' where id='"+id+"'";
            ST.executeUpdate(msg);
            System.out.println("회원정보 변경이 완료되었습니다.");
            break;

          default : System.out.println("번호를 다시 입력하여 주세요."); break;
        }
      }
    } catch (Exception e) {}
  }
}