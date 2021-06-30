package com.bitcamp.day0630;

import java.io.InputStream;

public class Work03gugudan {
  public static void main(String[] args) {
    try {
      InputStream is = System.in; // static InputStream in 표준  ascii코드
      System.out.print("단입력 >>> ");

      int dan = is.read();
      for(int a=1; a<10; a++) {
        System.out.println(dan+"*"+a+"="+(dan*a));
      }
    } catch (Exception e) {}
  }
}
