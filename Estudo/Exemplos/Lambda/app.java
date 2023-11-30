package Lambda;

import java.util.ArrayList;

public class app {
    public static void main(String[] args) {
        ArrayList<Integer> valores = new ArrayList<Integer>();
        ArrayList<Integer> pares = new ArrayList<Integer>();

        valores.add(1);
        valores.add(2);
        valores.add(3);
        valores.add(4);
        valores.add(5);

        valores.forEach((valorUn) -> {
                if(valorUn%2==0) {
                    pares.add(valorUn);
                }
        });
        System.out.print(valores); // 1 2 3 4 5 
        System.out.print(pares); // 1 2 3 4 5 

    }
    }
    