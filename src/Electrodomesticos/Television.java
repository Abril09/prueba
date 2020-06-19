package Electrodomesticos;

public class Television extends Electrodomestico{
    private static final Double RESOLUCION_DEFAULT=20.0;
    private static final Boolean SINTONIZADORTDT_DEFAULT = false;
    private Double resolucion;
    private Boolean sintonizadorTDT;

    public Television(Integer precio, Integer peso) {
        super(precio, peso);
        this.resolucion = RESOLUCION_DEFAULT;
        this.sintonizadorTDT =SINTONIZADORTDT_DEFAULT;
    }

    public Television(Integer precioBase, String color, Integer peso, String consumoEnergético, Double resolucion,
            Boolean sintonizadorTDT) {
        super(precioBase, color, peso, consumoEnergético);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public  double precioFinal(){
        Integer total =(this.precioBase + this.sumarPorConsumo() + this.sumarPorPeso() + this.sumaPorTDT()); 
        return  this.sumaPorResolucion(total);
    }

    private Double sumaPorResolucion(Integer precio){
        return  ((precio*0.3) + precio);
    }
    private Integer sumaPorTDT(){
        return this.sintonizadorTDT ? 50 : 0;
    }


}