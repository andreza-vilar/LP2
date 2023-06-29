public class Descanso{
   private int horasDescanso;
   private int numeroSemanas;
   

   public Descanso(){
    this.horasDescanso = 0;
    this.numeroSemanas = 0;
   }

   void defineHorasDescanso(int valor){
      this.horasDescanso = valor;

   }

   void defineNumeroSemanas(int valor){
      this.numeroSemanas = valor;
   }

   String getStatusGeral(){
      if (this.horasDescanso == 0 || ((this.horasDescanso / this.numeroSemanas) < 26)){
         return "cansado";
       }
      else{
         return "descansado";
       }
   }

}