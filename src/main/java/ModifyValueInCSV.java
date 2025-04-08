import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ModifyValueInCSV {
    public static void main(String[] args) {

        try (BufferedReader bf = new BufferedReader(new FileReader("employees.csv"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("outputemployees.csv"))) {

            String line;
            while ((line = bf.readLine()) != null) {
                String column[] = line.split(",");

                if (column.length >= 4 && column[2].equalsIgnoreCase("IT")) {
                    // Parse and update salary
                    double salary = Double.parseDouble(column[3]);
                    salary = salary + salary * 0.10;
                    column[3] = (String.valueOf(Integer.parseInt(column[3]) + Integer.parseInt(column[3]) * 0.1));
                    // Update the salary in the array
                }

                // Join and write updated line to the output file
                String updatedLine = String.join(",", column);
                bw.write(updatedLine);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Files.delete(Paths.get("employees.csv")); // delete old file
            Files.move(Paths.get("outputemployees.csv"), Paths.get("employees.csv")); // rename temp to original
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
