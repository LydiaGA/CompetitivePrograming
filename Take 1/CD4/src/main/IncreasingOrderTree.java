package main;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        doInOrder(root, inOrder);
        TreeNode result = new TreeNode(inOrder.get(0));
        TreeNode current = result;
        for(int i = 1; i < inOrder.size(); i++){
            TreeNode newNode = new TreeNode(inOrder.get(i));
            current.right = newNode;
            current = current.right;
        }
        return result;
    }

    void doInOrder(TreeNode root, List<Integer> inOrder){
        if(root == null){
            return;
        }

        if(root.left != null){
            doInOrder(root.left, inOrder);
        }

        inOrder.add(root.val);

        if(root.right != null){
            doInOrder(root.right, inOrder);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

