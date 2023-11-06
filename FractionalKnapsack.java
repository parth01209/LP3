import java.util.*;

public class FractionalKnapsack {

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

        // Create a list of items with profit/weight ratio
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(profits[i], weights[i]));
        }

        // Sort the items by profit/weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.getRatio(), a.getRatio()));

        // Calculate the maximum profit
        double totalProfit = 0.0;
        int currentCapacity = capacity;

        for (Item item : items) {
            if (currentCapacity >= item.weight) {
                totalProfit += item.profit;
                currentCapacity -= item.weight;
            } else {
                totalProfit += item.profit * (currentCapacity / (double) item.weight);
                break;
            }
        }

        // Print the maximum profit
        System.out.println("The maximum profit is " + totalProfit);
    }

    static class Item {
        int profit;
        int weight;

        public Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }

        public double getRatio() {
            return (double) profit / weight;
        }
    }
}


//    Enter the number of items: 3
//        Enter profit for item 1: 100
//        Enter weight for item 1: 20
//        Enter profit for item 2: 60
//        Enter weight for item 2: 10
//        Enter profit for item 3: 120
//        Enter weight for item 3: 30
//        Enter the knapsack capacity: 50
