import util.TreeNode;

public class KthSmallest {

    int index = 0;
    int ans = 0;

    public int kthSmallest(TreeNode<Integer> root, int k) {
        postOrder(root, k);
        return ans;
    }

    private void postOrder(TreeNode<Integer> root, int k) {
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
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        root.left = new TreeNode<Integer>(1);
        root.right = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(2);
        System.out.println(new KthSmallest().kthSmallest(root, 1));
    }
}
