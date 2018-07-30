package test;

import domain.Main;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test4 {

    public static void main(String[] args) {
        Session  session = Main.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Customer where custName like ''");
        System.out.println(query.list().size());

        tx.commit();
    }
}
