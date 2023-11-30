public class Gafanhoto extends Pessoa{
    private String login;
    private double totalAssistido;

    public Gafanhoto (String nome, int idade, char sexo, String login) {
        super(nome, idade, sexo);
        this.login = login;
        this.totalAssistido=0;
    }

    public void viuMaisUm() {
        System.out.println("Assistindo mais um video.");
        totalAssistido+=1;
    }

    @Override
    public String toString() {
        return "Gafanhoto [login=" + login + ", totalAssistido=" + totalAssistido + "]";
    }

    @Override
    protected void ganharExp () {
        experiencia+=1;
        System.out.println("Ganhando experiencia...");
    }
}
