package Lab_3;

import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter The List Of Fruits: ");
        String input = scanner.nextLine();

        String[] fruits = input.split(" ");

        for (String fruit : fruits) {
            set.add(fruit);
        }

        System.out.println(set);

        scanner.close();
    }
}
