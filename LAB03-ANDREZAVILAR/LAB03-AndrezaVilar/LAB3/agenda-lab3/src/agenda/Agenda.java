package agenda;


/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Andreza Vilar
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	private Contato[] contatos; //apenas uma simplificacao de contato
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}


	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}


	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	public Contato[] getFavoritos(){
		return this.favoritos.clone();
	}

	public Contato getFavorito(int posicao){
		return favoritos[posicao];
	}


	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */

	 public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao > 100 || posicao < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}
		if (posicao == 0) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVALIDA");
		}
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
		if (telefone.isEmpty()) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
		if (verificaContato(nome, sobrenome)) {
			throw new IllegalArgumentException("CONTATO JA CADASTRADO");
		}
		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}

	
	/**
	 * Verifica se o contato já está cadastrado.
	 * @param nome nome do contato.
	 * @param sobrenome sobrenome do contato.
	 * @return
	 */
	private boolean verificaContato(String nome, String sobrenome) {
		for (Contato contato : contatos) {
			if (contato != null && 
			contato.getNome().equals(nome) && 
			contato.getSobrenome().equals(sobrenome)) {
                return true;
            }
		}
		return false;
	}

	/**
	 * Realiza o cadastro de contato como favorito
	 * @param posicaoContato posição do contato que quer cadastrar
	 * @param posicaoFavorito posição da lista de favoritos que ele quer inserir
	 */
	public void cadastraFavorito(int posicaoContato, int posicaoFavorito) {
		if (posicaoContato > 100 || posicaoContato < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}
		if (posicaoFavorito > 10 || posicaoFavorito < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}
		if (contatos[posicaoContato- 1] == null) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}
		if (contatos[posicaoContato - 1].getFavorito()) {
			throw new IllegalArgumentException("JA FOI FAVORITADO");
		}
		contatos[posicaoContato - 1].favoritado();
		favoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
	}

	/**
	 * retorna as informações da lista de contato
	 * @return lista de contatos
	 */
	public String returnListaContatos() {
		StringBuilder listagemNomes = new StringBuilder();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listagemNomes.append(String.format("%s - %s\n", i + 1, contatos[i].nomeCompleto()));
			}
		}
		return listagemNomes.toString();
	}

	/**
	 * retorna lista de contatos favoritados
	 * @return lista de favoritos
	 */
	public String returnFavoritos() {
		StringBuilder listagemFav = new StringBuilder();
			for (int i = 0; i < favoritos.length; i++) {
				if (favoritos[i] != null) {
					listagemFav.append(String.format("%s - %s\n", i + 1, this.favoritos[i].nomeCompleto()));
				}
			}
			if (listagemFav.isEmpty()) {
				return "NENHUM FAVORITO";
			}
			return listagemFav.toString();
		}

	/**
	 * método para remover contato da lista de favoritos
	 * @param posicao posicao em que o contato está
	 */
	public void removeFavorito(int posicao) {
		if (posicao > 10 || posicao < 0) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		if (contatos[posicao - 1] == null) {
			throw new IllegalArgumentException("POSIÇÃO INVALIDA");
		}

		this.favoritos[posicao - 1].desfavoritado();
		this.favoritos[posicao - 1] = null;
	}
}