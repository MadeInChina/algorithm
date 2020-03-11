package org.hanrw.search;

/**
 * @author hanrw
 * @date 2020/3/11 10:34 AM
 * 前置条件数列有序
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] sortedData = {1, 2, 3, 4, 5, 8};
    /**
     * results:
     * 2
     * 0
     * 5
     */
    System.out.println(binarySearch(sortedData, 3));
    System.out.println(binarySearch(sortedData, 1));
    System.out.println(binarySearch(sortedData, 8));
  }

  /**
   * 二分即对折查找
   * 例如查找1
   *                  [1, 2, 3, 4, 5, 8]
   * 左右指针(0,5)      ^              ^
   * 第一次对折
   *                  [1, 2] [3] [4, 5, 8]
   * 左中右指针(0,2,5)  ^      ^         ^
   * 1比mid 3的值要小, 那么只需找mid左边的数据
   * 然后把mid指针指向到mid的前面一个数据继续重复以上操作
   * 只需要在数据 [1, 2]里面进行第二次对折查找
   * @param sortedData 排序号的数据
   * @param searchTarget 需要查找的值
   * @return 返回下标位置
   */
  private static int binarySearch(int[] sortedData, int searchTarget) {

    int left = 0;
    int right = sortedData.length - 1;

    while (left <= right) {
      /**
       * (left + right) >> 1  等于 (left + right) / 2
       */
      int mid = (left + right) >> 1;
      int midValue = sortedData[mid];
      if (midValue < searchTarget) {
        left = mid + 1;
      } else if (midValue > searchTarget) {
        right = mid - 1;
      } else {
        /**
         * 找到下标
         */
        return mid;
      }
    }
    /**
     * 没找到
     */
    return -1;
  }
}
