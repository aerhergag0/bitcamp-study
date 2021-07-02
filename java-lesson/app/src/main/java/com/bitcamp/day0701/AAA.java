package com.bitcamp.day0701;

public interface AAA {
  public void apple();
  public String memo();
  public boolean nullCheck(int key);
  //추상메소드 구성원이라 AAA 인터페이스로 개체 생성하면 에러
  //AAA 인터페이스 상속 안하면 개체화 확인
}
