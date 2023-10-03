import java.util.*;
public class aplicados_atv7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Numero a ser multiplicado por 11: ");
            num = sc.nextInt();
        calcula(num);
        sc.close();
    }

    public static void calcula (int num) {
        int digitoUm = num/10; //pega o primeiro digito
        int digitoDois = num%10; //pega o ultimo digito

        int soma = digitoUm+digitoDois;
        
        if(soma>9) {
            int somaDir = soma % 10; //pega o digito da direita
            digitoUm+=1; //acrescenta 1 no digito da esquerda
            System.out.println(digitoUm+""+somaDir+""+digitoDois);
        } else {
            System.out.println(digitoUm+""+soma+""+digitoDois);
        }
    }

}
