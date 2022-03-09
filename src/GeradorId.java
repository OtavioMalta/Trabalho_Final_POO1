public class GeradorId {
    private static long IDCliente = 0;
    private static long IDConta = 0;
    private static long IDEmprestimo = 0;
    private static long IDFuncionario = 0;
    private static long IDOperacao = 0;

    private static long IDAgencia = 0;

    public GeradorId() {
    }

    public long gerarIdCliente(){
        return IDCliente++;
    }

    public long gerarIdConta(){
        return IDConta++;
    }

    public long gerarIdEmprestimo(){
        return IDEmprestimo++;
    }

    public long gerarIdFuncionario(){
        return IDFuncionario++;
    }

    public long gerarIdOperacao(){
        return IDOperacao;
    }

    public long gerarIdAgencia(){
        return IDAgencia++;
    }
    
}
