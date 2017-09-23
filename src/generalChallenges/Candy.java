package generalChallenges;

public class Candy {

    /*
    Each kid gets at least 1 piece of candy or more based on rating.
    Children are rated for some reason.
    Kid with higher rating must not have MORE candy than lower-rated neighbors
     */
    public int candiesGiven(int[] kidRatings){
        int length = kidRatings.length;
        int solution = 0;
        int[] candiesPerKid = new int[kidRatings.length];
        candiesPerKid[0]++;

        for (int i = 1; i < length; i++){
            solution += candiesPerKid[i-1];
            candiesPerKid[i]++;
            if (kidRatings[i] > kidRatings[i-1]){
                candiesPerKid[i] = candiesPerKid[i-1] + 1;
            }
        }

        for (int kid : candiesPerKid){
            System.out.print(kid + " ");
        }
        System.out.println();

        return solution += candiesPerKid[length - 1];
    }


    // MAIN
    public static void main(String[] args){
        Candy sweet = new Candy();

        int[] kiddies = {10, 0, 9, 3, 5, 6, 0, 0, 0, 2, 5, 7, 3, 4, 5, 6, 5};
        System.out.print("Minimum amount of candy to give out is: "
                + sweet.candiesGiven(kiddies));
    }

}
