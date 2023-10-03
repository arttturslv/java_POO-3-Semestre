
public class Java_compilado {

    /* ATIVIDADE 1 
  public static void main(String[] args) {
        int vetor[] = new int[6];

        leitura(vetor);

        System.out.println("\nVetor original: ");
        imprimeVetor(vetor);
        System.out.println("\nVetor reverso: ");
        vetor = inverte(vetor);
        imprimeVetor(vetor);
    }

    public static int[] leitura(int[] vetor) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite a posição " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
        sc.close();
        return vetor;
    }

    public static int[] inverte(int[] vetor) {
        int vetorInvertido[] = new int[vetor.length];
        int j = 0;
        for (int i = vetor.length - 1; i >= 0; i--) {
            vetorInvertido[j] = vetor[i];
            j++;
        }
        return vetorInvertido;
    }

    public static void imprimeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + vetor[i]);
        }
    }
    */

  /* ATIVIDADE 2 
  public static void main(String[] args) {
    int[] vetor;

    System.out.println("Digite o tamanho do vetor: ");
    vetor = leitura();
    System.out.println("\nVetor original: ");
    imprimeVetor(vetor);
    System.out.println("\nVetor duplas: ");
    imprimeVetor(vetorDuplas(vetor));

}

    public static int[] leitura() {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[sc.nextInt()];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite a posição " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
        sc.close();
        return vetor;
    }

    public static int[] vetorDuplas(int[] vetor) {
        int vetDuplasTam = calcTamanho(vetor);
        int vetorTam = vetor.length;

        int vetorDuplas[] = new int[vetDuplasTam];

        if (vetor.length % 2 != 0) { // já pega o ultimo valor e soma na ultima pos do vetor de duplas
            vetorTam -= 1;
            vetorDuplas[vetDuplasTam - 1] = 2 * vetor[vetorTam];
        }

        int j = 0;
        for (int i = 0; i < vetDuplasTam & j < vetorTam; i++) {
            vetorDuplas[i] = vetor[j] + vetor[j + 1];
            j += 2;
        }
        return vetorDuplas;
    }

    public static int calcTamanho(int[] vetor) {
        int novoTamanho = vetor.length / 2;
        if (vetor.length % 2 != 0) {
            novoTamanho += 1;
        }
        return novoTamanho;
    }

    public static void imprimeVetor(int[] vetor) {
    for (int i = 0; i < vetor.length; i++) {
        System.out.print(" " + vetor[i]);
    }
}
    */

  /* ATIVIDADE 3
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

    public static void desenhaRetangulo(int altura, int largura) {
        for (int i = 0; i < altura; i++) { // percorre toda altura
            for (int j = 0; j < largura; j++) { // percorre toda largura

                if (j == 0 || j == largura-1 || i == 0 || i == altura-1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    */

  /* ATIVIDADE 4    
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        System.out.println("Digite frases e elas serão invertidas. Digite \"fim\" para sair. \n ");

        while (!frase.equals("fim")) {
            System.out.print("normal: ");
            frase = sc.nextLine();
            inverteFrase(frase);
        }
        sc.close();
    }

    public static void inverteFrase(String frase) {
        System.out.print("invertida: ");
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.print(frase.charAt(i));
        }
        System.out.println();
    }
    */

  /* ATIVIDADE 5    
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
    */

  /* ATIVIDADE 6
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String primeiroPremio, segundoPremio;

        System.out.println("Resultado do primeiro premio: ");
        primeiroPremio = sc.nextLine();
        System.out.println("Resultado do segundo premio: ");
        segundoPremio = sc.nextLine();

        primeiroPremio = primeiroPremio.replace(".", "");
        segundoPremio = segundoPremio.replace(".", "");

        sc.close();

        System.out.println("Resultado: "+ segundoPremio.substring(0, 3) + "." + primeiroPremio.substring(2, 5));
    }
    */ 


  /* ATIVIDADE 7  
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
    */ 

  /* ATIVIDADE 8  
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
    */ 

  /* ATIVIDADE 9 
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes;

        System.out.println("Digite o dia: ");
            dia = sc.nextInt();
        System.out.println("Digite o mês: (sem o zero na frente)");
            mes = sc.nextInt();

            DescobreDiaDaSemana(contarDias(dia, mes));
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

    public static void DescobreDiaDaSemana(int qntDias) {
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
    */ 

}
