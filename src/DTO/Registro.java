package DTO;

import java.util.Date;

public class Registro {
    private Date data;
    private Double saldo;

    public Registro(Double saldo) {
        this.data = new Date();
        this.saldo = saldo;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "}\n";
    }
    

}
