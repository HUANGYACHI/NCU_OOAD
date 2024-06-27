public class Car {
    protected int initSpeed;
    protected int accSpeed;
    protected int Speed;

    protected Car() {
        initSpeed = 0;
        accSpeed = 0;
        Speed = 0;
    }

    protected Car(int initSpeed, int accSpeed) {
        this.initSpeed = initSpeed;
        this.accSpeed = accSpeed;
        this.Speed = initSpeed;
    }

    protected int getSpeed() { return Speed; }

    protected void accelerate() { Speed += accSpeed; }

    protected void resetSpeed() { Speed = initSpeed; }

}
