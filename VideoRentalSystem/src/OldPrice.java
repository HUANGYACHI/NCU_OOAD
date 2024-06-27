public class OldPrice extends Price{
    protected double charge = 2;
    protected double renewCharge = 1.5;
    protected int rentalDays = 2;
    protected double point = 1;
    public OldPrice() {
        super(2, 1.5, 2, 1);
    }
    @Override
    int getVideoType() {
        return Movie.OLD;
    }


}
