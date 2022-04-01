package DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;

public class Registro implements ManipularArquivo{
    private Long idConta;
    private Date data;
    private Double saldo;
    private Long id;

    private static long IDRegistro = System.nanoTime();

    public Registro(Double saldo, Long idConta) {
        this.id = IDRegistro;
        this.data = new Date();
        this.saldo = saldo;
        this.idConta = idConta;
    }
    public Registro(Long id, Double saldo, Long idConta, Date data) {
        this.id = id;
        this.data = data;
        this.saldo = saldo;
        this.idConta = idConta;
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


    public Long getIdConta() {
        return this.idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "}\n";
    }

    @Override
    public ArrayList<Registro> lista() {
        String path = "repository\\registros.txt";		
		ArrayList<Registro> list = new ArrayList<Registro>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                Registro registro = new Registro(Long.parseLong(texto[0]), Double.parseDouble(texto[1]), Long.parseLong(texto[2]), formatter.parse(texto[3]));
                list.add(registro);
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
            String path = "repository\\registros.txt";
            String texto = getId() + "," +
            getSaldo() + "," +
            getIdConta() + "," +
            getData();
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    

}
