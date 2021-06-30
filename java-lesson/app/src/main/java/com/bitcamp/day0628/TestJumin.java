package com.bitcamp.day0628;

public class TestJumin {
  public static void main(String[] args) {

    // string클래스의 메서드 string substring(1시작) 시작부터 끝까지
    String min = "971224-1541965";
    int pos = min.indexOf("-");
    System.out.println("pos=" + pos);
    //10월 24일 생일이네요
    String month = min.substring(2,3);
    String day = min.substring(4,6);
    System.out.println(month+"월 "+day+"일 생일");

    String last = min.substring(7); //시작점, 끝x
    System.out.println(last);

    int len = min.length();
    System.out.println("총자리수 =" + len );

  }
}







/*
public class TestJumin {
  public static void main(String[] args) {
    String min = "19971224-1541965";

    char gender = min.charAt(9);
    String message = "당신의 성별은  성별출력합니다";

    if(gender=='1' || gender=='3')
      message = "당신의 성별은 남자입니다";
    else if(gender=='2' || gender=='4')
      message = "당신의 성별은 여자입니다";
    else
      message = "성별이 잘못 표기 되었습니다.";
  }
}
 */
