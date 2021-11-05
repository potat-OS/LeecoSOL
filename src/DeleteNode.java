import util.ListNode;

class DeleteNode {
    public void deleteNode(ListNode<Integer> node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<Integer>(4);
        ListNode<Integer> tmpNode = node;
        tmpNode.next = new ListNode<Integer>(5);
        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode<Integer>(1);
        tmpNode = tmpNode.next;
        tmpNode.next = new ListNode<Integer>(9);
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node.next);
    }
}
