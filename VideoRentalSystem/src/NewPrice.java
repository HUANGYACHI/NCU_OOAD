public class NewPrice extends Price{
    protected double charge = 3;
    protected double renewCharge = 3;
    protected int rentalDays = 1;
    protected double point = 2;

    public NewPrice() {
        super(3, 3, 1, 2);
    }

    @Override
    int getVideoType() {
        return Movie.NEW;
    }

}
