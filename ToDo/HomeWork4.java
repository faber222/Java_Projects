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
        Scanner Keyboard = new Scanner(System.in);
        float Number[] = new float[4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter a fact number: ");
            Number[i] = Keyboard.nextFloat();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(factorial(Number[i]));
        }
        Keyboard.close();
    }
}
