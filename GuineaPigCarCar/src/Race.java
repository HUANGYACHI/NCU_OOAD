import java.util.ArrayList;

public class Race {
    private int goalDis;
    private ArrayList<GuineaPigCarCar> raceCars = new ArrayList<GuineaPigCarCar>();

    public Race(int goalDis, ArrayList<GuineaPigCarCar> raceCars) {
        this.goalDis = goalDis;
        this.raceCars = raceCars;
    }

    public void start() {
        for (int sec = 0; firstPGCar().getDistance() < goalDis; sec++) {
            for (GuineaPigCarCar car : raceCars)
                car.run();
            if (sec % 10 == 0 & sec != 0) {
                firstPGCar().eat("生菜");
                lastPGCar().eat("紅蘿蔔");
            }
        }
        endGame();
    }

    public GuineaPigCarCar firstPGCar() {
        GuineaPigCarCar firstCar = null;
        int maxDis = Integer.MIN_VALUE;
        for (GuineaPigCarCar GPcar : raceCars) {
            if (GPcar.getDistance() > maxDis) {
                maxDis = GPcar.getDistance();
                firstCar = GPcar;
            }
        }
        return firstCar;
    }

    public GuineaPigCarCar lastPGCar() {
        GuineaPigCarCar lastCar = null;
        int minDis = Integer.MAX_VALUE;
        for (GuineaPigCarCar GPcar : raceCars) {
            if (GPcar.getDistance() < minDis) {
                minDis = GPcar.getDistance();
                lastCar = GPcar;
            }
        }
        return lastCar;
    }

    public void endGame() {
        System.out.println("The winner is " + firstPGCar().getName() + " !");
        for (GuineaPigCarCar car : raceCars)
            System.out.println(car.getName() + " : " + car.getDistance());
    }
}
