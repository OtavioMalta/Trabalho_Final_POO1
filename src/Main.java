

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.Agencia;
import DTO.Cliente;
import DTO.ContaCorrente;
import DTO.ContaPoupanca;
import Util.Tipo;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");


        Cliente cliente1 = new Cliente( "Teste1", "123", f.parse("31/08/2001"), "rua 1", "franca","sp");
        Cliente cliente2 = new Cliente("Teste2", "456", f.parse("12/02/2002"), "rua 2", "Uberlandia","mg");
        ArrayList<Cliente> clientes= new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        Agencia agencia1 = new Agencia("Uberaba", "mg", "AgenciaPrincipal");
        agencia1.imprimirAgencia();
        Agencia agencia2 = new Agencia("Restinga", "sp", "AgenciaSecundaria");
        agencia2.imprimirAgencia();

        ContaCorrente cc = new ContaCorrente(agencia2.getId(), 5202.21, 2.3);
        cliente1.adicionarConta(cc);
        cc.realizarOperacao(Tipo.DEBITO, "Luz", 6000, new Date());
        
        ContaPoupanca cp = new ContaPoupanca(agencia1.getId(), 4500, 3);
        cliente2.adicionarConta(cp);

        cp.imprimirConta();

        agencia1.realizarEmprestimo(clientes, 9500, 2);
        System.out.println("\n\n");
        cliente2.imprimirCliente();
        
        
      
    }
}
