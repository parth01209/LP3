import java.util.Scanner;

public class Knapsack01 {

    public static int knapsack(int[] profits, int[] weights, int capacity) {
        int[][] table = new int[profits.length + 1][capacity + 1];

        for (int i = 0; i <= profits.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (weights[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], profits[i - 1] + table[i - 1][j - weights[i - 1]]);
                }
            }
        }

        return table[profits.length][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] profits = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit for item " + (i + 1) + ": ");
            profits[i] = scanner.nextInt();
            System.out.print("Enter weight for item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();

        int maximum = knapsack(profits, weights, capacity);

        System.out.println("The maximum profit is " + maximum);
    }
}
