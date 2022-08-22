package DefiningClasses;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight){
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color){
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine){
        this(model, engine, -1, "n/a");
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }


    public boolean hasEnoughPower(){
        return this.getEngine().getPower() > 250;
    }

    public String carInfo(){
        String displacement = this.engine.getDisplacement() == -1 ? "n/a" : String.valueOf(this.engine.getDisplacement());
        String weight = this.weight == -1 ? "n/a" : String.valueOf(this.weight);
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s", this.getModel(), this.engine.getModel(),
                this.engine.getPower(), displacement, this.engine.getEfficiency(), weight, this.color);
    }
}
