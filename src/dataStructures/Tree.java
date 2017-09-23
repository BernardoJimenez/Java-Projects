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
    //
}
