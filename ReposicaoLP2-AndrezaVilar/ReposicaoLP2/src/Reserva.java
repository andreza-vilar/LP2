class Reserva {
    private static long nextId = 1;

    private long id;
    private Instalacao instalacao;
    private int quantidadeDiarias;
    private String nomeCliente;
    private String documentoCliente;
    private String tipoDeReserva;

    public Reserva(Instalacao instalacao, int quantidadeDiarias, String nomeCliente, String documentoCliente, String tipoDeReserva) {
        this.id = nextId++;
        this.instalacao = instalacao;
        this.quantidadeDiarias = quantidadeDiarias;
        this.nomeCliente = nomeCliente;
        this.documentoCliente = documentoCliente;
        this.tipoDeReserva = tipoDeReserva;
    }

    public long getId() {
        return id;
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public String getTipoDeReserva() {
        return tipoDeReserva;
    }

    public double calcularPrecoTotal() {
        double precoTotal = instalacao.getPreco() * quantidadeDiarias;
        if (tipoDeReserva.equals("Taxa Balcão")) {
            precoTotal *= 1.2;
        } else if (tipoDeReserva.equals("Premium")) {
            precoTotal *= 0.9;
        }
        return precoTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva nº ## ").append(id).append(" ##\n");
        sb.append("#### Dados da instalação ####\n");
        sb.append(instalacao.toString()).append("\n");
        sb.append("----------------------------\n");
        sb.append("Em favor de ").append(nomeCliente).append(", ").append(documentoCliente).append("\n");
        sb.append("#### Valor Total: R$").append(calcularPrecoTotal()).append(", ").append(quantidadeDiarias).append(" diária(s) ####");
        return sb.toString();
    }
}