import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class App {
    static Scanner sc;

    //#region utilidades

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
        System.out.println("Enter...");
        sc.nextLine();
    }

    /**
     * Função que pede uma data no formato dd/mm/yyyy até que seja uma data válida e retorna uma String com a data lida.
     * @return dataFormatada -> data lida no formato "dd/mm/yyyy"
     */
    public static String calendario () {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false); 
        boolean dataValida = false;
        
        Date data=null;
        String dataFormatada="";

        while(!dataValida) {
            try {
                String stringData = leitura("Data no formato dd/MM/yyyy: ");
                data = formatter.parse(stringData);
                dataValida = true;
                dataFormatada = formatter.format(data);
            } catch (ParseException ex) {
                System.out.print("Data inválida.");
            }
        }
        return dataFormatada;
    }

    /**
     * Função sem retorno que exibe o menu de opções disponíveis para o usuário no console.
     */
    public static void menu() {
        limparTela();
        System.out.println(
        "\n\t MENU "+
        "\n1 - Adicionar socio: "+
        "\n2 - Adicionar dependente  "+
        "\n3 - Convidar dependentes "+
        "\n4 - Registrar entrada  "+
        "\n5 - Registrar saida  "+
        "\n6 - Lista de visitantes (data especifica)  "+
        "\n7 - Lista de visitas (de qlqr frequentador)  "+
        "\n8 - Lista de visitas dos convidados (de um socio)  "
        );
    }

    /**  Função principal que controla o menu e a interação do usuário com o programa.    */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcao = 1;

        Clube clube = new Clube();

        while(opcao != 0) {
            menu();
            opcao = Integer.parseInt(leitura("Qual sua escolha"));
            limparTela();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar socio... ");

                    cadastrarSocio(clube);
                    pausa();
                    limparTela();
                    break;
                case 2:
                    System.out.println("Adicionar convidado... ");

                    cadastrarConvidado(clube);
                    pausa();
                    limparTela();
                    break;
                case 3:
                    System.out.println("Convidar dependentes...");
                    
                    convidarDependentes(clube);
                    pausa();
                    limparTela();
                    break;
                case 4:
                    System.out.println("Registrar entrada...");

                    registrarEntrada(clube);
                    pausa();
                    limparTela();
                    break;
                case 5:
                    System.out.println("Registrar saida...");

                    registrarSaida(clube);
                    pausa();
                    limparTela();
                    break;         
                case 6:
                    System.out.println("Lista de visitantes de dada especifica...");

                    System.out.println("Digite a data especifica.");
                    String data = calendario();
                     
                    limparTela();
                    System.out.println(clube.relatorioVisitasData(data));
                    pausa();
                    limparTela();
                break;
                case 7:
                    System.out.println("Lista de visitas de um frequentador...");

                    String idFrequentador = leitura("Digite o id do frequentador");
                                         
                    limparTela();
                    System.out.println(clube.relatorioVisitasQuantidade(idFrequentador));
                    pausa();
                    limparTela();
                break;
                case 8:
                    System.out.println("Lista de visitas de um convidado...");

                    String idSocio = leitura("Digite o id do socio");
                    System.out.println(clube.relatorioVisitasConvidados(idSocio));    
                    pausa();
                    limparTela();
                break;

            }
        }
    }

    /**
     * Função que lê um nome e cadastra como um sócio no clube.
     * @param clube -> instância da classe Clube onde o sócio será cadastrado
     * @return socio -> o sócio cadastrado
     */
    public static Socio cadastrarSocio (Clube clube) {
        String nome = leitura("Digite o nome");
        Socio socio = new Socio(nome);
        clube.addFrequentador(socio);

        return socio;
    }

    /**
     * Função que lê um nome e cadastra como convidado no clube.
     * @param clube -> instância da classe Clube onde o convidado será cadastrado
     * @return convidado -> o convidado cadastrado
     */
    public static Convidado cadastrarConvidado(Clube clube) {
        String nome = leitura("Digite o nome");
        Convidado convidado = new Convidado(nome);
        clube.addFrequentador(convidado);

        return convidado;
    }

    /**
     * Função boolean que permite um sócio convidar dependentes. Ela requisita uma data, 
     * o id do socio e o id do convidado, chamando a função de cadastrar convidado caso ele não tenha um id.
     * @param clube -> instância da classe Clube onde a operação ocorrerá
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public static Boolean convidarDependentes(Clube clube) {
        Convidado convidado;

        System.out.println("Digite a data para o convite.");
        String dataFormatada = calendario();

        String idSocio = leitura("Digite o id do Socio");
        Socio socio = clube.buscarSocio(idSocio);

        if(socio == null) {
            System.out.println("Socio não existe!");
            return false;
        }

        String resposta = leitura("O convidado tem cadastro? (s/n)").toLowerCase();

        if(resposta.charAt(0) != 's') { //não tem cadastro -> cadastro e convido
            convidado = cadastrarConvidado(clube);
            socio.convidar(convidado, dataFormatada);
            return true;
        } 

        String idDependente = leitura("Digite o id do dependente"); //tem cadastro 
        convidado = clube.buscarConvidado(idDependente);

        if(convidado != null) { //se for valido, já retorno
            socio.convidar(convidado, dataFormatada);
            return true;
        }
        
        System.out.println("Convidado não existe!");
        return false;
    }

    /**
     * Função que registra a entrada de um frequentador (sócio ou convidado) no clube. Ela requisita um id
     * e verifica se é sócio ou convidado, caso for socio, apenas registra. Caso seja convidado, chama a função
     * verificarEntradaConvidado() para verificar o convite e registra a entrada caso ele seja valido.
     * @param clube -> instância da classe Clube onde a operação ocorrerá
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public static Boolean registrarEntrada(Clube clube) {
        String idFrequentador = leitura("Digite o id para entrar no clube");
        
        if(clube.buscarSocio(idFrequentador)!= null) { //é socio
            System.out.println("Registrando a visita de um socio.");
            clube.registrarEntrada(idFrequentador);
            return true;
        } 

        if (clube.buscarConvidado(idFrequentador)!= null) { //é convidado
            System.out.println("Registrando a visita de um convidado.");
            Convidado convidado = clube.buscarConvidado(idFrequentador);
            Boolean convite = verificarEntradaConvidado(convidado, clube);
            
            if(convite) {
                clube.registrarEntrada(idFrequentador);
                return true;
            }
        }
        System.out.println("-> O id digitado não está cadastrado.");
        return false;
    }

    /**
     * Função que verifica a entrada de um convidado no clube, com base em um convite válido. Ela requisita o id
     * do socio que fez o convite ao dependente e a data atual. Ele procura os convites no convidado para ver se 
     * existe algum com aquele socio e aquela data e por fim, verifica se o socio já está no clube, retornando true caso esteja.
     * @param convidado -> o convidado a ser verificado
     * @param clube -> instância da classe Clube onde a operação ocorrerá
     * @return true se o convidado puder entrar, false caso contrário
     */
    public static Boolean verificarEntradaConvidado(Convidado convidado, Clube clube) {
            String idSocio = leitura("Digite o id do socio que convidou:");
            System.out.println("Digite a data atual.");
            String dataEntrada = calendario();

            if(convidado.procurarConvite(dataEntrada, idSocio)) {                
                if(clube.verificarPresenca(idSocio) >= 0) {
                    return true;
                }
                System.out.println("Espere até que o socio entre no clube para entrar também.");
            } else {
                System.out.println("O convidado não possui um convite valido."); 
            }
        return false;
    }

    /**
     * Função que registra a saída de um frequentador (sócio ou convidado) do clube. Ela requisita o id do
     * frequentador e verifica se é convidado ou socio, chamando a função do clube registrarSaida() com base 
     * no tipo de objeto.
     * @param clube -> instância da classe Clube onde a operação ocorrerá
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public static Boolean registrarSaida(Clube clube) {
        String idFrequentador = leitura("Digite o id para sair do clube");
        int posicaoNaPresenca = clube.verificarPresenca(idFrequentador);

        if(posicaoNaPresenca>=0) { //existe na lista de presenca
            if(clube.buscarSocio(idFrequentador)!= null) { //se for socio
                Socio socio = clube.buscarSocio(idFrequentador);
                clube.registrarSaida(posicaoNaPresenca, socio);
                return true;
            } else if (clube.buscarConvidado(idFrequentador)!= null) { //se for convidado
                Convidado convidado = clube.buscarConvidado(idFrequentador);
                clube.registrarSaida(posicaoNaPresenca, convidado);
                return true;
            }
        } 
        System.out.println("O id digitado não é de uma pessoa presente ou não está cadastrado.");
        return false;
    }

  
}
