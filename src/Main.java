import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import DAO.ClienteDAO;
import DTO.Agencia;
import DTO.Cliente;
import DTO.ContaCorrente;
import Util.SaldoInsuficienteException;
import Util.Tipo;

public class Main {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat f  = new SimpleDateFormat("dd/MM/yyyy", Locale.US);


        Cliente cliente1 = new Cliente( "Teste1", "123", f.parse("31/08/2001"), "rua 3", "franca","sp");
        Cliente cliente2 = new Cliente("Teste2", "456", f.parse("12/02/2002"), "rua 4", "Uberlandia","mg");
        ArrayList<Cliente> clientes= new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        ClienteDAO clienteDAO = new ClienteDAO();
        
        Agencia agencia1 = new Agencia("Uberaba", "mg", "AgenciaPrincipal");
        Agencia agencia2 = new Agencia("Restinga", "sp", "AgenciaSecundaria");
        agencia2.realizarEmprestimo(clientes, 3000, 4);

        ArrayList<Cliente> clientesNovos = clienteDAO.lista();
        ContaCorrente cc = new ContaCorrente(agencia2.getId(), 12000, 2.3);
        
        for(Cliente c : clientesNovos){
            System.out.println(c);
        }
        
        cliente1.adicionarConta(cc);
        clienteDAO.salvar(cliente1);
        
    }
}
