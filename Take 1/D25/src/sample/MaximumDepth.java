package sample;

import java.util.List;

public class MaximumDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max = 1;
        for (Node node : root.children) {
            int tempMax = maxDepth(node) + 1;
            if(tempMax > max){
                max = tempMax;
            };
        }
        return max;
    }
}
