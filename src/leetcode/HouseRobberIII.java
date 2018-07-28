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
    public int rob(TreeNode root) {
        ArrayList<Integer> list = getBFSValues(root);
        if (list.size() < 1) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() == 2) {
            return Math.max(list.get(0), list.get(1));
        }

        int result = 0;
        int[] V = new int[list.size()];
        V[0] = list.get(0);
        V[1] = Math.max(list.get(0), list.get(1));

        for(int i = 2;i<list.size();i++) {
            V[i] = Math.max(V[i - 1], list.get(i) + V[i - 2]);
            if (V[i] > result) {
                result = V[i];
            }
        }

        return result;

    }

    public static ArrayList<Integer> getBFSValues(TreeNode root) {
        Stack<TreeNode> stack_child = new Stack<TreeNode>();
        Stack<TreeNode> stack_node = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            int sum = 0;
            stack_node.push(root);
            while (!stack_node.isEmpty()) {
                TreeNode tmp = stack_node.pop();
                if (tmp.left != null) {
                    stack_child.push(tmp.left);
                }
                if (tmp.right != null) {
                    stack_child.push(tmp.right);
                }
                sum += tmp.val;
            }
            list.add(sum);
            while (!stack_child.isEmpty()) {
                stack_node.push(stack_child.pop());
            }
        } while (!stack_node.isEmpty());
        return list;
    }
}
