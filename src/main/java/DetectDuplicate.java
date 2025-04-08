import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

public class DetectDuplicate {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/java/studentsss.csv"))) {
            HashSet<String> studentset = new HashSet<>();
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null) {
                if(studentset.contains(line[0])) System.out.println(" ID :"+ line[0] + " name :"+ line[1]+ " mark :" + line[2]);
                else studentset.add(line[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
