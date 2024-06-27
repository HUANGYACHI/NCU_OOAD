public class ChildPrice extends Price{
    protected double charge = 1.5;
    protected double renewCharge = 1.5;
    protected int rentalDays = 3;
    protected double point = 0.5;
    public ChildPrice() {
        super(1.5, 1.5, 3, 0.5);
    }
    @Override
    int getVideoType() {
        return Movie.CHILD;
    }


}
