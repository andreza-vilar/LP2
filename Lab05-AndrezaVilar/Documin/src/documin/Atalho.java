package documin;

public class Atalho implements Elemento {
	private String representacaoCompleta;
	private String representacaoResumo;
	private double media;
	@SuppressWarnings("unused")
	private String valor;
	
	
	/**
	 * Construtor da classe Atalho
	 * 
	 * @param valor                   valor de atalho
	 * @param media                   média de atalho
	 * @param representacaoCompleta   representação completa de atalho
	 * @param representacaoResumida   representação resumida de atalho
	 */
	public Atalho(String valor, double media, String representacaoCompleta, String representacaoResumida) {
		this.representacaoCompleta = representacaoCompleta;
		this.representacaoResumo = representacaoResumida;
		this.media = media;
		this.valor = valor;
	}

	/**
	 * representação completa do atalho
	 * 
	 * @return representação completa do atalho
	 */
	public String gerarRepresentacaoCompleta() {
		return this.representacaoCompleta;
	}

	/**
	 * representação resumida do atalho
	 * 
	 * @return representação resumida do atalho
	 */
	public String gerarRepresentacaoResumida() {
		return this.representacaoResumo;
	}

	/**
	 * prioridade do atalho
	 * 
	 * @return prioridade do atalho, média associada a ele
	 */
	public int getPrioridade() {
		return (int) this.media;
	}
	
}