public abstract class Adicional {
    protected static int idCounter = 1;
    protected int id;
    protected String nome;

    public Adicional(String nome) {
        this.id = idCounter++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public abstract double getValorDoAdicional(int numero_de_dias);

    public abstract String getDescricao();
}
