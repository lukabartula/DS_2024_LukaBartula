package homework3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {

    public static void main(String[] args) {

        System.out.println("Loading the entries...");
        System.out.println("=======================================");
        Scanner scanner = new Scanner(System.in);
        RedBlackTree tree = null;
        try {
            tree = FileUtils.readFile("raw_phonebook_data.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No file: " + e.getMessage());
            scanner.close();
            return;
        }

        System.out.println("System is ready.");

        int[] counts = tree.countRedAndBlackEdges();
        System.out.println("Total " + "\033[31m" + "red edges " + "\033[0m" + "in the tree: " + counts[1]);
        System.out.println("Total black edges in the tree: " + counts[0] + "\n");

        while (true) {
            System.out.println("Enter a name that you wish to search for, or -1 to exit:");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            ArrayList<Entry> entries = tree.get(input);
            if (entries == null) {
                System.out.println("No entries with the given name exist in the phonebook.\n");
            } else {
                System.out.println("Entries found: " + entries.size() + "\n");
                for (Entry entry : entries) {
                    System.out.println(entry);
                }
            }
        }
        scanner.close();
    }
}
