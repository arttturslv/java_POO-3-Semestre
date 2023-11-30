import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public abstract class Frequentador {
	protected static int ultimoId = 1;

    protected String id;
    protected String nome;
    protected boolean presenca;

    protected List<Visita> visitas;

    public Frequentador(String nome) {
        this.id = ""+ultimoId;
        ultimoId++;
        this.nome = nome;
        visitas = new ArrayList<>();
    }

    /**
     * Função que retorna o id do frequentador.
     * @return id do frequentador 
     */
    public String getId() {
        return id;
    }

    /**
     * Função que retorna o nome do frequentador.
     * @return nome do frequentador 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função booleana que retorna se o frequentador está presente.
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public boolean getPresenca () {
        return presenca;
    } 

    /**
     * Função que inverte o estado da presenca do frequentador.
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public void setPresenca () {
        presenca = !presenca;
    } 

    /**
     * Função que registra um objeto visita na lista de visitas com base na data e hora recebidas via parametro.
     * @param diaEntrada -> dia da entrada da visita
     * @param horaEntrada -> hora da entrada da visita
     */
    public void entrarClube(Date diaEntrada, Date horaEntrada) {
        visitas.add(new Visita(id, diaEntrada));
    }

    /**
     * Função que registra no ultimo objeto visita a hora de saida recebida via parametro.
     * @param horaSaida -> hora de saida da visita
     */
    public void sairClube(Date horaSaida) {
        if (!visitas.isEmpty()) {
            visitas.get(visitas.size() - 1).registrarSaida(horaSaida);
        }
        setPresenca();
    }

    /**
     * Função booleana que verifica se o frequentador visitou o clube em determinada data.
     * @param data -> Data a ser verificada
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public boolean visitouClube(Date data) {
        for (Visita visita : visitas) {
            if (comparaData(data, visita.getData())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função booleana que compara duas datas entre si, verificando apenas o dia, mes e ano.
     * @param dataEscrita -> Data passada como parametro.
     * @param dataVisita -> Data do convite.
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    private boolean comparaData(Date dataEscrita, Date dataVisita) {
        Calendar dtEscrita = Calendar.getInstance();
        dtEscrita.setTime(dataEscrita);

        Calendar dtVisita = Calendar.getInstance();
        dtVisita.setTime(dataVisita);

        boolean resultado = dtEscrita.get(Calendar.YEAR) == dtVisita.get(Calendar.YEAR) &&
        dtEscrita.get(Calendar.MONTH) == dtVisita.get(Calendar.MONTH) &&
        dtEscrita.get(Calendar.DAY_OF_MONTH) == dtVisita.get(Calendar.DAY_OF_MONTH);

        return resultado;
    }

    /**
     * Gera um relatório das visitas do frequentador, e caso não existam, retorna que não há informações.
     * @return Uma string que contém as informações das visitas do frequentador.
     */
    public String relatorioVisitas() {
        String relatorio = "Frequentador: "+nome+"\n";
        if (visitas.isEmpty()) {
            relatorio+="Não há informações de visitas.";
        } else {
            for (Visita visita : visitas) {
                relatorio += visita.toString();
            }
        }
        return relatorio;
    }

    /**
     * Função abstract que é sobrescrita no socio e no convidado. 
     * Caso seja socio, ele faz um visita.add e muda a presença do frequentador para true.
     * Caso seja convidado, ele pesquisa um convite no dia, verifica se é valido e se o socio que o emitiu está dentro, se estiver, ele faz a visita.add e muda a presença.
     * @param dia -> Dia da entrada (tecnicamente o atual)
     * @param clube -> Clube que ocorre a entrada. 
     * @return true se a operação for bem-sucedida, false caso contrário
     * @throws Exception -> Caso dê erro de cast.
     */
    abstract Boolean registrarEntrada(Date dia, Clube clube) throws Exception;

}