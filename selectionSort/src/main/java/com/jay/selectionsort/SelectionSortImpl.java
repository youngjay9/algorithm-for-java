package com.jay.selectionsort;

public class SelectionSortImpl {

  private int[] array;

  public SelectionSortImpl(int[] array) {
    this.array = array;
  }

  public void sortWithRecur() {
    // 1.counter
    int round = 0;

    // 2.data flow
    recur(round);

  }

  private void recur(int round) {
    // 3. termination
    if (round >= array.length) {
      return;
    }

    // 1. counter
    int i = round + 1;

    // 2. data flow
    int tmpMax = array[round];
    int maxValIndx = round;

    maxValIndx = recurExe(i, maxValIndx, tmpMax);

    // switch
    int tmp = array[maxValIndx];
    array[maxValIndx] = array[round];
    array[round] = tmp;

    recur(round + 1);
  }

  private int recurExe(int i, int maxValIndx, int tmpMax) {
    // 3. termination
    if (i >= array.length) {
      return maxValIndx;
    }

    if (array[i] > tmpMax) {
      maxValIndx = i;
      tmpMax = array[i];
    }

    return recurExe(i + 1, maxValIndx, tmpMax);
  }

  public void sort() {
    if (array == null || array.length == 0) {
      return;
    }
    for (int round = 0; round < array.length; round++) {
      int tmpMax = array[round];// 暫存最大值
      int maxValIndx = round; // 暫存最大值的 index

      // 開始找最大值的 index
      for (int i = round + 1; i < array.length; i++) {
        if (array[i] > tmpMax) {
          maxValIndx = i;
          tmpMax = array[i];
        }
      }
      // switch
      int tmp = array[maxValIndx];
      array[maxValIndx] = array[round];
      array[round] = tmp;
    }
  }

  public static void main(String[] args) {
//    int[] arr = {8, 2, 6, 10, 4};

    int[] arr = {8, 7, 6, 2, 7};

    SelectionSortImpl selectionSort = new SelectionSortImpl(arr);

//    selectionSort.sort();

    selectionSort.sortWithRecur();

    System.out.println(arr);

  }
}
