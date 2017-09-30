package textBased;
import java.util.*;

/*
There are three types of license plates that can be made of the format:
        AAA000; 000AAA; 0AAA000
In the last format, the plate is 7 characters long and cannot contain O, P, or Q

Print statement indicating wheter plate is valid or not
 */
public class LicensePlates {
    // this is a regex sorta question

    public void checkPlate (String plate){
        boolean isValid = false;

        if (plate.length() == 6) {
            isValid = (plate.matches("[A-Z]{3}\\d{3}") ||
                    plate.matches("\\d{3}[A-Z]{3}"));
            // Java MUST have double slashes
        } else if (plate.length() == 7){
            isValid = plate.matches("\\d{1}(?![OPQ]){3}(([A-Z](?![OPQ])){3})\\d{3}");
            // put negative look-ahead in parenthesis with expression
        } else {
            System.out.print("License Plate must contain either 6 OR 7 characters. ");
        }

        if (isValid){
            System.out.println("License Plate " + plate + " is valid.");
        } else {
            System.out.println("License Plate " + plate + " is NOT valid.");
        }
    }

    // MAIN
    public static void main(String[] args){
        LicensePlates lp = new LicensePlates();
        List<String> plates = new ArrayList<>();

        plates.add("0AQD111");
        plates.add("JUNDU3F9N9FNTN");
        plates.add("ASD956");
        plates.add("344IRR");
        plates.add("9ETZ070");
        plates.add("AAAAAA");
        plates.add("FU");
        plates.add("1234567");

        for (String plate : plates){
            lp.checkPlate(plate);
        }
    }
}
