import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLine {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            int count = 0;
            while ((line = bf.readLine())!= null ){
                count++;
            }
            System.out.println(count-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
