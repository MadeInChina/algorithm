package org.hanrw.advanced.tree;

/**
 * @author hanrw
 * @date 2020/3/13 5:12 PM
 * 中序遍历
 * 左根右
 * left degree right
 */
public class Ldr {

  /**
   *       树结构如下
   *          A
   *        /   \
   *      B      C
   *     |       |
   *    / \     / \
   *   D  E    F   G
   *   中序遍历返回:D->B->E->A->F->C->G
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
    System.out.println(node.name);
    /**
     * 递归退出条件
     */
    if (node.right != null) {
      printOrder(node.right);
    }
  }
}
