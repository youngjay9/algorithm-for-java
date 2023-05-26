package com.jay.array;

public class ArrayImpl {

  private String[] arr;

  private int i_end;

  public ArrayImpl(int size) {
    arr = new String[size];
    i_end = -1;
  }

  public void add_space() {
    // array length add 2 times
    String[] new_arr = new String[arr.length * 2];

    // 將既有陣列的資料搬到 new_arr
    for (int i = 0; i < arr.length; i++) {
      new_arr[i] = arr[i];
    }

    this.arr = new_arr;
  }

  public void add_by_indx(int i_add, String val) {
    // 先檢查目前陣列長度是否需擴充
    if ((i_end + 1) == arr.length) {
      add_space();
    }

    // 檢查 i_add 是否正確：超過最後一個 element 兩個位置 or -1
    if (i_add > (i_end + 1) || i_add < -1) {
      return;
    }

    for (int count = i_end; count >= i_add; count--) {
      arr[count + 1] = arr[count];
      arr[count] = null;
    }

    arr[i_add] = val;
    i_end++;
  }

  public void add_by_val(String val) {
    add_by_indx(i_end + 1, val);
  }

  public void remove_by_indx(int i_del) {
    if (i_del >= i_end + 1 || i_del < 0) {
      return;
    }

    arr[i_del] = null;

    for (int count = i_del; count < i_end; count++) {
      arr[count] = arr[count + 1];
      arr[count + 1] = null;
    }

    i_end--;
  }

  public void remove_by_val(String val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(val)) {
        remove_by_indx(i);
        break;
      }
    }
  }

  public String search_by_indx(int indx) {
    if (indx > i_end || indx < 0) {
      return null;
    }

    return arr[indx];
  }

  public String search_by_val(String val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(val)) {
        return arr[i];
      }
    }

    return null;
  }

  public static void main(String[] args) {

    ArrayImpl arr = new ArrayImpl(4);

    arr.add_by_indx(0, "a");
    arr.add_by_indx(1, "b");
    arr.add_by_indx(2, "c");
    arr.add_by_indx(3, "d");

    arr.remove_by_indx(1);


  }

}
