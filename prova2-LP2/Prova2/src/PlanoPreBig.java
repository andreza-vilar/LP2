public class PlanoPreBig extends Plano {
    private int franquia;
    private double valorInicial;
    private double valorExcedente;

    public PlanoPreBig(Telefonia telefonia, int franquia, double valorInicial, double valorExcedente) {
        super();
        this.franquia = franquia;
        this.valorInicial = valorInicial;
        this.valorExcedente = valorExcedente;
    }

    public PlanoPreBig(String joaoCampos, String s, String number, int valorExcedente, double v, double v1) {
    }

    @Override
    public double valorAPagar(int numero_de_dias) {
        if (numero_de_dias < 0) {
            throw new IllegalArgumentException("O número de dias não pode ser negativo");
        }
        if (numero_de_dias <= franquia) {
            return valorInicial;
        } else {
            int diasExcedentes = numero_de_dias - franquia;
            return diasExcedentes * valorExcedente;
        }
    }
}
