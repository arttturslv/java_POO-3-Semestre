import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Clube {
    private List<Frequentador> frequentadores;
    private List<String> listaPresenca;
	private Date data = new Date();

    public Clube() {
        frequentadores = new ArrayList<>();
        listaPresenca = new ArrayList<>();
    }

    public boolean addFrequentador(Frequentador novo) {
        for(Frequentador frequentador: frequentadores) {
            if(frequentador.getId() == novo.getId()) {
                return false;
            } 
        }
        System.out.println("-> "+novo.getNome()+" entrou no clube.");
        frequentadores.add(novo);
        return true;
    }

    public Socio buscarSocio(String idSocio) {
        for(Frequentador frequentador: frequentadores) {
            if(frequentador.getId().equals(idSocio) & (frequentador instanceof Socio)) {
                return (Socio) frequentador;
            }
        }
        return null;
    }

    public Convidado buscarConvidado(String idConvidado) {
        for(Frequentador frequentador: frequentadores) {
            if(frequentador.getId().equals(idConvidado)  & (frequentador instanceof Convidado)) {
                return (Convidado) frequentador;
            }
        }
        return null;
    }

    public int verificarPresenca(String idFreq) {
        int index;
        for(index=0; index < listaPresenca.size(); index++ ) {
            String visita = listaPresenca.get(index);
            if(visita.equals(idFreq)) {
                return index;
            }
        }
        return -1;
    }

    public boolean registrarEntrada(String idFreq) {
        String dataEntrada = new SimpleDateFormat("dd/MM/yyyy").format(data);
        String horaEntrada = new SimpleDateFormat("HH:mm:ss").format(data);

        if(verificarPresenca(idFreq)>=0) {
            System.out.println("-> Frequentador já está dentro do clube.");
            return false;
        }

        for(Frequentador frequentador: frequentadores) {
            if(frequentador.getId().equals(idFreq)) {
                frequentador.entrarClube(dataEntrada, horaEntrada);
                System.out.println("-> Entrada registrada"); 
                listaPresenca.add(idFreq);
                return true;
            }
        }
        return false;
    }

    public void registrarSaida(int posListaPresenca, Frequentador frequentador ) {
        listaPresenca.remove(posListaPresenca);
        Date data = new Date();
        frequentador.sairClube(data);
        System.out.println("-> Saida registrada.");
    }

    public String relatorioVisitasData(String data) {
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

    public String relatorioVisitasQuantidade(String idFreq) {
        for(Frequentador frequentador: frequentadores) {
            if (frequentador.getId().equals(idFreq))
                return frequentador.relatorioVisitas();
        }
        return "-> O id digitado não está cadastrado.";
    }

    public String relatorioVisitasConvidados(String idSocio) {
        for(Frequentador frequentador: frequentadores) {
            Socio socio = null;
            if (frequentador.getId().equals(idSocio)  & (frequentador instanceof Socio)) {
                socio = (Socio) frequentador;
                return socio.relatorioConvidados();
            }
        }
        return "-> Não existe socio com o id:"+idSocio;
    }
}
