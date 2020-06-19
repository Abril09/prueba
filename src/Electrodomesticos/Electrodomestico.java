package Electrodomesticos;

public class Electrodomestico {
    protected static final String COLOR_DEFAULT = "blanco";
    protected static final char CONSUMO_DEFAULT = 'F';
    protected static final Integer PRECIO_BASE_DEFAULT = 100000;
    protected static final Integer PESO_DEFAULT =5;
    protected static final String [] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};
    protected Integer precioBase;
    protected String color;
    protected Integer peso;
    protected String consumoEnergético;

    protected Electrodomestico(){
        this.precioBase = PRECIO_BASE_DEFAULT;
        this.color = COLOR_DEFAULT;
        this.consumoEnergético = Consumo.F.name();
        this.peso = PESO_DEFAULT;        
    }

    protected Electrodomestico(Integer precio,Integer peso){
        this.precioBase = precio;
        this.color = COLOR_DEFAULT;
        this.consumoEnergético = Consumo.F.name();
        
        this.peso = peso;        
    }

    public Electrodomestico(Integer precioBase, String color, Integer peso, String consumoEnergético) {
        this.precioBase = precioBase;
        this.color = this.comprobarColor(color);
        this.peso = peso;
        this.consumoEnergético = this.comprobarConsumoEnergetico(consumoEnergético.toCharArray()[0]);;
    }

    private String comprobarConsumoEnergetico(char letra){
        String  convertLetra = String.valueOf(letra).toLowerCase();
        if(Consumo.F.name().indexOf(convertLetra) > 0){
            return String.valueOf(letra);
        }else {
            return  Consumo.F.name();
        }
    }


    private String comprobarColor(String color){
        for(String c : COLORES_DISPONIBLES){
            if(c == color){
                return color;                                
            }
        }
        return COLORES_DISPONIBLES[5];
    }


    public  double  precioFinal(){
       return (double)(this.precioBase + this.sumarPorConsumo() + this.sumarPorPeso());  
    }
    
    protected Integer sumarPorPeso(){
        if(this.peso < 20){
            return 10;
        }else if(this.peso < 50){
            return 50;
        }else if(this.peso <80){
            return 80;
        }else{
            return 100;
        }
    }

    protected  Integer sumarPorConsumo(){
        for(Consumo i :Consumo.values()){
            if(i.name().equalsIgnoreCase(this.consumoEnergético)){
                return  i.getPrecio();                
            }
        }
        return 0;
    }

    public Integer getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }
 
    public Integer getPeso() {
        return peso;
    }

    public String getConsumoEnergético() {
        return consumoEnergético;
    }

       

}