package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class app2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        //lambda permite armazenar uma funcao em uma variavel, aqui usei Consumer
        Consumer<String> consumer = s -> System.out.println(s); 
        list.forEach(consumer);

        System.out.println("---------");

        list.stream().forEach(consumer);

    }
}
