package org.hanrw.sort;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/9 2:42 PM
 * 时间复杂度O(N^2)
 * 空间复杂度O(N)
 * 交换次数(N2~N!)
 * 稳定排序
 * 打印每次排序的结果
 */
public class BubbleSortV2 {

  public static void main(String[] args) {
    /*
    准备即将排序的数据
     */
    int [] toBeSorted = {4, 5, 3, 6, 2, 1};

    /*
    开始排序
    调用bubbleSort方法
     */
    bubbleSort(toBeSorted);
  }

  /**
   * 冒泡排序算法
   * 注意三点
   *  1.相邻两个元素比较
   *  2.如果大小不满足关系,则交换相邻两个元素位置
   *  3.每一次冒泡结束后,可以确定一个元素本应该在的位置
   * @param toBeSorted
   */
  private static void bubbleSort(int[] toBeSorted) {
    /*
    开始遍历元素
                           {4, 5, 3, 6, 2, 1}
    当前下标开始位置 i        ^
    相邻元素的下标开始位置i+1     ^
    排序次数等于n-1
     */
    int length = toBeSorted.length;
    for (int i = 0; i < length - 1; i++) {
      /*
       为什么减i, 是因为每次冒泡接受都可以确定一个元素的位置,所以那个位置就不需要再进行比较了
       */
      for (int j = 0; j < length - 1 - i; j++) {
        /*
        开始比较相邻元素的大小
         */
        compareAndSwap(toBeSorted, j, j + 1);
      }
      System.out.println("bubble sort:" + i + " order:" + Arrays.toString(toBeSorted));
    }

  }

  private static void compareAndSwap(int[] toBeSorted, int current, int next) {
    /*
    比较两个数
    如果当前的元素大于后一个相邻的元素
    则换位置
     */
    if (toBeSorted[current] > toBeSorted[next]) {
      swap(toBeSorted, current, next);
    }
  }

  private static void swap(int[] toBeSorted, int current, int next) {
    /*
    可以不用零时变量交换位置,如果是用数字的话
     */
    toBeSorted[current] += toBeSorted[next];
    toBeSorted[next] = toBeSorted[current] - toBeSorted[next];
    toBeSorted[current] -= toBeSorted[next];
  }

}
