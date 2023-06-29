package documin;

import java.util.HashMap;


public class Lista implements Elemento {
    private HashMap<String, String> propriedades;
    private String valorLista;
    private int prioridade;

    /**
     * cria uma Lista os parametros especificados.
     *
     * @param valorLista valor da lista.
     * @param prioridade prioridade da lista.
     * @param separador separador utilizado na lista.
     * @param charLista caractere de lista utilizado na representação da lista.
     */
    public Lista(String valorLista, int prioridade, String separador, String charLista) {
        this.propriedades = new HashMap<>();
        this.propriedades.put("separador", separador);
        this.propriedades.put("caractereDeLista", charLista);
        this.valorLista = valorLista;
        this.prioridade = prioridade;
    }

    /**
     * retorna a representação completa da lista.
     *
     * @return a representação completa da lista.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        StringBuilder representacao = new StringBuilder();
        String[] palavras = valorLista.replace(this.propriedades.get("separador"), ",").split(",");
        for (String palavra : palavras) {
            representacao.append(this.propriedades.get("caractereDeLista"))
                        .append(" ")
                        .append(palavra.strip())
                        .append("\n");
        }
        return representacao.toString().strip();
    }

    /**
     * retorna a representação resumida da lista.
     *
     * @return representação resumida da lista.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        StringBuilder representacao = new StringBuilder();
        String[] palavras = valorLista.replace(this.propriedades.get("separador"), ",").split(",");
        for (int i = 0; i < palavras.length; i++) {
            if (i == 0) {
                representacao.append(palavras[i].strip());
            } else {
                representacao.append(", ").append(palavras[i].strip());
            }
        }
        return representacao.toString();
    }

    /**
     * retorna a prioridade da lista.
     *
     * @return prioridade da lista.
     */
    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}