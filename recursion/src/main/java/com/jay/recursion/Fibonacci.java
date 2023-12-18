package com.jay.recursion;

public class Fibonacci {

  private Integer[] F;

  public Fibonacci(int n) {
    F = new Integer[n];
  }

  public int fib(int n) {
    if (n <= 1) {
      return n;
    } else {
      F[n - 2] = fib(n - 2);
      F[n - 1] = fib(n - 1);
    }
    return F[n - 2] + F[n - 1];
  }

  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci(7);
    System.out.printf("fib(5):" + fibonacci.fib(7));
    ;
  }
}
