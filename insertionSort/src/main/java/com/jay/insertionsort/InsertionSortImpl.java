package com.jay.insertionsort;

public class InsertionSortImpl {

  private int[] array;

  public InsertionSortImpl(int[] array) {
    this.array = array;
  }

  public void sort() {
    if (this.array == null || this.array.length == 0) {
      return;
    }

    for (int round = 0; round < array.length; round++) {
      for (int i = round; i > 0; i--) {
        if (array[i] > array[i - 1]) {
          int tmp = array[i - 1];
          array[i - 1] = array[i];
          array[i] = tmp;
        }
      }
    }
  }

  public void sortWithRecur() {
    // 1.計數器
    int round = 0;

    // 2.data flow
    recur(round);
  }

  private void recur(int round) {
    // 3. termination
    if (round >= array.length) {
      return;
    }

    // 1.計數器
    int i = round;

    //2. data flow
    exeRecur(i);

    // data flow
    recur(round + 1);
  }

  private void exeRecur(int i) {
    //3. termination
    if (i <= 0) {
      return;
    }

    // main logic
    // swap
    if (array[i] > array[i - 1]) {
      int tmp = array[i - 1];
      array[i - 1] = array[i];
      array[i] = tmp;
    }

    // data flow
    exeRecur(i - 1);
  }

  public static void main(String[] args) {

    int[] arr = {8, 6, 4, 10, 2};
    InsertionSortImpl insertionSort = new InsertionSortImpl(arr);

//    insertionSort.sort();

    insertionSort.sortWithRecur();

    System.out.println(arr);

  }
}
