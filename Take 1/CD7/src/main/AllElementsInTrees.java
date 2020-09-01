package main;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AllElementsInTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        prepareHeap(root1, queue);
        prepareHeap(root2, queue);


        int size = queue.size();
        for(int i = 0; i < size; i++){
            result.add(queue.poll());
        }
        return result;
    }

    void prepareHeap(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.add(root.val);

        if (root.left != null && root.right != null) {
            prepareHeap(root.left, queue);
            prepareHeap(root.right, queue);
        } else if (root.left != null) {
            prepareHeap(root.left, queue);
        } else if (root.right != null) {
            prepareHeap(root.right, queue);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
