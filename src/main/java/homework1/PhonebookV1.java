package homework1;

import java.io.IOException;
import java.util.Scanner;

import static homework1.BinarySearch.search;
import static homework1.MergeSort.sort;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        // main application logic
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loading the entries...");
        Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");

        System.out.println("Sorting the entries...");
        sort(entries);
        System.out.println("Saving the sorted file...");
        FileUtils.writeToFile(entries, "raw_phonebook_data_sorted.csv");
        System.out.println("================================");
        System.out.println("System is ready.\n");

        while(true) {
            System.out.print("Enter the name that you wish to search for, or -1 to exit: ");
            String searchedName = scanner.nextLine();

            if (searchedName.equals("-1")) {
                System.out.println("Thank you for using the phonebook");
                break;
            } else {
                int[] results = search(entries, searchedName);

                if (results.length != 0) {
                    System.out.println("Entries found: " + (results[1] - results[0] + 1));
                    for (int i = results[0]; i <= results[1]; i++) {
                        System.out.println("Name: " + entries[i].name);
                        System.out.println("Street: " + entries[i].streetAddress);
                        System.out.println("City: " + entries[i].city);
                        System.out.println("Postal code: " + entries[i].postcode);
                        System.out.println("Country: " + entries[i].country);
                        System.out.println("Phone number: " + entries[i].phoneNumber + "\n");

                    }
                } else {
                    System.out.println("No entries with the given name exist in the phonebook.\n");
                }
            }
        }
    }
}
