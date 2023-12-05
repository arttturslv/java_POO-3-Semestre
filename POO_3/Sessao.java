package POO_3;

import java.time.LocalDateTime;

public class Sessao {
    private Filme filme;
    private LocalDateTime horario;
    private double precoSessao; //valor base
    private int ingressosVendidos;
    private int capacidade;

    public Sessao(Filme filme, LocalDateTime horarioDaSessao, double precoSessao, int capacidade) {
        this.filme = filme;
        this.horario = horarioDaSessao;
        this.ingressosVendidos = 0;
        this.capacidade = capacidade;
        atualizaPrecoSessao(precoSessao);
    }

    /***
     * Função que verifica qual é dia da semana. Armazena o valor do dia atual na variavel diaDaCompra. Se o valor for >= 6, retorna true, pois sabado (6) e domingo (7) é fim de semana,.
     * Caso contrario, retorna false;
     * @return true, se for final de semana e false, caso não seja.
     */
    private boolean verificaFimSemana() {
        LocalDateTime diaDaCompra = LocalDateTime.now();
        int diaDaSemana =  diaDaCompra.getDayOfWeek().getValue();
        if (diaDaSemana>=6) {
            return true;
        }
        return false;
    }

    /***
     * Função para atualizar o preço da sessão recebendo o novo valor no tipo double e aplicando o percentual devido as politicas do cinema, noite tem aumento de 20% e diurno tem aumento de 0%;.
     * @param precoSessao variavel double que atualiza o valor base do preço da sessao.
     */
     public void atualizaPrecoSessao(double precoSessao) {
        if(horario.getHour()>=17) {
            this.precoSessao = precoSessao + (precoSessao*EPercentualIngresso.NOTURNO.getPercentual());
        } else {
            this.precoSessao = precoSessao + (precoSessao*EPercentualIngresso.DIURNO.getPercentual());
        }
    }

    /**
     * Função que retorna o valor do ingresso, com base no preço da sessao e no dia da compra, caso seja fim de semana, aplica 15% de aumento com base no preço noturno.
     * @return Valor do ingresso do dia da compra.
     */
    public double valorIngresso() {
        if(verificaFimSemana()) {
            double preçoNoturno = precoSessao + (precoSessao*EPercentualIngresso.NOTURNO.getPercentual());
            return preçoNoturno + (preçoNoturno*EPercentualIngresso.FIMDESEMANA.getPercentual());
        } 
         return precoSessao;
    }

    public String dadosSessao() {
        return ("Filme: " + filme.getNameFilme() + "\nhorario: " + horario + "\nCapacidade: " + capacidade);
    }


    public double valorArrecadado() {
        return precoSessao * ingressosVendidos;
    }
}
