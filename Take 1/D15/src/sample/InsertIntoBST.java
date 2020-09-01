package sample;

public class InsertIntoBST {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode current = root;
        while(true){
            if(val < current.val){
                if(current.left == null){
                    current.left = new TreeNode(val);
                    break;
                }
            current = current.left;
            }else if(val > current.val){
                if(current.right == null){
                    current.right = new TreeNode(val);
                    break;
                }
                current = current.right;
            }
        }

        return root;
//        TreeNode current = root;
//        if(val < current.val){
//            if(current.left == null){
//                current.left = new TreeNode(val);
//                return root;
//            }
//            current = current.left;
//        }else if(val > current.val){
//            if(current.right == null){
//                current.right = new TreeNode(val);
//                return root;
//            }
//            current = current.right;
//        }
//
//        return insertIntoBST(current, val);
    }
}
