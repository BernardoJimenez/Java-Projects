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

    // end main
    }
}
