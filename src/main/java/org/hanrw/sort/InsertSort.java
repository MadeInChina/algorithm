package org.hanrw.sort;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/8 3:01 PM
 * 时间复杂度O(N)
 * 插入排序流程
 * 1.将数据分成已排序和未排序段，最开始已排序段只有一个元素
 * 2.到未排序段取一个元素，插入已排序段且保证有序
 * 3.重复执行以上过程，直到排序完成
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 7, 8, 5};

    System.out.println(Arrays.toString(insertSort(toBeSorted)));
  }

  public static int[] insertSort(int[] toBeSorted) {

    /** 第一个元素不需要排序. 例如 [3,2,1,7,8,5] 2是最开的第一个元素 从3开始遍历 */
    for (int i = 1; i < toBeSorted.length; i++) {
      /** 获取当前元素的值 */
      int curData = toBeSorted[i];
      /** 和前面的一个元素依次比较 */
      for (int j = i - 1; j >= 0; j--) {
        /** 如果前一个元素大于当前的元素,则把前一个元素和当前元素交换 */
        int preData = toBeSorted[j];
        if (preData > curData) {
          toBeSorted[j + 1] = preData;
          toBeSorted[j] = curData;
        } else {
          /** 当前元素已经大于前一个元素，就不需要再进行比较了 */
          break;
        }
      }
      System.out.println("No: " + i + " current order" + Arrays.toString(toBeSorted));
    }

    return toBeSorted;
  }

  public static int[] insertSort2(int[] toBeSorted) {

    /** 第一个元素不需要排序. 例如 [3,2,1,7,8,5] 2是最开的第一个元素 从3开始遍历 */
    for (int i = 1; i < toBeSorted.length; i++) {
      /** 获取当前元素的值 */
      int curData = toBeSorted[i];
      /** 和前面的一个元素依次比较 */
      int preIndex = i - 1;
      for (; preIndex >= 0; preIndex--) {
        /** 如果前一个元素大于当前的元素,则把前一个元素往后移 */
        int preData = toBeSorted[preIndex];
        if (preData > curData) {
          toBeSorted[preIndex + 1] = preData;
        } else {
          /** 当前元素已经大于前一个元素，就不需要再进行比较了 */
          break;
        }
      }
      toBeSorted[preIndex + 1] = curData;
      System.out.println("No: " + i + " current order" + Arrays.toString(toBeSorted));
    }

    return toBeSorted;
  }
}
