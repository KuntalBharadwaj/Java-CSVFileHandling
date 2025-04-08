import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DatabaseToCSV {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("exp1.csv"));
            CSVWriter writer = new CSVWriter(new FileWriter("exp2.csv"))) {
            ArrayList<String[]> list = new ArrayList<>();
            String line[];
            while((line = reader.readNext()) != null) {
                list.add(line);
            }
            writer.writeAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
