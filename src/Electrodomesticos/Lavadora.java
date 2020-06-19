package Electrodomesticos;

public class Lavadora extends Electrodomestico{
    private static final Integer CARGA_DEFAULT = 5;
    private Integer carga;

    public Lavadora(){}     
    
    public Lavadora(Integer precio,Integer peso) {
        super(precio,peso);
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(Integer precioBase, String color, Integer peso, String consumoEnergético, Integer carga) {
        super(precioBase, color, peso, consumoEnergético);
        this.carga = carga;
    }

  
    public  double  precioFinal(){
        return (double) (this.precioBase + this.sumarPorConsumo() + this.sumarPorPeso() + this.sumaPorCarga());
    }

    private Integer sumaPorCarga(){
        if(this.carga >= 30){
            return 50;
        }
        return 0;
    }

    public Integer getCarga() {
        return carga;
    }


  

    

}