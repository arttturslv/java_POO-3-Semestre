import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class arquivos_atv12 {
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

    public static void leitura(File arq) {
        String linha="";
        try (FileInputStream fis = new FileInputStream(arq)) {
            InputStreamReader leitor = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            linha = bufferedReader.readLine();

            while(!linha.equals("fim")) {
                linha = bufferedReader.readLine();
                System.out.print("normal: ");
                System.out.print(linha+"\n");

                inverteFrase(linha);
            }
            bufferedReader.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
    }

    public static void inverteFrase(String frase) {
        System.out.print("invertida: ");
        for (int i = frase.length()-1; i >= 0 ; i--) {
            System.out.print(frase.charAt(i));
        }
        System.out.println();
    }
}
