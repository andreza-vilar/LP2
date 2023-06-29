package documin;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Documento {
	private ArrayList<Elemento> elementos;
	private int tamanho;
	private String titulo;
	private boolean temAtalho;
	
	/**
	 * Construtor com tamanho específico.
	 * 
	 * @param titulo   título do documento
	 * @param tamanho  tamanho máximo do documento
	 * @throws IllegalArgumentException caso o título for null, uma string vazia ou uma string contendo apenas espaços
	 * @throws IllegalArgumentException caso o tamanho for menor ou igual a 0
	 */

	public Documento(String titulo, int tamanho) {
		if (titulo != null) {
			if (!titulo.equals("")) {
				if (!temApenasEspacos(titulo)) {
					if (tamanho > 0) {
						this.elementos = new ArrayList<>();
						this.titulo = titulo;
						this.tamanho = tamanho;
						this.temAtalho = false;
					}
					else {
						throw new IllegalArgumentException("TAMANHO INVÁLIDO");
					}
				}
				else {
					throw new IllegalArgumentException("ERRO: STRING COM APENAS ESPAÇOS!");
				}
			}
			else {
				throw new IllegalArgumentException("ERRO: STRING VAZIA!");
			}
		}
		else {
			throw new IllegalArgumentException("ERRO: STRING NULL!");
		}
	}
	
	/**
	 * Construtor com tamanho infinito
	 * 
	 * @param titulo   título do documento
	 * @throws IllegalArgumentException se o título for null, uma string vazia ou uma string contendo apenas espaços
	 */
	public Documento(String titulo) {
		if (titulo != null) {
			if (!titulo.equals("")) {
				if (!temApenasEspacos(titulo)) {
					this.elementos = new ArrayList<>();
					this.titulo = titulo;
					this.tamanho = Integer.MAX_VALUE;
					this.temAtalho = false;
				}
				else {
					throw new IllegalArgumentException("ERRO: STRING COM APENAS ESPAÇOS!");
				}
			}
			else {
				throw new IllegalArgumentException("ERRO: STRING VAZIA!");
			}
		}
		else {
			throw new IllegalArgumentException("ERRO: STRING NULL!");
		}
	}

	/**
	 * Verifica se tem apenas espaços.
	 * 
	 * @param str  a string a ser verificada
	 * @return     true se a string contiver apenas espaços, caso contrário, retorna False
	 */
	private boolean temApenasEspacos(String texto) {
		for(String i: texto.split("")) {
			if (i != " ") {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * verifica se atingiu tamanho máximo
	 *
	 * @return true se o tamanho máximo foi atingido, caso contrário, retorna False
	 */
	private boolean atingiuTamanhoLimite() {
		if (this.tamanho == this.elementos.size()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * retorna o código hash do título do documento
	 *
	 * @return código hash do título do documento
	 */
	@Override
	public int hashCode() {
		return this.titulo.hashCode();
	}
	
	/**
	 * obtém o título do documento.
	 *
	 * @return título do documento.
	 */
	public String getTitulo() {
		return this.titulo;
	}
	

	/**
	 * verifica se o objeto especificado é igual a este documento
	 *
	 * @param obj objeto a ser comparado.
	 * @return true se o objeto é igual a este documento,caso contrário, retorna False
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Documento doc = (Documento) obj;
		return this.getTitulo().equals(doc.getTitulo());
	}

	/**
	 * cria um texto e adiciona ao documento
	 *
	 * @param valor     valor do texto.
	 * @param prioridade prioridade do texto.
	 * @return índice do texto criado ou -1 se o tamanho máximo foi atingido.
	 */
	public int criarTexto(String valor, int prioridade) {
		if (!atingiuTamanhoLimite()) {
			Elemento texto = new Texto(valor, prioridade);
			this.elementos.add(texto);
			return this.elementos.indexOf(texto) + 1;
		}
		else {
			return -1;
		}
    }
    
	/**
	 * cria um título e adiciona ao documento.
	 *
	 * @param valor     valor do título.
	 * @param prioridade prioridade do título.
	 * @param nivel     nível do título.
	 * @param linkavel  indica se o título pode ser linkável.
	 * @return O índice do título criado ou -1 se o tamanho máximo foi atingido.
	 */
    public int criarTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
    	if (!atingiuTamanhoLimite()) {
			Elemento titulo = new Titulo(valor, prioridade, nivel, linkavel);
			this.elementos.add(titulo);
			return this.elementos.indexOf(titulo) + 1;
		}
		return -1;
    }
    
	/**
	 * cria uma lista e adiciona ao documento.
	 *
	 * @param valorLista   valor da lista.
	 * @param prioridade   prioridade da lista.
	 * @param separador    separador dos itens da lista.
	 * @param charLista    caractere usado para marcar cada item da lista.
	 * @return índice da lista criada ou -1 se o tamanho máximo foi atingido.
	 */
    public int criarLista(String valorLista, int prioridade, String separador, String charLista) {
		if (!atingiuTamanhoLimite()) {
			Elemento lista = new Lista(valorLista, prioridade, separador, charLista);
			this.elementos.add(lista);
			return this.elementos.indexOf(lista) + 1;
		}
		return -1;
	}
    
	/**
	 * Cria um novo termo
	 *
	 * @param valorTermos   valor dos termos.
	 * @param prioridade    prioridade dos termos.
	 * @param separador     separador dos termos.
	 * @param ordem         ordem dos termos.
	 * @return índice do termo criado ou -1 se o tamanho máximo foi atingido.
	 */
    public int criarTermos(String valorTermos, int prioridade, String separador, String ordem) {
    	if (!atingiuTamanhoLimite()) {
    		Elemento termo = new Termo(valorTermos, prioridade, separador, ordem);
    		this.elementos.add(termo);
    		return this.elementos.indexOf(termo) + 1;
    	}
    	return -1;
   	}
    

	/**
	 * Cria um novo atalho e o adiciona ao documento
	 *
	 * @param valor                  valor do atalho
	 * @param media                  média do atalho
	 * @param representacaoCompleta  representação completa do atalho
	 * @param representacaoresumida  representação resumida do atalho
	 * @return índice do atalho criado ou -1 se o tamanho máximo foi atingido ou se já existe um atalho no documento.
	 */
    public int criarAtalho(String valor, double media, String representacaoCompleta, String representacaoresumida) {
    	if (!atingiuTamanhoLimite() || !this.temAtalho) {
   			Atalho atalho = new Atalho(valor, media, representacaoCompleta, representacaoresumida);
    		this.elementos.add(atalho);
    		this.temAtalho = true;
    		return this.elementos.indexOf(atalho) + 1;
    	}
    	return -1;
   	}
    

	/**
	 * retorna a representação completa do elemento na posição especifica
	 *
	 * @param elementoPosicao posição do elemento
	 * @return representação completa do elemento na posição especificada ou "Posição inválida." se a posição for inválida
	 */
    public String pegarRepresentacaoCompleta(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		return "Posição inválida.";
    	}
    	else {
    		return this.elementos.get(elementoPosicao - 1).gerarRepresentacaoCompleta();
    	}
    }
    

	/**
	 * representação resumida do elemento na posição especificada
	 *
	 * @param elementoPosicao posição do elemento
	 * @return representação resumida do elemento na posição especificada ou "Posição inválida." se a posição for inválida
	 */
    public String pegarRepresentacaoResumida(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		return "Posição inválida.";
    	}
		return this.elementos.get(elementoPosicao - 1).gerarRepresentacaoResumida();
    }
    

	/**
	 * remove o elemento da posição especificada
	 *
	 * @param elementoPosicao posição do elemento que vai ser removido
	 */
    public void apagarElemento(int elementoPosicao) {
    	this.elementos.remove(elementoPosicao - 1);
    }
    


	/**
	 * Move o elemento na posição especificada para cima.
	 *
	 * @param elementoPosicao A posição do elemento a ser movido para cima.
	 * @throws NoSuchElementException se o elemento não for encontrado na posição especificada.
	 */
    public void moverParaCima(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		throw new NoSuchElementException("Elemento não encontrado nesta posição.");
    	} else
    	if ((elementoPosicao - 1) > 0 || (elementoPosicao - 1) < this.elementos.size()) {
			Elemento elemento1 = this.elementos.get(elementoPosicao - 1);
			Elemento elemento2 = this.elementos.get(elementoPosicao - 2);
		
			this.elementos.set(elementoPosicao - 2, elemento1);
			this.elementos.set(elementoPosicao - 1, elemento2); 
		}
    }
    

	/**
	 * Move o elemento na posição especificada para baixo.
	 *
	 * @param elementoPosicao A posição do elemento a ser movido para baixo.
	 * @throws NoSuchElementException se o elemento não for encontrado na posição especificada.
	 */
    public void moverParaBaixo(int elementoPosicao) {
    	if (elementoPosicao > this.elementos.size()) {
    		throw new NoSuchElementException("Elemento não encontrado nesta posição.");
    	} else
        if (elementoPosicao - 1 >= 0 || elementoPosicao - 1 < (this.elementos.size() - 1)) {
			Elemento elemento1 = this.elementos.get(elementoPosicao - 1);
			Elemento elemento2 = this.elementos.get(elementoPosicao);
		
			this.elementos.set(elementoPosicao, elemento1);
			this.elementos.set(elementoPosicao - 1, elemento2);
		}
    }

    
	public int contarElementos() {
		return this.elementos.size();
	}

	

	/**
	 * Retorna um array contendo todas as representações completas dos elementos do documento.
	 *
	 * @return Um array de strings contendo as representações completas dos elementos do documento.
	 */
	public String[] exibirDocumento() {
		String[] todasRepresentacoes = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			todasRepresentacoes[i] = this.elementos.get(i).gerarRepresentacaoCompleta() + "\n\n";
		}
		return todasRepresentacoes;
	}
	
	/**
	 * Retorna um array contendo todas as representações completas dos elementos do documento que têm prioridade 4 ou 5.
	 *
	 * @return Um array de strings contendo as representações completas dos elementos do documento com prioridade 4 ou 5.
	 */
	public String[] getRepresentacoesCompletas() {
		ArrayList<String> representacao = new ArrayList<>();
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getPrioridade() == 4 || this.elementos.get(i).getPrioridade() == 5) {
				if (this.elementos.get(i) != null) {
					representacao.add(this.elementos.get(i).gerarRepresentacaoCompleta() + "\n");
				}
			}
		}
		
		String[] representacao2 = new String[representacao.size()];
		for (int s = 0; s < representacao.size(); s++) {
			representacao2[s] = representacao.get(s);
		}
		return representacao2;
	}
	
	

	/**
	 * Retorna um array contendo todas as representações resumidas dos elementos do documento.
	 *
	 * @return Um array de strings contendo as representações resumidas dos elementos do documento.
	 */
	public String[] getRepresentacoesResumidas() {
		ArrayList<String> representacao = new ArrayList<>();
		for (int t = 0; t < this.elementos.size(); t++) {
			if (this.elementos.get(t) != null) {
				representacao.add(this.elementos.get(t).gerarRepresentacaoResumida() + "\n");
			}
		}
		String[] representacao2 = new String[representacao.size()];
		for (int s = 0; s < representacao.size(); s++) {
			representacao2[s] = representacao.get(s);
		}
		
		return representacao2;
	}
	


	/**
	 * Calcula a média das prioridades dos elementos do documento.
	 *
	 * @return A média das prioridades dos elementos do documento. Retorna 0 se não houver elementos.
	 */
	public double calculaMedia() {
		double soma = 0;
		if (this.elementos.size() == 0) {
			return 0;
		}
		for (Elemento elemento: this.elementos) {
			soma += elemento.getPrioridade();
		}
		return soma/this.elementos.size();
	}
	
	
	public boolean temAtalho() {
		return this.temAtalho;
	}

	
	public String[] getVisaoCompleta() {
		String[] visoes = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			visoes[i] = this.elementos.get(i).gerarRepresentacaoCompleta();
		}
		return visoes;
	}

	
	public String[] getVisaoResumida() {
		String[] visoes = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			visoes[i] = this.elementos.get(i).gerarRepresentacaoResumida();
		}
		return visoes;
	}

	
	public String[] getVisaoTitulo() {
		ArrayList<String> visoes = new ArrayList<>();
		Titulo titulo = new Titulo(null, 1, 1, true);
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getClass() == (titulo.getClass())) {
				visoes.add(this.elementos.get(i).gerarRepresentacaoResumida());
			}
		}
		String[] visao = new String[visoes.size()];
		for (int v = 0; v < visoes.size(); v++) {
			visao[v] = visoes.get(v);
		}
		return visao;
	}

	
	public String[] getVisaoPrioridade(int prioridade) {
		ArrayList<String> prioridades = new ArrayList<>();
		for (int i = 0; i < this.elementos.size(); i++) {
			if (this.elementos.get(i).getPrioridade() >= prioridade) {
				prioridades.add(this.elementos.get(i).gerarRepresentacaoCompleta());
			}
		}
		String[] todasPrioridades = new String[prioridades.size()];
		for (int p = 0; p < prioridades.size(); p ++) {
			todasPrioridades[p] = prioridades.get(p);
		}
		return todasPrioridades;
	}
	
 }