import java.util.ArrayDeque;
import java.util.Queue;

import util.TreeNode;

public class IsEvenOddTree {

    // public boolean isEvenOddTree(TreeNode root) {
    //     List<TreeNode> list = new ArrayList<TreeNode>(), tmp;
    //     list.add(root);
    //     int level = 0;
    //     boolean isOdd = false;
    //     while (!list.isEmpty()) {
    //         tmp = new LinkedList<>();
    //         isOdd = (level++ & 1) == 1;
    //         for (int i = 0; i < list.size(); i++) {
    //             TreeNode cur = list.get(i);
    //             int nextIdx = i + 1;
    //             int curVal = cur.val, nextVal = nextIdx < list.size() ? list.get(nextIdx).val : 0;
    //             boolean isEven = (curVal & 1) == 0;
    //             Boolean isAsc = curVal <= nextVal, isDec = curVal >= nextVal;
    //             if (isOdd) {
    //                 if (nextVal == 0 ? !isEven : !isEven || isAsc) {
    //                     return false;
    //                 }
    //             } else {
    //                 if (nextVal == 0 ? isEven : isEven || isDec) {
    //                     return false;
    //                 }
    //             }
    //             TreeNode lt = cur.left, rt = cur.right;
    //             if (lt != null) {
    //                 tmp.add(lt);
    //             }
    //             if (rt != null) {
    //                 tmp.add(rt);
    //             }
    //         }
    //         list = tmp;
    //     }
    //     return true;
    // }

    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> adq = new ArrayDeque<TreeNode>();
        adq.offer(root);
        while (!adq.isEmpty()) {
            boolean isOdd = (level++ & 1) == 1;
            int size = adq.size();
            int prev = isOdd ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = adq.poll();
                int val = cur.val;
                boolean isEven = (val & 1) == 0;
                Boolean isAsc = val >= prev, isDec = val <= prev;
                if (isOdd == !isEven) {
                    return false;
                }
                if ((!isOdd && isDec) || (isOdd && isAsc)) {
                    return false;
                }
                prev = val;
                if (cur.left != null) {
                    adq.offer(cur.left);
                }
                if (cur.right != null) {
                    adq.offer(cur.right);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(10);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);

        System.out.println(new IsEvenOddTree().isEvenOddTree(tree));
    }
}
