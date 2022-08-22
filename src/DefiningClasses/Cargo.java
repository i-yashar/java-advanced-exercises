package DefiningClasses;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int cargoWeight, String cargoType){
        this.weight = cargoWeight;
        this.type = cargoType;
    }

    public String getType() {
        return type;
    }
}
