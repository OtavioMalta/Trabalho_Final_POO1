import java.util.ArrayList;
import java.util.Date;

public class Supervisor extends Funcionario{

    public Supervisor(String nome, String telefone, ArrayList<Pessoa> dependentes, Supervisor supervisor,
            Date admissao, Agencia agencia) {
        super( nome, telefone, dependentes, supervisor, admissao, agencia);
        
    }
    
}
