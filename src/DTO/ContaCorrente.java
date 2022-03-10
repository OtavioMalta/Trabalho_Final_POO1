package DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        super.acesso = new Date();
        return this.tarifa;
    }

    public void setTarifa(double tarifa) {
        super.acesso = new Date();
        this.tarifa = tarifa;
    }


    public ArrayList<Operacao> getOperacoes() {
        return this.operacoes;
    }

    public void setOperacoes(ArrayList<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public void realizarOperacao(Tipo tipo, String descricao, double valor, Date data){
        super.acesso = new Date();
        Operacao operacao = new Operacao(tipo, descricao, valor, data, this);
        if(valor>5000){
            geraCupom();
        }
        operacoes.add(operacao);
    }
 
    public void geraCupom(){
        
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Cupom cupom = new Cupom(f.parse("25/05/2023"));
            adicionarCupom(cupom);
            System.out.println("Cupom gerado com sucesso. Numero: " + cupom.getNumero());
     
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void adicionarCupom(Cupom c){
        cupons.add(c);
    }

    @Override
    public void imprimirConta() {
        System.out.println("------------------\n"+
        "ID ='" + getId() + "'\n" +
        "idAgencia='" + getIdAgencia() + "'\n" +
        "criacao='" + getCriacao() + "'\n" +
        "saldo='" + getSaldo() + "'\n" +
        "acesso='" + getAcesso() + "'\n" +
        "tarifa='" + getTarifa() + "'\n" +
        "operacoes=");
        imprimirOperacoes();
        System.out.println("idClientes=");
        imprimirClientes();
    }

    private void imprimirOperacoes() {
        for(Operacao o : operacoes){
            o.imprimirOperacao();
        }
    }

      
    public void imprimirClientes(){
        for(Cliente c: clientes){
            System.out.println(c.getId());
        }
    }
}
