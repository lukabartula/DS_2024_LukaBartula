package week3.labTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            List<String> lines = reader.lines().toList();
            IPAddress[] arrayReturn = new IPAddress[lines.size()];

            for(int i=0; i< lines.size(); i++){
                String[] split = lines.get(i).split(";");
                IPAddress newAddress = new IPAddress(
                        Long.parseLong(split[0]),
                        Long.parseLong(split[1]),
                        split[2],
                        split[3],
                        split[4],
                        split[5]);
                arrayReturn[i] = newAddress;
            }
            reader.close();
            return arrayReturn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
