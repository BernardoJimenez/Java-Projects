package generalChallenges;
import java.util.*;

public class LeaderBoard {

    // Hashmap which has the player_id as the key, represented by an integer
    // the value is an array of floats, with the first index the score
    // and the second index is the number of scores the player has total.
    // value: {averageScore, numberOfScores}
    Map<Integer, float[]> scores = new HashMap<>();


    /*
    Input: two integers, player_id and score
    Output: a float value
    Description: adds the given score to given player's average
     */
    public float add_score(int player_id, int score){
        // if player_id is not already in the 'scores' hashmap,
        // add a new entry with key: player_id
        if (scores.get(player_id) == null){
            // construct value array for entry
            float[] key = {score, 1};
            // add the entry
            scores.put(player_id, key);
            // return the average, which is just the score
            return score;
        }
        // get the value array for entry with key: player_id
        float[] current = scores.get(player_id);
        // update score for value array to include new score in average
        current[0] = ((current[0] * current[1]) + score)/(current[1] + 1);
        // increment the number of total scores the player has
        current[1]++;
        // update the player in the 'scores' hashmap
        scores.put(player_id, current);

        // return the new average score for player_id
        return current[0];
    }


    /*
    Input: an integer representing the number of top scores
    Output: a list
    Description: returns a list 'max' number of player_ids sorted by score
     */
    public List<Integer> top(int max){
        // create a list to hold the top scores
        LinkedList<Integer> tops = new LinkedList<>();

        // iterate over the entries in the 'score' hashmap
        for (Map.Entry<Integer, float[]> entry : scores.entrySet()){
            // store the entry's value array as 'score'
            float[] score = entry.getValue();

            // if the list of scores is not empty
            if (!tops.isEmpty()){
                // check if max is one element
                if (max == 1){ // these lines may be redundant
                    // store the head of the list as 'current'
                    int current = tops.peek();
                    // if so: add the greater between "current"'s score
                    // and the current entry's score
                    if (score[0] > scores.get(current)[0]){
                        // add the entry player_id as the head
                        tops.addFirst(entry.getKey());
                    } else {
                        // keep the current head
                        tops.addFirst(current);
                    }
                    // skip rest of iteration
                    continue;
                }
                // if the next entry's score is
                // lower than the list's head
                if (score[0] < scores.get(tops.peek())[0]){
                    // save the list's current size as 'size'
                    int size = tops.size();
                    // iterate trough the list starting at index 1
                    for (int i = 1; i <= size; i++){
                        // check if we are at the end of the list
                        if (i == size){
                            // if so, add id as last element
                            tops.add(entry.getKey());
                        }
                        // if the element at current index is
                        // less than the next entry's score
                        if (scores.get(tops.get(i))[0] < score[0]){
                            // add id for entry's score at current index
                            tops.add(i, entry.getKey());
                            // break out of iteration
                            break;
                        }
                    }
                } else {
                    // if next entry's score is higher than
                    // the head of the list, then add the
                    // id for the entry as the new head
                    tops.addFirst(entry.getKey());
                }
            } else {
                if (max > 0) {
                    // if the list is currently empty, add entry's id
                    tops.addFirst(entry.getKey());
                } else {
                    return tops;
                }
            }
        }
        // if the max is bigger than the list's length
        // then have the end of the sublist be the whole list
        int end = max > tops.size() ? tops.size() : max;
        // return the list of top scores
        return tops.subList(0, end);
    }


    /*
    Input: an int representing a player_id
    Output: nothing
    Description: reset the given player's score to zero
     */
    public void reset(int player_id){
        // initialize a reset value array with
        // zero scores and an average of zero
        float[] value = {0, 0};
        // if the player is not present, add it
        // if so, replace score/num_scores with value array
        scores.put(player_id, value);
    }


    // tests
    public static void main(String[] args){
        LeaderBoard leader = new LeaderBoard();

        System.out.println(leader.add_score(2, 100));
        System.out.println(leader.add_score(2, 98));
        System.out.println(leader.add_score(1, 7));

        leader.reset(2);

        System.out.println(leader.add_score(2, 25));
        System.out.println(leader.add_score(3, 80));
        System.out.println(leader.add_score(4, 24));
        System.out.println(leader.add_score(5, 32));
        System.out.println(leader.add_score(5, 11));
        System.out.println(leader.add_score(8, 99));
        System.out.println(leader.add_score(9, 68));
        System.out.println(leader.add_score(12, 28));
        System.out.println(leader.add_score(50, 84));
        System.out.println(leader.add_score(2, 0));

        leader.reset(3);

        System.out.println(leader.add_score(4, 47));
        System.out.println(leader.add_score(4, 55));
        System.out.println(leader.add_score(12, 100));
        System.out.println(leader.add_score(2, 33));
        System.out.println(leader.add_score(2, 75));
        System.out.println(leader.add_score(50, 32));

        leader.reset(2);

        System.out.println(leader.add_score(2, 11));
        System.out.println(leader.add_score(1, 99));
        System.out.println(leader.add_score(3, 68));
        System.out.println(leader.add_score(16, 28));
        System.out.println(leader.add_score(4, 84));

        leader.reset(9);

        System.out.println();

        System.out.println("   =====Rankings=====");
        for (int number : leader.top(100)){
            System.out.println("Player ID: " + number + ", " + "Score: " + leader.scores.get(number)[0]);
        }
        System.out.println("   ==================");

        System.out.println();

        System.out.println("   =====Rankings=====");
        for (int number : leader.top(1)){
            System.out.println("Player ID: " + number + ", " + "Score: " + leader.scores.get(number)[0]);
        }
        System.out.println("   ==================");

        System.out.println();

        System.out.println("   =====Rankings=====");
        for (int number : leader.top(3)){
            System.out.println("Player ID: " + number + ", " + "Score: " + leader.scores.get(number)[0]);
        }
        System.out.println("   ==================");

        System.out.println();

        System.out.println("There should not be anything between...");
        for (int number : leader.top(0)){
            System.out.println("Player ID: " + number + ", " + "Score: " + leader.scores.get(number)[0]);
        }
        for (int number : leader.top(-5)){
            System.out.println("Player ID: " + number + ", " + "Score: " + leader.scores.get(number)[0]);
        }
        System.out.println("... these lines since max is less than 1.");
    }// end tests
}// end class