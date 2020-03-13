package org.hanrw.advanced.tree;

/**
 * @author hanrw
 * @date 2020/3/13 5:17 PM
 * 树的结构
 */
public class TreeNode {

  String name;

  TreeNode left;
  TreeNode right;

  public TreeNode(String name, TreeNode left, TreeNode right) {
    this.name = name;

    this.left = left;
    this.right = right;
  }

  public static TreeNode generateTree() {
    TreeNode dNode = new TreeNode("D", null, null);
    TreeNode eNode = new TreeNode("E", null, null);
    TreeNode bNode = new TreeNode("B", dNode, eNode);

    TreeNode fNode = new TreeNode("F", null, null);
    TreeNode gNode = new TreeNode("G", null, null);
    TreeNode cNode = new TreeNode("C", fNode, gNode);

    TreeNode aNode = new TreeNode("A", bNode, cNode);

    return aNode;
  }
}
