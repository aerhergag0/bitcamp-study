package com.bitcamp.day0628;

import java.util.Scanner;

public class TestGugudan {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("원하는 단 입력 >>>  ");
    try {

      int dan = sc.nextInt();

      for(int i=1; i<10; i++) {
        System.out.println(dan+"*"+i+"="+(dan*i));
        Thread.sleep(500); }
    }
    catch( Exception ex ) {}


    System.out.println();
    System.out.println("우리나라");
    System.out.println("대한민국");
    System.out.println("금수강산");
    sc.close();
  }
}
