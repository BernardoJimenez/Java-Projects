import java.io.*;

public class ReadAndWriteTest {

    public static void main(String[] args){
        String filePath = "C:\\Users\\t430\\Desktop\\REMEMBER.txt";
        String line = null;

        try{
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            while ((line = bf.readLine()) != null){
                System.out.println(line);
            }
            bf.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found!");
        }
        catch (IOException ex){
            System.out.println("Error reading file!");
        }
    }
}
