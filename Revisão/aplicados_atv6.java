import java.util.*;
public class aplicados_atv6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String primeiroPremio, segundoPremio;

        System.out.println("Resultado do primeiro premio: ");
            primeiroPremio = sc.nextLine();
        System.out.println("Resultado do segundo premio: ");
            segundoPremio = sc.nextLine();
        //editado pelo telefone e nao testado
        primeiroPremio = primeiroPremio.replace(".", "");
        segundoPremio = segundoPremio.replace(".", "");
        //fim do edit
        sc.close();
        
        System.out.println(segundoPremio.substring(0, 3)+primeiroPremio.substring(2, 5));
    }
}
