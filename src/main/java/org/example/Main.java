package machine;
import java.util.Scanner;
public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffee = 120;
    private static int cups = 9;
    private static int cash = 550;
    // water, milk, coffe, price
    private static final int[] ESPRESSO = {250, 0, 16, 4};
    private static final int[] LATTE = {350, 75, 20, 7};
    private static final int[] CAPPUCCHINO = {200, 100, 12, 6};
    public static int readInt(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextInt();
    }
    public static String readString(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.next();
    }
    public static void fillCoffeMachine() {
        water += readInt("Write how many ml of water you want to add:");
        milk += readInt("Write how many ml of milk you want to add:");
        coffee += readInt("Write how many grams of coffee beans you want to add:");
        cups += readInt("Write how many disposable cups you want to add:");
    }
    public static void takeMoney() {
        System.out.printf("I gave you $%d\n", cash);
        cash = 0;
    }
    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffee);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", cash);
    }
    public static void spendingIngredients(String type) {
        int[] COFFEE = new int[4];
        switch (type) {
            case "1" -> COFFEE = ESPRESSO;
            case "2" -> COFFEE = LATTE;
            case "3" -> COFFEE = CAPPUCCHINO;
        }
        if (type.equals("back")) {
            return;
        }
        if (water < COFFEE[0]) {
            System.out.println("Sorry, not enough water!");
            return;
        } else {
            water -= COFFEE[0];
        }
        if (milk < COFFEE[1]) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else {
            milk -= COFFEE[1];
        }
        if (coffee < COFFEE[2]) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else {
            coffee -= COFFEE[2];
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        } else {
            cups -= 1;
        }
        cash += COFFEE[3];
        System.out.println("I have enough resources, making you a coffee!");
    }
    public static void buy() {
        spendingIngredients(readString("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:"));
    }
    public static void main(String[] args) {
        boolean i = true;
        while ( i == true) {
            System.out.println();
            switch (readString("Write action (buy, fill, take, remaining, exit):")) {
                case "buy" -> buy();
                case "fill" -> fillCoffeMachine();
                case "take" -> takeMoney();
                case "remaining" -> remaining();
                case "exit" -> i = false;
            }
        }

    }
}
