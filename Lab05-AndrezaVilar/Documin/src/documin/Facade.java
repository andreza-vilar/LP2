package documin;

public class Facade {

    private DocumentoController documentoController;

    
    public Facade() {
        this.documentoController = new DocumentoController();
    }

   
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }
    
   
    public boolean criarDocumento(String titulo, int tamanho) {
        return this.documentoController.criarDocumento(titulo, tamanho);
    }
    
    
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    	return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
    }

   
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    
    
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    
    
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    
    
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }
    
    
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    
    
    public void apagarElemento(String tituloDoc, int elementoPosicao) {
    	this.documentoController.apagarElemento(tituloDoc, elementoPosicao); 
    }
    
    
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }
    
    
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }
    
    
    public void removerDocumento(String titulo) {
    	this.documentoController.removerDocumento(titulo);
    }
    
   
    public int contarElementos(String titulo) {
    	return this.documentoController.contarElementos(titulo);
    }
    
    
    public String[] exibirDocumento(String titulo) {
    	return this.documentoController.exibirDocumento(titulo);
    }
    
    
    public int criarVisaoCompleta(String tituloDoc) {
		return this.documentoController.criarVisaoCompleta(tituloDoc);
    }
    
    
    public int criarVisaoResumida(String tituloDoc) {
    	return this.documentoController.criarVisaoResumida(tituloDoc);
    }
    
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }
    
    
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.documentoController.criarVisaoTitulo(tituloDoc);
    }
    
    
    public String[] exibirVisao(int visaoId) {
    	return this.documentoController.exibirVisao(visaoId);
    }
}