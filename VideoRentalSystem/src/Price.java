public abstract class Price {
    protected double _charge;
    protected double _renewCharge;
    protected int _rentalDays;
    protected double _point;

    /**
     *
     * @param charge
     * @param renewCharge
     * @param rentalDays
     * @param point
     */
    public Price(double charge, double renewCharge, int rentalDays, double point) {
        _charge = charge;
        _renewCharge = renewCharge;
        _rentalDays = rentalDays;
        _point = point;
    }
    abstract int getVideoType();
    double getCharge(int daysRented) {
        return _charge + (daysRented - _rentalDays) * _renewCharge;
    };
    double getPoint() {
        return _point;
    };
}
