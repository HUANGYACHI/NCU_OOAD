import java.util.ArrayList;

public class GuineaPigCarCar implements GuineaPig{
    private String name;
    private Car vehicles;
    private ArrayList<String> food = new ArrayList<String>();
    private int distance;

    public GuineaPigCarCar(String name, Car vehicles) {
        this.name = name;
        this.vehicles = vehicles;
        this.distance = 0;
    }

    public String getName() { return name; }

    public ArrayList<String> getFood() { return food; }

    public int getDistance() { return distance; }

    public void run() { distance += this.vehicles.getSpeed(); }

    @Override
    public void noise() {
        System.out.println(this.name + ": PUI PUI");
    }

    @Override
    public void pupu() {
        System.out.print(this.name + " pupu: ");
        for (String foodName : food)
            System.out.print(foodName + " ");
        System.out.print("\n");
        this.vehicles.resetSpeed();
        this.food.clear();
    }

    @Override
    public void eat(String foodName) {
        this.food.add(foodName);
        if (foodName == "紅蘿蔔") this.vehicles.accelerate();
        if (this.food.size() > 5) this.pupu();
    }
}
