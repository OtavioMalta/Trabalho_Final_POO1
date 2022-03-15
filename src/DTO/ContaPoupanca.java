package DTO;

public class ContaPoupanca extends Conta{
    private double juros;

    public ContaPoupanca( long idAgencia, double saldo, double juros) {
        super(idAgencia, saldo);
        this.juros = juros;
    }

    public double getJuros() {
        return this.juros;
    }

    public void setJuros(double juros) {
        registros.add(new Registro(this.saldo));
        this.juros = juros;
    }
    
    @Override
    public String toString() {
        return "{" +
            "clientes='" + getClientes() + "'" +
            "\nidAgencia='" + getIdAgencia() + "'" +
            "\ncriacao='" + getCriacao() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "\nregistros='" + getRegistros() + "'" +
            "\nid='" + getId() + "'" +
            "\njuros='" + getJuros() + "'" +
            "}\n";
    }

   

    

    
}
