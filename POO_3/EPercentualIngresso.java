package POO_3;

public enum EPercentualIngresso {
    DIURNO(0.0),
    NOTURNO(0.25),
    FIMDESEMANA(0.15);

    private double percentual;

    EPercentualIngresso(double percentual) {
        this.percentual = percentual;
    }

    public double getPercentual() {
        return percentual;
    }
}
