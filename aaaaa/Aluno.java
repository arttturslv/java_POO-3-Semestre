public class Aluno {
  public static final int NOTA_APROVACAO = 60;
  public static final int FREQUENCIA_DIA_UTIL = 200;
  public static final double FREQUENCIA_MINIMA = 0.75;
  public static final int QUANT_AVALIACOES = 4;
  public static int id=1;

  private String nome;
  private int idMatricula;
  private double notasAluno [] = new double [QUANT_AVALIACOES];
  private int faltasCometidas;

  public Aluno (String nome) {
    this.nome = nome;
    faltasCometidas = 0;
    idMatricula = id;
    id++;
  }

  public void cadastrarNotas(double [] notas) {
     if(validarNotas(notasAluno)) {
        notasAluno = notas;
     }
  }

  private boolean validarNotas(double [] notas) {
    for(double i:notas) {
        if(i>100 || i < 0) {
            return false;
        }
    }
    return true;
  }

  public void lancarFaltas(int qntFaltas) {
    faltasCometidas+= qntFaltas;
  }

  public boolean calcularAprovacao () {
    if(calculoFaltas() && calculoNotas()) {
        return true;
    }
    return false;
  }

  private boolean calculoFaltas() {
    if(((FREQUENCIA_DIA_UTIL-faltasCometidas)/FREQUENCIA_DIA_UTIL*100)>FREQUENCIA_MINIMA) {
        return true;  
    }
    return false;
  }

  private boolean calculoNotas() {
    double soma = 0;

    for (double nota : notasAluno) {
        soma += nota;
    }

    if(soma>=NOTA_APROVACAO) {
        return true;
    }
    return false;

  }
}
