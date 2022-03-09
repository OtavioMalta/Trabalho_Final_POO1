import java.util.ArrayList;
import java.util.Date;

public abstract class Conta {
    protected ArrayList<Cliente> clientes;
    protected long idAgencia;
    protected Date criacao;
    protected double saldo;
    protected Date acesso;
    protected long id;
    public Conta() {
    }

    public Conta( long idAgencia, double saldo, long id) {
        
        this.idAgencia = idAgencia;
        this.criacao = new Date();
        this.saldo = saldo;
        this.acesso = new Date();
        this.id = id;
        this.clientes = new ArrayList<>();
    }


    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> cliente) {
        acesso = new Date();

        this.clientes = cliente;
    }

    public long getIdAgencia() {
        acesso = new Date();
        return this.idAgencia;
    }

    public void setIdAgencia(long idAgencia) {
        acesso = new Date();
        this.idAgencia = idAgencia;
    }

    public double getSaldo() {
        acesso = new Date();
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        acesso = new Date();
        this.saldo = saldo;
    }

    public Date getAcesso() {
        acesso = new Date();
        return this.acesso;
    }
    public Date getCriacao() {
        return this.criacao;
    }


    public long getId() {
        return this.id;
    }

    public void atribuirCliente(Cliente cliente){
        acesso = new Date();
        clientes.add(cliente);
    }

    public void atribuirCliente(ArrayList<Cliente> clientes){
        acesso = new Date();
        for(Cliente c : clientes){
            this.clientes.add(c);
            c.adicionarConta(this);
        }
    }

    @Override
    public String toString() {
        return "{" +
            ", idAgencia='" + getIdAgencia() + "'" +
            ", criacao='" + getCriacao() + "'" +
            ", saldo='" + getSaldo() + "'" +
            ", acesso='" + getAcesso() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }



   

}
