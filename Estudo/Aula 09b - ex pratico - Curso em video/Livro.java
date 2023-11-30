public class Livro implements IPublicacao {
    private String titulo;
    private String autor;
    private int totalPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;


    public Livro (String titulo, String autor, int totalPaginas, Pessoa pessoa ) {
        this.titulo = titulo;
        this.autor = autor;
        this.totalPaginas = totalPaginas;
        this.leitor = pessoa;
        this.pagAtual=0;
        this.aberto = false;
    }

    public String detalhes() {
        return (titulo+", escrito por "+autor+" está sendo lido por "+leitor.getNome()+", que está na pagina "+pagAtual+" de "+totalPaginas+" paginas.");
    }

    public void abrir() {
        System.out.println("Livro foi aberto");
    }
    public void fechar() {
        System.out.println("Livro foi fechado");
    }
    public void folhear() {
        System.out.println("Livro está sendo folheado");
    }
    public void avancarPag() {
        System.out.println("Avançando paginas");
    }
    public void voltarPag() {
        System.out.println("Retrocendendo paginas");
    }
}
