import java.util.Scanner;

public class ScanKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = keyboard.nextLine(); // lendo cadeia de caracteres
        System.out.println("Name: " + name);
        System.out.print("Enter a integer number: ");
        int i = keyboard.nextInt(); // lendo inteiro
        System.out.print("Enter a rational number: ");
        double r = keyboard.nextDouble(); // lendo reais
        System.out.println("Integer: " + i + ", rational: " + r);
        keyboard.close();
    }
}
