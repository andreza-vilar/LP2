package documin;

public interface Elemento {

    /**
     *representação completa do elemento
     *
     * @return representação completa do elemento
     */
    public String gerarRepresentacaoCompleta();

    /**
     * representação resumida do elemento.
     *
     * @return representação resumida do elemento.
     */
    public String gerarRepresentacaoResumida();

    /**
     * prioridade do elemento.
     *
     * @return prioridade do elemento.
     */
    public int getPrioridade();
}