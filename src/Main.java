

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.Agencia;
import DTO.Cliente;
import DTO.ContaCorrente;
import DTO.ContaPoupanca;
import Util.SaldoInsuficienteException;
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
        Agencia agencia2 = new Agencia("Restinga", "sp", "AgenciaSecundaria");
        

        ContaCorrente cc = new ContaCorrente(agencia2.getId(), 12000, 2.3);
        cliente1.adicionarConta(cc);
        try{
            cc.realizarOperacao(Tipo.DEBITO, "Luz", -6000, new Date());
            cc.realizarOperacao(Tipo.DEBITO, "Luz", 300, new Date());
            cc.realizarOperacao(Tipo.DEBITO, "Luz", -20, new Date());
            cc.realizarOperacao(Tipo.DEBITO, "Luz", -20000, new Date());
        }catch(SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
        System.out.println(cc);
       

        /*agencia1.realizarEmprestimo(clientes, 9500, 2);
        System.out.println("\n\n");*/
        
        
      
    }
}
