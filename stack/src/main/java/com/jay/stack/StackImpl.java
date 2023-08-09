package com.jay.stack;

public class StackImpl {

  static class Node {

    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private Node top;

  public void push(int val) {
    if (top == null) {
      top = new Node(val);
    } else {
      Node newNode = new Node(val);
      newNode.next = top;
      top = newNode;
    }
  }

  public Integer pop() {
    if (top == null) {
      return 0;
    }

    int rtnVal = top.val;

    top = top.next;

    return rtnVal;
  }

  public static void main(String[] args) {
    StackImpl stack = new StackImpl();
    stack.push(8);
    stack.push(7);
    stack.push(6);

    int num = stack.pop();

    System.out.println(num);

  }

}
