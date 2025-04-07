import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class FilterByMark {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new FileReader("src/main/java/Student.csv"))) {
            String line;
            while ((line = bf.readLine())!= null ){
                String column[] = line.split(",");
                if(parseInt(column[1]) > 80) System.out.println("Name :"+column[0] + " Marks :" + column[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
