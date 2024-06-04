package homework3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileUtils {
    // This method reads a file and returns a RedBlackTree containing entries from the file.
    public static RedBlackTree readFile(String filePath) throws FileNotFoundException {
        // Create a new RedBlackTree.
        RedBlackTree tree = new RedBlackTree();

        // Scanner to read the file.
        Scanner scanner = new Scanner(new FileReader(filePath));

        // This flag is used to skip the first line of the file (usually the header).
        boolean isFirstLine = true;

        // Loop through each line in the file.
        while (scanner.hasNextLine()) {
            // Trim leading and trailing whitespace from the line.
            String line = scanner.nextLine().trim();

            // Skip the first line.
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }

            // Skip empty lines.
            if (line.isEmpty()) continue;

            // Split the line into data fields using the semicolon as a delimiter.
            String[] data = line.split(";");

            // If the line does not contain exactly 6 data fields, print an error message and skip this line.
            if (data.length != 6) {
                System.out.println("Invalid line skipped: " + line);
                continue;
            }

            // Split the first data field (the name) into surname and name using the comma as a delimiter.
            String[] nameParts = data[0].split(", ");

            // If the name field does not contain exactly 2 parts (surname and name), print an error message and skip this line.
            if (nameParts.length != 2) {
                System.out.println("Invalid name field: " + data[0]);
                continue;
            }

            // Extract the surname and name.
            String surname = nameParts[0];
            String name = nameParts[1];

            // Create a new Entry with the data from the line.
            Entry entry = new Entry(surname, name, data[1], data[2], data[3], data[4], data[5]);

            // Add the entry to the tree using the full name (surname + ", " + name) as the key.
            tree.put(surname + ", " + name, entry);
        }

        // Close the scanner.
        scanner.close();

        // Return the populated tree.
        return tree;
    }
}