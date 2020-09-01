package main;

import java.util.HashMap;
import java.util.Map;

public class MaximumProduct {
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> sumMap = new HashMap<>();
        getEachSum(root, sumMap);

        long maxProduct = 0;
        long total = sumMap.get(root);

        for(TreeNode key : sumMap.keySet()){
            long currentProduct = sumMap.get(key) * (total - sumMap.get(key));
            if(currentProduct > maxProduct){
                maxProduct = currentProduct;
            }
        }

        long result = maxProduct % (long) (Math.pow(10, 9) + 7);

        return (int) result;

    }

    long getEachSum(TreeNode root,  Map<TreeNode, Long> sumMap){
        if(root == null){
            return 0;
        }
        long sum = root.val;
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

