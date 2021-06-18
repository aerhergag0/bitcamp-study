package com.eomcs.lang.ex07;

import java.util.Scanner;

class Test0110 {

  static void spaces(int x) {
    for(int i=1; i<(x-1)/2; i++) {
      System.out.print(" ");
    }
  }

  static void stars(int x) {
    for(int i=0; i<=x; i++) {
      System.out.print("*");
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("삼각형 밑변의 길이?");
    System.out.print(">> ");
    int length = sc.nextInt();
    sc.close();

    for (int i=0; i<length; i+=2) {
      spaces(i);
      stars(i);
      System.out.println();
    }

  }
}