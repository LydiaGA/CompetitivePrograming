package sample;

public class RangeSum {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(10);
        TreeNode input2 = new TreeNode(5);
        TreeNode input3 = new TreeNode(15);
        TreeNode input4 = new TreeNode(3);
        TreeNode input5 = new TreeNode(7);
        TreeNode input6 = new TreeNode(6);

        input.left = input2;
        input.right = input3;
        input2.left = input4;
        input2.right = input5;
        input3.left = null;
        input3.right = input6;

        System.out.println(rangeSumBST(input, 7, 15));

    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        TreeNode next;
        for (int i = L; i <= R; i++) {
            next = root;
            while (true){
                if(next.val == i){
                    sum += next.val;
                    break;
                }

                if(next.left == null && next.right == null){
                    break;
                }

                if(i < next.val){
                    if(next.left == null){
                        break;
                    }
                    next = next.left;
                }else if(i > next.val){
                    if(next.right == null){
                        break;
                    }
                    next = next.right;
                }
            }
        }

        return sum;

    }
}
