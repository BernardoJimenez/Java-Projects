package mathBased;

public class Dynamic {

    private int fibHelper(int number, int[] container){
        if (number == 0){
            //System.out.println(0);
            return 0;
        }
        if (number == 1 || number == 2){
            //System.out.println(1);
            return 1;
        }

        if (container[number] == 0){
            container[number] = fibHelper(number - 1, container) +
                    fibHelper(number - 2, container);
        }
        //System.out.println(container[number]);
        return container[number];
    }

    public int fibonacci(int number){
        return fibHelper(number, new int[number + 1]);
        // need 1 greater because will have a value
        // for 'index: 0' and for 'index: number'
    }


    public void printFib(int number){
        int[] memo = new int[2];

        if (number > -1){
            System.out.println(0);
            memo[0] = 0;
        }
        if (number > 0){
            System.out.println(1);
            memo[1] = 1;
        }
        if (number > 1){ // fib(2)
            System.out.println(1);
            memo[0] = 1;
        }

        for (int i = number; i > 2; i--){
            // already processed fib(0) ... fib(2)
            int sum = memo[0] + memo[1];

            System.out.println(sum);
            memo[0] = memo[1];
            memo[1] = sum;
        }
    }


    public static void main(String[] args){
        Dynamic dyno = new Dynamic();

        dyno.printFib(23);
    }
}