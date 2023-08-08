import java.util.*;

public class aplicados_atv8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, ano;
        
        System.out.println("Digite o dia: ");
            dia = sc.nextInt();
        System.out.println("Digite o mês: ");
            mes = sc.nextInt();
        System.out.println("Digite o ano: ");
            ano = sc.nextInt();

        if(verificaData(dia, mes, ano)) {
            System.out.println("A data é valida.");
        } else {
            System.out.println("A data é invalida.");
        };
        sc.close();
    }


    public static boolean verificaData(int day, int month, int year) {
        if(day<1) {
            System.out.println("O dia é invalido (menor que 0)");
            return false;
        }
        if(month>12 || month<0) {
            System.out.println("O mes é invalido. (Maior que 12 ou menor que 1))");
            return false;
        }    
        
        if(month/10==0 & month%10==9) { //java nao aceita 09 como inteiro
            month = 9;
        }

        return verifyMes(day, month, year);
    }

    public static boolean verifyMes(int day, int month, int year) {
        if(month==04 || month==06 || month==9 || month==12) { //verifica meses com 31
            if(day>31) {
                return false;
            }
        } else if (month==2) { //verifica fevereiro
            if(verificaBissexto(year)) {
                if(day>29)
                return false;
            }
        } else { //verifica meses com 30
            if(day>30) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificaBissexto(int year) {
        if (year % 4 != 0 & year % 400 != 0) {
            return false;
        }
        return true;
    }
}
