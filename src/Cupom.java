import java.util.Date;

public class Cupom {
    protected long numero;
    protected Date validade;
    protected static GeradorId gId = new GeradorId();

    public Cupom( Date validade) {
        this.numero = gId.gerarIdCupom();
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

}
