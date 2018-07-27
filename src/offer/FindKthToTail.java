package offer;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode result = null;
        int flag = 0;
        while (head != null) {
            stack.push(head);
            head = head.next;
            flag++;
        }
        if (flag >= k) {
            for (int i = 0; i < k; i++) {
                result = stack.pop();
            }
            return result;
        } else {
            return head;
        }

    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode preIndex = head;
        ListNode index = head;
        while (k-- > 0) {
            if (preIndex.next != null) {
                preIndex = preIndex.next;
            } else {
                preIndex = null;
                break;
            }
        }
        if (k > 0) {
            return null;
        }
        while (preIndex != null) {
            preIndex = preIndex.next;
            index = index.next;
        }
        return index;
    }
}

