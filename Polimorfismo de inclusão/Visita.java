import java.text.SimpleDateFormat;
import java.util.Date;
public class Visita {

    private String idFreq;
    private Date data;
    private Date horaEntrada;
    private Date horaSaida = null;

    public Visita(String idFreq, Date diaEntrada) {
        this.idFreq = idFreq;
        this.data = diaEntrada; 
        this.horaEntrada = diaEntrada;
    }

    /**
     * Função que retorna a data da visita.
     * @return data da visita
     */
    public Date getData() {
        return data;
    }

    /**
     * Função que retorna o id do frequentador.
     * @return id do frequentador
     */
    public String getIdFreq() {
        return idFreq;
    }

    /**
     * Função que retorna a hora da entrada.
     * @return hora da entrada.
     */
    public Date getHoraEntrada() {
        return horaEntrada; 
    }

    /**
     * Função que retorna a hora da saida.
     * @return hora da saida.
     */
    public Date getHoraSaida() {
        return horaSaida;
    }

    /**
     * Registra a hora de saída da visita recebida por parametro na variavel local.
     * @param horaSaida A hora de saída da visita.
     */    
    public void registrarSaida(Date horaSaida) {
        this.horaSaida = horaSaida; 
    }

    @Override
    public String toString() {
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm:ss");

        String stringData = formataData.format(data);
        String stringEntrada = formataHora.format(data);
        String stringSaida;

        if(horaSaida==null) {
            stringSaida = "Sem registro";
        } else {
            stringSaida = formataHora.format(horaSaida);
        }

        return ("\n- Data: "+stringData+"\n"+
        "- Hora de Entrada: "+stringEntrada+"\n"+
        "- Hora de Saida: "+stringSaida+"\n");
    }
}