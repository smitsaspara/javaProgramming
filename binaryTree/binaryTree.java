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

            System.out.print(temp.data + " ");

            if(temp.right != null){
                st.push(temp.right);
            }

            if(temp.left != null){
                st.push(temp.left);
            }
        }
    }

    //recursive
    public void inOrderR(TreeNode root){
        if(root == null){
            return;
        }

        inOrderR(root.left);
        System.out.print(root.data+ " ");
        inOrderR(root.right);
    }

    //Iterative
    public void inOrderI(TreeNode root){
        if (root == null) {
            return;            
        }

        Stack<TreeNode> st = new Stack<>();

        TreeNode temp = root;

        while (!st.isEmpty() || temp != null){
            if (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            else{
                temp = st.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    //Recursive
    public void postOrderR(TreeNode root){
        if (root == null) {
            return;            
        }
        postOrderR(root.left);
        postOrderR(root.right);
        System.out.print(root.data + " ");
    } 
    
    //Iterative
    public void postOrderI(TreeNode root){
        TreeNode current = root;

        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || current != null ) {

            if (current != null) {

                st.push(current);
                current = current.left;
            }
            else{

                TreeNode temp = st.peek().right;
                if(temp == null){
                   
                    temp = st.pop();

                    System.out.print(temp.data + " ");

                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();

                        System.out.print(temp.data + " ");
                    }
                }
                else{
                    current = temp;
                }

            }
            
        }
    } 

    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.createBinaryTree();
        bt.preOrderR(bt.root);
        System.out.println();
        bt.preOrderI(bt.root);
        System.out.println();
        bt.inOrderR(bt.root);
        System.out.println();
        bt.inOrderI(bt.root);
        System.out.println();
        bt.postOrderR(bt.root);
        System.out.println();
        bt.postOrderI(bt.root);

    }
}
