package agenda;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;

    /**
     * construtor para inicializar o contato
     * @param nome nome do contato
     * @param sobrenome sobrenome do contato
     * @param telefone telefone do contato
     */
    public Contato(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.favorito = false;
    }

    /**método acessador GET
     * @return
     */

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean getFavorito(){
        return this.favorito;
    }

    /**
     * métodos acessadores SET
     * @return
     */
    public String nomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    public void favoritado(){
        this.favorito = true;
    }

    public void desfavoritado(){
        this.favorito = false;
    }

    public boolean equals(Contato contato) {
        if (this.nome == contato.getNome() && this.sobrenome == contato.getSobrenome()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.favorito) {
            return String.format("❤️ " + " " + this.nome + " " + " " +  this.sobrenome + "\n" + this.telefone);
        }
        else{
            return String.format("%s %s\n%s", this.nome, this.sobrenome, this.telefone);
        }
        
    }

}