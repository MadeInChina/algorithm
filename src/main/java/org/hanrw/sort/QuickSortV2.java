package org.hanrw.sort;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/9 4:29 PM
 */
public class QuickSortV2 {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 5, 0, 4};

    System.out.println(Arrays.toString(quickSort(toBeSorted, 0, toBeSorted.length - 1)));
  }

  /**
   * 主要步骤
   * 1.取基准数,一般情况默认取第一个元素
   * 2.从后面往前面找到比基准数小的数进行交换
   * 3.然后再从前面找到比基准数大的数进行交换
   * 最后得到的结果是
   * 以基准数分为两个部分
   *  左边都比基准数小
   *  右边都比基准数大
   *  e.g [3, 2, 1]
   *       / \
   *      /   \
   *     1  2  3
   */
  private static int[] quickSort(int[] toBeSorted, int left, int right) {
    //原始数据                 [3, 2, 1, 5, 0, 4]
    //左右指针                  ^              ^
    //round 1                 [0, 2, 1, 5, 3, 4] 找右边比基准小的数据(找到0,交换位置,右指针--1)
    //左右指针              leftPointer ++ rightPointer --
    //左右指针                     ^        ^
    // ....................
    //round 2                 [0, 2, 1, 3, 5, 4] 找左边边比基准大的数据(找到5,交换位置,循环三次左指针++1)
    //左右指针                           ^  ^
    //round 3                 [0, 2, 1, 3, 5, 4] 找右边比基准小的数据(没有找到,右指针--1),左右指针同时指向3
    //左指针                             ^
    //右指针                             ^
    //递归左右区间  (left-> leftPointer -1) (3) (leftPointer+1->right)

    // 取基准数
    int base = toBeSorted[left];

    // 左指针
    int leftPointer = left;
    // 右指针
    int rightPointer = right;

    // 从最后一个数开始找比基准数小的数的指针
    while (leftPointer < rightPointer) {
      // 从最后一个数开始找比基准数小的数
      while (leftPointer < rightPointer) {
        // 如果右边小于基准数的数,交换位置
        if (toBeSorted[rightPointer] < base) {
          swap(toBeSorted, leftPointer, rightPointer);
          leftPointer++;
          break;
        }
        // 没找到继续找下一个
        rightPointer--;
      }

      // 从前面开始找比基准数大的数
      while (leftPointer < rightPointer) {
        // 找到一个比基准数大的数交换位置
        if (toBeSorted[leftPointer] > base) {
          swap(toBeSorted, leftPointer, rightPointer);
          rightPointer--; // 和后面的下一个元素做比较的指针
          break;
        }
        // 没找到继续找下一个
        leftPointer++;
      }

      if (left < leftPointer) {
        quickSort(toBeSorted, left, leftPointer - 1);
      }
      if (rightPointer < right) {
        quickSort(toBeSorted, leftPointer + 1, right);
      }
    }
    return toBeSorted;
  }

  private static void swap(int[] toBeSorted, int left, int right) {
    int temp = toBeSorted[right];
    toBeSorted[right] = toBeSorted[left];
    toBeSorted[left] = temp;
  }
}
