package sample;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BottomLeftTree {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(10);
        TreeNode input2 = new TreeNode(5);
        TreeNode input3 = new TreeNode(15);
        TreeNode input4 = new TreeNode(3);
        TreeNode input5 = new TreeNode(7);
        TreeNode input6 = new TreeNode(18);

        input.left = input2;
        input.right = input3;
//        input2.left = input4;
//        input2.right = input5;
        input3.left = null;
        input3.right = input6;

        BottomLeftTree blt = new BottomLeftTree();

        System.out.println(blt.findBottomLeftValue(input));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Map<Integer, TreeNode> dictionary = new HashMap<>();
        addToDictionary(root, dictionary, 0);

        int maxKey = Collections.max(dictionary.keySet());

        return dictionary.get(maxKey).val;
    }

    static void addToDictionary(TreeNode root, Map<Integer, TreeNode> dictionary, int x){
        dictionary.put(x, root);
        if(root.left != null && root.right != null){
            addToDictionary(root.right, dictionary, x + 1);
            addToDictionary(root.left, dictionary, x + 1);
        }else if(root.left != null){
            addToDictionary(root.left, dictionary, x + 1);
        }else if(root.right != null){
            addToDictionary(root.right, dictionary, x + 1);
        }
    }
}
