import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        try(BufferedReader bf = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            while ((line = bf.readLine())!= null ){
                String column[] = line.split(",");
                if(column[1].equals(name)) System.out.println("Name :"+column[0] + " Department :" + column[2] + " Salary :" + column[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
