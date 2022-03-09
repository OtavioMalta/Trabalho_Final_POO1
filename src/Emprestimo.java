import java.util.ArrayList;

public class Emprestimo {
    protected Agencia agencia;
    protected ArrayList<Cliente> clientes;
    protected long id;
    protected double valor;
    protected int parcela;
    protected static GeradorId gId = new GeradorId();

    public Emprestimo(Agencia agencia, ArrayList<Cliente> clientes, double valor, int parcela) {
        this.agencia = agencia;
        this.clientes = clientes;
        this.id = gId.gerarIdEmprestimo();
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

}
