package documin;

import java.util.Arrays;
import java.util.HashMap;


public class Termo implements Elemento {
    private HashMap<String, String> propriedades;
    private int prioridade;
    private String valor;
    @SuppressWarnings("unused")
    private String separador;

    /**
     * Cria uma instância de Termo com os parametros especificados
     *
     * @param valor valor do termo.
     * @param prioridade prioridade do termo.
     * @param separador separador utilizado no termo.
     * @param ordem ordem utilizada na representação do termo.
     */
    public Termo(String valor, int prioridade, String separador, String ordem) {
        this.propriedades = new HashMap<>();
        this.prioridade = prioridade;
        this.valor = valor;
        this.propriedades.put("separador", separador);
        this.propriedades.put("ordem", ordem);
    }

    /**
     * retorna a representação completa do termo
     *
     * @return representação completa do termo
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        String ordem = this.propriedades.get("ordem");
        if ("ALFABÉTICA".equals(ordem)) {
            return ordenaPorOrdemAlfabetica();
        } else if ("NENHUM".equals(ordem)) {
            return semOrdemAlfabetica();
        }
        return "ORDEM NÃO ENCONTRADA!";
    }

    private String semOrdemAlfabetica() {
        String[] palavras = valor.split(this.propriedades.get("separador"));
        for (int indice = 0; indice < palavras.length; indice++) {
            palavras[indice] = palavras[indice].strip();
        }
        String representacao = "Total termos: " + palavras.length + "\n- ";
        String representacao2 = String.join(", ", palavras);
        return representacao + representacao2;
    }

    private String ordenaPorOrdemAlfabetica() {
        String[] palavras = valor.split(this.propriedades.get("separador"));
        for (int indice = 0; indice < palavras.length; indice++) {
            palavras[indice] = palavras[indice].strip();
        }
        Arrays.sort(palavras);
        String representacao = String.format("Total termos: %d%n- ", palavras.length);
        String representacao2 = String.join(", ", palavras);
        return representacao + representacao2.strip();
    }

    /**
     * retorna a representação resumida do termo
     *
     * @return representação resumida do termo
     */
    @Override
    public String gerarRepresentacaoResumida() {
        String[] palavras = valor.split(this.propriedades.get("separador"));
        for (int indice = 0; indice < palavras.length; indice++) {
            palavras[indice] = palavras[indice].strip();
        }

        String ordem = this.propriedades.get("ordem");
        if (ordem.equals("NENHUM")) {
            palavras = valor.replace(" ", "").split(this.propriedades.get("separador"));
        } else if (ordem.equals("ALFABÉTICA")) {
            Arrays.sort(palavras);
        } else if (ordem.equals("TAMANHO")) {
            palavras = ordenarPalavrasTamanho(palavras);
        }

        String separador = this.propriedades.get("separador");
        String representacao = String.join(" " + separador + " ", palavras);
        return representacao.strip();
    }

    private String[] ordenarPalavrasTamanho(String[] palavra) {
        String[] palavras = Arrays.copyOf(palavra, palavra.length);
        for (int x = 0; x < palavras.length; x++) {
            for (int i = palavras.length - 1; i > 0; i--) {
                String atual = palavras[i];
                String anterior = palavras[i - 1];
                if (atual.length() > anterior.length()) {
                    palavras[i - 1] = atual;
                    palavras[i] = anterior;
                }
            }
        }
        return palavras;
    }

    /**
     * retorna a prioridade do termo
     *
     * @return prioridade do termo
     */
    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}