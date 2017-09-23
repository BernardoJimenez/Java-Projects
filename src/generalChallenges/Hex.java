package generalChallenges;

class Hex {

    public static String doubleHex(String hexstring){
        String[] parts = hexstring.split("x");

        int asInt = Integer.parseInt(parts[1], 16);

        int doubledInt = asInt * 2;

        String solution = "0x" + Integer.toHexString(doubledInt);

        return solution;
    }


    // MAIN
    public static void main(String[] args){
        String stringy = "0x5";
        System.out.print(Hex.doubleHex(stringy));
    }
}