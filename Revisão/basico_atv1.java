import java.util.*;

public class basico_atv1 {
    public static void main(String[] args) {
        int vetor[] = new int[6];

        leitura(vetor);

        System.out.println("\nVetor original: ");
        imprimeVetor(vetor);
        System.out.println("\nVetor reverso: ");
        vetor = inverte(vetor);
        imprimeVetor(vetor);
    }

    public static int[] leitura(int[] vetor) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite a posição " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
        sc.close();
        return vetor;
    }

    public static int[] inverte(int[] vetor) {
        int vetorInvertido[] = new int[vetor.length];
        int j = 0;
        for (int i = vetor.length - 1; i >= 0; i--) {
            vetorInvertido[j] = vetor[i];
            j++;
        }
        return vetorInvertido;
    }

    public static void imprimeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + vetor[i]);
        }
    }
}