package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 这题是二叉树的遍历问题
 * 分情况讨论
 * 然后通过深度优先遍历即可
 */

public class MinDepthBT {

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return run(root.right) + 1;
        }
        if (root.right == null) {
            return run(root.left) + 1;
        }
        int leftDepth = run(root.left);
        int rightDepth = run(root.right);
        return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
    }


}
