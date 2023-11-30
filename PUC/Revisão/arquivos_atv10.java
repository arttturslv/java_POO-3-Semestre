import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class arquivos_atv10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String arqName;

        System.out.println("Digite o nome do arquivo: ");
        arqName = sc.nextLine();

        File arq = new File (arqName+".txt");
        
        if(arq.exists()) {
            System.out.println("O arquivo foi encontrado.\n");
            leitura(arq);
        } else {
            System.out.println("O arquivo não foi encontrado.\n");
        }
        sc.close();
    }

    public static int [] stringParaVetor (String [] vetorLinha) {
        int [] vetor = new int[vetorLinha.length];
        
        for (int i = 0; i < vetorLinha.length; i++) {
            vetor[i] =  Integer.parseInt(vetorLinha[i]);
        }
        return vetor;
    }
     
    public static String leitura(File arq) {
        String linha="";
        int [] vetor;

        try (FileInputStream fis = new FileInputStream(arq)) {
            InputStreamReader leitor = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            while ((linha = bufferedReader.readLine()) != null) {
                // lê a primeira linha;
                String[] vetorLinha = linha.split(";");

                vetor = stringParaVetor(vetorLinha);
                System.out.println("\n\nVetor original: ");
                    imprimeVetor(vetor);
                System.out.println("\nVetor duplas: ");
                    imprimeVetor(vetorDuplas(vetor));
            }
            leitor.close();
            bufferedReader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
        return linha;
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
