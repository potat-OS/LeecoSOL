import util.ListNode;

// TODO
class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        for (int i = 0; i < lists.length; i++) {

        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.add(1);
        node1.add(4);
        node1.add(5);
        ListNode node2 = new ListNode();
        node1.add(1);
        node1.add(3);
        node1.add(4);
        ListNode node3 = new ListNode();
        node1.add(2);
        node1.add(6);
        System.out.println(new MergeKLists().mergeKLists(new ListNode[] { node1, node2, node3 }));
    }
}
