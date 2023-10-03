
/**
 * @author Artur Marcos
 * @version 1.1
 */

import java.util.Scanner;

public class ExerciciosRevisão {
    static Scanner sc;

    /**
     * Função que recebe uma mensagem, encapsula com ":" e lê a resposta do usuario,
     * retornando-a.
     * 
     * @param mensagem
     * @return textoDigitado
     */
    public static String leitura(String mensagem) {
        System.out.print("\n" + mensagem + ": ");
        return sc.nextLine();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausa() {
        System.out.println("Enter...");
        sc.nextLine();
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcao = 1;

        while (opcao != 0) {
            limparTela();
            menu();
            opcao = Integer.parseInt(leitura("Digite a opção desejada"));

            switch (opcao) {
                case 1:
                    atv1();
                    pausa();
                    break;
                case 2:
                    atv2();
                    pausa();
                    break;
                case 3:
                    atv3();
                    pausa();
                    break;
                case 4:
                    atv4();
                    pausa();

                    break;
                // case 5 :
                // atv5();
                // break;
                // case 6 :
                // atv6();
                // break;
                // case 7 :
                // atv7();
                // break;
                // case 8 :
                // atv8();
                // break;
                // case 9 :
                // atv9();
                // break;
                default:
                    System.out.println("Error.");
            }
        }

    }

    /**
     * Escreva dois métodos em Java: o primeiro deve ser utilizado para preencher um
     * vetor de 6 números inteiros a
     * partir da entrada do usuário. O segundo deve inverter as posições dos números
     * do vetor. Por exemplo, se o vetor
     * original era 4-8-15-16-23-42, deve ficar 43-23-16-15-8-4 após a execução do
     * segundo método. Escreva um
     * programa que execute e teste os dois métodos.
     */
    private static void atv1() {
        System.out.print("\t Atividade 1");
        int[] vetor = new int[6];

        preencherVetor(vetor);
        System.out.print("\nVetor original: ");
        imprimeVetor(vetor);
        System.out.print("Vetor invertido: ");
        imprimeVetor(inverterVetor(vetor));
    }

    /**
     * Escreva um método que receba como parâmetro um vetor de inteiros e crie outro
     * vetor, contendo a soma de
     * cada par de vizinhos do vetor original. Por exemplo, se o vetor original era
     * 4-8-15-16-23-42, o retorno deve ser um
     * vetor 12-31-65 (ou seja, 4+8, 15+16 e 23+42). Caso o vetor tenha tamanho
     * ímpar, o último número deve ser somado
     * consigo mesmo. Para ler o vetor, pode aproveitar o método do exercício 02.
     * Escreva um programa que execute e teste
     * os métodos.
     */
    private static void atv2() {
        System.out.print("\t Atividade 2");
        int tamanhoVetor = Integer.parseInt(leitura("Digite o tamanho do vetor"));
        int[] vetor = new int[tamanhoVetor];

        preencherVetor(vetor);
        System.out.print("\nVetor original: ");
        imprimeVetor(vetor);
        System.out.print("Vetor vizinhos: ");
        imprimeVetor(somaVizinhos(vetor));
    }

    private static void atv3() {
        System.out.print("\t Atividade 3");
        int altura = Integer.parseInt(leitura("Digite a altura do retangulo"));
        int largura = Integer.parseInt(leitura("Digite a largura do retangulo"));

        desenhaRetangulo(altura, largura);
    }

    private static void atv4() {
        System.out.print("\t Atividade 4");
        String frase = "";

        while (!frase.equals("fim")) {
            System.out.println("\nDigite a frase: ");
            frase = sc.nextLine();
            reverteFrase(frase);
        }
    }

    public static void reverteFrase(String frase) {
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.print(frase.charAt(i));
        }
        System.out.println();
    }

    /**
     * Recebe altura e largura, imprimindo um retangulo.
     * 
     * @param alt
     * @param larg
     */
    public static void desenhaRetangulo(int alt, int larg) {
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < larg; j++) {
                if ((i == 0 || i == alt - 1) || (j == 0 || j == larg - 1)) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Recebe o vetor, cria vetorSoma com o tamanho/2 + 1 caso for o vetor for impar
     * e 0 se for par.
     * Depois itera, armazenando a soma dos vizinhos no vetor menor. Por fim,
     * verifica novamente se o vetor é impar, somando o ultimo numero impar no vetor
     * menor.
     * 
     * @param vetor
     * @return vetorSoma - é o vetor que contem a soma dos vizinhos
     */
    public static int[] somaVizinhos(int[] vetor) {
        int[] vetorSoma = new int[vetor.length / 2 + vetor.length % 2];

        for (int i = 0; i < vetor.length - 1; i += 2) {
            vetorSoma[i / 2] = vetor[i] + vetor[i + 1];
        }

        if (vetor.length % 2 != 0) {
            vetorSoma[vetorSoma.length - 1] += 2 * vetor[vetor.length - 1];
        }
        return vetorSoma;
    }

    public static void menu() {
        System.out.println("1 - Vetor invertido: ");
        System.out.println("2 - Soma vizinhos: ");
        System.out.println("3 - Imprime retangulos: ");
        System.out.println("4 - Inverte frase: ");
        System.out.println("5 - Cronograma de estudo: ");
        System.out.println("6 - Bilhete premiado: ");
        System.out.println("7 - Multiplicação por 11: ");
        System.out.println("8 - Verifica data: ");
        System.out.println("9 - Dia semanal 2024: ");
        System.out.println("0 - Sair do programa");
    }

    /**
     * Função que chama a função de leitura, converte em numeros e prenche no vetor;
     * 
     * @param tamVetor
     */
    public static void preencherVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(leitura("Digite a posição " + (i + 1) + " do vetor"));
        }
    }

    /**
     * Função int [] que recebe um vetor, inverte e retorna um vetor
     * 
     * @param vetor
     * @return vetorInvertido
     */
    public static int[] inverterVetor(int[] vetor) {
        int[] vetorInvertido = new int[vetor.length];

        int j = 0;
        for (int i = vetor.length - 1; i >= 0; i--) {
            vetorInvertido[j] = vetor[i];
            j++;
        }
        return vetorInvertido;
    }

    /**
     * Função void que recebe o vetor e imprime seu conteudo;
     * 
     * @param vetor
     */
    public static void imprimeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

}