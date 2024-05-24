package binaryTree;

import java.util.Stack;

public class binaryTree {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data; // Can be any generic type

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
  
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    //recursive
    public void preOrderR(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preOrderR(root.left);
        preOrderR(root.right);
    }

    //iterative
    public void preOrderI(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while (!st.isEmpty()) {

            TreeNode temp = st.pop();

            System.out.println(temp.data + " ");

            if(temp.right != null){
                st.push(temp.right);
            }

            if(temp.left != null){
                st.push(temp.left);
            }
        }
    }

    
    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.createBinaryTree();
    }
}
