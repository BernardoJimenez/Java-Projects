import java.io.*;

public class InputHelper {
    public String getUserInput(String prompt) {
        String userInput = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            userInput = reader.readLine();

            if (userInput.length() == 0) return null;
        } catch (IOException exception) {
            System.out.println("IOException: " + exception);
        }
        return userInput;
    }
}
