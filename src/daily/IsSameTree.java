package daily;

/**
 * @author xzx
 * @date 2020/10/13
 */
public class IsSameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return isSameTree1(p, q);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        // 左
        boolean left = true;
        if (p.left != null) {
            if (q.left == null) {
                return false;
            }
            left = isSameTree1(p.left, q.left);
        } else {
            if (q.left != null) {
                return false;
            }
        }
        // 中
        if (p.val != q.val) {
            return false;
        }
        // 右
        boolean right = true;
        if (p.right != null) {
            if (q.right == null) {
                return false;
            }
            right = isSameTree1(p.right, q.right);
        } else {
            if (q.right != null) {
                return false;
            }
        }
        return left && right;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            val = val;
            left = left;
            right = right;
            next = next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        connect(root.left, root.right);
        return root;
    }

    public void connect(Node node1, Node node2) {
        if (node1 == null) {
            return;
        }
        node1.next = node2;
        connect(node1.left, node1.right);
        if (node2 != null) {
            connect(node1.right, node2.left);
            connect(node2.left, node2.right);
            connect(node2.right, null);
        }
    }

    static class Test<T>{
        private Class<T>[] types;
        private Class<?>[] types2;
    }
}
