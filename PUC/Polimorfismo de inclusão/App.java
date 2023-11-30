import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class App {
    static Scanner sc;

    /**  Função principal que controla o menu e a interação do usuário com o programa.    */
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        int opcao = 1;

        Clube clube = new Clube();

        while(opcao != 8) {
            menu();
            opcao = Integer.parseInt(leitura("Qual sua escolha"));
            limparTela();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar frequentador... ");

                    String tipoFrequentador = leitura("\n(1) Socio \n(2) Convidado\nCadastrar: ").toLowerCase();
                    cadastrar(clube, tipoFrequentador);

                    pausa();
                    limparTela();
                    break;
                case 2:
                    System.out.println("Convidar dependentes...");

                    System.out.print("\nDigite a data para o convite.");
                    Date dataFormatada = calendario("dd/MM/yyyy", "Data");

                    System.out.print("\nDigite a hora para o convite.");
                    Date horaFormatada = calendario("HH:mm:ss", "Hora");

                    String idSocio = leitura("Digite o id do Socio");
                    Frequentador frequentador = clube.buscarFrequentador(idSocio);
                    
                    convidarDependentes(clube, dataFormatada, horaFormatada, frequentador);
                    pausa();
                    limparTela();
                    break;
                case 3:
                    System.out.println("Registrar entrada...");

                    registrarEntrada(clube);
                    pausa();
                    limparTela();
                    break;
                case 4:
                    System.out.println("Registrar saida...");

                    registrarSaida(clube);
                    pausa();
                    limparTela();
                    break;         
                case 5:
                    System.out.println("Lista de visitantes de dada especifica...");

                    System.out.println("Digite a data especifica.");
                    Date data = calendario("dd/MM/yyyy", "Data");
                     
                    limparTela();
                    System.out.println(clube.relatorioVisitasData(data));
                    pausa();
                    limparTela();
                break;
                case 6:
                    System.out.println("Lista de visitas de um frequentador...");

                    String idFrequentador = leitura("Digite o id do frequentador");
                                         
                    limparTela();
                    System.out.println(clube.relatorioVisitasQuantidade(idFrequentador));
                    pausa();
                    limparTela();
                break;
                case 7:
                    System.out.println("Lista de visitas de um convidado...");

                    String IdSocio = leitura("Digite o id do socio");
                    System.out.println(clube.relatorioVisitasConvidados(IdSocio));    
                    pausa();
                    limparTela();
                break;
                case 8:
                    limparTela();
                    System.out.println("Programa finalizado.");
                break;

            }
        }
    }

    /**
     * Função que recebe o clube onde o frequentador vai ser cadastrado e o tipo de frequentador a ser cadastrado. Ele verifica o tipo e cadastra chamando a função clube.addFrequentador(), depois retorna o objeto do tipo de frequentador;
     * @param clube -> Clube que os frequentadores serão cadastrados.
     * @param tipoFrequentador -> Socio ou convidado.
     * @return objeto convidado ou socio.
     */
    public static Frequentador cadastrar (Clube clube, String tipoFrequentador) {
        String nome = leitura("Digite o nome");

        if(tipoFrequentador.charAt(0) == '1') {
            Socio socio = new Socio(nome);
            clube.addFrequentador(socio);
            return socio;
        } else {
            Convidado convidado = new Convidado(nome);
            clube.addFrequentador(convidado);
            return convidado;
        }
    }

     /**
      * Função booleana que recebe o clube, a data formatada (dd/MM/yyyy), a hora formatada (HH:mm:ss) e o objeto frequentador que representa um socio. Pergunta se o convidado tem cadastro,
      * cadastrando o caso não tenha e depois convida utilizando a função socio.convidar();
      * @param clube -> instância da classe Clube onde a operação ocorrerá
      * @param dataFormatada -> data formatada (dd/MM/yyyy)
      * @param horaFormatada -> hora formatada (HH:mm:ss) 
      * @param socio -> Objeto frequentador que representa um socio
     * @return true se a operação for bem-sucedida, false caso contrário
      */
    public static Boolean convidarDependentes(Clube clube, Date dataFormatada, Date horaFormatada, Frequentador socio) {
        Convidado convidado;

        String resposta = leitura("O convidado tem cadastro? (s/n)").toLowerCase();

        if(resposta.charAt(0) != 's') { 
            convidado = (Convidado) cadastrar(clube, "2");
        } else {
            String idConvidado = leitura("Digite o id do convidado"); //tem cadastro 
            convidado = (Convidado) clube.buscarFrequentador(idConvidado);
        }

        if(socio == null || convidado == null) {
            System.out.println("Erro ao convidar.");
            return false;
        }

        ((Socio) socio).convidar(convidado, dataFormatada, horaFormatada);
        return true;
    }

    /**
     * Função booleana que registra a entrada de um frequentador (sócio ou convidado) no clube. Ela requisita um id
     * e chama a função registrarEntrada() passando o id lido e verifica o retorno para ver se foi cadastrado ou não.
     * @param clube -> instância da classe Clube onde a operação ocorrerá
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public static Boolean registrarEntrada(Clube clube) throws Exception {
        String idFrequentador = leitura("Digite o id para entrar no clube");
        if(!clube.registrarEntrada(idFrequentador)){
            System.out.println("Erro ao registrar.");
            return false;
        }
        return true;
    }

    /**
     * Função booleana que registra a saída de um frequentador (sócio ou convidado) do clube. Ela requisita um id
     * e chama a função registrarSaida() passando o id lido e verifica o retorno para ver se foi cadastrado ou não.
     * @param clube -> instância da classe Clube onde a operação ocorrerá
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public static void registrarSaida(Clube clube) throws Exception {
        String idFrequentador = leitura("Digite o id para sair do clube");
         
        if(!clube.registrarSaida(idFrequentador)){
            System.out.println("Erro ao registrar saida.");
        }
    }

    /**
     * Função que recebe o pattern a ser comparado e o tipo (data ou hora). Ele formata uma data com o pattern passado e 
     * lê do teclado uma String que tenha o mesmo pattern e que seja valida, com base no tipo. Caso o dado seja incorreto,
     * ele repete a leitura.
     * @param pattern -> é data (dd/MM/yyyy) ou horario (hh:mm:ss) 
     * @param tipo -> "data" ou "hora". É usada apenas na impressão.
     * @return String formatada.
     */
    public static Date calendario (String pattern, String tipo) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setLenient(false); 
        boolean calendarioValido = false;
        
        Date calendario=null;
        String calendarioFormatado="";

        while(!calendarioValido) {
            try {
                String stringData = leitura(tipo+" no formato "+pattern+" ");
                calendario = formatter.parse(stringData);
                calendarioValido = true;
                calendarioFormatado = formatter.format(calendario);
            } catch (ParseException ex) {
                System.out.print(tipo+" inválida.");
            }
        }
        return formatter.parse(calendarioFormatado);
    }

    /**
     * Função sem retorno que exibe o menu de opções disponíveis para o usuário no console.
     */
    public static void menu() {
        limparTela();
        System.out.println(
        "\n\t MENU "+
        "\n1 - Adicionar frequentador: "+
        "\n2 - Convidar dependentes "+
        "\n3 - Registrar entrada  "+
        "\n4 - Registrar saida  "+
        "\n5 - Lista de visitantes (data especifica)  "+
        "\n6 - Lista de visitas (de qlqr frequentador)  "+
        "\n7 - Lista de visitas dos convidados (de um socio)  "+
        "\n8 - SAIR "

        );
    }

    /**
     * Recebe uma string que é exibida na tela, lê do teclado e retorna o conteudo lido em formato String.
     * @param mensagem -> a ser exibida
     * @return resposta -> que foi lida
     */
    public static String leitura(String mensagem) {
        System.out.print("\n" + mensagem + ": ");
        return sc.nextLine();
    }

    /** Função sem retorno que limpa a tela do console     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /** Função sem retorno que "pausa" o console até Enter seja pressionada. */
    public static void pausa() {
        System.out.print("\nPressione enter para continuar...");
        sc.nextLine();
    }
}
