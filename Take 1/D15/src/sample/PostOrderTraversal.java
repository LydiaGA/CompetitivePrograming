package sample;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            traverse(root, result);
        }
        return result;
    }

    void traverse(TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }else if(root.left == null){
            traverse(root.right, list);
            list.add(root.val);
        }else if(root.right == null){
            traverse(root.left, list);
            list.add(root.val);
        }else{
            traverse(root.left, list);
            traverse(root.right, list);
            list.add(root.val);
        }
    }
}
