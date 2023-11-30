import java.util.*;

public class basico_atv4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        System.out.println("Digite frases e elas serão invertidas. Digite \"fim\" para sair. \n ");

        while (!frase.equals("fim")) {
            System.out.print("normal: ");
            frase = sc.nextLine();
            inverteFrase(frase);
        }
        sc.close();
    }

    public static void inverteFrase(String frase) {
        System.out.print("invertida: ");
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.print(frase.charAt(i));
        }
        System.out.println();
    }
}
