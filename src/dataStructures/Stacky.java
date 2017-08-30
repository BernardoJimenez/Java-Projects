package dataStructures;

public class Stacky {
    // own stack implementation

    private int maxSize; // size of stack
    private int[] stackArray;
    private int top; // item on top of stack
    // when stack is full, top is at last index

    public Stacky(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // stack is currently empty
    }


    public void push(int num){
        // add new item after the top item. Stack it on
        stackArray[++top] = num;
    }


    public int pop(){
        // return value of top item
        return stackArray[--top];
        // also decrement top
    }


    public int peek(){
        return stackArray[top];
    }


    public boolean isEmpty(){
        return (top == -1); // top is the index of the top item
    }


    public boolean isFull(){
        // top is at final index
        return (top == stackArray.length - 1);
    }
    //
}
