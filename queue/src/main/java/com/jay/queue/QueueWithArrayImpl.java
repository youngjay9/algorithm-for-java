package com.jay.queue;

public class QueueWithArrayImpl {

  private Integer[] queue;

  private Integer front;// 指向第 1 個 element

  private Integer rear; // 指向最後 1 個 element

  private int size;

  public QueueWithArrayImpl(int size) {
    this.front = -1;
    this.rear = -1;
    this.size = size;
    this.queue = new Integer[size];
  }

  public void enQueue(int val) {
    // 先檢查 queue 是否為 full
    if (rear == (size - 1)) {
      System.out.println("Queue Is Full");
    } else {
      // enQueue 時, rear 會加 1
      rear++;
      queue[rear] = val;
    }
  }

  public int deQueue() {
    int rtnV = -1;

    // 先檢查 queue 是否為 empty
    if (front == rear) {
      System.out.println("Queue Is Empty");
    } else {
      front++;
      rtnV = queue[front];
      queue[front] = null;
    }

    return rtnV;
  }

  public static void main(String[] args) {
    int size = 7;
    QueueWithArrayImpl queueWithArray = new QueueWithArrayImpl(size);
    queueWithArray.enQueue(12);
    queueWithArray.enQueue(24);
    queueWithArray.enQueue(8);

    System.out.println(queueWithArray.deQueue());
    System.out.println(queueWithArray.deQueue());
    System.out.println(queueWithArray.deQueue());
    System.out.println(queueWithArray.deQueue());
  }
}
