import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import Electrodomesticos.Consumo;
import Electrodomesticos.Electrodomestico;
import Electrodomesticos.Lavadora;
import Electrodomesticos.Television;

public class App {
    public static void main(String[] args) throws Exception {
        
       Electrodomestico[] electrodomesticos =new Electrodomestico[10];


        for (int i = 0; i < electrodomesticos.length; i++) {
            if(i % 2 ==0 ){
                electrodomesticos[i] = new Television(100+i, 10);
            }else{
                electrodomesticos[i] = new Lavadora(100+i, "azul", 50+i, Consumo.C.name(), 50);
            }
            
        }
       
            double tv = Arrays.stream(electrodomesticos)
                                        .filter((x)->{ return  x instanceof Television;})
                                        .map(x->x.precioFinal())
                                        .reduce((x,y)->x+y)
                                        .get();
            double lavadora = Arrays.stream(electrodomesticos)
                                        .filter((x)->{ return  x instanceof Lavadora;})
                                        .map(x->x.precioFinal())
                                        .reduce((x,y)->x+y)
                                        .get();                            
            System.out.println("total tv:" + tv +" - total lavadora " + lavadora);           
    }
}
