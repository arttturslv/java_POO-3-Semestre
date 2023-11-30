import java.util.Date;

class Convite {

    private String emissor;
    private Date dataMarcada; 
    private Date horaMarcada; 

    public Convite(Date dataMarcada, Date horaMarcada, String emissor) {
        this.dataMarcada = dataMarcada;
        this.horaMarcada = horaMarcada;
        this.emissor = emissor;
    }

    /**
     * Função que retorna o id do emissor do convite.
     * @return idEmissor
     */
    public String getIdEmissor() {
        return emissor;
    }

    /**
     * Função booleana que verifica se o convite possui a mesma data que a passada via parametro.
     * @param dataAtual -> data no formato dd/MM/yyyy
     * @param horaAtual -> hora no formato HH:mm:ss
     * @return true se a operação for bem-sucedida, false caso contrário
     */
    public boolean existe(Date dataAtual, Date horaAtual) {
        if(dataMarcada.equals(dataAtual) && horaMarcada.compareTo(horaAtual) < 0) {
            return true;
        } 
        System.out.println("Não existe convites marcados para "+dataAtual+", as "+horaAtual);
        return false;
    }
}