import ReversePrint.*;

public class Flatten {

    Node res;
    Node cur;

    public void DFS(Node node) {
        if (node == null) {
            return;
        }
        if (cur == null) {
            res = new Node();
            res.val = node.val;
            cur = res;
        } else {
            Node newNode = new Node();
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

    public Node flatten(Node head) {
        DFS(head);
        return res;
    }
}