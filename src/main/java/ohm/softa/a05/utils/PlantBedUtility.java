package ohm.softa.a05.utils;

import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;

public abstract class PlantBedUtility {

    private PlantBedUtility(){

    }

    public static <T extends Plant> void repot (PlantBed<T> from, PlantColor c, PlantBed<? super T> to){
        // TODO
    }

}
