package DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import DTO.Cliente;
import Util.Arquivo;
import Util.SemDadosException;

public class ClienteDAO {


    public ClienteDAO() {
    }


    public void salvar(Cliente cliente){
        try{
            String path = "repository\\clientes.txt";
            
            String texto = cliente.getId() + "," +
            cliente.getNome() + "," +
            cliente.getCpf() + "," +
            cliente.getNascimento() + "," +
            cliente.getEndereco() + "," +
            cliente.getCidade() + "," +
            cliente.getEstado() + ","+
            cliente.getEmprestimos() + "," +
            cliente.getGerente();
            
            Arquivo.Write(path, texto);
        }
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

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
                String texto[] = l.split(",");
                if(texto[8].equals("null")){
                    Cliente cliente = new Cliente(texto[1], texto[2], formatter.parse(texto[3]), texto[4], texto[5], texto[6], 0l);
                    list.add(cliente);
                }else{
                    Cliente cliente = new Cliente(texto[1], texto[2], formatter.parse(texto[3]), texto[4], texto[5], texto[6], Long.parseLong(texto[8]));
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
