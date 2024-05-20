package homework1;

import java.io.*;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        // implement the actual logic (remove next line)

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            List<String> lines = reader.lines().toList();
            Entry[] returnThisArray = new Entry[lines.size() - 1];
            for (int i = 1; i < lines.size(); i++) {
                //splitting the lines by the semicolon and creating a new Entry object with the split values
                String[] split = lines.get(i).split(";");
                //no need for parsing because all are strings
                Entry newEntry = new Entry(split[0], split[1], split[2], split[3], split[4], split[5]);
                returnThisArray[i - 1] = newEntry;
            }

            reader.close();
            return returnThisArray;
        } catch (IOException e) {
            throw new FileNotFoundException("File not found");
        }
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        // implement the actual logic

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        //writing for each entry the values separated by semicolons using String.format
        for(Entry entry: entries) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s\n", entry.name, entry.streetAddress, entry.city, entry.postcode, entry.country, entry.phoneNumber));
        }
        writer.close();
    }
}