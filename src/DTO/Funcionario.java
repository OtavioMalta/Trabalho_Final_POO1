package DTO;
import java.util.ArrayList;
import java.util.Date;

public abstract class Funcionario extends Pessoa{
    protected long id;
    protected String nome;
    protected String telefone;
    protected ArrayList<Dependente> dependetes;
    protected Supervisor supervisor;
    protected Date admissao;
    protected Agencia agencia;
    private static long IDFuncionario = 1;


    public Funcionario( String nome, String telefone, ArrayList<Dependente> dependentes, Supervisor supervisor, Date admissao, Agencia agencia) {
        super(nome);
        this.id = Funcionario.IDFuncionario++;
        this.telefone = telefone;
        this.dependetes = dependentes;
        this.supervisor = supervisor;
        this.admissao = admissao;
        this.agencia = agencia;
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

    public Supervisor getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Date getAdmissao() {
        return this.admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Agencia getAgencia() {
        return this.agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
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
    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            "\nnome='" + getNome() + "'" +
            "\ntelefone='" + getTelefone() + "'" +
            "\ndependetes='" + getDependetes() + "'" +
            "\nsupervisor='" + getSupervisor() + "'" +
            "\nadmissao='" + getAdmissao() + "'" +
            "\nagencia='" + getAgencia() + "'" +
            "}\n";
    }


}
