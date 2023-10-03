import java.util.ArrayList;
import java.util.List;

class Convidado extends Frequentador {
    private List<Convite> convites;

    public Convidado(String nome) {
        super(nome);
        convites =  new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void receberConvite(Convite convite) {
        System.out.println("-> Convite recebido.");
        convites.add(convite);
    }

    public boolean procurarConvite(String data, String idSocio) {
        for(Convite convite: convites) {
            if(convite.existe(data, idSocio)) {
                return true;
            }
        }
        return false;
    }


}