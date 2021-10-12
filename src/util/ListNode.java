package util;

/**
 * @author Han.Linjue
 */
public class ListNode<E extends Object> {
    public E val;
    public ListNode<E> next;

    public ListNode(E val) {
        this.val = val;
    }

    public ListNode(E val, ListNode<E> next) {
        this.val = val;
        this.next = next;
    }

    public void add(E i) {
        if (this.next != null) {
            this.next.add(i);
        } else {
            this.next = new ListNode<E>(i);
        }
    }

    @Override
    public String toString() {
        ListNode<E> head = this;
        StringBuilder sBuilder = new StringBuilder();
        while (head != null) {
            sBuilder.append(head.val);
            head = head.next;
        }
        return sBuilder.toString();
    }
}
