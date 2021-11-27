import util.ListNode;

class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode tmpNode = node;
        tmpNode.next = new ListNode(5);
        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode(1);
        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode(9);
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node.next);
    }
}
