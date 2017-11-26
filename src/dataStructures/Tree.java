package dataStructures;
import java.io.*;
import java.util.*;

public class Tree {
    private Node root; // first Node
    public Tree(){
        root = null;
    }


    public Node find(int key){
        // assumes non empty tree
        Node current = root;

        while (current.NData != key){
            if (key < current.NData){
                // left subtree contains smaller ints
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                // did not find key in tree
                return null;
            }
        }
        return current;
    }


    public void insert(int myData){
        Node newNode = new Node();
        newNode.NData = myData;

        if (root == null){
            // if there's no root, place new Node there
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while(true){
                parent = current;

                if (myData < current.NData){
                    // go down left subtree
                    current = current.leftChild;

                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;

                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    private Node getSuccessor(Node noddy){
        // returns Node with highest value after noddy
        Node succParent = noddy;
        Node successor = noddy;
        Node current = noddy.rightChild;

        while (current != null){
            // go right, until no more left children Nodes
            succParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != noddy.rightChild){
            succParent.leftChild = successor.rightChild;
            successor.rightChild = noddy.rightChild;
        }
        return successor;
    }


    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.NData != key){
            parent = current;

            if (key < current.NData){
                // go down left subtree
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                // did not find Node to delete
                return false;
            }
        }

        if (current.leftChild == null &&
                current.rightChild == null){

            if (current == root){
                // tree is empty, delete root
                root = null;
            } else if (isLeftChild){
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null){

            if (current == root){
                root = current.leftChild;
            } else if (isLeftChild){
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null){

            if (current == root){
                root = current.rightChild;
            } else if (isLeftChild){
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);

            if (current == root){
                root = successor;
            } else if (isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
        }
        return true;
    }


    public void preOrderTraversal(Node localRoot){
        if (localRoot != null){
            System.out.print(localRoot.NData + " ");
            preOrderTraversal(localRoot.leftChild);
            preOrderTraversal(localRoot.rightChild);
        }
    }


    public void inOrderTraversal(Node localRoot){
        if (localRoot != null){
            inOrderTraversal(localRoot.leftChild);
            System.out.print(localRoot.NData + " ");
            inOrderTraversal(localRoot.rightChild);
        }
    }


    public void postOrderTraversal(Node localRoot){
        if (localRoot != null){
            postOrderTraversal(localRoot.leftChild);
            postOrderTraversal(localRoot.rightChild);
            System.out.print(localRoot.NData + " ");
        }
    }


    private void invertHelper(Node root){
        Node tempy = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tempy;

        if (root.leftChild != null){
            invertHelper(root.leftChild);
        }
        if (root.rightChild != null){
            invertHelper(root.rightChild);
        }
    }


    public void invertBST(Node root){
        if (root == null){
            return;
        } else{
            invertHelper(root);
        }
    }


    private boolean checkIfBalancedHelper(Node left, Node right){
        if (right == null && left == null){
            return true;
        } else if (right == null || left == null){
            return false;
        }

        return (checkIfBalancedHelper(left.leftChild, right.rightChild) && // outer
                checkIfBalancedHelper(left.rightChild, right.leftChild));  // inner
    }


    public boolean checkIfBalaned(Node root){
        if (root == null){
            return true;
        } else {
            return checkIfBalancedHelper(root.leftChild, root.rightChild);
        }
    }

    public boolean checkIfBST(Node root){
        return checkIfBSTHelper(root, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private boolean checkIfBSTHelper(Node node, int min, int max){
        if (node == null){
            // all nodes meet properties of BST up to leaf node
            return true;
        }

        // check that properties of BST still met
        return (min < node.NData && node.NData < max) &&
                checkIfBSTHelper(node.leftChild, min, node.NData) &&
                checkIfBSTHelper(node.rightChild, node.NData, max);
    }

    public ArrayList<Node> inOrderArrayList(Node root, ArrayList<Node> nodes){
        if (root != null){
            inOrderArrayList(root.leftChild, nodes);
            nodes.add(root);
            inOrderArrayList(root.rightChild, nodes);
        }
        return nodes;
    }

    public ArrayList<Node> postOrderArrayList(Node root, ArrayList<Node> nodes){
        if (root != null){
            postOrderArrayList(root.leftChild, nodes);
            postOrderArrayList(root.rightChild, nodes);
            nodes.add(root);
        }
        return nodes;
    }

    public Node lowestCommonAncestor(Node root, Node a, Node b){
        List<Node> inOrder = inOrderArrayList(root, new ArrayList<Node>());
        List<Node> postOrder = postOrderArrayList(root, new ArrayList<Node>());
        List<Node> subset = inOrder.subList(inOrder.indexOf(a)-1, inOrder.indexOf(b)+1); // make inclusive

        /*
        from inOrder, get the sub array from Node a to Node b
        from postOrder, answer is the Node in subArray that appear farthest right
         */

        Node answer = null;
        for (Node node : postOrder){
            if (subset.contains(node)){
                answer = node;
            }
        }

        return answer; // returns null if no answer
    }

    public int height(Node root){
        // make containers for left subtree and right subtree heights
        int leftHeight = 0;
        int rightHeight = 0;

        if (root.leftChild != null){
            // if the left child is not null
            leftHeight = 1 + height(root.leftChild);
            // add 1 to left height and recall height method on leftChild
        }

        if (root.rightChild != null){
            // if right child is not null
            rightHeight = 1 + height(root.rightChild);
            // add 1 to right height and recall height on right child
        }
        // will return the largest height for both

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    public void levelTraversal(Node root){
        java.util.Queue<Node> nodes = new java.util.LinkedList<Node>();
        // queue is FIFO
        nodes.add(root);
        // add the initial root

        while (!nodes.isEmpty()){
            // while the queue is not empty
            Node tempNode = nodes.poll();
            // get first item from queue
            System.out.print(tempNode + " ");
            // print it

            if (tempNode.leftChild != null) {
                // if the left child of root is not empty/null
                nodes.add(tempNode.leftChild);
                // add it to thee queue
            }

            if (tempNode.rightChild != null) {
                // if the right child of root is not empty/null
                nodes.add(tempNode.rightChild);
                // add it to the queue
            }

            // now repeats since there are two more items in the queue (of the same level)
            // prints them in order on next
            // if there is null, nothing happens
        }


    }


    //
}
