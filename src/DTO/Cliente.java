package DTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    protected Long id;
    protected String nome;
    protected String cpf;
    protected Date nascimento;
    protected String endereco;
    protected String cidade;
    protected String estado;
    protected ArrayList<Long> emprestimos;
    protected Long idGerente;
    protected ArrayList<Conta> contas;
    private static Long IDCliente = 1L;

    public Cliente(String nome, String cpf, Date nascimento, String endereco, String cidade, String estado) {
        super(nome);
        this.id = Cliente.IDCliente++;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.contas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Cliente(String nome, String cpf, Date nascimento, String endereco, String cidade, String estado, Long gerente) {
        super(nome);
        this.id = Cliente.IDCliente++;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.contas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.idGerente = gerente;
    } 
 
    public Long getId() {
        return this.id;
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

    public ArrayList<Long> getEmprestimos() {
        return this.emprestimos;
    }

    public void setEmprestimos(ArrayList<Long> emprestimos) {
        this.emprestimos = emprestimos;
    }

   public Long getGerente() {
        return this.idGerente;
    }

    public void setGerente(Long gerente) {
        this.idGerente = gerente;
    }

    public ArrayList<Conta> getcontas() {
        return this.contas;
    }

    

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }


    public void adicionarConta(Conta conta){
        contas.add(conta);
        conta.atribuirCliente(this);
    }

    public void adicionarContas(ArrayList<Conta> contas){
        try{
            for(Conta c: contas){
                this.contas.add(c);
                c.atribuirCliente(this);
            }    
        }catch (Exception e){
            e.getMessage();
    }
    }

    public void realizarEmprestimo(Long emprestimo){
        try{
            this.emprestimos.add(emprestimo);
        }catch (Exception e){
            e.getMessage();
    }
    }

    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            "\nnome='" + getNome() + "'" +
            "\ncpf='" + getCpf() + "'" +
            "\nnascimento='" + getNascimento() + "'" +
            "\nendereco='" + getEndereco() + "'" +
            "\ncidade='" + getCidade() + "'" +
            "\nestado='" + getEstado() + "'" +
            "}\n";
    }
   


}
