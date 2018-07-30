package test;

import domain.Customer;
import domain.Main;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
/*
criteria查询
 */
public class test3 {
    public static void main(String[] args) {
        fun3();
    }

    public static void fun1(){
        Session session = Main.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria =session.createCriteria(Customer.class);
        List<Customer> list =  criteria.list();
        for(Customer c:list){
            System.out.println(c);
        }
        tx.commit();

    }


    public static void fun2(){
        Session session = Main.getCurrentSession();
        Transaction tx =session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("custName","zeng"));
        List<Customer> list = criteria.list();
        for(Customer c:list){
            System.out.println(c);
        }
        tx.commit();
    }

    public static void fun3(){
        Session session = Main.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(2);
        List<Customer> list= criteria.list();
        for(Customer c:list){
            System.out.println(c);
        }
        tx.commit();
    }


}
