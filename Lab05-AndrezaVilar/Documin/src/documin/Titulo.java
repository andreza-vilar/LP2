package documin;

import java.util.HashMap;


public class Titulo implements Elemento {
    private HashMap<String, String> propriedades;
    private int prioridade;
    private String valor;

    /**
     * Cria uma instância de Titulo com os atributos especificados
     * @param valor valor do título
     * @param prioridade prioridade do título
     * @param nivel nível do título
     * @param linkavel indica se o título é linkável ou não
     */
    public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
        this.propriedades = new HashMap<>();
        this.propriedades.put("nivel", Integer.toString(nivel));
        this.propriedades.put("linkavel", linkavel ? "true" : "false");
        this.prioridade = prioridade;
        this.valor = valor;
    }

    /**
     * retorna as propriedades do título em formato de texto
     *
     * @return as propriedades do título
     */
    public String getPropriedades() {
        String textoPropriedades = "";
        textoPropriedades += this.valor + "\n";
        textoPropriedades += "Nível: " + this.propriedades.get("nivel") + "\n";
        textoPropriedades += "Linkável: " + this.propriedades.get("linkavel") + "\n";
        return textoPropriedades;
    }

    /**
     * retorna a representação completa 
     *
     * @return a representação completa
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        String representacao = this.propriedades.get("nivel") + ". " + this.valor;
        if (this.propriedades.get("linkavel").equals("true")) {
            representacao += " -- " + this.propriedades.get("nivel") + "-" + this.valor.replace(" ", "").toUpperCase();
        }
        return representacao;
    }

    /**
     * retorna a representação resumida
     *
     * @return representação resumida
     */
    @Override
    public String gerarRepresentacaoResumida() {
        String representacao = "";
        if (this.propriedades.get("linkavel").equals("true")) {
            representacao += this.propriedades.get("nivel") + ". " + this.valor.split(" ")[0];
        } else {
            representacao += this.propriedades.get("nivel") + ". " + this.valor;
        }
        return representacao;
    }

    /**
     * retorna a prioridade
     *
     * @return prioridade
     */
    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}
