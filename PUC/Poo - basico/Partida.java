public class Partida {
    
    private String nomeTimeUm; 
    private String nomeTimeDois; 

    private String pontosTimeUm;
    private String pontosTimeDois;

    private int qntProrrogacoes; 

    /**
     * Construtor que recebe os valores iniciais, como o nome do time e os pontos feitos. 
     * @param nomeUm
     * @param nomeDois
     * @param pontosUm
     * @param pontosDois
     */
    public Partida (String nomeUm, String nomeDois, String pontosUm, String pontosDois) {
        nomeTimeUm = nomeUm;
        nomeTimeDois = nomeDois;
        pontosTimeUm = pontosUm;
        pontosTimeDois = pontosDois;
        qntProrrogacoes = 0;
    }

    /**
     * Função que verifica se um time ganhou ou não com base na função somaPontos()
     * @return boolean - True se algum ganhou e False se nenhum ganhou.
     */
    public boolean verificaGanhador() {
        if(somaPontos(pontosTimeUm) != somaPontos(pontosTimeDois)) {
            return true;
        }
        return false;
    }

    /**
     * Função que retorna um int que contem a soma dos pontos do time recebido no parametro.
     * @param pontosTime
     * @return soma
     */
    private int somaPontos(String pontosTime) {
        String [] arrayPontosTime = pontosTime.split(";");
        int soma=0;

        for (int i = 0; i < arrayPontosTime.length; i++) {
            soma+= Integer.parseInt(arrayPontosTime[i]);
        }
        return soma;
    }

    /**
     * Atualiza os pontos do placar, concatenando os pontos dos times em suas respectivas strings com ";"
     * para separação, além de transformar os pontos recebidos via parametro em inteiro e somar na 
     * somaPontos de cada time. A função também aumenta a variavel qntProrrogacoes em +=1
     * @param pontosTimeUm
     * @param pontosTimeDois
     */
    public void atualizaPlacar(String pontosUm, String pontosDois) {
        qntProrrogacoes+=1;

        pontosTimeUm += pontosUm + ";";
        pontosTimeDois += pontosDois + ";";
    }

    /**
     * Função retorna a string placar com o placar formatado. Ela gera o cabeçalho da tabela que contem os periodos
     * e também gera a quantidade de "PR" com base na qntProrrogações.
     * Ela chama a função retornaPlacarTime para cada um dos times.
     * @return placar - Com o cabeçalho e as informaçoes dos times formatados.
     */
    public String retornaPlacar() {
        String placar="\n\t\t1Q\t2Q\t3Q\t4Q";

        for (int qntPartidas = 0; qntPartidas < qntProrrogacoes; qntPartidas++) {
            placar+="\tPR";
        }
        placar+="\tFINAL\n";

        placar += retornaPlacarTime(nomeTimeUm, pontosTimeUm);
        placar += retornaPlacarTime(nomeTimeDois, pontosTimeDois);

        return placar;
    }

    /**
     * A função retorna uma string que possui o nome, os pontos e a soma de pontos espaçada com "\t".
     * Ela recebe uma string com todos os pontos, transforma em array de string e concatena na String time, 
     * junto com o nome do time e os pontos totais que são fornecidos pela funcao somaPontos().
     * @param nomeTime - Nome do time da vez 
     * @param pontosTime - String que contem todos os pontos do time da vez
     * @return time - Toda a informação concatenada e formatada do time.
     */
    private String retornaPlacarTime(String nomeTime, String pontosTime) {
        String [] arrayPontosTime = pontosTime.split(";");
        String time="";
        time+=nomeTime+"\t";
        for (int i = 0; i < arrayPontosTime.length; i++) {
            time+="\t"+arrayPontosTime[i];
        }
        time+="\t"+somaPontos(pontosTime)+"\n";
        return time;
    }

}

