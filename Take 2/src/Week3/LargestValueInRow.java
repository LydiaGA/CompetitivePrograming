package Week3;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doDFS(list, 0, root);
        return list;
    }

    void doDFS(List<Integer> list, int level, TreeNode root){
        if(root == null){
            return;
        }

        if(level >= list.size()){
            list.add(level, root.val);
        }

        if(root.val > list.get(level)){
            list.set(level, root.val);
        }

        if(root.left != null){
            doDFS(list, level + 1, root.left);
        }

        if(root.right != null){
            doDFS(list, level + 1, root.right);
        }
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
