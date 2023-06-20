public class Telefonia {
    private String nome;
    private String cpf;
    private String numeroTelefone;

    public Telefonia(String nome, String cpf, String numeroTelefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;
    }

    public Telefonia(String joanaCosta, String cpf, String number, int i) {

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    @Override
    public String toString() {
        return "Telefonia: [nome=" + nome + ", cpf=" + cpf + ", telefone=" + numeroTelefone + "]";
    }
}
