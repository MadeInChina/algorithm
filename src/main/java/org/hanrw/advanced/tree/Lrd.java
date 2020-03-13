package org.hanrw.advanced.tree;

/**
 * @author hanrw
 * @date 2020/3/13 5:12 PM
 * 后序遍历
 * 左右根
 * left right degree
 */
public class Lrd {

  /**
   *       树结构如下
   *          A
   *        /   \
   *      B      C
   *     |       |
   *    / \     / \
   *   D  E    F   G
   *   中序遍历返回:D->E->B->F->G->C->A
   * @param args
   */
  public static void main(String[] args) {
    printOrder(TreeNode.generateTree());
  }

  public static void printOrder(TreeNode node) {

    /**
     * 递归退出条件
     */
    if (node.left != null) {
      printOrder(node.left);
    }
    /**
     * 递归退出条件
     */
    if (node.right != null) {
      printOrder(node.right);
    }
    System.out.println(node.name);
  }

}
