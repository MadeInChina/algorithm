package org.hanrw.sort;


import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/8 3:01 PM
 * 时间复杂度O(N)
 * 类似打扑克:
 *  1.你手里的牌(已排序)
 *  2.需要拿的牌(未排序)
 *  把未排序的牌一个个插入到已排序的数列中
 * 插入排序流程
 * 1.将数据分成已排序和未排序段，最开始已排序段只有一个元素
 * 2.到未排序段取一个元素，插入已排序段且保证有序
 * 3.重复执行以上过程，直到排序完成
 */
public class InsertSortV2 {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 7, 8, 5};
    System.out.println(Arrays.toString(insertSort(toBeSorted)));
  }

  /**
   * 插入排序
   *            {3, 2, 1, 7, 8, 5}
   * preIndex    ^
   * currentIndex   ^
   * 第一个元素不需要遍历
   * 第一次循环2和3比较,交换位置
   *            {2, 3, 1, 7, 8, 5}
   * =============================
   * 第二次循环1分别和3,2比较,交换位置
   *            {2, 3, 1, 7, 8, 5}
   * preIndex       ^
   * currentIndex      ^
   * 和3比较交换位置
   *            {2, 1, 3, 7, 8, 5}
   * preIndex       ^
   * currentIndex      ^
   * 和2比较交换位置
   *            {2, 1, 3, 7, 8, 5}
   * preIndex    ^
   * currentIndex      ^
   * ......
   * @param toBeSorted
   * @return
   */
  private static int[] insertSort(int[] toBeSorted) {
    int size = toBeSorted.length;
    // 遍历未排序数列,第一个元素(下标)不需要遍历
    for (int i = 1; i < size; i++) {
      int preIndex = i - 1;
      int currentData = toBeSorted[i];
      for (; preIndex >= 0; preIndex--) {
        int preData = toBeSorted[preIndex];
        // 如果前一个元素比当前元素大交换位置,pre和pre+1交换
        if (preData > currentData) {
          toBeSorted[preIndex] = currentData;
          toBeSorted[preIndex+1] = preData;
        }
        //前一个元素已经比当前元素大了,则退出循环
        else {
          break;
        }
      }
    }
    return toBeSorted;
  }
}
