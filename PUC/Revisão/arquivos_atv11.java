import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class arquivos_atv11 {
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
    public static String leitura(File arq) {
            String linha="";
            try (FileInputStream fis = new FileInputStream(arq)) {
                InputStreamReader leitor = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(leitor);
                linha = bufferedReader.readLine();
                int qntVezes = Integer.parseInt(linha);

                for (int i = 0; i < qntVezes; i++) {
                    linha = bufferedReader.readLine();
                    String[] vetorLinha = linha.split("/");

                    int dia = Integer.parseInt(vetorLinha[0]);
                    int mes = Integer.parseInt(vetorLinha[1]);
                    int ano = Integer.parseInt(vetorLinha[2]);
                    
                    if(verificaData(dia, mes, ano)) {
                        System.out.println("A data "+linha+" é valida.");
                    } else {
                        System.out.println("A data "+linha+" é invalida.");
                    };
                }
                    
                leitor.close();
                bufferedReader.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
            return linha;
    }
    
    public static boolean verificaData(int day, int month, int year) {
        if(day<1) {
            System.out.println("O dia é invalido (menor que 0)");
            return false;
        }
        if(month>12 || month<0) {
            System.out.println("O mes é invalido. (Maior que 12 ou menor que 1))");
            return false;
        }

        return verifyMes(day, month, year);
    }

    public static boolean verifyMes(int day, int month, int year) {
        if(month==4 || month==6 || month==9 || month==12) { //verifica meses com 31
            if(day>31) {
                return false;
            }
        } else if (month==2) { //verifica fevereiro
            if(verificaBissexto(year)) {
                if(day>29)
                return false;
            } else {
                if(day>28)
                return false;
            }
        } else { //verifica meses com 30
            if(day>30) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificaBissexto(int year) {
        if (year % 4 != 0 & year % 400 != 0) {
            return false;
        }
        return true;
    }
}
