import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ProductWriter {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        boolean done = false;

        while (!done) {
            System.out.println("Enter the product details:");

            String id = SafeInput.getRegExString(scanner, "Enter ID (a String)", "\\d+");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter the product name");
            String desc = SafeInput.getNonZeroLenString(scanner, "Enter the product description");
            double cost = SafeInput.getDouble(scanner, "Enter the product price");

            String record = id + ", " + name + ", " + desc + ", " + cost;
            products.add(record);

            done = !SafeInput.getYNConfirm(scanner, "Do you want to add another product?");
        }

        String filename = SafeInput.getNonZeroLenString(scanner, "Enter the name of the file to save (e.g., Persons.txt)");

        try (FileWriter writer = new FileWriter(filename)) {
            for (String person : products) {
                writer.write(person + "\n");
            }
            System.out.println("File saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }

        scanner.close();
    }
}
