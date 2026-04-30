package org.abondar.experimental.structs.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    private final List<Integer> traversedNodes = new ArrayList<>();

    private BinaryTreeNode root;


    public BinaryTree() {
    }

    public BinaryTree(int rootVal) {
        root = new BinaryTreeNode(rootVal);
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void setNodeChildren(BinaryTreeNode parentNode,
                                int val1, int val2) {
        BinaryTreeNode left;
        BinaryTreeNode right;
        if (val1 < val2) {
            left = new BinaryTreeNode(val1);
            right = new BinaryTreeNode(val2);
        } else {
            right = new BinaryTreeNode(val1);
            left = new BinaryTreeNode(val2);
        }

        left.parent = parentNode;
        right.parent = parentNode;

        parentNode.left = left;
        parentNode.right = right;

    }

    /**
     * Visit left,current,right
     */
    public void inOderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOderTraversal(node.left);
            visit(node);
            inOderTraversal(node.right);
        }
    }

    /**
     * Visit current,left,right
     */
    public void preOderTraversal(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOderTraversal(node.left);
            preOderTraversal(node.right);
        }
    }

    /**
     * Visit left,right,current
     */
    public void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int val) {
        if (node == null) {
            node = new BinaryTreeNode(val);
            return node;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private BinaryTreeNode delete(BinaryTreeNode node, int val) {
        if (node == null) {
            return node;
        }

        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.val = getMostLeftValue(root.right);
            node.right = delete(node.right, node.val);
        }

        return node;
    }


    public BinaryTreeNode search(BinaryTreeNode startNode, int val) {
        if (startNode == null || startNode.getVal() == val) {
            return startNode;
        }

        if (val < startNode.getVal()) {
            return search(startNode.getLeft(), val);
        } else {
            return search(startNode.getRight(), val);
        }

    }

    public int getMostLeftValue(BinaryTreeNode node) {
        return getMostLeftNode(node).val;
    }

    public int getMostRightValue(BinaryTreeNode node) {
        return getMostRightNode(node).val;
    }

    public void minTree(int[] arr) {
        root = minTree(arr, 0, arr.length - 1);
    }

    private BinaryTreeNode minTree(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        BinaryTreeNode node = new BinaryTreeNode(arr[mid]);

        node.left = minTree(arr, start, mid - 1);
        node.right = minTree(arr, mid + 1, end);

        return node;

    }

    public List<List<BinaryTreeNode>> listOfDepth() {
        List<List<BinaryTreeNode>> res = new ArrayList<>();

        List<BinaryTreeNode> currentLevel = new ArrayList<>();

        if (root != null) {
            currentLevel.add(root);
        }

        while (currentLevel.size() > 0) {
            res.add(currentLevel);
            List<BinaryTreeNode> parentLevel = currentLevel;
            currentLevel = new ArrayList<>();
            for (BinaryTreeNode p : parentLevel) {
                if (p.getLeft() != null) {
                    currentLevel.add(p.getLeft());
                }

                if (p.getRight() != null) {
                    currentLevel.add(p.getRight());
                }
            }

        }

        return res;
    }


    public boolean isBalanced() {
        return checkHeight(root) != Integer.MIN_VALUE;
    }


    private int checkHeight(BinaryTreeNode node) {
        if (node == null) return -1;

        //height of left subtree
        int leftHeight = checkHeight(node.getLeft());

        // return error
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.getRight());
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }

    public boolean isBST() {
        return checkNode(root);
    }

    private boolean checkNode(BinaryTree.BinaryTreeNode node) {

        if (node == null) return true;

        int curVal = node.val;

        if (node.left != null && node.right != null) {
            int leftVal = node.left.val;
            int rightVal = node.right.val;

            if (leftVal <= curVal && curVal < rightVal) {

                if (node.parent != null && node.equals(node.parent.left)) {
                    int parentVal = node.parent.val;
                    if (rightVal > parentVal) {
                        return false;
                    }
                }

                return checkNode(node.right) && checkNode(node.left);
            }
        } else {
            return true;
        }

        return false;
    }

    public List<List<BinaryTreeNode>> bstSequences(BinaryTreeNode node) {
        List<List<BinaryTreeNode>> res = new ArrayList<>();

        if (node == null) {
            res.add(new ArrayList<>());
            return res;
        }

        List<List<BinaryTreeNode>> leftSeq = bstSequences(node.getLeft());
        List<List<BinaryTreeNode>> rightSeq = bstSequences(node.getRight());

        List<BinaryTreeNode> prefix = new ArrayList<>();
        prefix.add(node);

        //weave lists from left and right
        leftSeq.forEach(ls -> rightSeq.forEach(rs -> {
            List<List<BinaryTreeNode>> weaved = new ArrayList<>();
            weaveLists(ls, rs, weaved, prefix);
            res.addAll(weaved);
        }));

        return res;
    }

    //get all possible lists combos. remove head from ls,recurse, than do the same with rs
    private void weaveLists(List<BinaryTreeNode> ls, List<BinaryTreeNode> rs, List<List<BinaryTreeNode>> weaved, List<BinaryTreeNode> prefix) {
        if (ls.size() == 0 || rs.size() == 0) {
            List<BinaryTreeNode> res = new ArrayList<>();
            res.addAll(prefix);
            res.addAll(ls);
            res.addAll(rs);
            weaved.add(res);
            return;
        }

        BinaryTreeNode headLS = ls.remove(0);
        prefix.add(headLS);
        weaveLists(ls, rs, weaved, prefix);
        prefix.remove(prefix.size() - 1);
        ls.add(0, headLS);

        BinaryTreeNode headRS = ls.remove(0);
        prefix.add(headRS);
        weaveLists(ls, rs, weaved, prefix);
        prefix.remove(prefix.size() - 1);
        rs.add(0, headRS);


    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public List<Integer> getTraversedNodes() {
        return traversedNodes;
    }

    public void clearTraversedNodes() {
        traversedNodes.clear();
    }

    public List<Integer> getFirstNodesOfRow(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                var node = queue.remove();

                if (i == 0) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }

        return res;
    }

    public List<Integer> getFirstNodesOfRowDfs(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        dfs(root, 0, res);
        return res;
    }

    //BST ONLY SOLUTION
    public Integer findMinGreaterThanN(BinaryTreeNode root, int n) {
        Integer min = null;

        var current = root;
        while (current != null) {
            if (current.val > n) {
                min = current.val;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return min;
    }

    public Integer findMin(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        Integer leftMin = findMin(node.left);
        Integer rightMin = findMin(node.right);

        int min = node.val;

        if (leftMin != null && leftMin < min) {
            min = leftMin;
        }

        if (rightMin != null && rightMin < min) {
            min = rightMin;
        }

        return min;
    }

    public Integer findMinBst(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return findMinBst(node.left);
        }

        return node.val;
    }


    private void dfs(BinaryTreeNode node, int level, List<Integer> res) {
        if (node == null) return;

        if (level == res.size()) {
            res.add(node.val);
        }

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }

    //helper methods
    private void visit(BinaryTreeNode n) {
        traversedNodes.add(n.val);
    }

    private BinaryTreeNode getMostLeftNode(BinaryTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private BinaryTreeNode getMostRightNode(BinaryTreeNode node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node;
    }

    public static class BinaryTreeNode {

        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private BinaryTreeNode parent;

        private int val;

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public int getVal() {
            return val;
        }
    }


}
