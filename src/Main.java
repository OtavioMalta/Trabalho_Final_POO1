import java.nio.channels.ClosedByInterruptException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import DTO.Agencia;
import DTO.Cliente;
import DTO.ContaCorrente;
import DTO.ContaPoupanca;
import DTO.Dependente;
import DTO.Gerente;
import DTO.Supervisor;
import Util.Tipo;

public class Main {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat f  = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        Agencia Agencia = new Agencia("Franca", "SP", "AGENCIA1");
        ContaCorrente contaCorrente = new ContaCorrente(Agencia.getId(), 8520, 2.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(Agencia.getId(), 7410, 3.0);
        Dependente dependente = new Dependente("PAI");
        Supervisor supervisor = new Supervisor("ASUP", "134", f.parse("31/08/2001"), Agencia.getId());
        
        System.out.println(supervisor);
        Gerente gerente = new Gerente("GER", "344", supervisor.getId(), f.parse("31/08/2001"), Agencia.getId());
        Cliente cliente = new Cliente("Otavio", "1232457", f.parse("31/08/2001") , "rua 1", "Franca", "Sp",gerente.getId());

        /*Agencia.salvar();
        contaCorrente.salvar();
        contaPoupanca.salvar();
        cliente.salvar();
        supervisor.salvar();
        gerente.salvar();*/
        contaCorrente.realizarOperacao(Tipo.DEBITO, "dsaa", 222);
        System.out.println(Agencia.lista());
        System.out.println(contaCorrente.lista());
        System.out.println(contaPoupanca.lista());
        System.out.println(cliente.lista());
        System.out.println(supervisor.lista());
        System.out.println(gerente.lista());
    }
}
