package sample;

import jdk.nashorn.api.tree.Tree;

public class MinimumDistance {
    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        int minDistance = 0;
        TreeNode closest = root;
        return findMin(root, minDistance, closest);
    }

    int findMin(TreeNode root, int minDistance, TreeNode closest){

        int minDistanceLeft, minDistanceRight;
        TreeNode tempClosest = closest;
        if(root.left != null && root.right != null){
            minDistance = Math.min(Math.abs(root.val - root.left.val), Math.abs(root.val - root.right.val));
            tempClosest = Math.abs(root.val - root.left.val) < Math.abs(root.val - root.right.val) ? root.left : root.right;
        }else if(root.left != null){
            minDistance = Math.abs(root.val - root.left.val);
            tempClosest = root.left;
        }else if(root.right != null){
            minDistance = Math.abs(root.val - root.right.val);
            tempClosest = root.right;
        }

        if(tempClosest.val > closest.val){
            closest = tempClosest;
        }

        if(root.left != null){
            minDistanceLeft = findMin(root.left, minDistance, closest);
            if (minDistanceLeft < minDistance){
                return minDistanceLeft;
            }
        }

        if(root.right != null){
            minDistanceRight = findMin(root.right, minDistance, closest);
            if (minDistanceRight < minDistance){
                return minDistanceRight;
            }
        }


        return minDistance;
    }
}
