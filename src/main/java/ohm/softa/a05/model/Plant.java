package ohm.softa.a05.model;

public abstract class Plant implements Comparable{
    double height;
    String family, name ;

    public double getHeight() {
        return height;
    }

    public String getFamily(){
        return family;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Name: " + this.getName() + " - Family: " + this.getFamily() + " - Color: " + this.getColor() + " - Height: " + this.getHeight();
    }

    @Override
    public boolean equals(Object o){
        return this.getHeight() == ((Plant) o).getHeight()
                && this.name.equals(((Plant) o).name)
                && this.family.equals(((Plant) o).family)
                && this.getColor().equals(((Plant) o).getColor());
    }
    public abstract PlantColor getColor();
}
