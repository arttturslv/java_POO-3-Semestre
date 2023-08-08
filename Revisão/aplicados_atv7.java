import java.util.*;
public class aplicados_atv7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Numero a ser multiplicado por 11: ");
            num = sc.nextInt();
        resultado(num);
        sc.close();
    }

    public static void resultado (int num) {
        int digitoUm = num/10;
        int digitoDois = num%10;
        int soma = digitoUm+digitoDois;
        
        if(soma>9) {
            int somaDir = soma % 10;
            digitoUm+=1;
            System.out.println(digitoUm+""+somaDir+""+digitoDois);
        } else {
            System.out.println(digitoUm+""+soma+""+digitoDois);
        }
    }

}
