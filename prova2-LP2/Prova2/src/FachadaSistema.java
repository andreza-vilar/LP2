import java.util.ArrayList;
public class FachadaSistema {
    private ArrayList<Plano> planos;
    private ArrayList<Adicional> adicionais;
    private int proximoIdPlano;
    private int proximoIdAdicional;
    public FachadaSistema() {
        this.planos = new ArrayList<>();
        this.adicionais = new ArrayList<>();
        this.proximoIdPlano = 1;
        this.proximoIdAdicional = 1;
    }

    public int cadastrarPlanoPreBig(String nome, String cpf, String numeroTelefone, int franquia, double valorInicial, double valorExcedente) {
        if (nome == null || cpf == null || numeroTelefone == null) {
            throw new IllegalArgumentException("Os parâmetros não podem ser nulos");
        }

        Telefonia telefonia = new Telefonia(nome, cpf, numeroTelefone);
        PlanoPreBig plano = new PlanoPreBig(telefonia, franquia, valorInicial, valorExcedente);
        int id = proximoIdPlano++;
        planos.get(id);

        return id;
    }

    public int cadastrarPlanoPosBig(String nome, String cpf, String numeroTelefone, double valorDia)
            throws IllegalArgumentException {
        if (nome == null || nome.isEmpty() || cpf == null || cpf.isEmpty() || numeroTelefone == null || numeroTelefone.isEmpty()) {
            throw new IllegalArgumentException("Dados do plano de telefonia inválidos");
        }

        Telefonia telefonia = new Telefonia(nome, cpf, numeroTelefone);
        PlanoPosBig planoPosBig = new PlanoPosBig(telefonia, valorDia);
        planos.get(planoPosBig.getId());

        return planoPosBig.getId();
    }

    public double valorAPagar(int id, int numero_de_dias) throws IllegalArgumentException {
        Plano plano = planos.get(id);
        if (plano == null) {
            throw new IllegalArgumentException("ID do plano de telefonia inválido");
        }
        return plano.valorAPagar(numero_de_dias);
    }

    public String exibirPlano(int id) throws IllegalArgumentException {
        Plano plano = planos.get(id);
        if (plano == null) {
            throw new IllegalArgumentException("ID do plano de telefonia inválido");
        }
        return plano.exibirPlano();
    }

    public int cadastrarAdicionalInternet(String adInternet, int mega) throws IllegalArgumentException {
        if (adInternet == null || adInternet.isEmpty() || mega <= 0) {
            throw new IllegalArgumentException("Dados do adicional de internet inválidos");
        }

        AdicionalInternet adicionalInternet = new AdicionalInternet(adInternet, mega);
        adicionais.get(adicionalInternet.getId());

        return adicionalInternet.getId();
    }

    public int cadastrarAdicionalMusica(String adMusica, String servico) throws IllegalArgumentException {
        if (adMusica == null || adMusica.isEmpty() || servico == null || servico.isEmpty()) {
            throw new IllegalArgumentException("Dados do adicional de música inválidos");
        }

        if (!servico.equals("Spotify") && !servico.equals("Deezer")) {
            throw new IllegalArgumentException("Serviço de música inválido");
        }

        AdicionalMusica adicionalMusica = new AdicionalMusica(adMusica, servico);
        adicionais.get(adicionalMusica.getId());

        return adicionalMusica.getId();
    }

    public void setAdicional(int idPlano, int idAdicional) throws IllegalArgumentException {
        Plano plano = planos.get(idPlano);
        if (plano == null) {
            throw new IllegalArgumentException("ID do plano de telefonia inválido");
        }

        Adicional adicional = adicionais.get(idAdicional);
        if (adicional == null) {
            throw new IllegalArgumentException("ID do adicional inválido");
        }

        plano.setAdicional(adicional);
    }
}
