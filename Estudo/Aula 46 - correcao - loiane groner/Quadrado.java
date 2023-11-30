public class Quadrado extends Figura2D implements IDimensaoSuperficial{
    int numero = 0;
    int base=5;
    int altura=5;

    @Override
    public double calcularArea() {
        return (base*altura);
    }

    @Override
    public String toString() {
        return "Quadrado [numero=" + numero + ", base=" + base + ", altura=" + altura + "]";
    }
}
