package generalChallenges;
import java.util.*;

public class LinkedListManipulation {

    public Object findNthInLinked(LinkedList linky, int n) {
        // make an equivalent array
        Object[] answer = linky.toArray();
        // return int casted Object at index n-1
        return answer[n-1];
    }

}
