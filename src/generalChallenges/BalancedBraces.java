package generalChallenges;
import java.util.*;

public class BalancedBraces {

    private static boolean closingCompliment(char brace, char nextBrace){
        if ((brace == '(') && (nextBrace == ')')){
            return true;
        } else if ((brace == '[') && (nextBrace == ']')){
            return true;
        } else if ((brace == '{') && (nextBrace == '}')){
            return true;
        } else {
            return false;
        }
    }


    private static boolean aCloser(char brace){
        char[] closingBraces = {')', ']', '}'};

        for (char closer : closingBraces){
            if (brace == closer){
                return true;
            }
        }
        return false;
    }


    public boolean check(String braceStr) {
        // input MUST be a String of braces
        if (braceStr.length() == 0){
            return true;
        } else if (aCloser(braceStr.charAt(0)) || (braceStr.length() % 2 > 0)){
            return false;
        }

        Stack<Character> braces = new Stack<>();

        for (int i = 0; i < braceStr.length(); i++) {
            if (aCloser(braceStr.charAt(i))) {
                if (closingCompliment(braces.peek(), braceStr.charAt(i))) {
                    braces.pop();
                } else {
                    return false;
                }
            } else {
                braces.push(braceStr.charAt(i));
            }
        }
        return braces.empty();
    }


    // MAIN
    public static void main(String[] args){

        BalancedBraces bb = new BalancedBraces();

        boolean solution  = bb.check("([{}])");
        boolean solution1 = bb.check("()()()()");
        boolean solution2 = bb.check("(){}[]{}[]()");
        boolean solution3 = bb.check("([)]");
        boolean solution4 = bb.check("([{}]]{])");
        boolean solution5 = bb.check("");
        boolean solution6 = bb.check("{");

        System.out.println("Expects true. Actual: " + solution);
        System.out.println("Expects true. Actual: " + solution1);
        System.out.println("Expects true. Actual: " + solution2);
        System.out.println("Expects false. Actual: " + solution3);
        System.out.println("Expects false. Actual: " + solution4);
        System.out.println("Expects true. Actual: " + solution5);
        System.out.println("Expects false. Actual: " + solution6);
        // all tests pass
    }
}
