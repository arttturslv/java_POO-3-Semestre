import java.util.ArrayList;
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

    public void convidar(Convidado convidado, String data) {
        System.out.println("Socio ("+nome+") convidou "+convidado.getNome());
        if (convitesUsados < LIMITESCONVITE) {
            Convite convite = new Convite(data, id);
            convidado.receberConvite(convite);
            convidados.add(convidado);
            convitesUsados++;
        }
    }

    public String relatorioConvidados() {
        String relatorio = "O socio ("+nome+") teve "+convidados.size()+"convidados.\n";
        if(convidados.size()!=0) {
            for(Convidado convidado: convidados) {
                relatorio+=convidado.relatorioVisitas();
            }
            return relatorio;
        } else {
            return "Não há convidados.";
        }
    }
}