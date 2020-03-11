package org.hanrw.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hanrw
 * @date 2020/3/11 11:30 AM
 * 使用场景 排序有200w学生的考试成绩(成绩范围在0~900)
 */
public class CountSort {

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

  private static int[] countSort(int[] scores) {
    /**
     * 0 到 900分
     */
    int temp[] = new int[900];
    /**
     * 遍历所有的分数
     */
    for (int i = 0; i < scores.length - 1; i++) {
      /**
       * 获取分数
       */
       int score = scores[i];
      /**
       * 将相同分数的人数加一
       */
      temp[score] ++;
    }

    return temp;
  }
}
