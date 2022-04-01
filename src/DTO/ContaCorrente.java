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
    private ArrayList<Operacao> operacoes;
    private ArrayList<Cupom> cupons;

    public ContaCorrente(long idAgencia, double saldo, double tarifa) {
        super(idAgencia, saldo);
        this.tarifa = tarifa;
        this.operacoes = new ArrayList<>();
        this.cupons = new ArrayList<>();
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


    public ArrayList<Operacao> getOperacoes() {
        return this.operacoes;
    }

    public void setOperacoes(ArrayList<Operacao> operacoes) {
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
            operacoes.add(operacao);
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
            cupons.add(cupom);
            System.out.println("Cupom gerado com sucesso. Numero: " + cupom.getNumero()+"\n");
     
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cupom> getCupons() {
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
                ContaCorrente contaCorrente = new ContaCorrente(Long.parseLong(texto[0]), Double.parseDouble(texto[1]),Double.parseDouble(texto[2]));
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
            String texto = getIdAgencia() + "," +
            getSaldo() + "," +
            getTarifa();
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    
}
