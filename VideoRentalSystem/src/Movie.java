public class Movie {
    public static final int NEW = 0;
    public static final int OLD = 1;
    public static final int CHILD = 2;

    private String _name;
    private Price _price;

    public Movie(String name, int videoType) {
        _name = name;
        setPrice(videoType);
    }

    public void setPrice(int videoType) {
        switch (videoType) {
            case NEW:   // 新片
                _price = new NewPrice();
                break;
            case OLD:   // 舊片
                _price = new OldPrice();
                break;
            case CHILD:   // 兒童片
                _price = new ChildPrice();
                break;
            default:
                System.out.println("沒有這個類別");
        }
    }

    public String getName() {
        return _name;
    }

    public int getVideoType() {
        return _price.getVideoType();
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public double getPoint() {
        return _price.getPoint();
    }
}
