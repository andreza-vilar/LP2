public abstract class Plano {
    private static int idCounter = 1;
    private int id;
    private Telefonia telefonia;
    private Adicional adicional;

    public Plano() {
        this.id = idCounter++;
        this.telefonia = telefonia;
        this.adicional = null;
    }

    public Plano(String joaoCampos, String s, String number, int valorExcedente, double v, double v1) {

    }

    public int getId() {
        return id;
    }

    public Telefonia getTelefonia() {
        return telefonia;
    }

    public Adicional getAdicional() {
        return adicional;
    }

    public void setAdicional(Adicional adicional) {
        this.adicional = adicional;
    }

    public abstract double valorAPagar(int numero_de_dias);

    public String exibirPlano() {
        StringBuilder builder = new StringBuilder();
        builder.append("Telefonia: ").append(telefonia);
        if (adicional != null) {
            builder.append(adicional.getDescricao());
        }
        return builder.toString();
    }
}
