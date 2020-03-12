package org.hanrw.sort;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author hanrw
 * @date 2020/3/12 6:16 PM
 * TopK 问题一般采用大顶堆来实现 时间复杂度O(log(n))
 */
public class HeapSort {

  PriorityQueue<Integer> maxHeap;
  int topK;

  public static void main(String[] args) {
    Random ran = new Random();
    HeapSort heapSort = new HeapSort(10);
    for (int i = 0; i < 1000000; i++) {
      heapSort.add(ran.nextInt(10000));
    }
    while (!heapSort.maxHeap.isEmpty()){
      System.out.print(heapSort.maxHeap.poll()+"\t");
    }

  }

  public HeapSort(int topK) {
    this.topK = topK;
    this.maxHeap = new PriorityQueue<>(topK, (a, b) -> b - a);
  }


  public void add(int number) {
    /**
     * 堆还没有装满的时候,直接添加
     */
    if (maxHeap.size() < topK) {
      maxHeap.add(number);
    } else {
      /**
       * 取出当前root节点(堆顶)和新添加的值比较
       * 如果新添加的值大于对顶,那么把对顶删除替换
       */
      Integer currentMax = maxHeap.peek();
      if (currentMax != null && number > currentMax) {
        maxHeap.poll();
        maxHeap.add(number);
      }
    }

  }
}
