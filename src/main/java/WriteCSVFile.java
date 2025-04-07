import java.io.*;
import java.util.Scanner;

public class WriteCSVFile {
    public static void main(String[] args) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"))) {
            bw.write("ID,Name,Role,Salary\n");
            bw.write("101,Kuntal,Developer,30000\n");
            bw.write("102,Ujjwal,Management,50000\n");
            bw.write("103,Nikhil,CTO,50000\n");
            bw.write("104,XYZ,Tester,20000\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
