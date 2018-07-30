package test;

import domain.Customer;
import domain.Main;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/*
hql
 */
public class test2 {
    public static void main(String[] args) {

        fun1();
    }
    /*
    查询所有记录
     */
    public static  void fun1(){
        Session session = Main.getCurrentSession();
        Transaction tx =session.beginTransaction();
        String hql = "from Customer";
        Query query =session.createQuery(hql);
        List <Customer> list = query.list();
        for(Customer c : list) {
            System.out.println(c);
        }
    }


    /*
    指定查询
     */
    public static void fun2(){
        Session session = Main.getCurrentSession();
        Transaction tx =session.beginTransaction();
        String hql = "from Customer where custName = :custName";
        Query query =session.createQuery(hql);
        query.setParameter("custName","zeng");
        Customer c = (Customer) query.uniqueResult();
        System.out.println(c);
        tx.commit();
    }

    /*
    分页查询
     */
    public static void fun3(){
        Session session = Main.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String hql =" from Customer";
        Query query = session.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List<Customer> list = query.list();

        for(Customer c:list){
            System.out.println(c);
        }
        tx.commit();
    }


}
