package ReversePrint;

/**
 * @author Han.Linjue
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public void add(int i) {
        ListNode node = new ListNode(i);
        if (node.next != null) {
            this.next = node;
        } else {
            this.next.add(i);
        }
    }
}
