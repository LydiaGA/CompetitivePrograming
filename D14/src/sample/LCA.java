package sample;

import java.util.Stack;

public class LCA {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(10);
        TreeNode input2 = new TreeNode(5);
        TreeNode input3 = new TreeNode(15);
        TreeNode input4 = new TreeNode(3);
        TreeNode input5 = new TreeNode(7);
        TreeNode input6 = new TreeNode(18);

        input.left = input2;
        input.right = input3;
        input2.left = input4;
        input2.right = input5;
        input3.left = null;
        input3.right = input6;

        System.out.println(lowestCommonAncestor(input, input5, input4).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if((root.left == null && root.right == null) || root == null){
            return null;
        }

        Stack<TreeNode> longer, shorter;
        longer = findAncestors(root, p);
        shorter = findAncestors(root, q);

        if(shorter.size() > longer.size()){
            Stack<TreeNode> temp = longer;
            longer = shorter;
            shorter = temp;
        }

        while(true){
            if(longer.size() > shorter.size()){
                longer.pop();
            }else{
                if(longer.peek() == shorter.peek()){
                    return longer.pop();
                }
                longer.pop();
                shorter.pop();
            }

            if(longer.isEmpty() || shorter.isEmpty()){
                return null;
            }
        }
    }

    static Stack<TreeNode> findAncestors(TreeNode root, TreeNode node){
        Stack<TreeNode> ancestors = new Stack<>();
        TreeNode next = root;

        while(true){
            ancestors.push(next);
            if(next.val == node.val){
                break;
            }
            if(next.left == null && next.right == null){
                break;
            }
            if(node.val < next.val){
                if(next.left == null){
                    break;
                }
                next = next.left;
            }else {
                if(next.right == null){
                    break;
                }
                next = next.right;
            }
        }

        return ancestors;
    }
}
