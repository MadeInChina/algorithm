package org.hanrw.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hanrw
 * @date 2020/3/11 11:30 AM
 * 使用场景 排序有200w学生的考试成绩(成绩范围在0~900)
 *
 * 是一个固定大小的范围
 * 下标相当于已经排好序
 */
public class CountSortV2 {

  public static void main(String[] args) {
    int scores[] = new int[10000];
    Random ran = new Random();
    /**
     * 模拟填充数据
     */
    for (int i = 0; i < scores.length - 1; i++) {
      scores[i] = ran.nextInt(900);
    }

    System.out.println(Arrays.toString(countSort(scores)));
  }

  /**
   * 计数排序
   * @param scores
   * @return
   */
  private static int[] countSort(int[] scores) {
    // 0~900分范围, 下标为0代表0分, 下标为1代表1分.....
    int[] temp = new int[900];
    for (int i = 0; i < scores.length; i++) {
      // 每一个人的分数
      int score = scores[i];
      // 直接把分数当做下标使用,分数相同人数加1
      temp[score]++;
    }

    return temp;
  }


}
