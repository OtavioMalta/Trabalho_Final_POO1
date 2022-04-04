package DTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;

public class Cliente extends Pessoa implements ManipularArquivo{

    protected int id;
    protected String nome;
    protected String cpf;
    protected Date nascimento;
    protected String endereco;
    protected String cidade;
    protected String estado;
    protected ArrayList<Long> emprestimos;
    protected Long idGerente;
    protected ArrayList<Long> idContas;
    private static int IDCliente = 1;
    private ArrayList<Conta> conta;

    public Cliente(String nome, String cpf, Date nascimento, String endereco, String cidade, String estado, Long gerente) {
        super(nome);
        this.id = Cliente.IDCliente++;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.idContas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.idGerente = gerente;
        this.conta = new ArrayList<>();
    }

    public Cliente(int id,String nome, String cpf, Date nascimento, String endereco, String cidade, String estado, Long gerente, ArrayList<Long> emprestimos, ArrayList<Long> idContas) {
        super(nome);
        this.id = id;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.idContas = idContas;
        this.emprestimos = emprestimos;
        this.idGerente = gerente;
        
        this.conta = new ArrayList<>();
    } 
 
    public int getId() {
        return this.id;
    }
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return this.nascimento;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdGerente() {
        return this.idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }

    public ArrayList<Long> getIdContas() {
        return this.idContas;
    }

    
    public ArrayList<Conta> getConta() {
        return this.conta;
    }



    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Long> getEmprestimos() {
        return this.emprestimos;
    }

    public void setEmprestimos(ArrayList<Long> emprestimos) {
        this.emprestimos = emprestimos;
    }

   public Long getGerente() {
        return this.idGerente;
    }

    public void setGerente(Long gerente) {
        this.idGerente = gerente;
    }

    public ArrayList<Long> getidContas() {
        return this.idContas;
    }

    

    public void setidContas(ArrayList<Long> idContas) {
        this.idContas = idContas;
    }


    public void adicionarConta(Conta conta){
        try {
        this.conta.add(conta);
        idContas.add(conta.getId());
        conta.atribuirCliente(this.getId());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar conta!");
        }
    }

    protected void realizarEmprestimo(Long emprestimo){
        try{
            this.emprestimos.add(emprestimo);
        }catch (Exception e){
            e.getMessage();
    }
    }

    @Override
    public String toString() {
        return "{" +
            "id='" + getId() + "'" +
            "\nnome='" + getNome() + "'" +
            "\ncpf='" + getCpf() + "'" +
            "\nnascimento='" + getNascimento() + "'" +
            "\nendereco='" + getEndereco() + "'" +
            "\ncidade='" + getCidade() + "'" +
            "\nestado='" + getEstado() + "'" +
            "\nemprestimo='" + getEmprestimos() + "'" +
            "}\n";
    }

    @Override
    public void salvar() {
        try{
            String path = "repository\\clientes.txt";
            String texto = getId() + ";" +
            getNome() + ";" +
            getCpf() + ";" +
            getNascimento() + ";" +
            getEndereco() + ";" +
            getCidade() + ";" +
            getEstado() + ";"+
            getGerente() + ";"+
            getEmprestimos() + ";" +
            getidContas();
            System.out.println(texto);
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

    @Override
    public ArrayList<Cliente> lista() {
        String path = "repository\\clientes.txt";		
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(";");
                ArrayList<Long> idContas = new ArrayList<>();
                ArrayList<Long> emprestimos = new ArrayList<>();
                String emprestimo[] = texto[8].replace("[", "").replace("]", "").split(", ");
                String conta[] = texto[9].replace("[", "").replace("]", "").split(", ");
                for(String s : emprestimo){
                    emprestimos.add(Long.parseLong(s));
                }
                for(String s : conta){
                    idContas.add(Long.parseLong(s));
                }
                if(texto[7].equals("null")){
                    Cliente cliente = new Cliente(Integer.parseInt(texto[0]),texto[1], texto[2], formatter.parse(texto[3]), texto[4], texto[5], texto[6], 0l, emprestimos, idContas);
                    list.add(cliente);
                }else{
                    Cliente cliente = new Cliente(Integer.parseInt(texto[0]),texto[1], texto[2], formatter.parse(texto[3]), texto[4], texto[5], texto[6], Long.parseLong(texto[7]),emprestimos, idContas);
                    list.add(cliente);
                }
            }
        return list;
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            
            return list;
		}
	}

}
