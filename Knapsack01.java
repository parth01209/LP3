import java.util.*;

class Knapsack01 {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w)
                    dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter the profit and weight of each item:");
        for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextInt();
            weight[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        int W = scanner.nextInt();

        int result = knapSack(W, weight, profit, n);
        System.out.println("Maximum value in the knapsack: " + result);

        scanner.close();
    }
}
