import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class SortCSV {
    public static void main(String[] args) {
        ArrayList<String[]> column = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                String field[] = line.split(",");
                column.add(field);
            }

            column.sort((a, b) -> Integer.compare(Integer.parseInt(b[3]), Integer.parseInt(a[3])));
            System.out.println(column.size());

    } catch (Exception e) {
            e.printStackTrace();
        }

        try(BufferedWriter br = new BufferedWriter(new FileWriter("employees.csv"))) {
            for(int i=0;i< column.size();i++) {
                System.out.println(column.get(i)[3]);
                String row[] = column.get(i);
                String updatedLine = String.join(",", row);
                br.write(updatedLine);
                br.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

     }
}
