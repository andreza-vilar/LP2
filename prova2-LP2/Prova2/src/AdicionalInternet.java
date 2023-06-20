public class AdicionalInternet extends Adicional {
    private int mega;

    public AdicionalInternet(String nome, int mega) {
        super(nome);
        this.mega = mega;
    }

    @Override
    public double getValorDoAdicional(int numero_de_dias) {
        return mega * 0.05 * numero_de_dias;
    }

    @Override
    public String getDescricao() {
        return "Internet: [nome=" + nome + ", dados=" + mega + " Mega]";
    }
}
