package generalChallenges;
import java.util.*;

public class LinkedListManipulation {

    public int findNthInLinked(LinkedList linky, int n) {

        Object[] answer = linky.toArray();

        return (int) answer[n-1];

    }

}
