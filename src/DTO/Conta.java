package DTO;
import java.util.ArrayList;
import java.util.Date;

public abstract class Conta {
    protected ArrayList<Cliente> clientes;
    protected long idAgencia;
    protected Date criacao;
    protected double saldo;
    protected ArrayList<Registro> registros;
    protected long id;
    
    private static long IDConta = 1;

    public Conta() {
    }
 
    public Conta( long idAgencia, double saldo) {
        
        this.idAgencia = idAgencia;
        this.criacao = new Date();
        this.saldo = saldo;
        this.registros = new ArrayList<>();
        this.id = Conta.IDConta++;
        this.clientes = new ArrayList<>();
        registros.add(new Registro(saldo));
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> cliente) {
        this.clientes = cliente;
    }

    public long getIdAgencia() {
        return this.idAgencia;
    }

    public void setIdAgencia(long idAgencia) {
        registros.add(new Registro(this.saldo));
        this.idAgencia = idAgencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Registro> getRegistro() {
        return this.registros;
    }

    public Date getCriacao() {
        return this.criacao;
    }
    
    public long getId() {
        return this.id;
    }

    public void atribuirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void atribuirCliente(ArrayList<Cliente> clientes){
        for(Cliente c : clientes){
            this.clientes.add(c);
        }
    }

    public Registro ultimoAcesso(){
        return registros.get(registros.size());
    }

    public ArrayList<Registro> getRegistros() {
        return this.registros;
    }
}
