package POO_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<Filme, List<Sessao>> sessoes = new HashMap<>();
     
    public double totalArrecadado() {
        return 0;
    } 
    public String extrato(String documentoCliente) {
        return null;
    }
}
