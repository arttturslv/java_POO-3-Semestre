package POO_3;

public class Filme {
    private String nomeFilme;
    private boolean legendado;
    private int anoLancamento;

    public String dadosFilme() {
        return ("nome: "+nomeFilme+"\nlegenda: "+legendado+"\nLançamento: "+anoLancamento);
    }

    public String getNameFilme() {
        return nomeFilme;
    }
}
