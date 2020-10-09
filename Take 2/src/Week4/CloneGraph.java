package Week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node first = new Node(node.val);
        first.neighbors = new ArrayList<>();
        for(int i = 0; i < node.neighbors.size(); i++){
            first.neighbors.add(new Node(node.neighbors.get(i).val));
        }

        Map<Integer, Node> map = new HashMap<>();
        doClone(node, first, map);
        return first;
    }

    void doClone(Node node, Node copied, Map<Integer, Node> map){
        if(!map.containsKey(copied.val)){
            map.put(copied.val, copied);
            for(int i = 0; i < node.neighbors.size(); i++){
                Node current = copied.neighbors.get(i);
                current.neighbors = new ArrayList<>();
                for(int j = 0; j < node.neighbors.get(i).neighbors.size(); j++){
                    int currentVal = node.neighbors.get(i).neighbors.get(j).val;
                    if(map.containsKey(currentVal)){
                        current.neighbors.add(map.get(currentVal));
                    }else{
                        current.neighbors.add(new Node(currentVal));
                    }

                }
                doClone(node.neighbors.get(i), current, map);
            }
        }

    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
