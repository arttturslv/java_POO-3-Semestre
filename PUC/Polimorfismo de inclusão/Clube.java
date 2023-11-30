import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Clube {
    private List<Frequentador> frequentadores;
	private Date data = new Date();

    public Clube() {
        frequentadores = new ArrayList<>();
    }

    /**
     * Adiciona um novo frequentador à lista de frequentadores do clube.
     * @param novoFrequentador - O objeto do tipo Frequentador a ser adicionado à lista.
     */
    public void addFrequentador(Frequentador novoFrequentador) {
        System.out.println("-> "+novoFrequentador.getNome()+" foi cadastrado.");
        frequentadores.add(novoFrequentador);
    }

    /**
     * Função que recebe um ID de frequentador e retorna o objeto frequentador correspondente.
     * @param idFreq - O ID do frequentador a ser procurado na lista de frequentadores.
     * @return O frequentador encontrado ou null.
     */
    public Frequentador buscarFrequentador(String idFreq) {
        for(Frequentador frequentador: frequentadores) {
            if(frequentador.getId().equals(idFreq)) {
                return frequentador;
            }
        }
        return null;
    }

    /**
     * Função booleana que verifica a presença do frequentador que possui o id passado via parametro.
     * @param idFreq -> Frequentador a ser procurado.
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public boolean verificaPresenca (String idFreq) {
        for(Frequentador frequentador: frequentadores) {
            if(frequentador.getId().equals(idFreq) & frequentador.getPresenca()) {
                return true; 
            }
        }
        return false;
    }

     /**
     * Função booleana que recebe um ID de frequentador, verifica se o frequentador está presente, caso contrario
     * registra a entrada com base na data e hora atuais
     * @param idFreq -> O ID do frequentador a ser procurado na lista de presença.
     * @return A posição do frequentador na lista de presença ou -1 se não encontrado.
     */
    public boolean registrarEntrada(String idFreq) throws Exception {
        Date dataEntrada = data;

        if(verificaPresenca(idFreq)) {
            System.out.println("-> Frequentador já está dentro do clube.");
            return false;
        }

        Frequentador frequentador = buscarFrequentador(idFreq);

        if(frequentador.registrarEntrada(dataEntrada, this)) {
            return true;
        }

        return false;
    }

    /**
     * Registra a saída de um frequentador do clube com base em seu ID. Ele cria uma nova hora para ser passada na saida, verifica se o frequentador está presente
     * busca o frequentador utilizando o clube.buscarFrequentador(ID) e por fim, chama a função frequentador.sairClube() passando a hora de saida.
     * @param idFreq O ID do frequentador que vai sair.
     * @throws Exception Se ocorrer um erro de parse no obj Date.
     */
    public boolean registrarSaida(String idFreq) throws Exception {
        SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");

        Date dt = new Date();

        Date hSaida = formatterHora.parse(new SimpleDateFormat("HH:mm:ss").format(dt)); //pega apenas a hora

        if(verificaPresenca(idFreq) == false) {
            return false;
        }

        Frequentador frequentador = buscarFrequentador(idFreq);

        frequentador.sairClube(hSaida);
        System.out.println("-> Saida registrada.");
        return true;
    }

    /**
     * Função que retorna uma string com os relatorios de visitas de todos os frequentadores com base na data passada via parametro.
     * @return String com o relatorio ou uma mensagem de aviso dizendo que não há visitas.
     * @param data -> Data a ser pesquisada
     */
    public String relatorioVisitasData(Date data) {
        int qntVisitas=0;
        String relatorio = "\tVisitas (" + data + ")\n";
        for(Frequentador frequentador: frequentadores) {
            if(frequentador.visitouClube(data)) {
                qntVisitas++;
                relatorio += " - "+frequentador.getNome() + "\n";
            }
        }
        if(qntVisitas==0) 
            relatorio += "-> Não há visitas neste dia";

        return relatorio;
    }

    /**
     * Função que retorna uma string com os relatorios de visitas de um frequentador com base no ID.
     * @return String com o relatorio ou uma mensagem de aviso.
     * @param idFreq -> ID a ser pesquisado
     */
    public String relatorioVisitasQuantidade(String idFreq) {
        for(Frequentador frequentador: frequentadores) {
            if (frequentador.getId().equals(idFreq))
                return frequentador.relatorioVisitas();
        }
        return "->O id digitado não está cadastrado.";
    }

    /**
     * Função que retorna uma string com os relatorios de visitas de todos os convidados do socio passado via parametro.
     * @return String com o relatorio ou uma mensagem de aviso.
     * @param idSocio -> id do socio para pesquisar os convidados
     */
    public String relatorioVisitasConvidados(String idSocio) {
        for(Frequentador frequentador: frequentadores) {
            Socio socio = null;
            if (frequentador.getId().equals(idSocio)) {
                socio = (Socio) frequentador;
                return socio.relatorioConvidados();
            }
        }
        return "-> Não existe socio com o id:"+idSocio;
    }
}
