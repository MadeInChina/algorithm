package org.hanrw.sort;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/9 4:29 PM
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 5, 0, 4};

    //原始数据                 [3, 2, 1, 5, 0, 4]
    //左右指针                  ^              ^
    //round 1                 [0, 2, 1, 5, 3, 4] 找右边比基准小的数据(找到0,交换位置,右指针--1)
    //左右指针                  ^           ^
    //round 2                 [0, 2, 1, 3, 5, 4] 找左边边比基准大的数据(找到5,交换位置,循环三次左指针++1)
    //左右指针                           ^  ^
    //round 3                 [0, 2, 1, 3, 5, 4] 找右边比基准小的数据(没有找到,右指针--1),左右指针同时指向3
    //左指针                             ^
    //右指针                             ^
    //递归左右区间  (left-> leftPointer) (3) (leftPointer+1->right)

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
    /**
     * 如果左指针大于等于右指针说明 当前左右指针已经指向了同一数据(只有一个数据)
     */
    if (left > right) {
      return toBeSorted;
    }
    int leftPointer = left; // left == 0
    int rightPointer = right; // right == 2
    /**
     * 取第一为数据为基准数
     */
    int base = toBeSorted[leftPointer]; //base == 3
    /**
     * 从左右两边依次遍历直到 leftPointer=rightPointer
     */
    while (leftPointer < rightPointer) {
      /**
       * 从后面找到比基准数小的数
       * 左边的指针位置小于右边指针位置
       *  并且
       * 找到右边比基准数小的数
       */
      while (leftPointer < rightPointer && base < toBeSorted[rightPointer]) { //leftPointer==0 rightPointer==2  base==3 toBeSorted[rightPointer] = 1
        rightPointer--; //移动右指针 1
      }
      /**
       * 如果左边还小于右边,就说明找到了一个数据比基准值要小
       * 那么交换基准数和右边数据的位置
       */
      if(leftPointer < rightPointer){ //leftPointer==0 rightPointer==1
        swap(toBeSorted, leftPointer, rightPointer); //leftPointer==0 rightPointer==2 => 3 和 1进行交换=> [1, 2 ,3]
      }

      /**
       * 从前面找到比基准数大的数
       * 左边的指针位置小于右边指针位置
       *  并且
       * 找到左边比基准数大的数
       */
      while (leftPointer < rightPointer && base > toBeSorted[leftPointer]) {
        leftPointer++; //移动左指针 1
      }
      /**
       * 如果左边还小于右边,就说明找到了一个数据比基准值要小
       * 那么交换基准数和右边数据的位置
       */
      if (leftPointer < rightPointer) {
        swap(toBeSorted, leftPointer, rightPointer);
      }

      /**
       * 左边继续排序
       */
      quickSort(toBeSorted, left, leftPointer - 1);
      /**
       * 右边边继续排序
       */
      quickSort(toBeSorted, rightPointer + 1, right);
    }
    return toBeSorted;
  }

  private static void swap(int[] toBeSorted, int left, int right) {
    int temp = toBeSorted[right];
    toBeSorted[right] = toBeSorted[left];
    toBeSorted[left] = temp;
    System.out.println("交换结果:" + Arrays.toString(toBeSorted));
  }
}
