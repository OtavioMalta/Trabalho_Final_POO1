import java.util.ArrayList;
import java.util.Date;

public abstract class Conta {
    protected ArrayList<Cliente> clientes;
    protected long idAgencia;
    protected Date criacao;
    protected double saldo;
    protected Date acesso;
    protected long id;
    protected static GeradorId gId = new GeradorId();

    
    public Conta() {
    }

    public Conta( long idAgencia, double saldo) {
        
        this.idAgencia = idAgencia;
        this.criacao = new Date();
        this.saldo = saldo;
        this.acesso = new Date();
        this.id = gId.gerarIdConta();
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
        }
    }

    
    public abstract void imprimirConta();



   

}
