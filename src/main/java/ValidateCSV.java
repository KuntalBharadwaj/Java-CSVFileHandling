import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {

    static boolean validatePhone(String phone) {
        String regex = "^[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    static boolean validateEmail(String email) {
        email = email.trim();
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("contact.csv"))) {
            String[] line;
            reader.readNext();
            while((line = reader.readNext()) != null) {
                if(!validatePhone(line[0])) throw new Exception(" Phone Number is Invalid");
                else System.out.print("valid :" + line[0]);
                if(!validateEmail(line[1])) throw new Exception(" Email is Invalid");
                else System.out.println(" valid :" + line[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
