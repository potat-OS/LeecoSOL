package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int i) {
        if (this.next != null) {
            this.next.add(i);
        } else {
            this.next = new ListNode(i);
        }
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder sBuilder = new StringBuilder();
        while (head != null) {
            sBuilder.append(head.val);
            head = head.next;
        }
        return sBuilder.toString();
    }
}
