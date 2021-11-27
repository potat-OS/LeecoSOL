import java.lang.reflect.Constructor;
import util.ListNode;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null, tail = null;

        while (l1 != null || l2 != null) {

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) throws Exception {
        ListNode l1 = null;
        l1 = new ListNode(2);
        l1.add(4);
        l1.add(3);
        ListNode l2 = null;
        l2 = new ListNode(5);
        l2.add(6);
        l2.add(4);

        Class<?> clz = Class.forName("AddTwoNumbers");
        Constructor<?> constructor = clz.getConstructor();
        AddTwoNumbers addTwoNumbers = (AddTwoNumbers) constructor.newInstance();
        ListNode cur = addTwoNumbers.addTwoNumbers(l1, l2), pre = null, tmp = null;
        System.out.println(cur.toString());
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        System.out.println(pre.toString());
    }
}
