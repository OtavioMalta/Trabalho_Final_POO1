import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        GeradorId gId = new GeradorId();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Cliente c1 = new Cliente( gId.gerarIdCliente(), "Otavio", "cpf", f.parse("31/08/2001"), "rua 2", "franca","sp");
        Cliente c2 = new Cliente(gId.gerarIdCliente(), "Otavio", "cpf", f.parse("31/08/2002"), "rua 2", "f","sp");

        ArrayList<Cliente> clientes= new ArrayList<>();
        clientes.add(c1);
        clientes.add(c2);

        ContaCorrente c = new ContaCorrente(1, 5202.21, 2.3, gId.gerarIdConta());
        c.atribuirCliente(clientes);
        System.out.println(c1.toString());
        
        System.out.println("\n\n------------");
        System.out.println(c2.toString());

        System.out.println("\n\n------------");
        System.out.println(c);
    }
}
