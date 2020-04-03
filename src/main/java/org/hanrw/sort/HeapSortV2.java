package org.hanrw.sort;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author hanrw
 * @date 2020/3/12 6:16 PM
 * TopK 问题一般采用大顶堆来实现 时间复杂度O(log(n))
 * PriorityQueue 通过二叉小顶堆实现,可以用一棵完全二叉树表示
 */
public class HeapSortV2 {

  private final int topK;
  private PriorityQueue<Integer> maxHeap;

  /**
   * 构造函数需要传入初始容量,默认是小顶堆.
   * 所以需要设置比较器,转换为大顶堆
   * @param topK
   */
  public HeapSortV2(int topK) {
    this.topK = topK;
    this.maxHeap = new PriorityQueue<>(topK, (a, b) -> b - a);
  }

  /**
   * 如果要计算top 10
   * @param args
   */
  public static void main(String[] args) {
    // 初始化容量10,既top10
    HeapSortV2 heapSortV2 =new HeapSortV2(10);

    // 随机数生成100W进行计算topk
    Random ran = new Random();
    for (int i = 0; i < 1000000; i++) {
      heapSortV2.add(ran.nextInt(10000));
    }
    while (!heapSortV2.maxHeap.isEmpty()){
      System.out.print(heapSortV2.maxHeap.poll()+"\t");
    }

  }

  /**
   * 往优先队列里面添加元素
   * 如果已经超过初始容量,那么从优先队列里面头部元素和当前值做比较
   * 如果当前值较大,那么从优先队列中弹出元素,加入当前元素
   * @param n
   */
  private void add(int n) {
    if (maxHeap.size() < topK) {
      maxHeap.add(n);
    } else if (n > maxHeap.peek()) {
      maxHeap.poll();
      maxHeap.add(n);
    }
  }


}
