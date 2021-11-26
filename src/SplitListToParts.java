import util.ListNode;

class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode tmpHead = head;
        int[] partLen = new int[k];
        int len = 0, average = 0, remain = 0;
        while (tmpHead != null) {
            len++;
            tmpHead = tmpHead.next;
        }
        average = len / k;
        remain = len % k;
        for (int i = 0, j = 0; i < partLen.length; i++, j++) {
            partLen[i] = average;
            partLen[i] += j < remain ? 1 : 0;
        }
        tmpHead = head;
        for (int i = 0; i < k; i++) {
            if (partLen[i] > 0) {
                ListNode node = new ListNode(tmpHead.val);
                ListNode tmpNode = node;
                for (int j = 1; j < partLen[i]; j++) {
                    tmpHead = tmpHead.next;
                    tmpNode.next = new ListNode(tmpHead.val);
                    tmpNode = tmpNode.next;
                }
                tmpHead = tmpHead.next;
                ans[i] = node;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 2; i < 3; i++) {
            head.add(i);
        }
        new SplitListToParts().splitListToParts(head, 5);
    }
}
