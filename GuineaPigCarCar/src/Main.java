import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int trackLength = 4000;
        ArrayList<GuineaPigCarCar> raceCars = new ArrayList<GuineaPigCarCar>();

        raceCars.add(new GuineaPigCarCar("Shiromo", new PoliceCar()));
        raceCars.add(new GuineaPigCarCar("Abbey", new Ambulance()));
        raceCars.add(new GuineaPigCarCar("Teddy", new TrashTruck()));

// 		for (GuineaPigCarCar car : raceCars)
// 		    car.noise();

        Race race = new Race(trackLength, raceCars);
        race.start();
    }
}