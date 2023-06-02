package test1;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
    }
}


public class BinaryTreeTraversal {

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lVal=0;
        if(root.left!=null) {
            lVal =  height(root.left)+1;
        }
        int rVal=0;
        if(root.right!=null) {
            rVal = height(root.right)+1;
        }

        return Math.max(lVal, rVal);

    }

    public static void spiralTraversal(Node root) {
        if(root==null) return;
        Stack<Node> lStack = new Stack<>();
        Stack<Node> rStack = new Stack<>();

        lStack.add(root);
        while(!lStack.isEmpty() || !rStack.isEmpty()) {

            while(!lStack.isEmpty()) {
                Node node = lStack.pop();
                if(node.left!=null) {
                    rStack.add(node.right);
                }

                if(node.right!=null) {
                    rStack.add(node.left);
                }

                System.out.println("lS: "+node.data);
            }

            while(!rStack.isEmpty()) {
                Node node = rStack.pop();
                if(node.left!=null) {
                    lStack.add(node.left);
                }

                if(node.right!=null) {
                    lStack.add(node.right);
                }

                System.out.println("rS: "+node.data);

            }
        }


    }

    public static void spiralTraversalUsingDeque(Node root) {
        if(root==null) return;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        boolean flag =  true;
        while(!deque.isEmpty()) {
            int n = deque.size();

            for(int i=0;i<n;i++) {

                if(flag == false) {
                    Node curr = deque.pollFirst();
                   if(curr.left!=null) {
                       deque.addLast(curr.left);
                   }
                    if(curr.right!=null) {
                        deque.addLast(curr.right);
                    }
                    System.out.println("currL: "+curr.data);

                }

                if(flag) {
                    Node curr = deque.pollLast();
                    if(curr.right!=null) {
                        deque.addFirst(curr.right);
                    }
                    if(curr.left!=null) {
                        deque.addFirst(curr.left);
                    }
                    System.out.println("currR: "+curr.data);
                }
            }
            flag = !flag;

        }
    }
    Node root;
    public static void main(String args[]) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println(
                "Spiral order traversal of Binary Tree is ");
        int height = height(tree.root);
        System.out.println("height: "+height);
        spiralTraversal(tree.root);
        spiralTraversalUsingDeque(tree.root);
    }
}
