package textBased;

public class Stringy {

    public boolean SubstringHuh(String original, String sub){
        // max 'i' is original_string's length minus the sub's length
        for (int i = 0; i < (original.length() - sub.length()); i++){
            // == checks for reference equality (the same object)
            // .equals() checks for value equality
            if (sub.equals(original.substring(i, i + sub.length()))){ // right exclusive
                return true;
            }
        }
        return false;
    }


    public String reverseString(String aString){
        String solution = new String();

        for (int i = (aString.length() - 1); i >= 0; i--){
            /* continuously add element from aString to solution
            starting with the rightmost element of aString and
            using i as a counter and index for element to add
             */
            solution += aString.charAt(i);
        }
        return solution;
    }


    public boolean palindromeHuh(String aString){
        if (aString.equals(reverseString(aString))){
            return true;
        }
        return false;
    }


    public int lonelyIntegerFinder(int[] numbers){
        int answer = 0;

        for (int number : numbers){
            answer ^= number;
        }
        return answer;
    }


    public static void main(String[] args){
        Stringy stringy = new Stringy();
        String myString = "The quick brown fox jumped over the lazy dog.";
        String mySub = "e la";
        String racecar = "racecar";
        int[] numbers = {1, 1, 2, 2, 3, 4, 4, 5, 5};

        System.out.println(myString);
        System.out.println(stringy.SubstringHuh(myString, mySub));
        System.out.println(stringy.reverseString(myString));
        System.out.println("Racecar is a palindrome: " + stringy.palindromeHuh(racecar));
        System.out.println("Expecting 3, got: " + stringy.lonelyIntegerFinder(numbers));
    }
}
