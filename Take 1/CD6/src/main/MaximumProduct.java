package main;

import java.util.HashMap;
import java.util.Map;

public class MaximumProduct {

    public int maxProduct(TreeNode root) {
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        getEachSum(root, sumMap);

        long maxProduct = 0;
        int total = sumMap.get(root);

        for(TreeNode key : sumMap.keySet()){
            int currentProduct = sumMap.get(key) * (total - sumMap.get(key));
            if(currentProduct > maxProduct){
                maxProduct = currentProduct;
            }
        }

        long result = maxProduct % (long) (Math.pow(10, 9) + 7);

        return (int) result;

    }

    int getEachSum(TreeNode root,  Map<TreeNode, Integer> sumMap){
        if(root == null){
            return 0;
        }
        int sum = root.val;
        if(root.right != null && root.left != null){
            sum += getEachSum(root.left, sumMap);
            sum += getEachSum(root.right, sumMap);
        }else if(root.left != null){
            sum += getEachSum(root.left, sumMap);
        }else if(root.right != null){
            sum += getEachSum(root.right, sumMap);
        }

        sumMap.put(root, sum);
        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

