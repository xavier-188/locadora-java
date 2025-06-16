package console;

import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static int lerInt() {
        while (true) {
            try {
                String entrada = leitor.nextLine();
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número inteiro: ");
            }
        }
    }

    public static float lerFloat() {
        while (true) {
            try {
                String entrada = leitor.nextLine();
                return Float.parseFloat(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número real: ");
            }
        }
    }

    public static String lerString() {
        return leitor.nextLine();
    }
}