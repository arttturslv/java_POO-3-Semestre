import java.util.*;
public class aplicados_atv9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes;

        System.out.println("Digite o dia: ");
            dia = sc.nextInt();
        System.out.println("Digite o mês: (sem o zero na frente)");
            mes = sc.nextInt();

        if (verificaData(dia, mes)) {
            diaDaSemana(contarDias(dia, mes));
        }
        sc.close();
    }

    public static int contarDias(int dia, int mes) {
        int qntDias = 0;
        qntDias += dia;
        if (mes != 0) {
            for (int i = 1; i < mes; i++) {
                qntDias += meses(i);
            }
        }
        return qntDias;
    }

    public static int meses(int mes) {
        if (mes == 2) {
            return 29;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean verificaData(int dia, int mes) {
        if (dia > 31 || dia < 1 || mes > 12 || mes < 1) {
            return false;
        }
        return true;
    }

    public static void diaDaSemana(int qntDias) {
        int num = qntDias % 7;
        switch (num) {
            case 1:
                System.out.println("Segunda");
                break;
            case 2:
                System.out.println("Terça");
                break;
            case 3:
                System.out.println("Quarta");
                break;
            case 4:
                System.out.println("Quinta");
                break;
            case 5:
                System.out.println("Sexta");
                break;
            case 6:
                System.out.println("Sabado");
                break;

            default:
                System.out.println("Domingo");
                break;
        }
    }
}
