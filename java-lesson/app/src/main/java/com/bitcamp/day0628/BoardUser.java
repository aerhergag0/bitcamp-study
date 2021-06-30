package com.bitcamp.day0628;

public class BoardUser {
  public static void main(String[] args) {
    Board ob = new Board();
    ob.setTitle("6월 장마축제");
    String data = ob.getTitle(); 
    System.out.println(data);  

    //getter, setter --> lombok 연결
  }
}
