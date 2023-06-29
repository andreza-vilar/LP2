package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * A classe  é responsável por gerenciar os documentos e suas operações
 */
public class DocumentoController {
	
	private HashMap<String, Documento> documentos;
	private ArrayList<String[]> visoes;

	/**
     * Cria uma instância de DocumentoController.
     * Inicializa os atributos documentos e visoes.
     */
	public DocumentoController() {
		this.documentos = new HashMap<>();
		this.visoes = new ArrayList<>();
	}
	
      /**
     * cria documento com o título especificado.
     *
     * @param tituloDoc o título do documento
     * @return true se o documento foi criado, false se um documento com o mesmo título já existe
     */
	public boolean criarDocumento(String tituloDoc) {
		if (!this.documentos.containsKey(tituloDoc)) {
			documentos.put(tituloDoc, new Documento(tituloDoc));
			this.visoes = new ArrayList<>();
			return true;
		}
		return false;
	}
	
    /**
     * cria um documento com o título e o tamanho especificados.
     *
     * @param tituloDoc título
     * @param tamanho tamanho
     * @return true se o documento foi criado, false se um documento com o mesmo título já existe
     */
	public boolean criarDocumento(String tituloDoc, int tamanho) {
		if (!this.documentos.containsKey(tituloDoc)) {
			documentos.put(tituloDoc, new Documento(tituloDoc, tamanho));
			return true;
		}
		return false;
	}
	
	
    /**
     * remove o documento com o título especificado
     *
     * @param tituloDoc título do documento que vai ser resumido
     * @throws NoSuchElementException se o documento não existe.
     */
	public void removerDocumento(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	} 
		this.documentos.remove(tituloDoc);
	}
	
	/**
     * Cria um atalho para o documento especificado.
     *
     * @param tituloDoc título do documento
     * @param tituloDocReferenciado O título do documento referenciado
     * @return posição do atalho criado
     * @throws IllegalArgumentException se o título do documento ou do documento referenciado contiver caracteres inválidos.
     * @throws NoSuchElementException se o documento ou o documento referenciado não existir.
     * @throws IllegalStateException se o documento já possui um atalho.
     */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    	if (contemCaractereIndesejavel(tituloDoc) || contemCaractereIndesejavel(tituloDocReferenciado)) {
        	throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	}
    	if (!existeDocumento(tituloDoc) || !existeDocumento(tituloDocReferenciado)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	Documento documento = this.documentos.get(tituloDoc);
    	if (!documento.temAtalho()) {
        	Documento docReferenciado = this.documentos.get(tituloDocReferenciado);
        	return documento.criarAtalho(
            	docReferenciado.getTitulo(),
            	docReferenciado.calculaMedia(),
            	Arrays.toString(docReferenciado.getRepresentacoesCompletas()),
            	Arrays.toString(docReferenciado.getRepresentacoesResumidas())
        	);
    	} else {
        	throw new IllegalStateException("O DOCUMENTO JA TEM UM ATALHO");
    	}
	}

    
	
	/**
     * Cria um texto no documento especificado.
     *
     * @param tituloDoc O título do documento 
     * @param valor O valor do texto.
     * @param prioridade A prioridade do texto.
     * @return A posição do texto 
     * @throws IllegalArgumentException se o título do documento contiver caracteres inválidos.
     * @throws NoSuchElementException se o documento não existir.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	if (contemCaractereIndesejavel(tituloDoc)) {
        	throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	}
    	if (!existeDocumento(tituloDoc)) {
        	throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).criarTexto(valor, prioridade);
	}

    
    
	/**
     * Cria um novo título no documento especificado.
     *
     * @param tituloDoc O título do documento
     * @param valor O valor do título.
     * @param prioridade A prioridade do título.
     * @param nivel O nível do título.
     * @param linkavel Indica se o título pode ser linkado.
     * @return A posição do título
     * @throws IllegalArgumentException se o título do documento contiver caracteres inválidos.
     * @throws NoSuchElementException se o documento não existir.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	if (contemCaractereIndesejavel(tituloDoc)) {
        	throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	}
    	if (!existeDocumento(tituloDoc)) {
        	throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).criarTitulo(valor, prioridade, nivel, linkavel);
	}


    /**
     * Cria uma lista dentro do documento.
     *
     * @param tituloDoc O título do documento.
     * @param valorLista O valor da lista.
     * @param prioridade A prioridade da lista.
     * @param separador O separador da lista.
     * @param charLista O caractere de lista.
     * @return O número de elementos na lista.
     * @throws IllegalArgumentException Se o título do documento contiver caracteres inválidos.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	if (contemCaractereIndesejavel(tituloDoc)) {
        	throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	}
    	if (!existeDocumento(tituloDoc)) {
       		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		return this.documentos.get(tituloDoc).criarLista(valorLista, prioridade, separador, charLista);
	}

    

	/**
     * Cria termos dentro do documento.
     *
     * @param tituloDoc O título do documento.
     * @param valorTermos O valor dos termos.
     * @param prioridade A prioridade dos termos.
     * @param separador O separador dos termos.
     * @param ordem A ordem dos termos.
     * @return O número de elementos nos termos.
     * @throws IllegalArgumentException Se o título do documento contiver caracteres inválidos.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	if (contemCaractereIndesejavel(tituloDoc)) {
        	throw new IllegalArgumentException("CONTEM CARACTERE(S) INVALIDO!");
    	}
    	if (!existeDocumento(tituloDoc)) {
        	throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).criarTermos(valorTermos, prioridade, separador, ordem);
	}
    
    
	/**
     * representação completa de um elemento do documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @return A representação completa do elemento.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
    	
    }
    
    
	/**
     * representação resumida de um elemento documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @return A representação resumida do elemento.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	return this.documentos.get(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
    }
    
    
	/**
     * Apaga um elemento específico do documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
    public void apagarElemento(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	this.documentos.get(tituloDoc).apagarElemento(elementoPosicao);
    }
    
    
	/**
     * Move um elemento para cima no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	this.documentos.get(tituloDoc).moverParaCima(elementoPosicao);
    }
    
    

	/**
     * Move um elemento para baixo no documento.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	this.documentos.get(tituloDoc).moverParaBaixo(elementoPosicao);
    }

    
	/**
     * Exibe o documento completo.
     *
     * @param tituloDoc O título do documento.
     * @return Um array contendo as representações completas dos elementos do documento.
     * @throws NoSuchElementException Se o documento não for encontrado.
     */
	public String[] exibirDocumento(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		return this.documentos.get(tituloDoc).getRepresentacoesCompletas();
	}

	
	/**
     * Conta o número de elementos no documento
     *
     * @param tituloDoc título do documento
     * @return número de elementos no documento
     * @throws NoSuchElementException caso o documento não for encontrado
     */
	public int contarElementos(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		return this.documentos.get(tituloDoc).contarElementos();
	}
	

	/**
     * verifica se um documento existe
     *
     * @param tituloDoc título do documento
     * @return true se o documento existe, false caso não exista.
     */
    private boolean existeDocumento(String tituloDoc) {
    	return this.documentos.containsKey(tituloDoc);
    }
    

	/**
     * verifica se um título de documento tem caracteres que não deviam estar ali.
     *
     * @param tituloDoc título do documento
     * @return true se o título contém caracteres indesejáveis, false se não tiver.
     */
    private boolean contemCaractereIndesejavel(String tituloDoc) {
    	if (tituloDoc.equals("")) {
    		return true;
    	}
    	for (String i: tituloDoc.split("")) {
    		if (!i.equals(" ")) {
    			return false;
    		}
    	}
    	return true;
    }
    
   
	/**
     * cria uma visão completa do documento
     *
     * @param tituloDoc título do documento
     * @return ID da visão criada
     * @throws NoSuchElementException se o documento não for encontrado
     */
	public int criarVisaoCompleta(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoCompleta();
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}
	
	
	/**
     * cria uma visão resumida do documento
     *
     * @param tituloDoc título do documento
     * @return ID da visão criada.
     * @throws NoSuchElementException se o documento não for encontrado
     */
	public int criarVisaoResumida(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoResumida();
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}

	
	/**
     * cria uma visão do título do documento
     *
     * @param tituloDoc título do documento
     * @return ID da visão criada
     * @throws NoSuchElementException caso o documento não for encontrado
     */
	public int criarVisaoTitulo(String tituloDoc) {
		if (!existeDocumento(tituloDoc)) {
    		throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
		String[] visao = this.documentos.get(tituloDoc).getVisaoTitulo();
		this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}

	
	/**
     * cria uma visão prioritária do documento com base na prioridade especificada
     *
     * @param tituloDoc título do documento
     * @param prioridade prioridade dos elementos
     * @return ID da visão criada
     * @throws NoSuchElementException caso o documento não for encontrado
     */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	if (!existeDocumento(tituloDoc)) {
        	throw new NoSuchElementException("DOCUMENTO NAO ENCONTRADO!");
    	}
    	String[] visao = this.documentos.get(tituloDoc).getVisaoPrioridade(prioridade);
    	this.visoes.add(visao);
		return this.visoes.indexOf(visao) + 1;
	}
	
	/**
     * exibe uma visão específica
     *
     * @param visaoId ID da visão
     * @return um array contendo as representações dos elementos na visão
     */
	public String[] exibirVisao(int visaoId) {
		return this.visoes.get(visaoId - 1);
	}

}
