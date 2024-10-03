
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat cat1 = createCat();
        Cat cat2 = createCat();

        // TODO: some LAB04 code goes here
        Owner guy1 = createOwner();
        Owner guy2 = createOwner2();

        adopt(guy1);
        adopt(guy2);

        assignName(cat1,guy1);
        assignName(cat2,guy2);


        play(cat1, guy1);
        play(cat2, guy2);

        feed(cat1, guy1);
        feed(cat2, guy2);

        myScanner.close();
    }

    // Suggestion for LAB04: create a method to create a new owner.

    public static Cat createCat() {
        System.out.println("What is your cat's name?");
        String name = myScanner.nextLine();

        System.out.println("Your cat says what?");
        String catSound = myScanner.nextLine();

        System.out.println("Tell a funny story about your cat!");
        String funnyStory = myScanner.nextLine();

        System.out.println("Is your cat always hungry? (1 for yes, 2 for no)");

        int hungryNumber = 0;
        hungryNumber = myScanner.nextInt();
        // The following line is necessary to ignore the "enter" token the user inputs
        // after typing in an integer
        myScanner.nextLine();
        String ownerName = "name";
        boolean isHungry = (hungryNumber == 1);
        System.out.println("Meet " + name + ", it says " + catSound + "!\n");
        return new Cat(name, catSound, funnyStory, isHungry);
    }

    public static Owner createOwner() {
        System.out.println("What is your name");
        String name = myScanner.nextLine();
        boolean hasCat = false;
        while (!hasCat) {
            try {
                System.out.println("Do you own a cat: true for yes false for no?");
                hasCat = myScanner.nextBoolean();
                break;
            } catch (InputMismatchException c) {
                System.out.println("Use a number to pick");
                myScanner.nextLine();
            }
        }
        return new Owner(name, hasCat);

    }

    public static Owner createOwner2() {
        System.out.println("What is your name");
        String name = myScanner.nextLine();
        myScanner.nextLine();
        boolean hasCat = false;
        while (!hasCat) {
            try {
                System.out.println("Do you own a cat: true for yes false for no?");
                hasCat = myScanner.nextBoolean();
                break;
            } catch (InputMismatchException c) {
                System.out.println("Use a number to pick");
                myScanner.nextLine();
            }
        }
        return new Owner(name, hasCat);

    }

    public static void adopt(Owner guy) {
        if (!guy.hasACat()) {
            System.out.println(guy.getName() + " adopted a Cat!");
            guy.adopted(guy.hasACat());
        }
    }

    public static void play(Cat cat, Owner guy) {
        if (!cat.getIsHungry() && guy.hasACat()) {
            System.out.println(cat.getName() + " played with " + guy.getName());
            System.out.println(cat.getName() + " is not hungry");
        }
    }

    public static void feed(Cat cat, Owner guy) {
        if (cat.getIsHungry() && guy.hasACat() && cat.getOwnerName() != "null") {
            System.out.println(cat.getOwnerName() + " feed " + cat.getName());
        }
    }

    public static void assignName(Cat cat, Owner guy) {
        if (guy.hasACat()) {
            cat.setOwnerName(guy.getName());
        }
    }
}
