package org.hanrw.sort;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/9 2:42 PM
 * 时间复杂度O(N^2)
 * 空间复杂度O(N)
 * 交换次数(N2~N!)
 * 稳定排序
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] toBeSorted = {4, 5, 3, 6, 2, 1};

    System.out.println(Arrays.toString(bubbleSort(toBeSorted)));
  }

  private static int[] bubbleSort(int[] toBeSorted) {

    /*
      遍历数据
      依次比较相邻的两个数据,如果大小顺序不对
     * 那么交换位置
     */
    int n = toBeSorted.length;
    /*
     *排序次数 e.g  [2, 1] 排序次数等于n-1
     */
    for (int i = 0; i < n - 1; i++) {
      /*
       -i 每次排序后都确定一个数的位置
       */
      for (int j = 0; j < n - 1 - i; j++) {
        if (toBeSorted[j] > toBeSorted[j + 1]) {
          swap(toBeSorted, j, j + 1);
        }
      }
      System.out.println("bubble sort:" + i + " order:" + Arrays.toString(toBeSorted));

    }

    return toBeSorted;
  }

  private static void swap(int[] toBeSorted, int from, int to) {
//    int temp = toBeSorted[to];
//    toBeSorted[to] = toBeSorted[from];
//    toBeSorted[from] = temp;
    /**
     * 不用临时变量的方法
     */
    toBeSorted[to] = toBeSorted[from] + toBeSorted[to];
    toBeSorted[from] = toBeSorted[to] - toBeSorted[from];
    toBeSorted[to] = toBeSorted[to] - toBeSorted[from];

  }

}
