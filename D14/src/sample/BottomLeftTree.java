package sample;

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

    int leftDepth = 0, rightDepth = 0;

    public int findBottomLeftValue(TreeNode root) {

        int leftLeftMost = 0, rightLeftMost = 0;
        if(root.left == null && root.right == null){
            return root.val;
        }else if(root.left == null){
            rightDepth++;
            rightLeftMost = findBottomLeftValue(root.right);
        }else if(root.right == null){
            leftDepth++;
            leftLeftMost = findBottomLeftValue(root.left);
        }else{
            rightDepth++;
            rightLeftMost = findBottomLeftValue(root.right);
            leftDepth++;
            leftLeftMost = findBottomLeftValue(root.left);
        }

        if(rightDepth > leftDepth){
            return rightLeftMost;
        }else{
            return leftLeftMost;
        }
    }
}
