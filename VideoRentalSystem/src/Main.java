import java.util.ArrayList;

public class Main {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static void main(String[] args) {
        // Use Case A
        Movie m1 = new Movie("我的名字", Movie.NEW);
        Movie m2 = new Movie("K-O", Movie.OLD);
        Movie m3 = new Movie("涼宮春日的", Movie.OLD);
        Movie m4 = new Movie("GIVEN", Movie.CHILD);

        // Use Case B
//        Customer c1 = new Customer("倫倫");
//        Customer c2 = new Customer("六花醬");
//        Customer c3 = new Customer("K昂");
//        Customer c4 = new Customer("史家瑩");
        customers.add(new Customer("倫倫"));
        customers.add(new Customer("六花醬"));
        customers.add(new Customer("K昂"));
        customers.add(new Customer("史家瑩"));

        // Use Case C
        Rental r1 = new Rental(m4, 8);
        customers.get(0).addRental(r1);
        Rental r2 = new Rental(m1, 7);
        customers.get(0).addRental(r2);
        Rental r3 = new Rental(m1, 8);
        customers.get(1).addRental(r3);
        Rental r4 = new Rental(m2, 7);
        customers.get(1).addRental(r4);
        Rental r5 = new Rental(m3, 8);
        customers.get(1).addRental(r5);
        Rental r6 = new Rental(m2, 7);
        customers.get(2).addRental(r6);
        Rental r7 = new Rental(m4, 8);
        customers.get(3).addRental(r7);

        // Use Case D
        for (Customer c : customers) {
            c.statement();
        }
//        c1.statement();
//        c2.statement();
//        c3.statement();
//        c4.statement();

        // Use Case E
        m1.setPrice(Movie.OLD);

//        for (Customer c : customers) {
//            c.statement();
//        }
    }
}