package mathBased;
import java.util.*;

/*
Get current median at every addition of number from array to set
 */
public class RunningMedian {

    public static double[] getMedians(int[] array){
        PriorityQueue<Integer> lowerNumbers = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return -1 * (a.compareTo(b));
            }
        });
        PriorityQueue<Integer> higherNumbers = new PriorityQueue<Integer>();
        double[] medians = new double[array.length];

        for (int i = 0; i < array.length; i++){
            int number = array[i];
            addNumber(number, lowerNumbers, higherNumbers);
            rebalance(lowerNumbers, higherNumbers);
            medians[i] = getMediansHelper(lowerNumbers, higherNumbers);
        }
        return medians;
    }


    private static void addNumber(int number, PriorityQueue<Integer> lowerNumbers, PriorityQueue<Integer> higherNumbers){
        if (lowerNumbers.size() == 0 || number < lowerNumbers.peek()){
            lowerNumbers.add(number);
        } else {
            higherNumbers.add(number);
        }
    }


    private static void rebalance(PriorityQueue<Integer> lowerNumbers, PriorityQueue<Integer> higherNumbers){
        PriorityQueue<Integer> biggerHeap =
                lowerNumbers.size() > higherNumbers.size() ? lowerNumbers : higherNumbers;
        PriorityQueue smallerHeap =
                lowerNumbers == biggerHeap ? higherNumbers : lowerNumbers;

        if (biggerHeap.size() - smallerHeap.size() > 1){
            // if difference in size is greater than 1,
            // remove from top of stack from bigger and
            // add to smaller
            smallerHeap.add(biggerHeap.poll());
        }
    }


    private static double getMediansHelper(PriorityQueue<Integer> lowerNumbers, PriorityQueue<Integer> higherNumbers){
        PriorityQueue<Integer> biggerHeap =
                lowerNumbers.size() > higherNumbers.size() ? lowerNumbers : higherNumbers;
        PriorityQueue<Integer> smallerHeap =
                lowerNumbers == biggerHeap ? higherNumbers : lowerNumbers;

        if (biggerHeap.size() == smallerHeap.size()){
            return ((double) (biggerHeap.peek() + smallerHeap.peek()) / 2);
        } else {
            return biggerHeap.peek();
        }
    }


    // MAIN
    public static void main(String[] args){
        RunningMedian runner = new RunningMedian();
        int[] someNumbers = {1,2,3,1,16,8,5,33,6,8,84,32,6,8,5,45,0};
        double[] medians = runner.getMedians(someNumbers);

        for (int i = 0; i < someNumbers.length; i++){
            System.out.println("After adding " + someNumbers[i] +
                    " to the set, new median is " + medians[i]);
        }
    }
}



