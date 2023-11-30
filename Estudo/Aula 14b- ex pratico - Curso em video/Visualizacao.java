public class Visualizacao {
    private Gafanhoto espectador;
    private Video filme;

    public Visualizacao (Gafanhoto espec, Video filme) {
        this.espectador = espec;
        this.filme = filme;
        this.espectador.viuMaisUm();
        this.filme.visualizar();
    }

    public void avaliar() {
        System.out.println("Avaliando...");
        filme.avaliar(5.0);
    }

    public void avaliar(double nota) {
        System.out.println("Avaliando...");
        filme.avaliar(nota);

    }

    public void avaliar(float porcentagem) {
        double nota;
        if(porcentagem<=20) {
            nota = 1;
        } else if (porcentagem<=40) {
            nota = 3;
        } else if (porcentagem<=80) {
            nota = 4;
        } else {
            nota = 5;
        }

        filme.avaliar(nota);
    }


    @Override
    public String toString() {
        return "Visualizacao [espectador=" + espectador.toString() + ", filme=" + filme + "]";
    }

    
}
