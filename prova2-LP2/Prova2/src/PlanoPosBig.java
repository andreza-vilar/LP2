public class PlanoPosBig extends Plano {
    private double valorDia;

    public PlanoPosBig(Telefonia telefonia, double valorDia) {
        super();
        this.valorDia = valorDia;
    }

    public PlanoPosBig(String joanaCosta, String s, String number, double v) {
        super();
    }

    @Override
    public double valorAPagar(int numero_de_dias) {
        return valorDia * numero_de_dias;
    }
}
