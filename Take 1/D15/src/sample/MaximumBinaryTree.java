package sample;

import java.util.Arrays;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        System.out.println(constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }

    static int getMaxIndex(int[] array){
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] > array[max]){
                max = i;
            }
        }

        return max;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxIndex = getMaxIndex(nums);
        int max = nums[maxIndex];

        int[] left = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] right = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);

        TreeNode root = new TreeNode(max);
        if(left.length > 0){
            root.left = constructMaximumBinaryTree(left);
        }

        if(right.length > 0){
            root.right = constructMaximumBinaryTree(right);
        }

        return root;
    }
}
