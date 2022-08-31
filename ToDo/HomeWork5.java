import java.util.Scanner;

public class HomeWork5 {
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
        int number[] = new int[2];

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter a fact number: ");
            number[i] = keyboard.nextInt();
        }
        int x = number[0];
        int y = number[1];
        if (x < y) {
            x = number[1];
            y = number[0];
        }

        for (int i = y; i <= x; i++) {
            System.out.println(factorial(i));
        }
        keyboard.close();
    }
}
