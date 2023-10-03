import java.util.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String pontosTimeUm="";
        String pontosTimeDois="";
        String nomeTimeUm, nomeTimeDois;

        System.out.print("Inicio da partida\n");
            nomeTimeUm = leitura("Nome do 1º time");
            nomeTimeDois = leitura("Nome do 2º time");
        limparTela();

        for (int i = 0; i < 4; i++) { //roda nos 4 periodos.
            System.out.print((i+1)+"º partida!\n");
                pontosTimeUm += leitura("Digite os pontos do 1º time") + ";";
                pontosTimeDois += leitura("Digite os pontos do 2º time") + ";";
        }

        Partida partida = new Partida(nomeTimeUm, nomeTimeDois, pontosTimeUm, pontosTimeDois);

        while(!partida.verificaGanhador()) { //verifica e roda pedindo mais informação das prorrogações
            limparTela();
            System.out.print("\nAinda não há ganhadores.\nVamos para a prorrogação!\n\n");

            pontosTimeUm = leitura("Digite os pontos do 1º time");
            pontosTimeDois = leitura("Digite os pontos do 2º time");

            partida.atualizaPlacar(pontosTimeUm, pontosTimeDois);
        }

        System.out.println(partida.retornaPlacar());
        sc.close();
    }

    /**
     * Função para limpar a tela
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Função que recebe uma mensagem, encapsula com ": " e lê a resposta do usuario,
     * retornando-a.
     * @param mensagem
     * @return textoDigitado
     */
    public static String leitura(String mensagem) {
        System.out.print(mensagem + ": ");
        return sc.nextLine();
    }
}
