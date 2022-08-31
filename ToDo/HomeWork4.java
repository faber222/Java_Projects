import java.util.Scanner;

public class HomeWork4 {

    static float factorial(float n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return n;
        else
            return (n * factorial(n - 1));
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        float number[] = new float[4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter a fact number: ");
            number[i] = keyboard.nextFloat();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(factorial(number[i]));
        }
        keyboard.close();
    }
}
