package test;
import domain.Customer;
import domain.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class test1 {

    public static void main(String[] args) {
        Session session = Main.getSession();
        Transaction tx = session.beginTransaction();
        Customer c = new Customer();
        c.setCustName("权");
        session.save(c);
        tx.commit();

        session.close();


    }
}
