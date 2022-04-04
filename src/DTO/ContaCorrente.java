package DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ParametroInvalidoException;
import Util.SaldoInsuficienteException;
import Util.SemDadosException;
import Util.Tipo;

public class ContaCorrente extends Conta{
    private double tarifa;
    private ArrayList<Long> operacoes;
    private ArrayList<Long> cupons;

    public ContaCorrente(long idAgencia, double saldo, double tarifa) {
        super(idAgencia, saldo);
        this.tarifa = tarifa;
        this.operacoes = new ArrayList<>();
        this.cupons = new ArrayList<>();
    }

    public ContaCorrente(long id, long idAgencia, double saldo, double tarifa, ArrayList<Long> operacoes, ArrayList<Long> cupons, ArrayList<Long> registro, ArrayList<Integer> clientes, Date criacao) {
        super(idAgencia, saldo, criacao);
        this.id = id;
        this.tarifa = tarifa;
        this.operacoes = operacoes;
        this.cupons = cupons;
        this.operacoes = operacoes;
        this.clientes = clientes;
    }

    public double getTarifa() {
        return this.tarifa;
    }

    public void setTarifa(double tarifa) {
        Registro registro = new Registro(this.saldo, this.id);
        registro.salvar();
        idRegistros.add(registro.getId());
        registro.salvar();
        this.tarifa = tarifa;
    }


    public ArrayList<Long> getOperacoes() {
        return this.operacoes;
    }

    public void setOperacoes(ArrayList<Long> operacoes) {
        this.operacoes = operacoes;
    }

    // CRÉDITO RETIRA
    // DÉBITO ACRESCENTA
    public void realizarOperacao(Tipo tipo, String descricao, double valor){
        try{
            if(valor <=0){
                throw new ParametroInvalidoException("Valor deve ser maior que Zero!");
            }
            
            Operacao operacao = new Operacao(tipo, descricao, valor, this.getId());
            if(tipo.equals(Tipo.CREDITO)){
                if(valor > this.saldo){
                    throw new SaldoInsuficienteException("Saldo insuficiente");
                }else{
                    setSaldo(getSaldo() - valor);
                }
            }else if(tipo.equals(Tipo.DEBITO)){
                setSaldo(getSaldo() + valor);
            }
            if(valor>5000){
                geraCupom();
            }
            operacoes.add(operacao.getId());
            operacao.salvar();
    
            Registro registro = new Registro(this.saldo, this.id);
            idRegistros.add(registro.getId());
            registro.salvar();
        }catch (Exception e){
            System.err.println("ERRO AO REALIZAR OPERACAO!");
        }
    }
 
    public void geraCupom(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Cupom cupom = new Cupom(f.parse("25/05/2023"));
            cupons.add(cupom.getNumero());
            System.out.println("Cupom gerado com sucesso. Numero: " + cupom.getNumero()+"\n");
     
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Long> getCupons() {
        return this.cupons;
    }

    @Override
    public String toString() {
        return "{" +
            "\nidAgencia='" + getIdAgencia() + "'" +
            "\ncriacao='" + getCriacao() + "'" +
            "\nsaldo='" + getSaldo() + "'" +
            "\nregistros='" + getRegistros() + "'" +
            "\nid='" + getId() + "'" +
            "\ntarifa='" + getTarifa() + "'" +
            "\noperacoes='" + getOperacoes() + "'" +
            "\ncupons='" + getCupons() + "'" +
            "}\n";
    }

    @Override
    public ArrayList<ContaCorrente> lista() {
        String path = "repository\\contaC.txt";		
		ArrayList<ContaCorrente> list = new ArrayList<ContaCorrente>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");

                
                ArrayList<Long> operacoes = new ArrayList<>();
                ArrayList<Long> cupons = new ArrayList<>();
                ArrayList<Long> registros = new ArrayList<>();
                ArrayList<Integer> clientes = new ArrayList<>();

                String operacao[] = texto[4].replace("[", "").replace("]", "").split(", ");
                for(String s : operacao){
                    operacoes.add(Long.parseLong(s));
                }

                String cupom[] = texto[5].replace("[", "").replace("]", "").split(", ");
                for(String s : cupom){
                    cupons.add(Long.parseLong(s));
                }

                String registro[] = texto[9].replace("[", "").replace("]", "").split(", ");
                for(String s : registro){
                    registros.add(Long.parseLong(s));
                }

                String cliente[] = texto[6].replace("[", "").replace("]", "").split(", ");
                for(String s : cliente){
                    clientes.add(Integer.parseInt(s));
                }
                for(String s : operacao){
                    operacoes.add(Long.parseLong(s));
                }
                for(String s : cupom){
                    cupons.add(Long.parseLong(s));
                }
                for(String s : registro){
                    registros.add(Long.parseLong(s));
                }

                ContaCorrente contaCorrente = new ContaCorrente(Long.parseLong(texto[0]), Long.parseLong(texto[7]),Long.parseLong(texto[3]), Double.parseDouble(texto[2]), operacoes, cupons, registros, clientes, formatter.parse(texto[8]));
                list.add(contaCorrente);
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
            String path = "repository\\contaC.txt";
            String texto = getId() + "," +
            getSaldo() + "," +
            getTarifa() + "," +
            getSaldo() + "," +
            getOperacoes() + "," +
            getCupons() + "," +
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
