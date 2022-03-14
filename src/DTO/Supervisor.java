package DTO;
import java.util.ArrayList;
import java.util.Date;

public class Supervisor extends Funcionario{

    public Supervisor(String nome, String telefone, ArrayList<Dependente> dependentes,
            Date admissao, Agencia agencia) {
        super( nome, telefone, dependentes, null, admissao, agencia);
        
    }
    
}
 