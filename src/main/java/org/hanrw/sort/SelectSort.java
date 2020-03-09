package org.hanrw.sort;


import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/9 2:19 PM
 * 时间复杂度O(N^2)
 * 空间复杂度O(N)
 * 不稳定排序
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 7, 8, 5};

    System.out.println(Arrays.toString(selectSort(toBeSorted)));
  }

  private static int[] selectSort(int[] toBeSorted) {
    /**
     * 遍历循环全部数据
     */
    for (int i = 0; i < toBeSorted.length; i++) {
      /**
       * 遍历当前数据以后的数据
       * 然后找到最小的值的下标
       */
      int minPointer = i;
      for (int j = i + 1; j < toBeSorted.length; j++) {
        /**
         * 找到最小的值下标
         */
        if (toBeSorted[j] < toBeSorted[i]) {
          minPointer = j;
        }
      }
      /**
       * 比较当前值的计算出来的最小值是否交换位置
       */
      swap(toBeSorted, i, minPointer);

    }

    return toBeSorted;
  }

  private static void swap(int[] toBeSorted, int from, int to) {
    if (toBeSorted[from] > toBeSorted[to]) {
      int temp = toBeSorted[to];
      toBeSorted[to] = toBeSorted[from];
      toBeSorted[from] = temp;
    }
  }

}
