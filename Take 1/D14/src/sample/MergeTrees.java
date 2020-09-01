package sample;

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(10);
        TreeNode input11 = new TreeNode(5);
        TreeNode input12 = new TreeNode(15);
        TreeNode input2 = new TreeNode(3);
        TreeNode input21 = new TreeNode(7);
        TreeNode input22 = new TreeNode(6);

        input1.left = input11;
        input1.right = input12;
        input2.left = input21;
        input2.right = input22;

        System.out.println(mergeTrees(input1, input2).val);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode merged;
        if(t1 == null && t2 == null) {
            merged = null;
        }else if(t1 == null){
            merged = new TreeNode(t2.val);
            merged.left = mergeTrees(null, t2.left);
            merged.right = mergeTrees(null, t2.right);
        }else if(t2 == null){
            merged = new TreeNode(t1.val);
            merged.left = mergeTrees(t1.left, null);
            merged.right = mergeTrees(t1.right, null);
        }else{
            merged = new TreeNode(t1.val + t2.val);
            merged.left = mergeTrees(t1.left, t2.left);
            merged.right = mergeTrees(t1.right, t2.right);
        }

        return merged;
    }

}
