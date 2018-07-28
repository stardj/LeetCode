package leetcode;


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

import java.util.ArrayList;
import java.util.Stack;

public class HouseRobberIII {
//    public int rob(TreeNode root) {
//        ArrayList<Integer> list = getBFSValues(root);
//        if (list.size() < 1) {
//            return 0;
//        }
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        if (list.size() == 2) {
//            return Math.max(list.get(0), list.get(1));
//        }
//
//        int result = 0;
//        int[] V = new int[list.size()];
//        V[0] = list.get(0);
//        V[1] = Math.max(list.get(0), list.get(1));
//
//        for (int i = 2; i < list.size(); i++) {
//            V[i] = Math.max(V[i - 1], list.get(i) + V[i - 2]);
//            if (V[i] > result) {
//                result = V[i];
//            }
//        }
//        return result;
//    }

//    public static ArrayList<Integer> getBFSValues(TreeNode root) {
//        Stack<TreeNode> stack_child = new Stack<TreeNode>();
//        Stack<TreeNode> stack_node = new Stack<TreeNode>();
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        do {
//            int sum = 0;
//            stack_node.push(root);
//            while (!stack_node.isEmpty()) {
//                TreeNode tmp = stack_node.pop();
//                if (tmp.left != null) {
//                    stack_child.push(tmp.left);
//                }
//                if (tmp.right != null) {
//                    stack_child.push(tmp.right);
//                }
//                sum += tmp.val;
//            }
//            list.add(sum);
//            while (!stack_child.isEmpty()) {
//                stack_node.push(stack_child.pop());
//            }
//        } while (!stack_node.isEmpty());
//        return list;
//    }

//    public int rob1(TreeNode root) {
//        Stack<TreeNode> stack_child = new Stack<TreeNode>();
//        Stack<TreeNode> stack_node = new Stack<TreeNode>();
//        ArrayList<Integer> V = new ArrayList<Integer>();
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return root.val;
//        }
//        int valL = root.left == null ? root.left.val : 0;
//        int valR = root.right == null ? root.right.val : 0;
//        if (valL == 0) {
//            if (valR != 0 && root.right.left == null && root.right.right == null) {
//                return Math.max(root.val, valR);
//            }
//        }
//        if (valR == 0) {
//            if (valL != 0 && root.left.left == null && root.left.right == null) {
//                return Math.max(root.val, valL);
//            }
//        }
//        TreeNode tmpL = root.left;
//        TreeNode tmpR = root.right;
//        if (tmpL.left == null && tmpL.right == null && tmpR.left == null && tmpR.right == null) {
//            return Math.max(root.val, valL + valR);
//        }
//
//        V.add(root.val);
//        V.add(Math.max(root.val, tmpL.val + tmpR.val));
//
//        if (tmpL != null) {
//            if (tmpL.left != null) {
//                stack_node.push(tmpL.left);
//            }
//            if (tmpL.right != null) {
//                stack_node.push(tmpL.right);
//            }
//        }
//
//        if (tmpR != null) {
//            if (tmpR.right != null) {
//                stack_node.push(tmpR.right);
//            }
//            if (tmpR.left != null) {
//                stack_node.push(tmpR.left);
//            }
//        }
//        int result = 0;
//        for (int i = 2; !stack_node.isEmpty(); i++) {
//            int sum = 0;
//            while (!stack_node.isEmpty()) {
//                TreeNode tmpNode = stack_node.pop();
//                sum += tmpNode.val;
//                if (tmpNode.left != null) {
//                    stack_child.push(tmpNode.left);
//                }
//                if (tmpNode.right != null) {
//                    stack_child.push(tmpNode.right);
//                }
//            }
//            while (!stack_child.isEmpty()) {
//                stack_node.push(stack_child.pop());
//            }
//            V.add(Math.max(V.get(i - 1), V.get(i - 2) + sum));
//            if (V.get(i) > result) {
//                result = V.get(i);
//            }
//        }
//        return result;
//    }

    //不相邻不是指不在相邻的层，而是指不相邻的节点，所以不是层次遍历，应该是深度遍历
    public int rob2(TreeNode root) {
        Stack<TreeNode> stack_child = new Stack<TreeNode>();
        Stack<TreeNode> stack_node = new Stack<TreeNode>();
        ArrayList<Integer> V = new ArrayList<Integer>();
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            stack_node.push(root.left);
        }
        if (root.right != null) {
            stack_node.push(root.right);
        }
        if (stack_node.isEmpty()) {
            return root.val;
        }
        int tmpval = 0;
        while (!stack_node.isEmpty()) {
            TreeNode tmp = stack_node.pop();
            tmpval += tmp.val;
            if (tmp.right != null) {
                stack_child.push(tmp.right);
            }
            if (tmp.left != null) {
                stack_child.push(tmp.left);
            }
        }
        if (stack_child.isEmpty()) {
            return Math.max(tmpval, root.val);
        }
        while (!stack_child.isEmpty()) {
            stack_node.push(stack_child.pop());
        }
        V.add(root.val);
        V.add(Math.max(tmpval, root.val));
        int result = 0;
        for (int i = 2; !stack_node.isEmpty(); i++) {
            int sum = 0;
            while (!stack_node.isEmpty()) {
                TreeNode tmpNode = stack_node.pop();
                sum += tmpNode.val;
                if (tmpNode.left != null) {
                    stack_child.push(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    stack_child.push(tmpNode.right);
                }
            }
            V.add(Math.max(V.get(i - 1), V.get(i - 2) + sum));
            if (V.get(i) > result) {
                result = V.get(i);
            }
            while (!stack_child.isEmpty()) {
                stack_node.push(stack_child.pop());
            }

        }

        return result;
    }


    //dfs solution
    public int rob(TreeNode root) {
        return 0;
    }

}
