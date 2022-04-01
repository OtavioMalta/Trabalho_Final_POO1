package DTO;
import java.util.ArrayList;
import java.util.Date;

public abstract class Funcionario extends Pessoa{
    protected long id;
    protected String nome;
    protected String telefone;
    protected ArrayList<Dependente> dependetes;
    protected Long idSupervisor;
    protected Date admissao;
    protected Long idAgencia;
    private static long IDFuncionario =System.nanoTime();


    public Funcionario( String nome, String telefone, ArrayList<Dependente> dependentes, Long supervisor, Date admissao, Long agencia) {
        super(nome);
        this.id = Funcionario.IDFuncionario++;
        this.telefone = telefone;
        this.dependetes = dependentes;
        this.idSupervisor = supervisor;
        this.admissao = admissao;
        this.idAgencia = agencia;
    }

    public Funcionario(Long id, String nome, String telefone, Long supervisor, Date admissao, Long agencia) {
        super(nome);
        this.id = id;
        this.telefone = telefone;
        this.idSupervisor = supervisor;
        this.admissao = admissao;
        this.idAgencia = agencia;
    } 
    
    public Funcionario( String nome, String telefone, Long supervisor, Date admissao, Long agencia) {
        super(nome);
        this.id = Funcionario.IDFuncionario++;
        this.telefone = telefone;
        this.idSupervisor = supervisor;
        this.admissao = admissao;
        this.idAgencia = agencia;
    } 
 

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Dependente> getDependentes() {
        return this.dependetes;
    }

    public void setDependentes(ArrayList<Dependente> dependentes) {
        this.dependetes = dependentes;
    }

    public Date getAdmissao() {
        return this.admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public ArrayList<Dependente> getDependetes() {
        return this.dependetes;
    }

    public void adicionarDependente(Dependente d){
        try{
            this.dependetes.add(d);

        }catch (Exception e){
            e.getMessage();
        }
    }

    public Long getIdSupervisor() {
        return this.idSupervisor;
    }

    public void setIdSupervisor(Long idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Long getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }

    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            "\nnome='" + getNome() + "'" +
            "\ntelefone='" + getTelefone() + "'" +
            "\ndependetes='" + getDependetes() + "'" +
            "\nsupervisor='" + getIdSupervisor() + "'" +
            "\nadmissao='" + getAdmissao() + "'" +
            "\nagencia='" + getIdAgencia() + "'" +
            "}\n";
    }


}
