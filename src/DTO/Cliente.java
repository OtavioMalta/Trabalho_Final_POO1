package DTO;
import java.util.ArrayList;
import java.util.Date;

import Util.GeradorId;

public class Cliente extends Pessoa{
    protected long id;
    protected String nome;
    protected String cpf;
    protected Date nascimento;
    protected String endereco;
    protected String cidade;
    protected String estado;
    protected ArrayList<Emprestimo> emprestimos;
    //protected Gerente gerente;
    protected ArrayList<Conta> contas;
    protected static GeradorId gId = new GeradorId();

    public Cliente(String nome, String cpf, Date nascimento, String endereco, String cidade, String estado) {
        super(nome);
        this.id = gId.gerarIdCliente();
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.contas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        //this.gerente = gerente;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

   /* public Gerente getGerente() {
        return this.gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }*/

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void imprimirContas(){
        
        for(Conta c: contas){
            System.out.println("--------------");
            c.imprimirConta();
        }
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }


    public void adicionarConta(Conta conta){
        contas.add(conta);
        conta.atribuirCliente(this);
    }

    public void adicionarContas(ArrayList<Conta> contas){
        for(Conta c: contas){
            this.contas.add(c);
            c.atribuirCliente(this);
        }
    }

    public void realizarEmprestimo(Emprestimo emprestimo){
        this.emprestimos.add(emprestimo);
    }

    public void imprimirCliente() {
        System.out.println("id='" + getId() + "'\n" +
            "nome='" + getNome() + "'\n" +
            "cpf='" + getCpf() + "'\n" +
            "nascimento='" + getNascimento() + "'\n" +
            "endereco='" + getEndereco() + "'\n" +
            "cidade='" + getCidade() + "'\n" +
            "estado='" + getEstado() + "'\n" +
            "emprestimos="
        );
        imprimirEmprestimo();
        System.out.println("contas=");
        imprimirContas();
            
    }

    public void imprimirEmprestimo(){
        for(Emprestimo e: emprestimos){
            System.out.println("--------------");
            e.imprimirEmprestimo();
        }
    }


}
