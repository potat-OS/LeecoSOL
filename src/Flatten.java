import util.DoublyListNode;

class Flatten {

    DoublyListNode res;
    DoublyListNode cur;

    public void DFS(DoublyListNode node) {
        if (node == null) {
            return;
        }
        if (cur == null) {
            res = new DoublyListNode();
            res.val = node.val;
            cur = res;
        } else {
            DoublyListNode newNode = new DoublyListNode();
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

    public DoublyListNode flatten(DoublyListNode head) {
        DFS(head);
        return res;
    }
}