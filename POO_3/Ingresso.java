package POO_3;

public class Ingresso {
    protected Sessao sessao;
    protected double valorDeVenda;

    public double precoIngresso() {
        return valorDeVenda;
    }
    public String dadosIngresso() {
        return ("Preço ingresso: "+valorDeVenda);
    }

}
