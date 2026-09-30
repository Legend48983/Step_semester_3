import java.util.Scanner;

public class NumberArrayOperations {

    // Find second lowest and second highest without built-in functions
    public static void findSecondValues(int[] numbers) {
        int lowest = numbers[0];
        int secondLowest = numbers[1];
        int highest = numbers[0];
        int secondHighest = numbers[1];

        if (secondLowest < lowest) {
            int temp = lowest;
            lowest = secondLowest;
            secondLowest = temp;
        }

        if (secondHighest > highest) {
            int temp = highest;
            highest = secondHighest;
            secondHighest = temp;
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] < lowest) {
                secondLowest = lowest;
                lowest = numbers[i];
            } else if (numbers[i] < secondLowest && numbers[i] != lowest) {
                secondLowest = numbers[i];
            }

            if (numbers[i] > highest) {
                secondHighest = highest;
                highest = numbers[i];
            } else if (numbers[i] > secondHighest && numbers[i] != highest) {
                secondHighest = numbers[i];
            }
        }

        System.out.println("Second Lowest  : " + secondLowest);
        System.out.println("Second Highest : " + secondHighest);
    }

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

        System.out.println("\n\nSecond Highest and Second Lowest:");
        findSecondValues(numbers);

        sc.close();
    }
}
