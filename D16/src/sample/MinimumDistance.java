package sample;

public class MinimumDistance {
    public static void main(String[] args) {

    }

    public static int minDiffInBST(TreeNode root) {
        int minDistance = -1;
        int minDistanceLeft, minDistanceRight;


        if(root.left != null && root.right != null){
            minDistance = Math.min(Math.abs(root.val - root.left.val), Math.abs(root.val - root.right.val));
        }

        if(root.left != null){
            minDistanceLeft = minDiffInBST(root.left);
            if (minDistance == -1 || minDistanceLeft < minDistance){
                return minDistanceLeft;
            }
        }

        if(root.right != null){
            minDistanceRight = minDiffInBST(root.right);
            if (minDistance == -1 || minDistanceRight < minDistance){
                return minDistanceRight;
            }
        }

        return minDistance;
    }
}
