class Suite extends Instalacao {
    public Suite(String id, String descricao, int capacidade, double preco) {
        super(id, descricao, capacidade, preco);
    }

    @Override
    public String toString() {
        return ":: " + id + ":: R$" + preco + " (diária padrão) :: máx " + capacidade + " pessoas ::\n"
                + "== " + descricao + " ==";
    }
}