package com.jay.linkedlist;

public class LinkedListImpl {

  static class Node {

    Integer val;

    Node next;

    public Node(Integer val) {
      this.val = val;
    }
  }

  private Node start;

  private Node end;

  public void add(int val) {
    if (start == null) {
      start = new Node(val);
      end = start;
    } else {
      end.next = new Node(val);
      end = end.next;
    }
  }

  public void remove(int del_val) {
    Node search = start;
    Node prev = null;
    Node target = null;

    // 用 while loop 找 delete Node
    while (search != null) {
      // 找到 delete node, 指定 target 並跳出迴圈
      if (search.val == del_val) {
        target = search;
        break;
      }

      prev = target;
      target = target.next;
    }

    if (target == null) {
      return;
    }

    if (target == start) {
      start = start.next;
    } else if (target == end) {
      prev.next = null;
      end = prev;
    }
    // delete node 在 start、end 中間
    else {
      prev.next = target.next;
    }

  }

  public static void main(String[] args) {
    LinkedListImpl linkedList = new LinkedListImpl();
    linkedList.add(9);
    linkedList.add(11);
    linkedList.add(12);

    linkedList.remove(11);
  }
}
