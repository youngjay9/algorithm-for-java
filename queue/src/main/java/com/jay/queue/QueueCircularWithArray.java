package com.jay.queue;

import java.util.TreeSet;

public class QueueCircularWithArray {

  private Integer[] queue;

  private int front;//指向 deQueue element index

  private int rear;//指向 enQueue element index

  public QueueCircularWithArray(int size) {
    this.queue = new Integer[size];
    this.front = 0;
    this.rear = 0;
  }

  public void enQueue(int val) {
    // 判斷 queue 是否 full
    if (((rear + 1) % queue.length) == front) {
      System.out.println("Queue Is Full");
    } else {
      rear = (rear + 1) % queue.length;
      queue[rear] = val;
    }
  }

  public int deQueue() {
    Integer result = null;
    // 判斷 queue 是否 empty
    if (front == rear) {
      System.out.println("Queue Is Empty");
    } else {
      front = (front + 1) % queue.length;
      result = queue[front];
      queue[front] = null;
    }

    return result;
  }

  public static void main(String[] args) {
    QueueCircularWithArray circularWithArray = new QueueCircularWithArray(4);

    circularWithArray.enQueue(8);
    circularWithArray.enQueue(10);
    circularWithArray.enQueue(7);

    System.out.printf("deQueue: "+circularWithArray.deQueue());
    circularWithArray.enQueue(11);


  }

}
