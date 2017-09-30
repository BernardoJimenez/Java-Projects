package dataStructures;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StackQ<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();
    // order they appeared
    // oldest is the 1st item

    public void enqueue(T value) { // Push onto newest stack
        stackNewestOnTop.push(value);
        // push more current item on top
    }

    public T peek() {
        prepOldStack();
        return stackOldestOnTop.peek();
    }

    public T dequeue() {
        prepOldStack();
        return stackOldestOnTop.pop();
        // pop form oldest numbers first stack

    }

    public void prepOldStack() {
        // only refill the oldest numbers first stack once it is empty
        if (stackOldestOnTop.isEmpty())
            while (!stackNewestOnTop.isEmpty())
                // empty the newest number sinto oldest in reverse order
                // once done, only have to do again once oldest is empty from dequeing
                stackOldestOnTop.push(stackNewestOnTop.pop());
    }


}
