package ReversePrint;

import java.util.*;

/**
 * @author Han.Linjue
 */
class ReversePrint {

    int[] result;
    int flag = 0;

    public int[] reversePrint(ListNode head) {
        boolean isContinue = true;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (isContinue) {
            stack.add(head);
            head = head.next;
            if (head == null) {
                isContinue = false;
            }

        }
        result = new int[stack.size()];
        for (int i = 0; i <= stack.size() + 1; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ReversePrint solution = new ReversePrint();
        ListNode head = new ListNode(1);
        solution.flag = 1;
        System.out.println(solution.reversePrint(head));
    }
}