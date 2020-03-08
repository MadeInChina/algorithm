package org.hanrw.sort;

import static java.util.Arrays.copyOfRange;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/8 5:48 PM
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 7, 8, 5};
    System.out.println(Arrays.toString(splitSort(toBeSorted)));
  }

  /**
   * @param toBeSorted 待排序数据
   */
  private static int[] splitSort(int[] toBeSorted) {

    /**
     * 第一步分: 把需要排序的数据分到知道不能分为止.
     * 比如:{1, 2, 3, 4, 5}
     * 分为
     *             1 2 3 4 5
     *               /   \
     *              /     \
     *             /       \
     *          1 2       3 4 5
     *          / \        / \
     *         /   \      /   \
     *        /     \    /     \
     *       1      2  3 4      5
     *                 / \
     *                /   \
     *               /     \
     *              3      4
     */

    /**
     * 跳出递归条件
     */
    if (toBeSorted.length < 2) {
      return toBeSorted;
    }

    /**
     * 计算中间位
     */
    int middle = (int) Math.floor(toBeSorted.length / 2);
    /**
     * 左边数据
     */
    int[] left = copyOfRange(toBeSorted, 0, middle);
    System.out.println("left:" + Arrays.toString(left));
    /**
     * 右边数据
     */
    int[] right = copyOfRange(toBeSorted, middle, toBeSorted.length);
    System.out.println("right:" + Arrays.toString(right));

    /**
     * 合并排序左右数据
     */
    return mergeSort(splitSort(left), splitSort(right));
  }

  private static int[] mergeSort(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int leftPointer = 0;
    int rightPointer = 0;
    int currentPointer = 0;
    /**
     * 左边和后边循环比较
     * 如果左边的值大于右边的值,那么把右边较小的值放在结果里面
     * 如果左边的值小于右边的值,那么把左右较小的值放在结果里面
     */
    while (leftPointer <= left.length - 1 && rightPointer <= right.length - 1) {
      if (left[leftPointer] > right[rightPointer]) {
        result[currentPointer++] = right[rightPointer++];
      } else {
        result[currentPointer++] = left[leftPointer++];
      }
    }

    /**
     * 上一步循环完成后还有数据没有放到结果里面,继续放入
     */
    while (rightPointer <= right.length - 1) {
      result[currentPointer++] = right[rightPointer++];
    }

    while (leftPointer <= left.length - 1) {
      result[currentPointer++] = left[leftPointer++];
    }

    return result;
  }

}
