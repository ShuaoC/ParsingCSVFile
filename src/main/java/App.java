import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {

    public static void main(String[] args) throws IOException {
        String city;
        int price;
        int sqt;

        int totalPrice = 0;
        int totalSqt = 0;
        int count = 0;
        int maxSac = 0;
        int minSac = 2147483647;


        Reader in = new FileReader("real-estate-data.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        for (CSVRecord record : records) {
            city = record.get(1);
            price = Integer.parseInt(record.get(9));
            sqt = Integer.parseInt(record.get(6));

            if(city == "SACRAMENTO"){
                if(price>maxSac) maxSac = price;
                if(price<minSac) minSac = price;
            }

            totalPrice += price;
            totalSqt += sqt;
            count++;
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }


}
