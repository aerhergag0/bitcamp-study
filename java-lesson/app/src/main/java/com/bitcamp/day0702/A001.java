package com.bitcamp.day0702;

public class A001 {
  public static void main(String[] args) {
    int kor = 90, eng = 85, hap=0;
    double avg =0.0;
    String info = "합격여부";
    hap = kor+eng;
    avg =(double)hap/2;

    System.out.println(avg>=70?"y":"n");

  }
}
