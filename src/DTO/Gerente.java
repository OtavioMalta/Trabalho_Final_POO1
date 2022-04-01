package DTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Util.Arquivo;
import Util.ManipularArquivo;
import Util.SemDadosException;

public class Gerente extends Funcionario implements ManipularArquivo{

    public Gerente( String nome, String telefone, ArrayList<Dependente> dependentes, Long supervisor,
            Date admissao, Long agencia) {
        super( nome, telefone, dependentes, supervisor, admissao, agencia);
        
    }
    public Gerente( Long id,String nome, String telefone, Long supervisor,
            Date admissao, Long agencia) {
        super( id,nome, telefone, supervisor, admissao, agencia);
        
    }
    public Gerente(String nome, String telefone, Long supervisor,
            Date admissao, Long agencia) {
        super( nome, telefone, supervisor, admissao, agencia);

}


    @Override
    public ArrayList<Gerente> lista() {
        String path = "repository\\gerentes.txt";		
		ArrayList<Gerente> list = new ArrayList<Gerente>();
		SimpleDateFormat formatter = new  SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);

        try{
            String conteudo =Arquivo.Read(path);
            String linhas[] = conteudo.split("\n");
            if(conteudo == ""){
                throw new SemDadosException("Dados não encotrados!");
            }
            for(String l : linhas){
                String texto[] = l.split(",");
                Gerente Gerente = new Gerente(Long.parseLong(texto[0]), texto[1], texto[2], Long.parseLong(texto[3]), formatter.parse(texto[4]), Long.parseLong(texto[5]));
                list.add(Gerente);
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
            String path = "repository\\gerentes.txt";
            String texto = 
            getId()+","+
            getNome() + "," +
            getTelefone() + "," +
            getIdSupervisor()  + "," +
            getAdmissao() + "," +
            getIdAgencia();
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
    
}
  