package com.bitcamp.day0702;

public class Bank {
  //overloading 오버로딩: 같은 이름 메서드, 다른 매개변수 받기, 생성자 중복가능
  //기본 생성자만 기술 => 기본 생성자 생략가능

  private int pwd = 1234;


  public Bank() {} // 생성자 private 키워드기술


  public void cal() {}
  public void cal(int m) {System.out.println(pwd);}
  public void cal(String name, int m) {}
}
