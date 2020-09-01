package sample;

public class DeepestLeavesAncestor {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Result result = findLca(root, 0);
        return result.ancestor;

    }

    Result findLca(TreeNode root, int level){
        if(root == null){
            return null;
        }

        if(root.left != null && root.right != null){
            Result leftResult = findLca(root.left, level + 1);
            Result rightResult = findLca(root.right, level + 1);

            if(leftResult.level == rightResult.level){
                return new Result(leftResult.level, root);
            }else if(leftResult.level > rightResult.level){
                return leftResult;
            }else {
                return rightResult;
            }
        }else if(root.left != null){
            return findLca(root.left, level + 1);
        }else if(root.right != null){
            return findLca(root.right, level + 1);
        }else{
            return new Result(level, root);
        }

    }
}

class Result{
    public int level;
    public TreeNode ancestor;

    public Result(int level, TreeNode ancestor){
        this.level = level;
        this.ancestor = ancestor;
    }
}
