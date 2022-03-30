package DTO;
import java.util.Date;

import Util.Tipo;

public class Operacao {
    private Tipo tipo;
    private String descricao;
    private double valor;
    private Date data;
    private long id;

    private ContaCorrente conta;

    private static long IDOperacao = 1;
 

    public Operacao(Tipo tipo, String descricao, double valor, Date data, ContaCorrente conta) {
        this.id = Operacao.IDOperacao++;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    
        this.conta = conta;
     }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public ContaCorrente getConta() {
        return this.conta;
    }

    @Override
    public String toString() {
        return "{" +
            "tipo='" + getTipo() + "'" +
            "\ndescricao='" + getDescricao() + "'" +
            "\nvalor='" + getValor() + "'" +
            "\ndata='" + getData() + "'" +
            "\nid='" + getId() + "'" +
            "}\n";
    }

}
