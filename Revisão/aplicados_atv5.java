import java.util.*;
public class aplicados_atv5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qntMinutosTotais=0, qntDisciplinas, qntHoras, qntMinutos, qntDiarias, tempoDescanso;

        System.out.print("Quantidade de disciplinas matriculadas: ");
            qntDisciplinas = sc.nextInt();
        System.out.print("Quantidade de horas disponiveis: ");
            qntHoras = sc.nextInt();
        System.out.print("Quantidade de minutos disponiveis: ");
            qntMinutos = sc.nextInt();
        System.out.print("Quantidade de disciplinas diarias: ");
            qntDiarias = sc.nextInt();

        System.out.println("\n\n\n\n"); //limpeza

        qntMinutosTotais = qntMinutos+(qntHoras*60);
        tempoDescanso =  (qntMinutosTotais/10); //10% do horario é descanso
        qntMinutosTotais = qntMinutosTotais - tempoDescanso; //subtrai o descanso do total

        System.out.println("\n\nEstudando todos os dias na semana: ");
            metodo(7, qntDisciplinas, qntMinutosTotais, tempoDescanso, qntDiarias);
        System.out.println("\n\nEstudando seis dias na semana: ");
            metodo(6, qntDisciplinas, qntMinutosTotais, tempoDescanso, qntDiarias);
        System.out.println("\n\nEstudando cinco dias na semana: ");
            metodo(5, qntDisciplinas, qntMinutosTotais, tempoDescanso, qntDiarias);
        sc.close();
    }

    public static void metodo (int qntDias, int qntDisciplinas, int qntMinutosTotais, int tempoDescanso, int qntDiarias) {
        System.out.println(" - Disciplinas a serem estudadas diariamente: "+qntDiarias);
        System.out.println(" - Tempo para estudar cada disciplina: "+(qntMinutosTotais/qntDias)/qntDiarias+"min");
        System.out.println(" - Tempo de descanso entre disciplinas: "+(tempoDescanso/qntDias)/(qntDiarias-1)+"min");
    }
}
