//import java.util.Arrays;

public class RegistroResumos {
    private String[] temas;
    private String[] resumos;
    private int indiceVariavel;
    private int indiceFinal;

    public RegistroResumos(int numeroDeResumos) {
        this.temas = new String[numeroDeResumos];
        this.resumos = new String[numeroDeResumos];
        this.indiceVariavel = 0;
        this.indiceFinal = 0;
    }

    public void adiciona(String tema, String resumo){
        if (this.indiceVariavel >= this.resumos.length){
            this.indiceVariavel = 0;
            this.indiceFinal = this.resumos.length;
            this.temas[indiceVariavel] = tema;
            this.resumos[indiceVariavel] = resumo;
            this.indiceVariavel += 1;
        }
        else{
            this.temas[indiceVariavel] = tema;
            this.resumos[indiceVariavel] = resumo;
            this.indiceVariavel +=1;
            this.indiceFinal +=1;
        }
    }

    public String[] pegaResumos(){
        String[] resumosCompletos = new String[this.indiceFinal];

        for (int i = 0; i <this.indiceFinal; i++){
            resumosCompletos[i] = this.temas[i] + ": " + this.resumos[i];
        }
        return resumosCompletos;
    }

    public String imprimeResumos(){
        String retorno = "- " + this.indiceFinal + " resumo(s) cadastrado(s)\n" + "-";
        for (int i = 0; i < this.indiceFinal; i++){
            if (i == (this.indiceFinal -1)){
                retorno += " " + this.temas[i];
            }
            else{
                retorno += " " + this.temas[i] + " |";

            }
            }
            return retorno;        
    }

    public int conta(){
        return this.indiceFinal;

    }

    public boolean temResumo(String tema){
        for (int i = 0; i < this.indiceFinal; i++){
            if (tema.equals(this.temas[i])){
                return true;
            }
        }
        return false;
        }
    }