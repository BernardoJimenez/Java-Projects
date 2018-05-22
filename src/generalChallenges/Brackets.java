package generalChallenges;
import java.util.*;

public class Brackets {

    public static boolean isBracket(char character){
        if (character == '}' ||
                character == '{' ||
                character == '[' ||
                character == ']' ||
                character == '(' ||
                character == ')'){
            return true;
        }
        return false;
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (isBracket(c)){
                if (c == '('){
                    stack.push(')');
                } else if (c == '{'){
                    stack.push('}');
                } else if (c == '['){
                    stack.push(']');
                } else if (stack.isEmpty()
                        || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args){
        String words = "d{{{5(([]))x}}}x";

        System.out.println(Brackets.isValid(words));
    }

}