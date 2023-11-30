public class Video implements IAcoesVideo {
    private String titulo;
    private double avaliacao;
    private int views;
    private int curtidas;
    private boolean reproduzindo;

    public Video (String titulo) {
        this.titulo = titulo;
        this.avaliacao = 0;
        this.views =0 ;
        this.curtidas = 0;
        this.reproduzindo = false;
    }

    @Override
    public void play() {
        System.out.println("Playing");
    }
    
    @Override
    public void pause() {
        System.out.println("Pausing");
    }

    @Override
    public void like() {
        System.out.println("Liking");
    }

    @Override
    public String toString() {
        return (titulo+" - "+views);
    }

    public void avaliar(double avaliacao) {
        this.avaliacao+=avaliacao;
    }

    public void visualizar() {
        System.out.println("Recebendo view");
        this.views +=1;
    }
}
