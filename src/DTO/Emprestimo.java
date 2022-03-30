package DTO;
import java.util.ArrayList;


public class Emprestimo {
    private Agencia agencia;
    private ArrayList<Cliente> clientes;
    private long id;
    private double valor;
    private int parcela;
    private static long IDEmprestimo = 1;

    public Emprestimo(Agencia agencia, ArrayList<Cliente> clientes, double valor, int parcela) {
        this.agencia = agencia;
        this.clientes = clientes;
        this.id = Emprestimo.IDEmprestimo++;
        this.valor = valor;
        this.parcela = parcela;
    }


 
    public Agencia getAgencia() {
        return this.agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcela() {
        return this.parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    @Override
    public String toString() {
        return "{" +
            "clientes='" + getClientes() + "'" +
            "\nid='" + getId() + "'" +
            "\nvalor='" + getValor() + "'" +
            "\nparcela='" + getParcela() + "'" +
            "}\n";
    }
    
}
