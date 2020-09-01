package sample;

public class PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(getPathSum(root, sum) == sum){
            return true;
        }else{
            return false;
        }
    }

    int getPathSum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        int tempSum = 0;
        if(root.left != null){
            tempSum = getPathSum(root.left, sum) + root.val;
            if(tempSum == sum){
                return sum;
            }
        }

        if(root.right != null){
            tempSum = getPathSum(root.right, sum) + root.val;
            if(tempSum == sum){
                return sum;
            }
        }

        return tempSum;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }