import java.util.Arrays;

public class Disciplina {
    private double media;
    private double [] notas;
    private int horaEstudo;
    private String dsiciplina;


    public Disciplina(String nomeDisciplina){
        this.dsiciplina = nomeDisciplina;
        this.media = 0;
        this.horaEstudo = 0;
        this.notas = new double[] {0, 0, 0, 0};
    }

    public void cadastraHoras(int horas){
        this.horaEstudo +=horas;
    }

    public void cadastraNota(int nota, double valorNota){
        this.notas[nota -1] = valorNota;
    }

    public boolean aprovado(){
        for (double soma : this.notas){
            this.media += soma;
        }
        this.media = this.media / 4;

        if (this.media >= 7){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return this.dsiciplina + " " + this.horaEstudo + " " + this.media + " " + Arrays.toString(this.notas);
    }
}