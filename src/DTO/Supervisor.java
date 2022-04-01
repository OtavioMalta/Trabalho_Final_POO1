package DTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;

public class Supervisor extends Funcionario implements ManipularArquivo{

    public Supervisor(String nome, String telefone, ArrayList<Dependente> dependentes,
            Date admissao, Long agencia) {
        super( nome, telefone, dependentes, null, admissao, agencia);
    }

    public Supervisor(Long id, String nome, String telefone,
            Date admissao, Long agencia) {
        super(id, nome, telefone, null, admissao, agencia);
    }
    public Supervisor( String nome, String telefone,
        Date admissao, Long agencia) {
    super(nome, telefone, null, admissao, agencia);
    }
    
    @Override
    public ArrayList<Supervisor> lista() {
        String path = "repository\\Supervisor.txt";		
		ArrayList<Supervisor> list = new ArrayList<Supervisor>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                System.out.println(l);
                Supervisor Supervisor = new Supervisor(Long.parseLong(texto[0]),texto[1], texto[2], formatter.parse(texto[3]), Long.parseLong(texto[4]));
                list.add(Supervisor);
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
            String path = "repository\\Supervisor.txt";
            String texto = 
            getId()+","+
            getNome() + "," +
            getTelefone() + "," +
            getAdmissao() + "," +
            getIdAgencia();
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    

    
}
 