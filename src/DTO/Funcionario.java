package DTO;
import java.util.ArrayList;
import java.util.Date;

import Util.GeradorId;

public class Funcionario extends Pessoa{
    protected long id;
    protected String nome;
    protected String telefone;
    protected ArrayList<Pessoa> dependetes;
    protected Supervisor supervisor;
    protected Date admissao;
    protected Agencia agencia;
    protected static GeradorId gId = new GeradorId();


    public Funcionario( String nome, String telefone, ArrayList<Pessoa> dependentes, Supervisor supervisor, Date admissao, Agencia agencia) {
        super(nome);
        this.id = gId.gerarIdFuncionario();
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

    public ArrayList<Pessoa> getDependentes() {
        return this.dependetes;
    }

    public void setDependentes(ArrayList<Pessoa> dependentes) {
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


}
