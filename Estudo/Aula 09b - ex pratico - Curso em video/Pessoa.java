/**
 * Pessoa
 */
public class Pessoa {
    private String nome;
    private int idade;
    private char sexo;

    public Pessoa (String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String fazerAniversario() {
        idade+=1;
        return (nome+" está fazendo aniversario! Feliz "+idade+" anos de vida.");
    }

    public String getNome() {
        return nome;
    }
}