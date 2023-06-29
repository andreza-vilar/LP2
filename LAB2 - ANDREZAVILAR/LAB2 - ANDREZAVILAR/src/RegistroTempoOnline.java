public class RegistroTempoOnline {
    private String disciplina;
    private int tempoUsado;
    private int tempoEsperado;


    public RegistroTempoOnline(String nomeDisciplina){
        this.disciplina = nomeDisciplina;
        this.tempoUsado = 0;
        this.tempoEsperado = 120;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
        this.disciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado; 
    }

    public void adicionaTempoOnline(int tempo){
        this.tempoUsado = tempo;
    }

    public boolean atingiuMetaTempoOnline(){
        if (this.tempoEsperado >= (2* this.tempoUsado)){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return this.disciplina + " " + this.tempoUsado +"/"+this.tempoEsperado;
    }
}