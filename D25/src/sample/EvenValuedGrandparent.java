package sample;

public class EvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        return doSum(root.left, root) + doSum(root.right, root);
    }

    int doSum(TreeNode root, TreeNode parent){
        if(root == null){
            return 0;
        }

        int sum = 0;

        if(root.left != null){
            if(parent.val % 2 == 0){
                sum += root.left.val;
            }
            sum += doSum(root.left, root);
        }

        if(root.right != null){
            if(parent.val % 2 == 0){
                sum += root.right.val;
            }
            sum += doSum(root.right, root);
        }

        return sum;
    }
}
