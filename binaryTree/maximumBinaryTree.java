package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class maximumBinaryTree {

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
    public int findMaxR(TreeNode root){
        
        if (root == null) { 
            return Integer.MIN_VALUE;
        }

        int result = root.data;
        int left = findMaxR(root.left);
        int right = findMaxR(root.right);

        if (left > result) {
            result = left;
        }

        if (right > result) {
            result = right;
        }
        return result;
    }


    //iterative

    public int findMaxI(TreeNode root){

        if (root == null){
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while (!qu.isEmpty()) {

            TreeNode current = qu.poll();

            if (current.data > max){
                max = current.data;
            }

            if (current.left != null){
                qu.offer(current.left);
            }
                
            if (current.right != null){
                qu.offer(current.right);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maximumBinaryTree mb = new maximumBinaryTree();
        mb.createBinaryTree();
        int result = mb.findMaxR(mb.root);
        System.out.println(result);

        int out = mb.findMaxR(mb.root);
        System.out.println(out);
    }
}
