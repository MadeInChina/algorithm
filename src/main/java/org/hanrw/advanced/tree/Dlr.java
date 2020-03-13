package org.hanrw.advanced.tree;

/**
 * @author hanrw
 * @date 2020/3/13 5:12 PM
 * 前序遍历
 * 根左右
 * degree left right
 */
public class Dlr {


  /**
   *       树结构如下
   *          A
   *        /   \
   *      B      C
   *     |       |
   *    / \     / \
   *   D  E    F   G
   *   前序遍历返回:A->B->D->E->C->F->G
   * @param args
   */
  public static void main(String[] args) {
    printOrder(TreeNode.generateTree());
  }

  public static void printOrder(TreeNode node) {
    System.out.println(node.name);
    /**
     * 递归退出条件
     */
    if (node.left == null && node.right == null) {
      return;
    }
    printOrder(node.left);
    printOrder(node.right);
  }


}
