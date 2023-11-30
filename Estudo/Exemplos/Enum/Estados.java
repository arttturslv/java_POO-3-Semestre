package Enum;
import java.util.Arrays;
import java.util.Optional;

public enum Estados {

    SAOPAULO("São Paulo", "SP", true),
    RIOJANEIRO("Rio de Janeiro", "RJ", false),
    BAHIA("Bahia", "BA", true),
    PERNAMBUCO("Pernambuco", "PE", true),
    MINASGERAIS("Minas Gerais", "MG", true);
    
    private final String nomeCompleto;
    private final String sigla;
    private final boolean isBom;

    private Estados(String nomeCompleto, String sigla, boolean isBom) {
        this.nomeCompleto = nomeCompleto;
        this.sigla = sigla;
        this.isBom = isBom;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getSigla() {
        return sigla;
    }

    public boolean getIsBom(){
        return isBom;
    }

    //public static Optional<Estados> getSiglaPeloIsBom (boolean isBom) {
       // return Arrays.stream(Estados.values())
                //.filter()
   // }

}
