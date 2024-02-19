import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner MyScan;
    //завдання 1

    public static void zavd1()
    {
        int n;
        System.out.println("Введіть число n: ");
        n = MyScan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        permute(array, 0, n - 1);
    }

    public static void permute(int[] array, int i, int n) {
        if (i == n) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int j = i; j <= n; j++) {
                swap(array, i, j);
                permute(array, i + 1, n);
                swap(array, i, j);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //завдання 2
    public static boolean nextCombination(int[] combination, int n, int r) {
        int i = r - 1;
        while (i >= 0 && combination[i] == n - r + i + 1) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        combination[i]++;
        for (int j = i + 1; j < r; j++) {
            combination[j] = combination[i] + j - i;
        }
        return true;
    }

    public static void printCombination(int[] combination) {
        System.out.println(Arrays.toString(combination));
    }


    public static void zavd2() {
        System.out.println("Введіть n :");
        int n = MyScan.nextInt();// Ввести натуральне число n

        System.out.println("Введіть r (r ≤ n): ");
        int r = MyScan.nextInt(); // Ввести невід’ємне ціле число r (r ≤ n)

        int[] combination = new int[r];

        // Початкове сполучення
        for (int i = 0; i < r; i++) {
            combination[i] = i + 1;
        }
        printCombination(combination);

        // Побудова лексикографічно наступного сполучення
        while (nextCombination(combination, n, r)) {
            printCombination(combination);
        }
    }

    public static void main(String[] args) {

        MyScan = new Scanner(System.in);
        System.out.println("Виберіть завдання: ");
        int choice = MyScan.nextInt();

        switch (choice)
        {
            case 1:
                zavd1();
                break;
            case 2:
                zavd2();
                break;
            default:
                break;
        }


    }
}
