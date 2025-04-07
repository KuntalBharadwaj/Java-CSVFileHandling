import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/main/java/employee.csv";
        BufferedReader bf2 = new BufferedReader(new FileReader(file));
        System.out.println(bf2);
        try(BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] column = line.split(",");
                System.out.println("ID :" + column[0]);
                System.out.println("Name :" + column[1]);
                System.out.println("Age :" + column[2]);
                System.out.println("Mark :" + column[3]);
                System.out.println("******************");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
