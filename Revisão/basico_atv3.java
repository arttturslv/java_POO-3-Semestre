import java.util.*;
public class basico_atv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alt, larg;

        System.out.println("Digite a altura do retangulo: ");
            alt = sc.nextInt();
        System.out.println("Digite a largura do retangulo: ");
            larg = sc.nextInt();
        
        desenhaRetangulo(alt, larg);
        sc.close();
    }
    public static void desenhaRetangulo(int alt, int larg) {
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < larg; j++) {
                if(j!=0 & j!=larg-1  & i!=0 & i!=alt-1) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
