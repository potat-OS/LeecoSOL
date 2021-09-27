import ReversePrint.ListNode;

class ReverseList {

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;
        int count = 0;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            count++;
        }
        int[] res = new int[count];
        ListNode curTmp = pre;
        for (int i = 0; i < count; i++) {
            res[i] = curTmp.val;
            curTmp = curTmp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(3);
        head.add(2);
        ReverseList reverseList = new ReverseList();
        int[] res = reverseList.reversePrint(head);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}