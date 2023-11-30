public class teste {
    public static void main(String[] args) {
        Video v1 = new Video("Poo");
        Video v2 = new Video("Hacking");

        Gafanhoto g1 = new Gafanhoto("Artur", 20, 'M', "laportebr");

        System.out.println(v1.toString());
        System.out.println(g1.toString());

        Visualizacao view1 = new Visualizacao(g1, v1);
        Visualizacao view2 = new Visualizacao(g1, v2);

        System.out.println(view1.toString());
    }
}
