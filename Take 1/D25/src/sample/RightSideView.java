package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        dfs(root, level, map);
        List<Integer> result = new ArrayList<Integer>();
        for(int key : map.keySet()){
            List<TreeNode> levelNodes = map.get(key);
            result.add(levelNodes.get(levelNodes.size() - 1).val);
        }
        return result;

    }

    void dfs(TreeNode root, int level, Map<Integer, List<TreeNode>> map){
        if(root == null){
            return;
        }
        if(map.containsKey(level)){
            map.get(level).add(root);
        }else{
            map.put(level, new ArrayList<TreeNode>());
            map.get(level).add(root);
        }
        if(root.left != null){
            dfs(root.left, level + 1, map);
        }
        if(root.right != null){
            dfs(root.right, level + 1, map);
        }
    }
}
