import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Convidado extends Frequentador {
    private List<Convite> convites;

    public Convidado(String nome) {
        super(nome);
        convites =  new ArrayList<>();
    }

    /**
     * Função que recebe um convite e aceita, adicionando na lista de convites.
     * @param convite
     */
    public void receberConvite(Convite convite) {
        System.out.println("-> Convite recebido.");
        convites.add(convite);
    }

    @Override
    Boolean registrarEntrada(Date diaEntrada, Clube clube) throws Exception {
        System.out.println("Registrando a visita de um convidado.");

        Convite convite = procuraConviteData(diaEntrada);

        if(convite==null) {
            System.out.println("O convidado não possui um convite valido."); 
            return false;
        }
        
        String idEmissor = convite.getIdEmissor();

        if(clube.verificaPresenca(idEmissor) == false) {
            System.out.println("Espere até que o socio entre no clube para entrar também.");
            return false;
        }

        visitas.add(new Visita(id, diaEntrada));
        setPresenca();
        return true;
    }   

    /**
     * Função que retorna um convite existente caso exista nesta dada ou null, caso não exista.
     * Ela recebe uma data, dessa data separa a hora e o dia, pesquisando na lista de convites se existe um com essa data e com hora inferior (ou seja, já passou o horario e ele pode entrar)
     * @param diaEntrada -> Data no formato "Thu Oct 05 00:00:00 BRT 2023"
     * @return Convite valido ou null
     * @throws Exception -> Caso dê erro no parse das datas.
     */
    private Convite procuraConviteData(Date diaEntrada) throws Exception{
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm:ss");
        
        String stringDia = formataData.format(diaEntrada);
        Date dia = formataData.parse(stringDia);

        String stringHora = formataHora.format(diaEntrada);
        Date hora = formataHora.parse(stringHora);

        for(Convite convite : convites) {
            if(convite.existe(dia, hora)) {
                return convite;
            }
        }
        return null;
    }
}