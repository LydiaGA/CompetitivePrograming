package sample;

public class MinimumDistance {
    public static void main(String[] args) {

    }

    public static int minDiffInBST(TreeNode root) {
        int minDistance;
        if(root.left != null && root.right != null){
            minDistance = Math.min(Math.abs(root.val - root.left.val), Math.abs(root.val - root.right.val));
        }else if(root.left != null){
            minDistance = Math.abs(root.val - root.left.val);
        }else{
            minDistance = Math.abs(root.val - root.right.val);
        }
        findMin(root, minDistance);
    }

    static int findMin(TreeNode root, int minDistance){
        int minDistanceLeft, minDistanceRight;


        if(root.left != null && root.right != null){
            minDistance = Math.min(Math.abs(root.val - root.left.val), Math.abs(root.val - root.right.val));
        }

        if(root.left != null){
            minDistanceLeft = minDiffInBST(root.left);
            if (minDistanceLeft < minDistance){
                return minDistanceLeft;
            }
        }

        if(root.right != null){
            minDistanceRight = minDiffInBST(root.right);
            if (minDistanceRight < minDistance){
                return minDistanceRight;
            }
        }

        return minDistance;
    }
}
