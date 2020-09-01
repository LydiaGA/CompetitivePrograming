package sample;

public class ValidateTree {
    public boolean isValidBST(TreeNode root) {
        Result2 result = doIsValid(root);
        System.out.println(result.min + " " + result.max);
        return result.isValid;
    }

    Result2 doIsValid(TreeNode root){
        if(root == null){
            return new Result2(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        boolean isValid = true;
        Result2 leftResult = new Result2(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result2 rightResult = new Result2(true, Integer.MAX_VALUE, Integer.MIN_VALUE);

        if(root.left != null){
            leftResult = doIsValid(root.left);
            //isValid = isValid && doIsValid(root.left);
            isValid = isValid && root.left.val < root.val && leftResult.isValid && leftResult.max < root.val;
        }

        if(root.right != null){
            rightResult = doIsValid(root.right);
            isValid = isValid && root.right.val > root.val && rightResult.isValid && rightResult.min > root.val;
        }


        Result2 result = new Result2();
        result.isValid = isValid;
        result.min = Math.min(Math.min(leftResult.min, rightResult.min), root.val);
        result.max = Math.max(Math.max(leftResult.max, rightResult.max), root.val);

        return result;
    }
}

class Result2{
    boolean isValid;
    int min;
    int max;

    public Result2(boolean isValid, int min, int max){
        this.isValid = isValid;
        this.min = min;
        this.max = max;
    }

    public Result2(){

    }
}
