import java.text.SimpleDateFormat;

class Convite {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private String emissor;
    private String dataMarcada; 

    public Convite(String dataMarcada, String socio) {
        this.dataMarcada = dataMarcada;
        emissor = socio;
    }

    public boolean existe(String dataAtual, String idSocio) {
        if(dataMarcada.equals(dataAtual) && emissor.equals(idSocio)) {
            return true;
        } 
        System.out.println("Convite não existe.");
        return false;
    }

}