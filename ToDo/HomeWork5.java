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
        Scanner Keyboard = new Scanner(System.in);
        int Number[] = new int[2];

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter a fact number: ");
            Number[i] = Keyboard.nextInt();
        }
        int x = Number[0];
        int y = Number[1];
        if (x < y) {
            x = Number[1];
            y = Number[0];
        }

        for (int i = y; i <= x; i++) {
            System.out.println(factorial(i));
        }
        Keyboard.close();
    }
}
