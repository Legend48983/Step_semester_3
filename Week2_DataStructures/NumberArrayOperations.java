import java.util.Scanner;

public class NumberArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 different numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nOriginal Array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        sc.close();
    }
}
