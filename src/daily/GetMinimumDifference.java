package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzx
 * @date 2020/10/12
 */
public class GetMinimumDifference {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> values = new ArrayList<>();

    public int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference2(root);
        return min;
    }

    public void getMinimumDifference2(TreeNode node) {
        if (node.left != null) {
            getMinimumDifference2(node.left);
        }
        values.add(node.val);
        if (values.size() > 1) {
            min = Math.min(min, values.get(values.size() - 1) - values.get(values.size() - 2));
        }
        if (node.right != null) {
            getMinimumDifference2(node.right);
        }
    }

    public static void main(String[] args) {

    }
}
