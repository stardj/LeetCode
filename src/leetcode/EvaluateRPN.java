package leetcode;

import java.util.Stack;


/**
 * 直接用栈
 * 这题类似于二叉树的后续遍历
 * 每算出一个节点，就把它放回stack中，最终再弹出stack的最后一个元素即可
 */
public class EvaluateRPN {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int valRight = stack.pop();
                int valLeft = stack.pop();
                stack.push(valLeft + valRight);

            } else if (tokens[i].equals("-")) {
                int valRight = stack.pop();
                int valLeft = stack.pop();
                stack.push(valLeft - valRight);
            } else if (tokens[i].equals("*")) {
                int valRight = stack.pop();
                int valLeft = stack.pop();
                stack.push(valLeft * valRight);
            } else if (tokens[i].equals("/")) {
                int valRight = stack.pop();
                int valLeft = stack.pop();
                stack.push(valLeft / valRight);
            } else
                stack.push(Integer.valueOf(tokens[i]));
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tmp = {"3", "-4", "+"};
        EvaluateRPN evaluateRPN = new EvaluateRPN();
        System.out.println(evaluateRPN.evalRPN(tmp));

    }
}
