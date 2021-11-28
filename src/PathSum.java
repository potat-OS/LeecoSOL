import util.TreeNode;

class PathSum {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    public void dfs(TreeNode node, int targetSum) {
        if (node != null) {
            targetSum -= node.val;
            if (targetSum == 0) {
                count++;
            }
        }
        if (node.left != null) {
            dfs(node.left, targetSum);
        }
        if (node.right != null) {
            dfs(node.right, targetSum);
        }
    }
}