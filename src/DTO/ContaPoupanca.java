package DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.SemDadosException;

public class ContaPoupanca extends Conta{
    private double juros;

    public ContaPoupanca( long idAgencia, double saldo, double juros) {
        super(idAgencia, saldo);
        this.juros = juros;
    }

    public ContaPoupanca(long id, long idAgencia, double saldo, double juros, ArrayList<Long> registro, ArrayList<Integer> clientes, Date criacao) {
        super(idAgencia, saldo, criacao);
        this.id = id;
        this.juros = juros;
        this.clientes = clientes;
    }

    public double getJuros() {
        return this.juros;
    }

    public void setJuros(double juros) {
        Registro registro = new Registro(this.saldo, this.id);
        idRegistros.add(registro.getId());
        registro.salvar();
        this.juros = juros;
    }
    
    @Override
    public String toString() {
        return "{" +
            "clientes='" + getClientes() + "'" +
            "\nidAgencia='" + getIdAgencia() + "'" +
            "\ncriacao='" + getCriacao() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "\nregistros='" + getRegistros() + "'" +
            "\nid='" + getId() + "'" +
            "\njuros='" + getJuros() + "'" +
            "}\n";
    }

    @Override
    public ArrayList<ContaPoupanca> lista() {
        String path = "repository\\contaC.txt";		
		ArrayList<ContaPoupanca> list = new ArrayList<ContaPoupanca>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");

                ArrayList<Long> registros = new ArrayList<>();
                ArrayList<Integer> clientes = new ArrayList<>();

                

                String registro[] = texto[9].replace("[", "").replace("]", "").split(", ");
                for(String s : registro){
                    registros.add(Long.parseLong(s));
                }

                String cliente[] = texto[6].replace("[", "").replace("]", "").split(", ");
                for(String s : cliente){
                    clientes.add(Integer.parseInt(s));
                }
               
                for(String s : registro){
                    registros.add(Long.parseLong(s));
                }

                ContaPoupanca contaPoupanca = new ContaPoupanca(Long.parseLong(texto[0]),Long.parseLong(texto[4]), Double.parseDouble(texto[2]), Double.parseDouble(texto[1]), registros, clientes, formatter.parse(texto[5]));
                list.add(contaPoupanca);
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
            String path = "repository\\contaP.txt";
            String texto = getId() + "," +
            getJuros() + "," +
            getSaldo() + "," +
            getClientes() + "," +
            getIdAgencia() + "," +
            getCriacao() + "," +
            getRegistros();
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    

    

    
}
