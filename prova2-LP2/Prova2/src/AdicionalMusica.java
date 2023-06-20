public class AdicionalMusica extends Adicional {
    private String servico;

    public AdicionalMusica(String nome, String servico) {
        super(nome);
        this.servico = servico;
    }

    @Override
    public double getValorDoAdicional(int numero_de_dias) {
        return 25.0 + numero_de_dias;
    }

    @Override
    public String getDescricao() {
        return "Musica: [nome=" + nome + ", servico=" + servico + "]";
    }
}
