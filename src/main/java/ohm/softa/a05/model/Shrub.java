package ohm.softa.a05.model;

public class Shrub extends Plant{

    PlantColor color;
    public Shrub(double height, String family, String name ){
        this.height = height;
        this.family = family;
        this.name = name;
        this.color = PlantColor.GREEN;
    }


    @Override
    public PlantColor getColor() {
        return this.color;
    }

    @Override
    public int compareTo(Object o) {
            return Double.compare(this.height, ((Flower) o).height);
    }
}
