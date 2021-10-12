import util.ListNode;

class ReverseList {

    public int[] reversePrint(ListNode<Integer> head) {
        ListNode<Integer> cur = head;
        ListNode<Integer> pre = null;
        ListNode<Integer> tmp;
        int count = 0;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            count++;
        }
        int[] res = new int[count];
        ListNode<Integer> curTmp = pre;
        for (int i = 0; i < count; i++) {
            res[i] = curTmp.val;
            curTmp = curTmp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.add(3);
        head.add(2);
        ReverseList reverseList = new ReverseList();
        int[] res = reverseList.reversePrint(head);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}