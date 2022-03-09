package DTO;
import java.util.ArrayList;

import Util.GeradorId;

public class Agencia {
    protected String cidade;
    protected String estado;
    protected String nome;
    protected long id;
    protected static GeradorId gId = new GeradorId();
    
    protected ArrayList<Emprestimo> emprestimos;

    public Agencia(String cidade, String estado, String nome) {
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
        this.id = gId.gerarIdAgencia();
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
       
        Emprestimo emprestimo = new Emprestimo(this, clientes, valor, parcela);
        this.emprestimos.add(emprestimo);

        for(Cliente c: clientes){
            c.realizarEmprestimo(emprestimo);
        }
    }

    public void imprimirAgencia(){
        System.out.println("cidade= '" + getCidade() + "'\n"+
        "estado= '" + getEstado() + "'\n"+
        "nome= '" + getNome() + "'\n"+
        "id= '" + getId() + "'\n");
    }
}
