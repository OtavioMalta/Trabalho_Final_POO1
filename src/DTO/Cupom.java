package DTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;
public class Cupom implements ManipularArquivo {
    private long numero;
    private Date validade;
    
    private static long IDCupom = System.nanoTime();

    public Cupom( Date validade) {
        this.numero = Cupom.IDCupom++;
        this.validade = validade;
    }

    public Cupom(long numero, Date validade) {
        this.numero = numero;
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
    @Override
    public void salvar() {
        try{
            String path = "repository\\cupons.txt";
            String texto = getNumero() + "," +
            getValidade()
            ;
            
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

    @Override
    public ArrayList<Cupom> lista() {
        String path = "repository\\agencia.txt";		
		ArrayList<Cupom> list = new ArrayList<Cupom>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            
            for(String l : linhas){
                String texto[] = l.split(",");
                    
                Cupom cupom = new Cupom(Long.parseLong(texto[0]) , formatter.parse(texto[1]));
                list.add(cupom);
               
            }
            
        return list;
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            
            return list;
		}
    }
}
