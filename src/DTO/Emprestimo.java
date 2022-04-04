package DTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;
import Util.Tipo;


public class Emprestimo implements ManipularArquivo{
    private Long agencia;
    private Integer cliente;
    private long id;
    private double valor;
    private int parcela;
    private static long IDEmprestimo =System.nanoTime();

    public Emprestimo(Long agencia, Integer clientes, double valor, int parcela) {


        this.agencia = agencia;
        this.id = Emprestimo.IDEmprestimo++;
        this.valor = valor;
        this.parcela = parcela;
        this.cliente=  clientes;
    }

    public Emprestimo(Long id, Long agencia,int parcela, double valor, Integer cliente) {
        this.agencia = agencia;
        this.id = id;
        this.valor = valor;
        this.parcela = parcela;
        this.cliente = cliente;
    }

    public Long getAgencia() {
        return this.agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }
 
    

    public Integer getClientes() {
        return this.cliente;
    }

    public void setClientes(Integer clientes) {
        this.cliente = clientes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcela() {
        return this.parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    @Override
    public String toString() {
        return "{" +
            "clientes='" + getClientes() + "'" +
            "\nid='" + getId() + "'" +
            "\nvalor='" + getValor() + "'" +
            "\nparcela='" + getParcela() + "'" +
            "}\n";
    }
    @Override
    public ArrayList<Emprestimo> lista() {
        String path = "repository\\emprestimos.txt";		
		ArrayList<Emprestimo> list = new ArrayList<Emprestimo>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                Emprestimo emprestimo = new Emprestimo(Long.parseLong(texto[0]),Long.parseLong(texto[1]),  Integer.parseInt(texto[2]),Double.parseDouble(texto[3]), Integer.parseInt(texto[4]));
               list.add(emprestimo);
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
            String path = "repository\\emprestimos.txt";
            String texto = getId() + "," +
            getAgencia() + "," +
            getParcela() +","+
            getValor() +","+
            getClientes()
            ;
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
}
