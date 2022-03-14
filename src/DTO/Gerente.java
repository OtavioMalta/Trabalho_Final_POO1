package DTO;
import java.util.ArrayList;
import java.util.Date;

public class Gerente extends Funcionario{

    public Gerente( String nome, String telefone, ArrayList<Dependente> dependentes, Supervisor supervisor,
            Date admissao, Agencia agencia) {
        super( nome, telefone, dependentes, supervisor, admissao, agencia);
        
    }
    
}
  