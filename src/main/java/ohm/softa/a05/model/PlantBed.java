package ohm.softa.a05.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;

public class PlantBed<T extends Plant>  {
    private SimpleList<T> plants;

    public PlantBed() {
        plants = new SimpleListImpl<>();
    }

    public void add(T plant){
        plants.add(plant);
    }

    public int size(){
        return plants.size();
    }

    public SimpleList<T> getPlantsByColor(PlantColor color){
        return plants.filter(p -> p.getColor().equals(color));
    }

    public SimpleList<T> getPlants() {
        //hack to get a copy of the current list
        return plants.map(p -> p);
    }

    public void remove(Plant plant){
        this.plants = this.plants.filter(p -> !p.equals(plant));
    }

    @Override
    public String toString(){
        String result = "";
        for (Plant p : this.plants){
            result += (p.toString() + "\n");
        }
        return result;
    }

}
