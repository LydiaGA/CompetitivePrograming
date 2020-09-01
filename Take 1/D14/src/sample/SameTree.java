package sample;

public class SameTree {
    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(10);
        TreeNode input11 = new TreeNode(5);
        TreeNode input12 = new TreeNode(15);
        TreeNode input2 = new TreeNode(5);
        TreeNode input21 = new TreeNode(5);
        TreeNode input22 = new TreeNode(15);

//        input1.left = input11;
//        input1.right = input12;
//        input2.left = input21;
//        input2.right = input22;

        System.out.println(isSameTree(null, null));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean same;
        if(p == null && q == null) {
            return true;
        }else if(p == null || q == null){
            return false;
        }else{
            same = p.val == q.val;
            if (same){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else{
                return same;
            }
        }

    }
}
