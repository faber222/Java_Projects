import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        int age = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter the year you were born: ");
        int year = keyboard.nextInt();

        System.out.print("Enter the current year: ");
        int currentYear = keyboard.nextInt();

        keyboard.close();

        age = YearCalc(year, currentYear);

        System.out.println(name + " has " + age);

    }

    public static int YearCalc(int year, int currentYear) {
        return currentYear - year;
    }
}
