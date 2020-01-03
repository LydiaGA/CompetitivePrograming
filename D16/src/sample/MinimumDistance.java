package sample;

import jdk.nashorn.api.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class MinimumDistance {
    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        int minDistance = 0;
        Map<TreeNode, TreeNode> closestDictionary = new HashMap<>();

        int min = findMin(root, minDistance, closestDictionary);
        for (TreeNode key :
                closestDictionary.keySet()) {
            System.out.println(key.val + ": " + closestDictionary.get(key).val);
        }
        return min;
    }

    int findMin(TreeNode root, int minDistance, Map<TreeNode, TreeNode> closestDictionary){
        int minDistanceLeft, minDistanceRight;
        TreeNode tempClosest;
        if(root.left != null && root.right != null){
            minDistance = Math.min(Math.abs(root.val - root.left.val), Math.abs(root.val - root.right.val));
            tempClosest = Math.abs(root.val - root.left.val) < Math.abs(root.val - root.right.val) ? root.left : root.right;
        }else if(root.left != null){
            minDistance = Math.abs(root.val - root.left.val);
            tempClosest = root.left;
        }else if(root.right != null){
            minDistance = Math.abs(root.val - root.right.val);
            tempClosest = root.right;
        }else{
            tempClosest = new TreeNode(-1);
            closestDictionary.put(root, tempClosest);
        }

        TreeNode closest;
        if(root.right != null){
            minDistanceRight = findMin(root.right, minDistance, closestDictionary);
            if(tempClosest.val > closestDictionary.get(root.right).val){
                closest = tempClosest;
            }else{
                closest = closestDictionary.get(root.right);
            }
            if(closestDictionary.get(root) == null){
                closestDictionary.put(root, closest);
            }else{
                if(closest.val > closestDictionary.get(root).val){
                    closestDictionary.replace(root, closest);
                }
            }
            if(Math.abs(closest.val - root.val) < minDistance){
                minDistance = Math.abs(closest.val - root.val);
            }
            if (minDistanceRight < minDistance){
                return minDistanceRight;
            }
        }

        if(root.left != null){
            minDistanceLeft = findMin(root.left, minDistance, closestDictionary);
            if(tempClosest.val > closestDictionary.get(root.left).val){
                closest = tempClosest;
            }else{
                closest = closestDictionary.get(root.left);
            }
            if(closestDictionary.get(root) == null){
                closestDictionary.put(root, closest);
            }else{
                if(closest.val > closestDictionary.get(root).val){
                    closestDictionary.replace(root, closest);
                }
            }

            if(Math.abs(closest.val - root.val) < minDistance){
                minDistance = Math.abs(closest.val - root.val);
            }
            if (minDistanceLeft < minDistance){
                return minDistanceLeft;
            }
        }

        closestDictionary.put(root, tempClosest);
        return minDistance;
    }
}
