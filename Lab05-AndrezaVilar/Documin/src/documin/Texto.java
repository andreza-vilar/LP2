package documin;

import java.util.HashMap;


public class Texto implements Elemento {
    private String valor;
    private int prioridade;
    @SuppressWarnings("unused")
    private HashMap<String, String> propriedades;

    /**
     * Cria uma instância de Texto com os atributos especificados.
     *
     * @param valor O valor do texto.
     * @param prioridade A prioridade do texto.
     */
    public Texto(String valor, int prioridade) {
        this.propriedades = new HashMap<>();
        this.valor = valor;
        this.prioridade = prioridade;
    }

    /**
     * retorna a representação completa do texto
     *
     * @return representação completa do texto
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        return this.valor;
    }

    /**
     * retorna a representação resumida do texto
     *
     * @return representação resumida do texto
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return this.valor;
    }

    /**
     * retorna a prioridade do texto
     *
     * @return prioridade do texto
     */
    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}