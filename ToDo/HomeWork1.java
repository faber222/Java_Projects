import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        int Age = 0;
        Scanner Keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String Name = Keyboard.nextLine();

        System.out.print("Enter the year you were born: ");
        int Year = Keyboard.nextInt();

        System.out.print("Enter the current year: ");
        int CurrentYear = Keyboard.nextInt();

        Keyboard.close();

        Age = YearCalc(Year, CurrentYear);

        System.out.println(Name + " has " + Age);

    }

    public static int YearCalc(int Year, int CurrentYear) {
        return CurrentYear - Year;
    }
}
