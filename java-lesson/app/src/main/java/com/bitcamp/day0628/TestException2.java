package com.bitcamp.day0628;

public class TestException2 {
  public static void main(String[] args) {

    try {
      int su1 = 9;
      int su2 = 0;
      int mul = 0, mok=0;
      mul = su1*su2;
      mok = su1/su2;
      System.out.println(su1+"*"+su2+"="+mul);
      System.out.println(su1+"/"+su2+"="+mok);
    }
    catch (Exception e){}
    System.out.println("\n1학기점수");
    System.out.println("국어=90");
    System.out.println("영어=85");
    System.out.println("총점=175");



  }
}
