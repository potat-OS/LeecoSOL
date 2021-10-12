import util.DoublyListNode;

public class Flatten {

    DoublyListNode<Integer> res;
    DoublyListNode<Integer> cur;

    public void DFS(DoublyListNode<Integer> node) {
        if (node == null) {
            return;
        }
        if (cur == null) {
            res = new DoublyListNode<Integer>();
            res.val = node.val;
            cur = res;
        } else {
            DoublyListNode<Integer> newNode = new DoublyListNode<Integer>();
            newNode.val = node.val;
            cur.next = newNode;
            newNode.prev = cur;
            cur = newNode;
        }
        if (node.child != null) {
            DFS(node.child);
        }
        if (node.next != null) {
            DFS(node.next);
        }
    }

    public DoublyListNode<Integer> flatten(DoublyListNode<Integer> head) {
        DFS(head);
        return res;
    }
}