package com.bitcamp.day0630;

public interface BoardImp {
  //메서드 선언만 = abstract method 추상메서드
  //abstract 키워드 생략가능, 기술해도 에러없음
  public abstract int boardCount();
  public boolean boardInsert();
  public void boardDelete(int num);
} //
