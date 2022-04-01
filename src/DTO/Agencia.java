package DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SaldoInsuficienteException;
import Util.SemDadosException;

public class Agencia implements ManipularArquivo {
    protected String cidade;
    protected String estado;
    protected String nome;
    protected long id;
    private static long IDAgencia = System.nanoTime();

    protected ArrayList<Emprestimo> emprestimos;

    public Agencia(String cidade, String estado, String nome) {
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
        this.id = Agencia.IDAgencia++;
        this.emprestimos = new ArrayList<>();
    }

    
    public Agencia(Long id, String cidade, String estado, String nome) {
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
        this.id = id;
        this.emprestimos = new ArrayList<>();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void realizarEmprestimo(Cliente cliente, double valor, int parcela) {
        if (valor > 0) {
            Emprestimo emprestimo = new Emprestimo(this.id, cliente.getId(), valor, parcela);
            this.emprestimos.add(emprestimo);
            cliente.realizarEmprestimo(emprestimo.getId());
            emprestimo.salvar();
        } else {
            throw new SaldoInsuficienteException("Valor Inválido!");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "cidade='" + getCidade() + "'" +
                "\nestado='" + getEstado() + "'" +
                "\nnome='" + getNome() + "'" +
                "\nid='" + getId() + "'" +
                "\nemprestimos='" + getEmprestimos() + "'" +
                "}\n";
    }

    @Override
    public void salvar() {
        try{
            String path = "repository\\agencia.txt";
            String texto = getId() + "," +
            getNome() + "," +
            getCidade() + "," +
            getEstado();
            
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

    @Override
    public ArrayList<Agencia> lista() {
        String path = "repository\\agencia.txt";		
		ArrayList<Agencia> list = new ArrayList<Agencia>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                Agencia agencia= new Agencia(Long.parseLong(texto[0]), texto[2], texto[3], texto[1]);
                list.add(agencia);
               
            }
            
        return list;
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            
            return list;
		}
	}

}
