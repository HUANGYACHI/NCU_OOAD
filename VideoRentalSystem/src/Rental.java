public class Rental {
    private Movie _movie;
    private int _daysRented;
    private double _charge;
    private double _point;
    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
        _charge = _movie.getCharge(_daysRented);
        _point = _movie.getPoint();
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge() {
        return _charge;
    }

    public double getPoint() {
        return _point;
    }
}
