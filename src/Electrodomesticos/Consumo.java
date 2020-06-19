package Electrodomesticos;

public  enum Consumo {
    A(100),
    B(80),
    C(60),
    D(50),
    E(30),
    F(10);

    private int precio;
    Consumo(int precio){
        this.precio = precio; 
   }

   public int getPrecio() {
       return precio;
   }
  
}