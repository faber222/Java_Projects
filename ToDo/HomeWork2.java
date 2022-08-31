import java.util.Scanner;

public class HomeWork2 {
    static int factorial(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return n;
        else
            return (n * factorial(n - 1));
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a fact number: ");
        int number = keyboard.nextInt();

        int fact = 1;
        fact = factorial(number);
        System.out.println("The factorial of " + number + " is " + fact);
        keyboard.close();
    }
}
