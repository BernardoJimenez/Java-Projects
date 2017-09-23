package dataStructures;
import java.util.*;

public class HashTableDemo {
    // just playing around with built in java.util
    // Hashtable class

    public static void main(String args[]) {
        Hashtable<String, String> pets =
                new Hashtable<String, String>();

        // Hashtable is synchronized, meaning only one thread
        // may access it at a time. It also does not accept
        // NULL key or values

        pets.put("Fido", "dog");
        pets.put("Bun-bun", "rabbit");
        pets.put("Snowball", "cat");
        pets.put("Dr. Bob", "clown fish");
        pets.put("Alejandro", "guinea pig");

        pets.get("Dr. Bob");

        pets.containsKey("Snowball");

        pets.containsValue("guinea pig");

        Enumeration petsVals = pets.elements();
        while (petsVals.hasMoreElements()) {
            System.out.print(petsVals.nextElement());
        }

        Enumeration petsKeys = pets.keys();

        pets.isEmpty();
        pets.size();

        Set petKeySet = pets.keySet();

        pets.clear();

        System.out.println();
        // end


        // GIVEN A STRING OF CHARACTERS, WALK THRU AND CALCULATE THE FREQUENCY OF EACH LETTER:
        String inputStr = "abcdeffgggghhiiiiijjkkllllmmmnnoopqrrrrrstvwwxxxxxxxxxxyyzzzzzzzzzzzz";
        Hashtable<Character, Integer> answer = new Hashtable(26); // can't use primitives
        char[] inputArr = inputStr.toCharArray();
        int counter = 0;

        for (int i = 0; i < inputArr.length; i++){
            char current = inputArr[i];
            counter++;

            if (((i + 1) == inputArr.length) || inputArr[i + 1] != inputArr[i]){
                answer.put(current, counter);
                counter = 0;
            }

        }

        Enumeration answerKeys = answer.keys();
        Enumeration answerValues = answer.elements();


        while (answerKeys.hasMoreElements()){
            System.out.println("(" + answerKeys.nextElement() +
                    ", " + answerValues.nextElement() + ")");
        }
        // "bugs" present in the above program:
        // Does not print in alphabetical order, possibly due to Enumeration
        // Does not acknowledge letters with zero instances in the String
        // not modular
    }
}
