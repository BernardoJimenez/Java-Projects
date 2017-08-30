package dataStructures;

public class Queue {

    private int maxSize;
    private int[] qArray;
    private int front;
    private int rear;
    private int numOfItems;

    public Queue(int size){
        maxSize = size;
        qArray = new int[maxSize];
        front = 0;
        rear = -1;
        numOfItems = 0;
    }


    public void insert(int newData){
        if (rear == maxSize - 1){
            // wrap around if at the last index
            rear = -1;
            // ring buffer
        }
        qArray[++rear] = newData;
        numOfItems++;
    }


    public int remove(){
        // from front of queue
        int temp = qArray[front++];

        if (front == maxSize){
            front = 0;
        }

        numOfItems--;
        return temp;
    }


    public int peekFront(){
        return qArray[front];
    }



    public boolean isFull(){
        return (numOfItems == maxSize);
    }


    public int size(){
        return numOfItems;
    }
    //
}
