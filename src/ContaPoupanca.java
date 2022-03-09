import java.util.ArrayList;
import java.util.Date;

public class ContaPoupanca extends Conta{
    private double juros;

    public ContaPoupanca( long idAgencia, double saldo, Date acesso, double juros, long id) {
        super(idAgencia, saldo, id);
        this.juros = juros;
    }

    public double getJuros() {
        super.acesso = new Date();
        return this.juros;
    }

    public void setJuros(double juros) {
        
        super.acesso = new Date();
        this.juros = juros;
    }
  

    
}
