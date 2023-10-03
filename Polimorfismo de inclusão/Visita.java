import java.text.SimpleDateFormat;
import java.util.Date;

public class Visita {

    private String id;
    private String data;
    private String horaEntrada;
    private String horaSaida;

    public Visita(String id, String diaEntrada, String horaEntrada) {
        this.id = id;
        this.data = diaEntrada; 
        this.horaEntrada = horaEntrada;
        this.horaSaida = null; 
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getHoraEntrada() {
        return horaEntrada; 
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void registrarSaida(Date data) {
        horaSaida = new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
}