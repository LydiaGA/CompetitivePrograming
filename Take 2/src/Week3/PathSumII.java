package Week3;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            doDFS(root, sum, 0, result, new ArrayList<>());
        }

        return result;
    }

    void doDFS(TreeNode root, int sum, int current, List<List<Integer>> list, List<Integer> currentList){
        currentList.add(root.val);
        if(root.left == null && root.right == null){
            if(current + root.val == sum){
                list.add(currentList);
            }
            return;
        }


        if(root.left != null){
            doDFS(root.left, sum, current + root.val, list, new ArrayList<>(currentList));
        }

        if(root.right != null){
            doDFS(root.right, sum, current + root.val, list, new ArrayList<>(currentList));
        }
    }
}
