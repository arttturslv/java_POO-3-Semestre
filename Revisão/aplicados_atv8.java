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


    public static boolean verificaData(int dia, int mes, int ano) {
        if(dia<1) {
            System.out.println("O dia é invalido (menor que 0)");
            return false;
        }
        if(mes>12 || mes<0) {
            System.out.println("O mes é invalido. (Maior que 12 ou menor que 1))");
            return false;
        }    
        
        if(mes/10==0 & mes%10==9) { //java nao aceita 09 como inteiro
            mes = 9;
        }

        return verificaMes(dia, mes, ano);
    }

    public static boolean verificaMes(int dia, int mes, int ano) {
        if(mes==04 || mes==06 || mes==9 || mes==12) { //verifica meses com 31
            if(dia>31) {
                return false;
            }
        } else if (mes==2) { //verifica fevereiro
            if(verificaBissexto(ano)) {
                if(dia>29)
                return false;
            } else {
                if(dia>28)
                return false;
            }
        } else { //verifica meses com 30
            if(dia>30) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificaBissexto(int ano) {
        if (ano % 4 != 0 & ano % 400 != 0) {
            return false;
        }
        return true;
    }
}
