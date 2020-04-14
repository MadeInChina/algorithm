package org.hanrw.sort;

import java.util.Arrays;

/**
 * 时间复杂度log(N)
 * @author hanrw
 * @date 2020/3/8 5:48 PM
 */
public class MergeSortV2 {

  public static void main(String[] args) {
    int[] toBeSorted = {3, 2, 1, 7, 8, 5, 0, 9};
    int leftIndex = 0;
    int rightIndex = toBeSorted.length - 1;
    System.out.println(Arrays.toString(mergeSort(toBeSorted,leftIndex,rightIndex)));
  }


  /**
   * 第一步分: 把需要排序的数据分到知道不能分为止.
   * 比如:{3, 2, 1, 7, 8, 5, 0, 9}
   * 分为
   *                     {3  2  1  7  8  5  0  9}
   *                        /               \
   *                       /                 \
   *                      /                   \
   *                     /                     \
   *                    /                       \
   *              {3  2  1  7}            {8  5  0  9}
   *                 /   \                  /     \
   *                /     \                /       \
   *               /       \              /         \
   *             {3  2}    {1  7}      {8  5}   {0  9}
   *            /   \       /   \      /   \     /   \
   *           /     \     /     \    /     \   /     \
   *          3       2   1       7  8       5  0      9
   *第二步合:   \     /    \      /   \      /   \      /
   *插入排序：   \   /      \    /     \    /     \    /
   *           {2  3}      {1  7}     {5  8}     {0  9}
   *              \          /          \          /
   *               \        /            \        /
   *                \      /              \      /
   *             {1  2  3  7}            {0  5  8  9}
   *                  \                        /
   *                   \                      /
   *                    \                    /
   *                     \                  /
   *                      \                /
   *                   {0  1  2  3  5  7  8  9}
   * @param toBeSorted 待排序数据
   * @param leftIndex
   * @param rightIndex
   */
  private static int[] mergeSort(int[] toBeSorted, int leftIndex,int rightIndex) {
    splitAndMerge(toBeSorted, leftIndex, rightIndex);
    return toBeSorted;
  }

  private static void splitAndMerge(int[] toBeSorted, int leftIndex, int rightIndex) {
    // 相等表示只有一个元素,不需要再继续拆分了
    if (leftIndex < rightIndex) {
      int middleIndex = (leftIndex + rightIndex) / 2;
      // 继续拆分左边
      splitAndMerge(toBeSorted, leftIndex, middleIndex);
      // 继续拆分右边边
      splitAndMerge(toBeSorted, middleIndex + 1, rightIndex);
      // 拆分完后,排序合并
      sortAndMerge(toBeSorted, leftIndex, middleIndex, rightIndex);
    }
  }

  private static void sortAndMerge(int[] toBeSorted, int leftIndex, int middleIndex, int rightIndex) {
    int[] temp = new int[toBeSorted.length];

    // 左边的第一个元素位置
    int leftPointer = leftIndex;
    // 右边的第一个元素位置
    int rightPointer = middleIndex + 1;
    // 当前的位置
    int loc = leftIndex;

    while (leftPointer <= middleIndex && rightPointer <= rightIndex) {
      if (toBeSorted[leftPointer] < toBeSorted[rightPointer]) {
        temp[loc] = toBeSorted[leftPointer];
        leftPointer++;
      }
      else{
        temp[loc] = toBeSorted[rightPointer];
        rightPointer++;
      }
      loc++;
    }
    // 把剩余没有赋值完的元素进行赋值
    while (leftPointer <= middleIndex) {
      temp[loc++] = toBeSorted[leftPointer++];
    }

    while (rightPointer <= rightIndex) {
      temp[loc++] = toBeSorted[rightPointer++];
    }

    // 把元素拷贝到元素组
    for (int i = leftIndex; i <= rightIndex; i++) {
      toBeSorted[i] = temp[i];
    }

  }
}
