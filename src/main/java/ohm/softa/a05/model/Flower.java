package ohm.softa.a05.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;

public class Flower extends Plant{

    PlantColor color;
    public Flower(double height, String family, String name, PlantColor color ){
        this.height = height;
        this.family = family;
        this.name = name;
        if(color != PlantColor.GREEN){
            this.color = color;
        }
        else{
            throw new IllegalArgumentException("Flowers can not be green.");
        }
    }


    @Override
    public PlantColor getColor() {
        return this.color;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.height, ((Flower) o).height);
    }

    public static class PlantBed<T extends Plant>  {
        SimpleList<T> plants;

        public PlantBed(){
            this.plants = new SimpleListImpl<T>();
        }

        public void add(T plant){
            plants.add(plant);
        }

        public int size(){
            return plants.size();
        }

        public SimpleList<T> getPlantsByColor(PlantColor color){
            return plants.filter(plant -> plant.getColor() == color);
        }

        public void repot(PlantBed<? extends Plant> from, PlantColor c, PlantBed<? super Plant> to){

        }

    }
}
