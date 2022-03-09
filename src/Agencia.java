import java.util.ArrayList;

public class Agencia {
    protected String cidade;
    protected String estado;
    protected String nome;
    protected long id;
    
    protected ArrayList<Emprestimo> emprestimos;

    public Agencia(String cidade, String estado, String nome) {
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
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
    
    public void realizarEmprestimo(ArrayList<Cliente> clientes, long id, double valor, int parcela){
        Emprestimo emprestimo = new Emprestimo(this, clientes, id, valor, parcela);
        this.emprestimos.add(emprestimo);

        for(Cliente c: clientes){
            c.getEmprestimos().add(emprestimo);
        }
    }
}
