package com.jay.recursion;

public class IndirectRecursion {

  public static void funA(int n) {
    if (n > 0) {
      System.out.printf("%d ", n);
      funB(n - 1);
    }
  }

  public static void funB(int n) {
    if (n > 1) {
      System.out.printf("%d ",n);
      funA(n / 2);
    }
  }


  public static void main(String[] args) {
    funA(20);
  }
}
