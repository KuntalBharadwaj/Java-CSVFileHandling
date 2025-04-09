import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class EncriptionDecription {

    static String encription(String line) {
        return Base64.getEncoder().encodeToString(line.getBytes());
    }

    static String decription(String line) {
        byte[] decodedbyte = Base64.getDecoder().decode(line.getBytes());
        return new String(decodedbyte);
    }

    static void showEncriptedFileData() {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/java/EncriptEmployee.csv"))) {
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null) {
                System.out.println("ID : " + line[0]);
                System.out.println("Name : " + line[1]);
                System.out.println("Email : " + decription(line[2]));
                System.out.println("Salary : " + decription(line[3]));
                System.out.println("************************");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showdecriptedFileData() {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/java/EncriptEmployee.csv"))) {
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null) {
                System.out.println("ID : " + line[0]);
                System.out.println("Name : " + line[1]);
                System.out.println("Email : " + (line[2]));
                System.out.println("Salary : " + (line[3]));
                System.out.println("************************");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void storeEncriptedData() {
        ArrayList<String[]> list = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader("src/main/java/EncriptEmployee.csv"))) {
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null) {
                line[2] = encription(line[2]);
                line[3] = encription(line[3]);
                list.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try(CSVWriter writter = new CSVWriter(new FileWriter("src/main/java/EncriptEmployee.csv"))) {
            writter.writeAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void storeDecriptedData() {
        ArrayList<String[]> list = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader("src/main/java/EncriptEmployee.csv"))) {
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null) {
                line[2] = decription(line[2]);
                line[3] = decription(line[3]);
                list.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try(CSVWriter writter = new CSVWriter(new FileWriter("src/main/java/EncriptEmployee.csv"))) {
            writter.writeAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equalsIgnoreCase("encription")) storeEncriptedData();
        if(input.equalsIgnoreCase("showEncriptedData"))showEncriptedFileData();
        if(input.equalsIgnoreCase("decription"))storeDecriptedData();
        if(input.equalsIgnoreCase("showDecriptedData"))showdecriptedFileData();
    }
}
