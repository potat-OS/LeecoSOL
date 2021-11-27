import util.TreeNode;

public class KthSmallest {

    int index = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        postOrder(root, k);
        return ans;
    }

    private void postOrder(TreeNode root, int k) {
        if (root.left != null) {
            postOrder(root.left, k);
        }
        index++;
        if (index == k) {
            ans = root.val;
        }
        if (root.right != null) {
            postOrder(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new KthSmallest().kthSmallest(root, 1));
    }
}
