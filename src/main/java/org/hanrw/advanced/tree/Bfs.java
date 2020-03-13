package org.hanrw.advanced.tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author hanrw
 * @date 2020/3/13 5:12 PM
 * 层次遍历
 * 一层一层遍历,其实就是广度优先的应用
 * Breadth-First-Search
 * 广度优先记住三点:
 * 1.队列
 * 2.标记数组(哪些已经遍历过了)
 * 3.加过的点不能在加
 */
public class Bfs {

  /**
   *       树结构如下
   *          A
   *        /   \
   *      B      C
   *     |       |
   *    / \     / \
   *   D  E    F   G
   *   层次遍历:A->B->C->D->E->F->G
   * @param args
   */
  public static void main(String[] args) {
    printOrder(TreeNode.generateTree());
  }

  public static void printOrder(TreeNode node) {
    if(node == null){
      return;
    }

    /**
     * 定义队列
     */
    Queue<TreeNode> queue = new ArrayBlockingQueue<>(7);
    /**
     * 广度优先算法:
     * 1.添加当前节点到队列
     *  队列加入第一个元素:A
     *   |A|
     * 2.如果队列不等于空,那么出队(A出队).打印出A
     *   ||
     * 3.如果A的左右节点不为空,加入队列
     *   ||
     *  队列加入第二三个元素:B,C
     *   |B|C|
     * 4.循环以上步骤
     */
     queue.add(node);

     while (!queue.isEmpty()){
       TreeNode poll = queue.poll();
       System.out.println(poll.name);
       if(poll.left!=null){
         queue.add(poll.left);
       }
       if(poll.right!=null){
         queue.add(poll.right);
       }
     }
  }

}
