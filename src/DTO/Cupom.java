package DTO;
import java.util.Date;
public class Cupom {
    private long numero;
    private Date validade;
    
    private static long IDCupom = 1;

    public Cupom( Date validade) {
        this.numero = Cupom.IDCupom++;
        this.validade = validade;
    }
    public long getNumero() {
        return this.numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    } 
    public Date getValidade() {
        return this.validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }


    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", validade='" + getValidade() + "'" +
            "}\n";
    }

}
