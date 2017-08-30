package dataStructures;
import java.io.*;
import java.util.*;

public class Node {

    public int NData; // data to be stored at each Node
    public Node leftChild;
    public Node rightChild;

    public void displayNode(){
        System.out.print("{" + NData + "} ");
    }
    //
}
