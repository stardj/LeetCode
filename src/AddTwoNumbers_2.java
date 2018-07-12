import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


/**
 * 要处理大数问题，用数组解决，或者biginteger？
 * <p>
 * biginteger is one of the best solution
 */
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getListNode(getNum(l1).add(getNum(l2)));
    }

    public BigInteger getNum(ListNode ln) {
        BigInteger result = BigInteger.valueOf(0);
        long loop = 0;
        while (ln != null) {
            BigInteger tmp = BigInteger.valueOf(ln.val);
            for (int i = 0; i < loop; i++) {
                tmp = tmp.multiply(BigInteger.valueOf(10));
            }
            result = result.add(tmp);
            ln = ln.next;
            loop++;
        }
        return result;
    }

    public ListNode getListNode(BigInteger input) {
        ListNode head = new ListNode((input.mod(BigInteger.valueOf(10))).intValue());
        ListNode tmpNode = head;
        input = input.divide(BigInteger.valueOf(10));
        while (input != BigInteger.valueOf(0)) {
            tmpNode.next = new ListNode((input.mod(BigInteger.valueOf(10))).intValue());
            tmpNode = tmpNode.next;
            input = input.divide(BigInteger.valueOf(10));
        }

        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 addT = new AddTwoNumbers_2();
        ListNode l1 = addT.getListNode(BigInteger.valueOf(12345));
        ListNode l2 = addT.getListNode(BigInteger.valueOf(5));
        BigInteger temp = addT.getNum(addT.addTwoNumbers(l1, l2));
        System.out.println(temp);
    }
}


