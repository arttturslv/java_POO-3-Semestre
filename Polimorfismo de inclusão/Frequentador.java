import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Frequentador {
	protected static int ultimoId = 1;

    protected String id;
    protected String nome;

    protected List<Visita> visitas;

    public Frequentador(String nome) {
        this.id = ""+ultimoId;
        ultimoId++;
        this.nome = nome;
        visitas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void entrarClube(String diaEntrada, String horaEntrada) {
        visitas.add(new Visita(id, diaEntrada, horaEntrada));
    }

    public void sairClube(Date data) {
        if (!visitas.isEmpty()) {
            visitas.get(visitas.size() - 1).registrarSaida(data);
        }
    }

    public boolean visitouClube(String data) {
        for (Visita visita : visitas) {
            if (visita.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    public String relatorioVisitas() {
        String relatorio = "Frequentador: "+nome+"\n";
        if (visitas.isEmpty()) {
            relatorio+="Não há informações de visitas.";
        } else {
            for (Visita visita : visitas) {
                relatorio+="- Data: "+visita.getData()+"\n";
                relatorio+="- Hora de Entrada: "+visita.getHoraEntrada()+"\n";
                relatorio+="- Hora de Saída: "+visita.getHoraSaida()+"\n";
            }
        }
        return relatorio;
    }
}