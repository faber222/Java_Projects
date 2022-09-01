import java.util.Scanner;

public class HomeWork3 {

    static float factorial(float n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return n;
        else
            return (n * factorial(n - 1));
    }

    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        System.out.print("Enter a factorial number: ");
        float Number = Keyboard.nextFloat();

        System.out.print("Enter a second factorial number: ");
        float Number2 = Keyboard.nextFloat();

        float Factorial = factorial(Number);
        float Factorial2 = factorial(Number2);
        float Result = Factorial + Factorial2;
        System.out.println("The factorial between the numbers " + Number + " and " + Number2
                + " is " + Result);
        Keyboard.close();
    }
}
