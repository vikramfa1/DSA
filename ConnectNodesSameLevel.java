class Node {
    int data;
    Node left, right, nextRight;
    public Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node root;
}
public class ConnectNodesSameLevel {

    private static Node identifyNextNode(Node node) {
        Node a = node.nextRight;
        while(a!=null ) {
            if(a.left!=null) {
                return a.left;
            } else if(a.right!=null) {
                return a.right;
            } else {
                a = a.nextRight;
            }
        }
        return null;
    }
    public static void connectNodesAtSameLevel(Node node) {
        if(node == null) return;
        Node p = node;
        while(p!=null) {
            Node q = p;
            while(q!=null) {

                if(q.left!=null) {
                    if(q.right!=null) {
                        q.left.nextRight = q.right;
                    } else {
                        q.left.nextRight = identifyNextNode(q);
                    }
                }

                if(q.right!=null) {
                    q.right.nextRight = identifyNextNode(q);
                }

                q = q.nextRight;
            }

            if(p.left!=null) {
                p = p.left;
            } else if(p.right!=null) {
                p = p.right;
            } else {
                p = identifyNextNode(p);
            }
        }
    }

    public static void main(String args[]) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = new Node(10);
        bTree.root.left = new Node(8);
        bTree.root.right = new Node(2);
        bTree.root.left.left = new Node(3);
        bTree.root.right.right = new Node(90);

        connectNodesAtSameLevel(bTree.root);
        // Let us check the values of nextRight pointers
        int a = bTree.root.nextRight != null ?
                bTree.root.nextRight.data : -1;
        int b = bTree.root.left.nextRight != null ?
                bTree.root.left.nextRight.data : -1;
        int c = bTree.root.right.nextRight != null ?
                bTree.root.right.nextRight.data : -1;
        int d = bTree.root.left.left.nextRight != null ?
                bTree.root.left.left.nextRight.data : -1;
        int e = bTree.root.right.right.nextRight != null ?
                bTree.root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + bTree.root.data + " is " + a);
        System.out.println("nextRight of " + bTree.root.left.data
                + " is " + b);
        System.out.println("nextRight of " + bTree.root.right.data +
                " is " + c);
        System.out.println("nextRight of " + bTree.root.left.left.data +
                " is " + d);
        System.out.println("nextRight of " + bTree.root.right.right.data +
                " is " + e);
    }
}
