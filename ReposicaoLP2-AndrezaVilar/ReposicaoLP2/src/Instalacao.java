abstract class Instalacao {
    protected String id;
    protected String descricao;
    protected int capacidade;
    protected double preco;

    public Instalacao(String id, String descricao, int capacidade, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.preco = preco;
    }

    public String getId() {
        return id; 
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public String toString(){
        return ":: " + id + ":: R$" + preco + " (diária padrão) :: máx " + capacidade + " pessoas ::\n"
                + "== " + descricao + " ==";
    }
}
