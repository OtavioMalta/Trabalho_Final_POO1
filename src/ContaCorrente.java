import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente extends Conta{
    private double tarifa;
    private ArrayList<Operacao> operacoes;

    public ContaCorrente(long idAgencia, double saldo, double tarifa, long id) {
        super(idAgencia, saldo, id);
        this.tarifa = tarifa;
        this.operacoes = new ArrayList<>();
    }

    public double getTarifa() {
        super.acesso = new Date();
        return this.tarifa;
    }

    public void setTarifa(double tarifa) {
        super.acesso = new Date();
        this.tarifa = tarifa;
    }

    public void realizarOperacao(Tipo tipo, String descricao, double valor, Date data){
        super.acesso = new Date();
        Operacao operacao = new Operacao(tipo, descricao, valor, data, super.id);
        operacoes.add(operacao);
    }
}
