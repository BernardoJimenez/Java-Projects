package textBased;

public class TimeConversion {

    static String convertToMilitary(String s) {
        String answer = new String();
        String[] sArr = s.split(":", 2);
        Integer hour = Integer.parseInt(sArr[0]);

        if (s.charAt(s.length()-2) == 'A'){
            if (hour == 12){
                hour = 0;
            }

            if (hour < 10){
                answer += "0" + hour + ":" + sArr[1].substring(0, (sArr[1].length() - 2));
            } else {
                answer += hour + ":" + sArr[1].substring(0, (sArr[1].length() - 2));
            }
        } else {
            if (hour != 12){
                hour += 12;
            }
            answer += hour + ":" + sArr[1].substring(0, (sArr[1].length() - 2));
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "11:05:45AM";
        System.out.println(convertToMilitary(s));
        s = "09:35:13AM";
        System.out.println(convertToMilitary(s));
        s = "09:10:00PM";
        System.out.println(convertToMilitary(s));
        s = "10:55:55AM";
        System.out.println(convertToMilitary(s));
        s = "12:00:59AM";
        System.out.println(convertToMilitary(s));
        s = "01:24:08PM";
        System.out.println(convertToMilitary(s));
    }
}

