import util.TreeNode;

class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val > root.val ? root.right : root.left, val);
    }
}
