package sample;

public class SearchBST {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(10);
        TreeNode input2 = new TreeNode(5);
        TreeNode input3 = new TreeNode(15);
        TreeNode input4 = new TreeNode(3);
        TreeNode input5 = new TreeNode(7);
        TreeNode input6 = new TreeNode(18);

//        input.left = input2;
//        input.right = input3;
//        input2.left = input4;
//        input2.right = input5;
//        input3.left = null;
//        input3.right = input6;

        System.out.println(searchBST(input, 11).val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }else if(val < root.val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
}
