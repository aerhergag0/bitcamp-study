package com.bitcamp.day0628;


public class SJ {

  //합계구하는함수 getTotal
  public int getTotal(String name, int A, int B) {
    return (A+B);
  }

  //평균구하는함수 avg
  public double getMean(double C) {
    return C/2;
  }
  //학점구하는함수 grade
  public char getGrade(double D) {
    char grade = 'F';
    switch(((int)D )/10) {
      case 10:
        grade = 'A';
        break;
      case 9:
        grade = 'A';
        break;
      case 8:
        grade = 'B';
        break;
      case 7:
        grade = 'C';
        break;
      case 6:
        grade = 'D';
        break;
      default:
        grade = 'F';
        break;
    }
    return grade;
  }
  //합격여부를 구하는 함수 pass 평균 70이상 축합격, 69이하 재시험
  public String result(double E) {
    if(E>=70) {
      if(SJUser.first<60 || SJUser.second<60) {
        System.out.println("과락 불합격입니다."); }
      else {
        return("축합격");} }
    else {
      return("재시험") ; }
  }

}
