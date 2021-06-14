package com.eomcs.lang.ex04;

//# 문자 변수 - 변수의 메모리 크기
//
public class Test05 {
  public static void main(String[] args) {
    // 배열 메모리의 시작 주소를 저장할 레퍼런스 선언
    int[] a = new int[3];

    a[0] = 100;
    a[1] = 200;
    a[2] = 300;

    a = new int[5];
    System.out.println(a[4]);
  }
}
