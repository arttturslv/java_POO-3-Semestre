public class App {
    public static void main(String[] args) {
    Aluno a1 = new Aluno("felipe");

    double [] notasAluno = {5,4,10,51};
    
    a1.cadastrarNotas(notasAluno);
    if(a1.calcularAprovacao()) {
        System.out.println("passou");
    };

    }
}
