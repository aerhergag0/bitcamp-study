package com.bitcamp.day0628;

public class TsetLast {
  public static void main(String[] args) {

    int a = 234;
    double b = 78.9;
    String c = "1200";

    // 문제1 b타입으로 int형으로 변환
    int x = (int)b;
    System.out.println(x);
    // 문제2 c타입으로 int형으로 변환
    int y = Integer.parseInt(c);
    System.out.println(y);
    // 문제3 a타입으로 String형으로 변환
    String z = Integer.toString(a);
    System.out.println(z);
  }
}
