package sample;

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return traversal(preorder, 0);
    }

    static TreeNode traversal(int[] preorder, int i){
        if(i == preorder.length - 1){
            return null;
        }
        TreeNode result;
        if(preorder[i + 1] < preorder[i]){
            result = new TreeNode(preorder[i]);
            result.left = traversal(preorder, i + 1);
        }else{
            result = new TreeNode(preorder[i]);
            result.right = traversal(preorder, i + 1);
        }

        return result;
    }
}
