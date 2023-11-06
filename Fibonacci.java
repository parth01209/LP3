import java.util.Scanner;

public class Fibonacci {

    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0;
        long b = 1;
        long result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        long startTimeIterative = System.nanoTime();
        long fibIterative = fibonacciIterative(n);
        long endTimeIterative = System.nanoTime();

        long startTimeRecursive = System.nanoTime();
        long fibRecursive = fibonacciRecursive(n);
        long endTimeRecursive = System.nanoTime();

        System.out.println("Fibonacci(" + n + ") (Iterative) = " + fibIterative);
        System.out.println("Time taken (Iterative): " + (endTimeIterative - startTimeIterative) + " nanoseconds");

        System.out.println("Fibonacci(" + n + ") (Recursive) = " + fibRecursive);
        System.out.println("Time taken (Recursive): " + (endTimeRecursive - startTimeRecursive) + " nanoseconds");
    }
}
