package Week3;

import java.util.PriorityQueue;

public class BSTIterator {
    PriorityQueue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = new PriorityQueue<>();
        this.populateQueue(queue, root);
    }

    void populateQueue(PriorityQueue queue, TreeNode root){
        if(root == null){
            return;
        }

        queue.add(root.val);

        if(root.left != null){
            populateQueue(queue, root.left);
        }

        if(root.right != null){
            populateQueue(queue, root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
