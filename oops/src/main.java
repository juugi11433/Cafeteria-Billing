import java.util.ArrayList;
import java.util.Scanner;

public class main{

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> itemNames = new ArrayList<>();
    static ArrayList<Double> itemPrices = new ArrayList<>();

    public static void main(String[] args) {

        setupMenu();

        while(true) {
            System.out.println("\n===== CAFETERIA BILLING SYSTEM =====");
            System.out.println("1. Start New Order");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if(choice == 1) {
                takeOrder();
            } else if(choice == 2) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    static void setupMenu() {
        itemNames.add("Samosa");
        itemPrices.add(15.0);

        itemNames.add("Vada Pav");
        itemPrices.add(20.0);

        itemNames.add("Pav Bhaji");
        itemPrices.add(50.0);

        itemNames.add("Masala Dosa");
        itemPrices.add(45.0);

        itemNames.add("Cold Drink");
        itemPrices.add(20.0);

        itemNames.add("Tea");
        itemPrices.add(10.0);

        itemNames.add("Coffee");
        itemPrices.add(15.0);

        itemNames.add("Sandwich");
        itemPrices.add(35.0);
    }

    static void takeOrder() {

        System.out.println("\n--- MENU ---");
        for(int i = 0; i < itemNames.size(); i++) {
            System.out.println((i+1) + ". " + itemNames.get(i) + " - Rs." + itemPrices.get(i));
        }


        ArrayList<String> orderNames = new ArrayList<>();
        ArrayList<Double> orderPrices = new ArrayList<>();
        ArrayList<Integer> orderQuantities = new ArrayList<>();

        while(true) {
            System.out.print("\nEnter item number (0 to finish): ");
            int itemNum = sc.nextInt();

            if(itemNum == 0) {
                break;
            }

            if(itemNum < 1 || itemNum > itemNames.size()) {
                System.out.println("Invalid item number!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            if(qty <= 0) {
                System.out.println("Invalid quantity!");
                continue;
            }

            orderNames.add(itemNames.get(itemNum - 1));
            orderPrices.add(itemPrices.get(itemNum - 1));
            orderQuantities.add(qty);

            System.out.println("✓ Added " + qty + " x " + itemNames.get(itemNum - 1));
        }


        if(orderNames.isEmpty()) {
            System.out.println("\nNo items ordered!");
            return;
        }

        double total = 0;

        System.out.println("\n========== BILL ==========");
        System.out.println("Item           Qty   Price   Total");
        System.out.println("---------------------------------");

        for(int i = 0; i < orderNames.size(); i++) {
            double itemTotal = orderPrices.get(i) * orderQuantities.get(i);
            System.out.printf("%-12s %3d   ₹%-5.0f  ₹%-6.0f\n",
                    orderNames.get(i), orderQuantities.get(i),
                    orderPrices.get(i), itemTotal);
            total = total + itemTotal;
        }

        System.out.println("---------------------------------");
        System.out.printf("TOTAL: ₹%.0f\n", total);
        System.out.println("=================================");
        System.out.println("   Thank you! Visit Again!");


        System.out.print("\nEnter amount to pay: Rs. ");
        double paid = sc.nextDouble();

        if(paid >= total) {
            double change = paid - total;
            System.out.printf("Change: ₹%.0f\n", change);
            System.out.println("Payment successful!");
        } else {
            System.out.println("Insufficient payment!");
        }

        System.out.println("\nOrder completed! Starting new session...");
    }
}