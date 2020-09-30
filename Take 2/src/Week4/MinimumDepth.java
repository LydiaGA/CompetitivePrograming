package Week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return doDFS(root, 0);
    }

    int doDFS(TreeNode root, int depth){
        if(root.left == null && root.right == null){
            return depth + 1;
        }

        List<Integer> depths = new ArrayList<>();

        if(root.left != null){
            depths.add(doDFS(root.left, depth + 1));
        }

        if(root.right != null){
            depths.add(doDFS(root.right, depth + 1));
        }

        return Collections.min(depths);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
