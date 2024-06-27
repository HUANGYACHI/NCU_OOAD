import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rental = new Vector();
    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        _rental.addElement(rental);
    }

    public String getName() {
        return _name;
    }

    public void statement() {
        Enumeration rentals = _rental.elements();
        System.out.println(getName() + " 借閱紀錄：");
        System.out.printf("%s %5s %5s \n", "電影名稱", "金額", "點數");
//        System.out.println("Movie\tCharge\tPoint");
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
//            System.out.printf("%-6s %5s %5s \n", each.getMovie().getName(), String.valueOf(each.getCharge()), String.valueOf(each.getPoint()));
//            System.out.println(each.getMovie().getName() + "\t" + String.valueOf(each.getCharge()) + "\t" + String.valueOf(each.getPoint()));
            System.out.println("電影：" + each.getMovie().getName() + " 金額：" + String.valueOf(each.getCharge()) + " 點數：" + String.valueOf(each.getPoint()));
        }
//        System.out.println("總金額：" + getTotalCharge());
//        System.out.println("總點數：" + getTotalPoint());
        System.out.println("總金額：" + getTotalCharge() + ", 總點數：" + getTotalPoint());
    }

    public double getTotalCharge() {
        double total = 0;
        Enumeration rentals = _rental.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            total += each.getCharge();
        }
        return total;
    }

    public double getTotalPoint() {
        double total = 0;
        Enumeration rentals = _rental.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            total += each.getPoint();
        }
        return total;
    }
}
