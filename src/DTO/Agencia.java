package DTO;
import java.util.ArrayList;

import Util.SaldoInsuficienteException;

public class Agencia {
    protected String cidade;
    protected String estado;
    protected String nome;
    protected long id;
    private static long IDAgencia = 1;
    
    protected ArrayList<Emprestimo> emprestimos;

    public Agencia(String cidade, String estado, String nome) {
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
        this.id = Agencia.IDAgencia++;
        this.emprestimos = new ArrayList<>();
 
    }
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void realizarEmprestimo(ArrayList<Cliente> clientes, double valor, int parcela){
       if(valor>0){
        Emprestimo emprestimo = new Emprestimo(this, clientes, valor, parcela);
        this.emprestimos.add(emprestimo);
        for(Cliente c: clientes){
            c.realizarEmprestimo(emprestimo);
        }
       }else{
           throw new SaldoInsuficienteException("Valor Inválido!");
       }
       
       
    }


    @Override
    public String toString() {
        return "{" +
            "cidade='" + getCidade() + "'" +
            "\nestado='" + getEstado() + "'" +
            "\nnome='" + getNome() + "'" +
            "\nid='" + getId() + "'" +
            "\nemprestimos='" + getEmprestimos() + "'" +
            "}\n";
    }
    
}
