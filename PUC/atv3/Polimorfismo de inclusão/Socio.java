import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Socio extends Frequentador {

    private static final int LIMITESCONVITE = 4;

    private int convitesUsados;
    private List<Convidado> convidados;

    public Socio( String nome) {
        super(nome);
        convitesUsados = 0;
        convidados = new ArrayList<>();
    }

    /**
     * Função exclusiva do socio que recebe como paramentro o frequentador a ser convidado, a data e a hora do convite. Ele verifica se o socio já passou do limite de convites
     * e caso não tenha, cria um objeto convite, chama o convidado.receberConvite(convite) e adiciona o convidado na lista. A função também aumenta a varivel de convites enviados.
     * @param convidado -> Convidado
     * @param data -> Data do convite
     * @param hora -> Hora do convite
     */
    public void convidar(Convidado convidado, Date data, Date hora) {
        System.out.println("Socio ("+nome+") convidou "+convidado.getNome());
        if (convitesUsados < LIMITESCONVITE) {
            Convite convite = new Convite(data, hora, id);
            convidado.receberConvite(convite);
            convidados.add(convidado);
            convitesUsados++;
        }
    }

    /**
     * Função que retorna uma string com os relatorios de visitas de todos os convidados do socio.
     * @return String com o relatorio ou uma mensagem de aviso dizendo que não há convidados.
     */
    public String relatorioConvidados() {
        String relatorio = "O socio ("+nome+") teve "+convidados.size()+" convidados.\n";
        if(convidados.size()!=0) {
            for(Convidado convidado: convidados) {
                relatorio+=convidado.relatorioVisitas();
            }
            return relatorio;
        } else {
            return "Não há convidados.";
        }
    }

    @Override
    Boolean registrarEntrada(Date diaEntrada, Clube clube) {
        System.out.println("Registrando a visita de um socio.");
        visitas.add(new Visita(id, diaEntrada));
        setPresenca();
        return true;
    }
}