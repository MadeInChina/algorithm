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
public class BubbleSortV3 {

  public static void main(String[] args) {
    /*
    准备即将排序的数据
     */
    int[] toBeSorted = {5, 4, 9, 0, 1, 2};

    /*
    开始排序
    调用bubbleSort方法
     */
    System.out.println(Arrays.toString(bubbleSort(toBeSorted)));
  }

  private static int[] bubbleSort(int[] toBeSorted) {
    int length = toBeSorted.length;
    //第一层遍历,需要遍历多少次
    for (int i = 0; i < length; i++) {

      //第二层遍历次数为n-1次
      //每一次遍历后都能确定一个元素的位置,所以可以不用比较排好顺序的元素了 - i
      for (int j = 0; j < length - 1 - i; j++) {
       // 相邻两个元素比较交换
        compareAndSwap(toBeSorted, j, j + 1);
      }

    }
  return toBeSorted;

  }

  private static void compareAndSwap(int[] toBeSorted, int current, int next) {
    // 如果前一个大于后一个元素
    if(toBeSorted[current]>toBeSorted[next]){
      swap(toBeSorted,  current,  next);
    }
  }

  private static void swap(int[] toBeSorted, int current, int next) {
    toBeSorted[current] += toBeSorted[next];
    toBeSorted[next] = toBeSorted[current] - toBeSorted[next];
    toBeSorted[current] -= toBeSorted[next];
  }


}
