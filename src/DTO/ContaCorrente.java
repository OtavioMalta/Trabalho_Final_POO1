package DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Util.SaldoInsuficienteException;
import Util.Tipo;

public class ContaCorrente extends Conta{
    private double tarifa;
    private ArrayList<Operacao> operacoes;
    private ArrayList<Cupom> cupons;

    public ContaCorrente(long idAgencia, double saldo, double tarifa) {
        super(idAgencia, saldo);
        this.tarifa = tarifa;
        this.operacoes = new ArrayList<>();
        this.cupons = new ArrayList<>();
    }

    public double getTarifa() {
        return this.tarifa;
    }

    public void setTarifa(double tarifa) {
        registros.add(new Registro(this.saldo));
        this.tarifa = tarifa;
    }


    public ArrayList<Operacao> getOperacoes() {
        return this.operacoes;
    }

    public void setOperacoes(ArrayList<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public void realizarOperacao(Tipo tipo, String descricao, double valor, Date data){
        if((valor *-1) > this.saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }else{
            setSaldo(getSaldo() + valor);
        }
        Operacao operacao = new Operacao(tipo, descricao, valor, data, this);
        if(valor>5000){
            geraCupom();
        }
        operacoes.add(operacao);
        registros.add(new Registro(this.saldo));
    }
 
    public void geraCupom(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Cupom cupom = new Cupom(f.parse("25/05/2023"));
            cupons.add(cupom);
            System.out.println("Cupom gerado com sucesso. Numero: " + cupom.getNumero()+"\n");
     
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cupom> getCupons() {
        return this.cupons;
    }

    @Override
    public String toString() {
        return "{" +
            "\nidAgencia='" + getIdAgencia() + "'" +
            "\ncriacao='" + getCriacao() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "\nregistros='" + getRegistros() + "'" +
            "\nid='" + getId() + "'" +
            "\ntarifa='" + getTarifa() + "'" +
            "\noperacoes='" + getOperacoes() + "'" +
            "\ncupons='" + getCupons() + "'" +
            "}\n";
    }
    
    
}
