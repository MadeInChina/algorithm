package org.hanrw.sort;

import java.util.Arrays;

/**
 * @author hanrw
 * @date 2020/3/9 12:58 PM
 */
public class ShellSort {

  public static void main(String[] args) {
    int[] toBeSorted = new int[]{3, 5, 2, 6, 1};
    System.out.println(Arrays.toString(sort(toBeSorted)));
  }

  private static int[] sort(int[] toBeSorted) {
    /**
     * 将数据每次分段,步幅等于数据量除以2
     * e.g. [3, 6, 2, 5, 1],数据量等于5
     * 循环退出条件: 小于2
     * 第一次遍历步幅等于: 5/2 = 2
     * 第一次数据分为 [3,2] [6,5] [1]
     * 比较返回后数据为
     * [2,3] [5,6] [1]
     * 第二次遍历步幅等于: 2/2 = 1
     * [2,3] [5,6] [1]
     * 直接对上面的数据插入排序
     * [1,2,3,5,6]
     */
    for (int step = toBeSorted.length / 2; step >= 1; step /= 2) {

      /**
       * 增加步幅后的数据和前面的数据比较
       * 插入排序
       */
      for (int j = step; j < toBeSorted.length; j++) {
        int curData = toBeSorted[j];
        int preIndex = j - step;
        for (; preIndex >= 0; preIndex -= step) {
          /**
           * 如果前一个数据大于当前数据
           * 那么把前一个数据往后移
           */
          if (toBeSorted[preIndex] > curData) {
            /**
             * 那么把前一个数据往后移
             */
            toBeSorted[preIndex + step] = toBeSorted[preIndex];
          }
          /**
           * 如果当前数据大于前一个数据说明位置关系正确 跳出循环
           */
          else {
            break;
          }
        }
        /**
         * 把当前数据插入到交换后的位置
         */
        toBeSorted[preIndex + step] = curData;
      }

    }
    return toBeSorted;
  }

}
