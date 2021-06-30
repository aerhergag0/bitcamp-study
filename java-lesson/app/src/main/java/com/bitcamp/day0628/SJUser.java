package com.bitcamp.day0628;

public class SJUser {
  static int first = 90;
  static int second = 85;
  public static void main(String[] args) {


    SJ sj = new SJ(); 
    String id = "kim";


    int total = sj.getTotal(id,first,second);
    double avg = sj.getMean(total);
    char grade = sj.getGrade(avg);
    String info = sj.result(avg);

    System.out.println("합계 = "+ total);
    System.out.println("평균 = "+ avg);
    System.out.println("학점 = "+ grade);
    System.out.println("결과 = "+ info);
  }
}
