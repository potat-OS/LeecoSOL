import java.util.List;

class MaxDepth {

    int ans;

    public int maxDepth(Node root) {
        ans = 1;
        if (root == null || root.children == null) {
            return 0;
        } else {
            for (Node node : root.children) {
                ans = Integer.max(ans, 1 + maxDepth(node));
            }
            // root.children.forEach((node) -> ans = Integer.max(ans, 1 + maxDepth(node)));
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node();
        System.out.println(new MaxDepth().maxDepth(root));
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
