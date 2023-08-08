import java.util.*;
public class basico_atv2 {
    public static void main(String[] args) {
        int [] vetor;

        System.out.println("Digite o tamanho do vetor: ");
            vetor = leitura();
        System.out.println("\nVetor original: ");
            imprimeVetor(vetor);
        System.out.println("\nVetor duplas: ");
            imprimeVetor(vetorDuplas(vetor));

    }
    
    public static int[] leitura() {
        Scanner sc = new Scanner(System.in);
        int [] vetor = new int[sc.nextInt()];
        
        for(int i = 0; i<vetor.length; i++) {
            System.out.print("Digite a posição "+(i+1)+": ");
            vetor[i] = sc.nextInt();
        }
        sc.close();
        return vetor;
    }

    public static int [] vetorDuplas(int [] vetor) {
        int vetDuplasTam = calcTamanho(vetor);
        int vetorTam = vetor.length;
        
        int vetorDuplas [] = new int [vetDuplasTam];

        if(vetor.length%2!=0) { //já pega o ultimo valor e soma na ultima pos do vetor de duplas
            vetorTam-=1;
            vetorDuplas[vetDuplasTam-1] = 2*vetor[vetorTam];
        }

        int j=0;
        for (int i = 0; i < vetDuplasTam & j<vetorTam; i++) {
            vetorDuplas[i] = vetor[j]+vetor[j+1];
            j+=2;
        }
        return vetorDuplas;
    }

    public static int calcTamanho (int [] vetor) {
        int novoTamanho = vetor.length/2;
            if(vetor.length%2!=0) {
                novoTamanho+=1;
            } 
        return novoTamanho;
    }

    public static void imprimeVetor(int [] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" "+vetor[i]);
        }
    }
}
