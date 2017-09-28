package textBased;
import java.util.*;
/*
There is a note and a magazine, each containing words
If words note all appear the appropriate number of times in magazine
return Yes
else No
 */
public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    // hashmaps containing words and their frequency

    public void checkHelper(String magazine, String note){
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();

        for (String word : magazine.split(" ")){
            // split returns a string array from original String with the arguement acting as the delimiter
            Integer i = magazineMap.get(word);
            // returns value at key = word
            if (i == null){
                magazineMap.put(word, 1);
                // if word was not already in magazineMap, add it and set value(frequency) to 1
            } else {
                magazineMap.put(word, i + 1);
                // if word was already in the map, then add 1 to it by replacing the value
            }
        }
        for (String word : note.split(" ")){
            Integer i = noteMap.get(word);

            if (i == null){
                noteMap.put(word, 1);
            } else {
                noteMap.put(word, i + 1);
            }
        }
    }

    public boolean checkIfLegit(){
        for (Map.Entry<String, Integer> entry :
                noteMap.entrySet()){
            Integer i = magazineMap.get(entry.getKey());

            if (i == null ||
                    entry.getValue() > i){
                // was notfound or word not appear right amount of times
                return false;
            }
        }
        return true;
    }
}

