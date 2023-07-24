package com.jay.bubblesort;

public class BubbleSortImpl {

  private int[] array;

  public BubbleSortImpl(int[] array) {
    this.array = array;
  }


  public void sort() {
    if (array == null) {
      return;
    }

    for (int round = 0; round < array.length; round++) {
      int exeTimes = array.length - round - 1;
      for (int i = 0; i < exeTimes; i++) {
        // switch
        if (array[i] > array[i + 1]) {
          int tmp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = tmp;
        }
      }
    }
  }

  public void sortWithRecur() {
    if (array == null) {
      return;
    }

    // 外層 loop 轉換成 recursive
    // 1. 計數器
    int round = 0;
    // 2. 資料流
    round_recur(round);
  }

  private void round_recur(int round) {
    // 2recursive termination
    if (round > array.length) {
      return;
    }

    // 內層 loop 轉換成 recursive
    // 1. 計數器
    int i_exe = 0;
    // 每個內層 recursive 執行的次數
    int exeTimes = array.length - round - 1;
    // 2. 資料流
    exe_recur(i_exe, exeTimes);

    round_recur(round + 1);
  }

  private void exe_recur(int i_exe, int exeTimes) {
    // 3. recursive terminations
    if (i_exe >= exeTimes) {
      return;
    }
    // switch
    if (array[i_exe] > array[i_exe + 1]) {
      int tmp = array[i_exe + 1];
      array[i_exe + 1] = array[i_exe];
      array[i_exe] = tmp;
    }

    exe_recur(i_exe + 1, exeTimes);
  }

  public int[] getArray() {
    return this.array;
  }

  public static void main(String[] args) {

    int[] array = {8, 2, 6, 10, 4};

    BubbleSortImpl bubbleSort = new BubbleSortImpl(array);

//    bubbleSort.sort();

    bubbleSort.sortWithRecur();

    int[] sortArr = bubbleSort.getArray();

    System.out.println(sortArr);

  }
}
