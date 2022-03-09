public class GeradorId {
    private static long IDCliente = 1;
    private static long IDConta = 1;
    private static long IDEmprestimo = 1;
    private static long IDFuncionario = 1;
    private static long IDOperacao = 1;
    private static long IDCupom = 1;
    private static long IDAgencia = 1;

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

    public long gerarIdCupom(){
        return IDCupom++;
    }
    
}
