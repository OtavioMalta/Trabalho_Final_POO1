package DTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;
import Util.Tipo;

public class Operacao implements ManipularArquivo{
    private Tipo tipo;
    private String descricao;
    private double valor;
    private Date data;
    private long id;

    private Long conta;

    private static long IDOperacao = 1;
 

    public Operacao(Tipo tipo, String descricao, double valor, Long conta) {
        this.id = Operacao.IDOperacao++;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = new Date();
    
        this.conta = conta;
     }

     public Operacao(Long id, Tipo tipo, String descricao, double valor, Date data, Long conta) {
        this.id = id;
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


    public Long getConta() {
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

    @Override
    public ArrayList<Operacao> lista() {
        String path = "repository\\operacoes.txt";		
		ArrayList<Operacao> list = new ArrayList<Operacao>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                Tipo tipo;
                if(texto[1].equals("DEBITO")){
                    tipo = Tipo.DEBITO;
                }else{
                    tipo = Tipo.CREDITO;
                }
                Operacao operacao = new Operacao(Long.parseLong(texto[0]), tipo, texto[2], Double.parseDouble(texto[3]), formatter.parse(texto[4]), Long.parseLong(texto[5]));
                list.add(operacao);
            }
        return list;
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            return list;
		}
	}

    @Override
    public void salvar() {
        try{
            String path = "repository\\operacoes.txt";
            String texto = getId() + "," +
            getTipo() + "," +
            getDescricao() + "," +
            getValor() +","+
            getData() + "," +
            getConta()
            ;
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

}
