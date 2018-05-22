package textBased;

public class PickFromArrays {

    /*
    Given a two-dimensional array of strings, return all possible combination of words.

    Example:
    ['grey','black']
    ['fox','dog']
    ['jumped','ran','growled']
    Return:
    grey fox jumped
    grey fox ran
    grey fox growled
    black fox jumped
    ...
    black dog growled
     */

    public void solve(String[][] twoD){
        for (String color : twoD[0]){
            for (String animal : twoD[1]){
                for (String verb : twoD[2]){
                    System.out.println(color + " " + animal + " " + verb);
                }
            }
        }
    }


    public static void main(String[] args){
        PickFromArrays solver = new PickFromArrays();
        String[][] words = {{"grey", "black"}, {"fox", "dog"}, {"jumped", "ran", "growled"}};
        solver.solve(words);
    }
}
