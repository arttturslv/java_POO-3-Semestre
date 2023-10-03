import java.util.*;

public class basico_atv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alt, larg;

        System.out.println("Digite a altura do retangulo: ");
        alt = sc.nextInt();
        System.out.println("Digite a largura do retangulo: ");
        larg = sc.nextInt();

        desenhaRetangulo(alt, larg);
        sc.close();
    }

    public static void desenhaRetangulo(int altura, int largura) {
        for (int i = 0; i < altura; i++) { // percorre toda altura
            for (int j = 0; j < largura; j++) { // percorre toda largura

                if (j == 0 || j == largura-1 || i == 0 || i == altura-1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
