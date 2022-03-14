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
    public void imprimirConta() {
        System.out.println("ID ='" + getId() + "'\n" +
        "idAgencia='" + getIdAgencia() + "'\n" +
        "criacao='" + getCriacao() + "'\n" +
        "saldo='" + getSaldo() + "'\n" +
        "acesso='" + getRegistro().get(getRegistro().size()) + "'\n" +
        "juros='" + getJuros() + "'\n" +
        "idClientes=" );
        imprimirClientes();
    }
  
    public void imprimirClientes(){
        for(Cliente c: clientes){
            System.out.println(c.getId());
        }
    }

    
}
